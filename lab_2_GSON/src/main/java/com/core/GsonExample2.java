package com.core;

import com.domain.Staff;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

public class GsonExample2 {
    public static void main(String[] args) {
        Gson gson = new Gson();
        try (Reader reader = new FileReader("json/staff.json")) {
            Type staffListType = new TypeToken<List<Staff>>(){}.getType();
            List<Staff> staffList = gson.fromJson(reader, staffListType);
            staffList.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
