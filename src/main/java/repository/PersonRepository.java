package repository;

import enums.Status;
import model.Person;
import model.Student;
import service.modelService.GraduationService;

import java.util.*;

public class PersonRepository implements BaseRepository<Person> {
    static final private Set<Person> people = new HashSet<>();

    public PersonRepository(){
        setData();
    }

    @Override
    public Set<Person> getAll(){
        return people;
    }

    @Override
    public void setData() {
//        people = List.of(
//                new Student("Jão",
//                        Status.REGULAR,
//                        new GraduationService().getGraduationByName("Programação"),
//                        "123",
//                        "321"),
//                new Student("Zé", Status.REGULAR, new GraduationService().getGraduationByName("Programação"), "456", "456")
//        );
    }

    @Override
    public void save(Person person) {
        people.add(person);
    }
}
