package org.sopt.model;

public class University {
    private int uniId;
    private String name, telephone, address;

    public University() {    }

    public University(int uniId, String name, String telephone, String address) {
        this.uniId = uniId;
        this.name = name;
        this.telephone = telephone;
        this.address = address;
    }

    public int getUniId() {
        return uniId;
    }

    public void setUniId(int uniId) {
        this.uniId = uniId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "학교 이름 : " + this.name + ", 대학 전화번호 : " + this.telephone + ", 학교 주소 : " + this.address + "\n";
    }
}
