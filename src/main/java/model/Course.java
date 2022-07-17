package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course {
    private final String title;
    private final int term;
    private final List<String> graduation;
    private final List<Course> precondition = new ArrayList<>();

    public Course(String title, int term, List<String> graduation){
        this.title = title;
        this.term = term;
        this.graduation = graduation;
    }

    private void addPrecondition(Course course) {
        this.precondition.add(course);
    }

    public String getTitle() {
        return title;
    }

    public int getTerm() {
        return term;
    }

    public List<String> getGraduation() {
        return graduation;
    }

    public void addNewGraduationToCourse(String graduation){
        this.graduation.add(graduation);
    }

    public List<Course> getPrecondition() {
        return precondition;
    }

    public void setPrecondition(Course course){
        this.precondition.add(course);
    }

    @Override
    public String toString() {
        return "\n" + this.getTitle() + " {\n" +
                "  semestre: " + this.getTerm() + "\n" +
                "  curso: " + this.getGraduation() + "\n" +
                "  pré-requisitos: " + this.getPrecondition() + "\n}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return term == course.term && title.equals(course.title) && graduation.equals(course.graduation) && Objects.equals(precondition, course.precondition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, term, graduation, precondition);
    }
}
