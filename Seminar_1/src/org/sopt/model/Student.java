package org.sopt.model;

public class Student extends  Department{
    private int stuId, age, status, grade;
    private String name, dept, email, address;

    public Student() {
        super();
    }

    public Student(int stuId, int age, String name, int grade, String dept, String email, String address, int status) {
        super();
        this.stuId = stuId;
        this.age = age;
        this.name = name;
        this.grade = grade;
        this.dept = dept;
        this.email = email;
        this.address = address;
        this.status = status;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String changeStatusToSting(int status) {
        switch (status) {
            case 0:
                return "휴학";
            case 1:
                return "재학";
            case 2 :
                return "군휴학";
            case 3:
                return "취업계";
                default:
                    return "졸업";
        }
    }

    @Override
    public String toString() {
        return  "학번 : " + stuId +
                ", 이름 : " + name + '\'' +
                ", 나이 : " + age +
                ", 학년 : " + grade +
                ", 상태 : " + changeStatusToSting(status) +
                ", 학과 : '" + dept + '\'' +
                ", 이메일 : '" + email + '\'' +
                ", 주소 : " + address + '\'' +
                '\n';
    }


}
