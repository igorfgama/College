package service.userService;

import model.Course;
import model.Student;
import repository.CourseRepository;
import service.search.SearchByName;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class MatriculateService {

    public void makeMatriculate(Student student) {
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.print("Disciplina: ");
            String title = scanner.nextLine();

            Course course = new SearchByName().searchBy(new CourseRepository().getAll(), title);
            if(!Objects.isNull(course)){
                student.setCoursesEnrolled(course);
                System.out.println("Matrícula na disciplina '" + course.getTitle() + "' realizada.");
            } else{
                System.out.println("Matrícular não realizada.");
            }
        } catch (InputMismatchException e){
            throw new InputMismatchException("Entrada incorreta.");
        }
    }
}
