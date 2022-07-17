package service;

import model.Course;
import model.Student;
import service.validation.CourseValidation;
import service.validation.PersonValidation;

public class EnrollCourse {
    public void enroll(Student student, Course course){
        CourseValidation courseValidation = new CourseValidation();
        PersonValidation personValidation = new PersonValidation();
        personValidation.validateItem(student);
//        CoursesAvailableToStudent coursesAvailableToStudent = new CoursesAvailableToStudent();

//        courseValidation.isPresent(course);
        courseValidation.validateItem(course);
//        coursesAvailableToStudent.listCoursesAvailable(student.getGraduationRelated(), student, 2);
        student.setCoursesEnrolled(course);
        System.out.println("Curso cadastrado.");
    }
}
