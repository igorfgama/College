package service.validation;

import model.Graduation;
import repository.GraduationRepository;

import java.util.Objects;

public class GraduationValidation implements Validation<Graduation> {
    @Override
    public void validateItem(Graduation graduation) {
        if(Objects.isNull(graduation))
            throw new RuntimeException("Item inexistente");
    }

    @Override
    public void validateNewRegister(Graduation graduation) {
        if(new GraduationRepository().getAll().contains(graduation))
            throw new RuntimeException("Graduação já existente.");
        if(graduation.name().length() < 3)
            throw new RuntimeException("Entrada inválida.");
        if(Objects.isNull(graduation.area()))
            throw new RuntimeException("Área inválida.");
    }
}
