package service.modelService;

import model.Course;
import model.Graduation;
import service.validation.GraduationValidation;
import service.validation.TeacherValidation;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TeacherService {
    public void addCourse() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nome da disciplina: ");
            String title = scanner.nextLine();
            System.out.print("Graduação pertencente: ");
            Graduation grad = new GraduationService().getGraduationByName(scanner.nextLine());
            new GraduationValidation().validateItem(grad);
            System.out.print("Semestre: ");
            int term = Integer.parseInt(scanner.nextLine());

            new CourseService().saveCourse(new Course(title, term, List.of(grad.name())));
        } catch (InputMismatchException e){
            throw new InputMismatchException("Entrada inválida.");
        }
    }

    public void teacherService() {
    }
}
