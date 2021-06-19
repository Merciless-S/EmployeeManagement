package com.merciless.dao;

import com.merciless.pojo.Department;
import com.merciless.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employees;

    @Autowired
    DepartmentDao departmentDao;


    static {
        employees = new HashMap<Integer, Employee>();

        employees.put(101, new Employee(1001, "Tom", "1231@qq.com", 1, new Department(101, "a"), new Date()));
        employees.put(102, new Employee(1002, "Bob", "1232@qq.com", 0, new Department(102, "b"), new Date()));
        employees.put(103, new Employee(1003, "King", "1233@qq.com", 1, new Department(103, "c"), new Date()));
        employees.put(104, new Employee(1004, "Mia", "1234@qq.com", 0, new Department(104, "d"), new Date()));
        employees.put(105, new Employee(1005, "kate", "1235@qq.com", 1, new Department(105, "e"), new Date()));
    }


    private static Integer initId= 1006;

    public void save(Employee employee){
        if (employee.getId() == null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);

    }

    public Collection<Employee> getAll(){
        return employees.values();
    }

    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    public void delete(Integer id){
        employees.remove(id);
    }
}