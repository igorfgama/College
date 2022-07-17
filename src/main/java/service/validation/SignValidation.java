package service.validation;

import enums.Status;
import model.Person;

public class SignValidation implements Validation<Person> {

    @Override
    public void validateItem(Person person) {

    }

    @Override
    public void validateNewRegister(Person person) {
        if(person.getName().length() < 2)
            throw new RuntimeException("Nome inválido.");
        if(person.getId().length() < 4)
            throw new RuntimeException("CPF inválido.");
        if(person.getStatus().equals(Status.UNREGULAR))
            throw new RuntimeException("Status irregular.");
    }
}
