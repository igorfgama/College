package service.validation;

import model.Course;
import repository.CourseRepository;
import repository.GraduationRepository;

public class CourseValidation implements Validation<Course> {
    @Override
    public void validateItem(Course course) {
        if(new CourseRepository().getAll().contains(course))
            throw new RuntimeException("Curso já listado.");
    }

    @Override
    public void validateNewRegister(Course course) {
        if(course.getTitle().length() < 2)
            throw new RuntimeException("Título inválido.");
        if(course.getTerm() < 1 || course.getTerm() > 10)
            throw new RuntimeException("Semestre inválido.");
        if(new GraduationRepository().getAll().contains(course.getGraduation()))
            throw new RuntimeException("Graduação não registrada.");
    }
}
