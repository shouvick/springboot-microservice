package com.shouvick.department.controller;

import com.shouvick.department.entity.Department;
import com.shouvick.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/departments")
public class DepartmentController {
    private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department) {
        log.info("department controller save department method called");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable Long id) {
        log.info("department controller get department method called");
        return departmentService.findByDepartmentId(id);
    }

}
