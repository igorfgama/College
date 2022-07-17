package service.userService;

import model.Course;
import model.Graduation;
import repository.CourseRepository;
import service.modelService.GraduationService;
import service.modelService.TeacherService;
import service.validation.TeacherValidation;

import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuService {
    public void menu(){
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("// MENU //");
            System.out.println("1. Login");
            System.out.println("2. Cadastrar Usuário");
            System.out.println("3. Cadastrar Disciplina");
            System.out.println("4. Cadastrar Curso");
            System.out.println("5. Todas as disciplinas");

            while(true){
                System.out.print(" -> ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice){
                    case 1 -> new LoginService().mainLogin();
                    case 2 -> new SignService().signUp();
                    case 3 -> new TeacherService().addCourse();
                    case 4 -> new GraduationService().addGraduation(new Graduation("Análise de Sistemas", "Computação", new CourseRepository().getAll()));
                    case 5 -> System.out.println(new CourseRepository().getAll());
                    default -> System.out.println("Entrada inválida.");
                }
            }
        } catch (InputMismatchException e){
            throw new InputMismatchException("Entrada inválida.");
        }
    }
}