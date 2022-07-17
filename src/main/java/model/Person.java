package model;

import enums.Status;

import java.util.Objects;

public abstract class Person {
    private final String name;
    private final String id;
    private final Status status;
    private final Graduation graduationRelated;
    private final String password;

    public Person(String name, Status status, Graduation graduationRelated, String id, String password) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.graduationRelated = graduationRelated;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public Graduation getGraduationRelated() {
        return graduationRelated;
    }

    @Override
    public String toString() {
        return "[NOME: " + this.getName() + ", " + this.getGraduationRelated() + ", PERFIL: " + this.getClass() + "]";
    }

    public boolean getPassword(String password) {
        return this.password.equals(password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) && id.equals(person.id) && status == person.status && graduationRelated.equals(person.graduationRelated) && password.equals(person.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, status, graduationRelated, password);
    }
}
