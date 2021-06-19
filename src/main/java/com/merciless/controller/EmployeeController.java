package com.merciless.controller;

import com.merciless.dao.DepartmentDao;
import com.merciless.dao.EmployeeDao;
import com.merciless.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        //System.out.println(employees.size());
        model.addAttribute("emps", employees);
        return "emp/list";
    }


    @GetMapping("/emp/add")
    public String add(Model model){
        model.addAttribute("departments", departmentDao.getDepartments());
        return "emp/add";
    }

    @PostMapping("/emp/add")
    public String addToDao(Employee employee){
        System.out.println(employee.toString());
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/update")
    public String update(@RequestParam("id") Integer id, Model model){
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("emp", employee);
        return "emp/list";
    }

    @GetMapping("/emp/delete")
    public String delete(@RequestParam("id") Integer id, Model model){
        return "emp/list";
    }


}
