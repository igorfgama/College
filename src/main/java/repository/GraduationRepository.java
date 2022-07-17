package repository;

import model.Graduation;

import java.util.*;

public class GraduationRepository implements BaseRepository<Graduation> {
    static private Set<Graduation> graduations = new HashSet<>();

    public GraduationRepository(){
        setData();
    }

    @Override
    public Set<Graduation> getAll(){
        if(!Objects.isNull(graduations))
            return graduations;
        else throw new RuntimeException("Sem registro de graduações.");
    }

    @Override
    public void setData() {
        graduations.addAll(List.of(
                new Graduation("Ciência da Computação", "TI", new CourseRepository().getAll()),
                new Graduation("Engenharia de Software", "TI", new CourseRepository().getAll())
        ));
    }

    @Override
    public void save(Graduation graduation) {
        graduations.add(graduation);
    }
}
