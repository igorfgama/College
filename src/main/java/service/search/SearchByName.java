package service.search;

import model.Course;

import java.util.List;
import java.util.Set;

public class SearchByName implements SearchService<Set<Course>, String, Course> {

    @Override
    public Course searchBy(Set<Course> courses, String title) {
        System.out.println("Retornando busca de curso pelo título.");
        return courses.stream()
                .filter(c -> c.getTitle().equals(title))
                .findFirst()
                .get();
    }
}
