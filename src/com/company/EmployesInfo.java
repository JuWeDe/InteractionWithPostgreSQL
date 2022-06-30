package com.company;

public class EmployesInfo {

    private String name;
    private String surname;
    private String education;
    private String department;
    private String operation;

    public EmployesInfo(String name, String surname, String education, String department, String operation) {

        this.name = name;
        this.surname = surname;
        this.education = education;
        this.department = department;
        this.operation = operation;
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
