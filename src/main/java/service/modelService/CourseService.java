package service.modelService;

import model.Course;
import repository.CourseRepository;
import service.validation.CourseValidation;

public class CourseService {
    public void saveCourse(Course course){
        new CourseValidation().validateNewRegister(course);
        new CourseRepository().save(course);
        System.out.println("Curso '" + course.getTitle() + "' criado.");
    }
}
