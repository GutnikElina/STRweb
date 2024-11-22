package com.company.model;

public class Group {
    private int id;
    private long number;
    private String fakultet;
    private int amountOfStudents;

    public Group() {}

    public Group(int id, long number, String fakultet, int amountOfStudents) {
        this.id = id;
        this.number = number;
        this.fakultet = fakultet;
        this.amountOfStudents = amountOfStudents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getFakultet() {
        return fakultet;
    }

    public void setFakultet(String fakultet) {
        this.fakultet = fakultet;
    }

    public int getAmountOfStudents() {
        return amountOfStudents;
    }

    public void setAmountOfStudents(int amountOfStudents) {
        this.amountOfStudents = amountOfStudents;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", number=" + number +
                ", fakultet='" + fakultet + '\'' +
                ", amountOfStudents=" + amountOfStudents +
                '}';
    }
}
