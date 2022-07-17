package model;

import enums.Status;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private final List<Course> coursesMade = new ArrayList<>();
    private List<Course> coursesEnrolled = new ArrayList<>();

    public Student(String name, Status status, Graduation graduationRelated, String id, String password) {
        super(name, status, graduationRelated, id, password);
    }

    public List<Course> getCoursesEnrolled() {
        return coursesEnrolled;
    }
    public List<Course> getCoursesMade() {
        return coursesMade;
    }

    public void setCoursesMade(Course course) {
        this.coursesMade.add(course);
    }

    public void setCoursesEnrolled(Course course){
        this.coursesEnrolled.add(course);
    }
}
