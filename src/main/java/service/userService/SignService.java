package service.userService;

import enums.Status;
import model.Graduation;
import model.Person;
import model.Student;
import model.Teacher;
import service.modelService.GraduationService;
import service.modelService.PersonService;
import service.validation.SignValidation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SignService {
    public void signUp(){
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Perfil: 1. Professor 2. Aluno");
            int profile = Integer.parseInt(scanner.nextLine());
            System.out.print("Nome: ");
            String name = scanner.nextLine();
            System.out.print("Login: ");
            String id = scanner.nextLine();
            System.out.print("Senha: ");
            String password = lenghtValidation(scanner.nextLine());
            System.out.print("Graduação: ");
            Graduation grad = new GraduationService().getGraduationByName(scanner.nextLine());

            Person person;
            if(profile == 1){
                person = new Teacher(name, Status.REGULAR, grad, id, password);
            } else{
                person = new Student(name, Status.REGULAR, grad, id, password);
            }

            new SignValidation().validateNewRegister(person);
            new PersonService().savePerson(person);
        } catch (InputMismatchException e){
            throw new InputMismatchException("Entrada inválida.");
        }
    }

    private String lenghtValidation(String password) {
        Scanner scanner = new Scanner(System.in);
        while(password.length() < 5){
            password = scanner.nextLine();
        }
        return password;
    }
}
