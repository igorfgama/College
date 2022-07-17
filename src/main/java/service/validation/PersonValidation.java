package service.validation;

import enums.Status;
import model.Person;
import repository.GraduationRepository;

import java.util.Objects;

public class PersonValidation implements Validation<Person> {
    @Override
    public void validateItem(Person person) {
        if(Objects.isNull(person.getName()))
            throw new RuntimeException("Nome inexistente.");
        if(Objects.isNull(person.getGraduationRelated()))
            throw new RuntimeException("Graduação não registrada.");
        if(Objects.isNull(person.getStatus()))
            throw new RuntimeException("Status inexistente.");
    }

    @Override
    public void validateNewRegister(Person person) {
        if(person.getName().length() < 2)
            throw new RuntimeException("Nome inválido.");
        if(new GraduationRepository().getAll().contains(person.getGraduationRelated()))
            throw new RuntimeException("Gradução não registrada.");
        if(person.getStatus().equals(Status.UNREGULAR))
            throw new RuntimeException("Usuário em situação irregular.");
    }
}
