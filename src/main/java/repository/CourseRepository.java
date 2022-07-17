package repository;

import model.Course;

import java.util.*;

public class CourseRepository implements BaseRepository<Course> {
    static private final Set<Course> courses = new HashSet<>();

    public CourseRepository(){
        setData();
    }

    @Override
    public Set<Course> getAll(){
        return courses;
    }

    @Override
    public void setData() {
        courses.addAll(List.of(
                new Course("Lógica", 1, List.of("Programação")),
                new Course("Lógica", 1, List.of("Programação")),
                new Course("Cálculo I", 1, List.of("Programação")),
                new Course("Metodologia", 1, List.of("Programação")),

                new Course("POO I", 2, List.of("Programação")),
                new Course("Técnicas", 2, List.of("Programação")),
                new Course("Física I", 2, List.of("Programação")),
                new Course("Cálculo II", 2, List.of("Programação")),

                new Course("POO II", 3, List.of("Programação")),
                new Course("Web I", 3, List.of("Programação")),
                new Course("Física II", 3, List.of("Programação")),
                new Course("Cálculo III", 3, List.of("Programação")),

                new Course("Web II", 4, List.of("Programação")),
                new Course("BD I", 4, List.of("Programação")),
                new Course("Física III", 4, List.of("Programação")),
                new Course("Criptografia", 4, List.of("Programação")),

                new Course("Software I", 3, List.of("Programação")),
                new Course("BD II", 5, List.of("Programação")),
                new Course("Segurança I", 5, List.of("Programação")),

                new Course("Segurança II", 6, List.of("Programação")),
                new Course("TCC", 6, List.of("Programação"))
        ));
    }

    @Override
    public void save(Course course) {
        courses.add(course);
    }
}
