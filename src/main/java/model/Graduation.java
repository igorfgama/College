package model;

import java.util.Set;

public record Graduation(String name, String area, Set<Course> curriculum) {

    public void addNewCourse(Course course) {
        this.curriculum.add(course);
    }

    @Override
    public String toString() {
        return "[CURSO: " + this.name() + ", ÁREA: " + this.area() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Graduation that = (Graduation) o;
        return name.equals(that.name) && area.equals(that.area) && curriculum.equals(that.curriculum);
    }

}
