package service.userService;

import model.Person;
import model.Student;
import model.Teacher;
import service.ListCoursesMade;
import service.modelService.PersonService;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class LoginService {
    public void mainLogin() {
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.print("Login: ");
            String id = scanner.nextLine();

            System.out.print("Senha: ");
            String password = scanner.nextLine();

            login(id, password);
        } catch (InputMismatchException e){
            throw new InputMismatchException("Entrada inválida.");
        }
    }

    private void login(String id, String password){
        Person person = new PersonService().getPersonInfo(id, password);
        if(!Objects.isNull(person)){
            System.out.println("Login efetuado.");
            if(person instanceof Student)
                loginService(person);
            else loginTeacherService((Teacher) person);
        } else {
            System.out.println("Dados incorretos.");
        }
    }

    private void loginTeacherService(Teacher teacher) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo(a), Dr(a) " + teacher.getName() + "!");
        System.out.println("1. Notas: ");
        System.out.println("2. Disciplinas: ");
        System.out.println("3. Cadastrar Graduação: ");

        while(true){
            System.out.print(" -> ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> System.out.println("// atribuir notas //");
                case 2 -> System.out.println("// disciplinas que está lecionando //");
                case 3 -> new MatriculateService().matriculateNewGraduation(teacher);
                default -> System.out.println("Entrada errada");
            }
        }
    }

    private void loginService(Person person) {
        Scanner scanner = new Scanner(System.in);
        Student student = (Student) person;

        System.out.println("Bem-vindo(a), " + person.getName() + "!");
        System.out.println("1. Ver Grade");
        System.out.println("2. Matricular-se");
        System.out.println("3. Ver Histórico");
        System.out.println("4. Sair");

        while(true){
            System.out.print(" -> ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> System.out.println(student.getCoursesEnrolled());
                case 2 -> new MatriculateService().matriculateNewCourse(student);
                case 3 -> new ListCoursesMade().listCourses(student);
                case 4 -> new MenuService().menu();
                default -> System.out.println("Entrada errada");
            }
        }
    }
}
