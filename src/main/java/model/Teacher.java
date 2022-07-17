package model;

import enums.Status;

public class Teacher extends Person {
    public Teacher(String name, Status status, Graduation graduationRelated, String id, String password) {
        super(name, status, graduationRelated, id, password);
    }
}
