package com.shouvick.department.service;

import com.shouvick.department.entity.Department;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface DepartmentService {
    Department saveDepartment(Department department);

    Department findByDepartmentId(Long id);

}
