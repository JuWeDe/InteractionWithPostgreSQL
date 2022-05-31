package com.company;

public class EmployesInfo {
    private String operation;
    private int id = 1;
    private String name;
    private String surname;
    private String education;
    private String department;


    public EmployesInfo(int id, String name, String surname, String education, String department, String operation) {

        this.name = name;
        this.surname = surname;
        this.education = education;
        this.department = department;
        this.operation = operation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
