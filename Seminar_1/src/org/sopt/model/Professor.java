package org.sopt.model;

public class Professor extends Department{
    private int proId;
    private String name, dept, telephone, subject;

    public Professor() {
        super();
    }

    public Professor(int proId, String name, String dept, String telephone, String subject) {
        super();
        this.proId = proId;
        this.name = name;
        this.dept = dept;
        this.telephone = telephone;
        this.subject = subject;
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "교수이름 : " + this.name + ", 교수 소속 학과 : " + this.dept + ", 교수 전화번호 : " + this.telephone + ", 담당 과목 : " + this.subject + "\n";
    }
}
