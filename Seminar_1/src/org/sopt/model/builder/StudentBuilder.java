package org.sopt.model.builder;

import org.sopt.model.Student;

public class StudentBuilder {
    private int stuId, age, status, grade;
    private String name, dept, email, address;

    public StudentBuilder setStuId(int stuId) {
        this.stuId = stuId;
        return this;
    }

    public StudentBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public StudentBuilder setStatus(int status) {
        this.status = status;
        return this;
    }

    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public StudentBuilder setGrade(int grade) {
        this.grade = grade;
        return this;
    }

    public StudentBuilder setDept(String dept) {
        this.dept = dept;
        return this;
    }

    public StudentBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public StudentBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Student build() {
        return new Student (this.stuId, this.age, this.name, this.grade, this.dept, this.email, this.address, this.status);
    }
}
