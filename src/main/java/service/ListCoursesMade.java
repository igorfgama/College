package service;

import model.Course;
import model.Student;

import java.util.Comparator;

public class ListCoursesMade {
    public void listCourses(Student student){
        System.out.println("Aluno: " + student.getName());
        student.getCoursesMade().stream()
                .sorted(Comparator.comparing(Course::getTerm))
                .forEach(c -> System.out.printf(" [Disciplina: %10s | Semestre: %2sº]\n", c.getTitle(), c.getTerm()));
    }


}
