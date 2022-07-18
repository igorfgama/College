package service.userService;

import model.*;
import repository.CourseRepository;
import repository.GraduationRepository;
import service.search.SearchByName;
import service.validation.GraduationValidation;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class MatriculateService {

    public void matriculateNewCourse(Student student) {
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.print("Disciplina: ");
            String title = scanner.nextLine();

            Course course = new SearchByName().searchBy(new CourseRepository().getAll(), title);
            if(!Objects.isNull(course)){
                student.setCoursesEnrolled(course);
                System.out.println("Matrícula na disciplina '" + course.getTitle() + "' realizada.");
            } else{
                System.out.println("Matrícula não realizada.");
            }
        } catch (InputMismatchException e){
            throw new InputMismatchException("Entrada incorreta.");
        }
    }

    public void matriculateNewGraduation(Person person){
        Scanner scanner = new Scanner(System.in);

        try{
            if(person instanceof Teacher){
                System.out.print("Graduação: ");
                String name = scanner.nextLine();
                System.out.println("Área: ");
                String area = scanner.nextLine();

                Graduation graduation = new Graduation(name, area, new CourseRepository().getAll());

                new GraduationValidation().validateNewRegister(graduation);
                new GraduationRepository().save(graduation);

                System.out.println("Novo curso de graduação '" + graduation + "' criado.");
            } else {
                System.out.println("Não é possível realizar esta operação.");
                new MenuService().menu();
            }
        } catch (InputMismatchException e){
            throw new InputMismatchException("Entrada incorreta.");
        }
    }
}
