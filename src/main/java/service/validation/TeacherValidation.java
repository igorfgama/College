package service.validation;

import model.Person;
import model.Teacher;

public class TeacherValidation implements Validation<Person> {
    @Override
    public void validateItem(Person person) {
        if(!(person instanceof Teacher))
            throw new RuntimeException("Não é professor.");
    }

    @Override
    public void validateNewRegister(Person person) {
        if(person.getName().length() < 3)
            throw new RuntimeException("Nome inválido.");
    }
}
