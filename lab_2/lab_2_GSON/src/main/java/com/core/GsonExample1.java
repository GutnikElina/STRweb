package com.core;

import com.domain.Staff;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GsonExample1 {
    public static void main(String[] args) {
        // pretty print
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Staff staff1 = createStaffObject("oleg", 35, new String[]{"Founder", "SEO", "coder"});
        Staff staff2 = createStaffObject("anna", 28, new String[]{"Manager", "HR"});

        // Java objects to JSON
        try (FileWriter writer = new FileWriter("json/staff.json")) {
            gson.toJson(Arrays.asList(staff1, staff2), writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Staff createStaffObject(String name, int age, String[] position) {
        Staff staff = new Staff();
        staff.setName(name);
        staff.setAge(age);
        staff.setPosition(position);
        Map<String, BigDecimal> salary = new HashMap<>() {{
            put("2010", new BigDecimal(10000));
            put("2012", new BigDecimal(12000));
            put("2018", new BigDecimal(14000));
        }};
        staff.setSalary(salary);
        staff.setSkills(Arrays.asList("java", "python", "node", "kotlin"));
        return staff;
    }
}

