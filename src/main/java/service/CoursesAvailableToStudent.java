package service;

import model.Course;
import model.Graduation;
import model.Student;

import java.util.HashSet;
import java.util.List;

public class CoursesAvailableToStudent {
    public List<Course> listCoursesAvailable(Graduation graduation, Student student, int actualTerm){
        return graduation.curriculum()
                .stream()
                .filter(c -> !student.getCoursesMade().contains(c))
                .filter(d -> new HashSet<>(student.getCoursesMade()).containsAll(d.getPrecondition()))
                .toList();
    }
}
