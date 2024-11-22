package com.company.action;

import com.company.dao.GroupDao;
import com.company.model.Group;
import com.company.model.Student;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class GroupAction {
    GroupDao dao = new GroupDao();
    int st;

    public void insert(Group group) {
        st = dao.insert(group);
        if (st == 1) {
            System.out.println("\nGroup inserted successfully!");
        } else if (st == -1) {
            System.out.println("\n-!!!- Group already exists -!!!-");
        } else {
            System.out.println("\n-!!!- Unable to insert group -!!!-");
        }
    }

    public void update(Group group) {
        st = dao.update(group);
        if (st == 1) {
            System.out.println("\nGroup updated successfully");
        } else {
            System.out.println("\n-!!!- Unable to update group -!!!-");
        }
    }

    public void fetchAll() {
        List<Group> groupList = dao.getAllGroups();
        if (groupList.isEmpty()) {
            System.out.println("\n-!!!- No Record Found -!!!-");
        } else {
            System.out.println("\n-----GROUPS-----");
            for (Group group : groupList) {
                System.out.println(group);
            }
        }
    }
}
