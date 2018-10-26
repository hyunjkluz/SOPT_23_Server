package org.sopt.model;

public class Department extends University{
    private int deptId;
    private String name, telephone, type;

    public Department() {
        super();
    }

    public Department(int deptId, String name, String telephone, String type) {
        super();
        this.deptId = deptId;
        this.name = name;
        this.telephone = telephone;
        this.type = type;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String toString() {
        return "학과 이름 : " + this.name + ", 학과 전화번호 : " + this.telephone + ", 학과 타입 : " + this.type + "\n";
    }
}
