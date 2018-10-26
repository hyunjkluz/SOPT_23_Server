package org.sopt.service.impl;

import org.sopt.model.Department;
import org.sopt.model.builder.DepartmentBuilder;
import org.sopt.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {
    @Override
    public Department getByDepartmentIdx(int deptId) {
        final DepartmentBuilder db = new DepartmentBuilder();

        return db
                .setDeptId(deptId)
                .setName("컴퓨터학과")
                .setType("공대")
                .setTelephone("02-940-4580")
                .build();
    }
}
