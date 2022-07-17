package service.search;

import model.Course;
import service.search.SearchService;

import java.util.List;

public class SearchByCourse implements SearchService<List<Course>, Course, Course> {

    @Override
    public Course searchBy(List<Course> courses, Course course) {
        System.out.println("Retornando busca de curso pela classe.");
        return courses.stream()
                .filter(c -> c.equals(course))
                .findFirst()
                .get();
    }
}
