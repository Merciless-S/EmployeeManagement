package com.merciless.mapper;

import com.merciless.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@Mapper
public interface EmployeeMapper {

    public Collection<Employee> getAll();

    public Employee getEmployeeById(Integer id);

    public void delete(Integer id);

    public void save(Employee employee);

    public void update(Employee employee);
}
