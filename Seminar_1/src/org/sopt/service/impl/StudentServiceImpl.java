package org.sopt.service.impl;

import org.sopt.model.Student;
import org.sopt.model.builder.StudentBuilder;
import org.sopt.service.StudentService;

public class StudentServiceImpl implements StudentService {
    @Override
    public Student getByStudentIdx(int stuId) {
        final StudentBuilder sb = new StudentBuilder();

        final Student st = sb
                .setStuId(stuId)
                .setAge(22)
                .setStatus(1)
                .setGrade(3)
                .setDept("컴퓨터학과")
                .setEmail("master@sopt.org")
                .setAddress("일산")
                .build();

        return st;
    }
}
