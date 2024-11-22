package com.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Staff {
    private String name;
    private int age;
    private String[] position;
    private List<String> skills;
    private Map<String, BigDecimal> salary;

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setPosition(String[] position) {
        this.position = position;
    }
    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
    public void setSalary(Map<String, BigDecimal> salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", position=" + String.join(", ", position) +
                ", skills=" + skills +
                ", salary=" + salary +
                '}';
    }
}