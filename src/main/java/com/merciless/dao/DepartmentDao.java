package com.merciless.dao;

import com.merciless.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class DepartmentDao {

    private static Map<Integer, Department> departments;


    static {
        departments = new HashMap<Integer, Department>();

        departments.put(101, new Department(101, "教学部"));
        departments.put(102, new Department(102, "市场部"));
        departments.put(103, new Department(103, "加班部"));
        departments.put(104, new Department(104, "后勤部"));
        departments.put(105, new Department(105, "物流部"));
    }

    public Collection<Department> getDepartments(){
        return departments.values();
    }

    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }
}
