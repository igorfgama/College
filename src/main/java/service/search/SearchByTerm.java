package service.search;

import model.Course;
import model.Graduation;

import java.util.Set;
import java.util.stream.Collectors;

public class SearchByTerm implements SearchService<Graduation, Integer, Set<Course>> {
    @Override
    public Set<Course> searchBy(Graduation graduation, Integer term){
        return graduation.curriculum()
                .stream()
                .filter(c -> c.getTerm()==term)
                .collect(Collectors.toSet());
    }
}
