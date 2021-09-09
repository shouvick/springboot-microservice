package com.shouvick.department.service.impl;

import com.shouvick.department.entity.Department;
import com.shouvick.department.repository.DepartmentRepository;
import com.shouvick.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {
    private static final Logger log = LoggerFactory.getLogger(DepartmentServiceImpl.class);

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        log.info("department service save department method called");
        return departmentRepository.save(department);
    }

    @Override
    public Department findByDepartmentId(Long id) {
        log.info("department service get department method called");
        Optional<Department> department = departmentRepository.findByDepartmentId(id);
        return department.get();
    }
}
