package service.modelService;

import model.Graduation;
import repository.GraduationRepository;
import service.validation.GraduationValidation;

import java.util.Set;

public class GraduationService {
    public Graduation getGraduationByName(String title){
        Set<Graduation> graduations = new GraduationRepository().getAll();
        return graduations.stream()
                .filter(g -> g.name().equals(title))
                .findFirst()
                .get();
    }

    public void addGraduation(Graduation graduation){
        new GraduationValidation().validateNewRegister(graduation);
        new GraduationRepository().save(graduation);
        System.out.println("O curso superior '" + graduation.name() + "' foi adicionado.");
    }
}
