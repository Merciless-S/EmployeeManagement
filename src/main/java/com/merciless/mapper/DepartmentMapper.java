package com.merciless.mapper;

import com.merciless.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.*;

import java.util.Collection;

@Mapper
@Repository
public interface DepartmentMapper {
    public Collection<Department> getDepartments();

    public Department getDepartmentById(Integer id);
}
