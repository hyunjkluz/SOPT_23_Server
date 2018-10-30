package org.sopt.seminar_2.model;

public class User {
    private int user_idx;
    private String name, part;

    public User() { }

    public User(final int user_idx, final String name, final String part) {
        this.user_idx = user_idx;
        this.name = name;
        this.part = part;
    }

    public int getUser_idx() {
        return user_idx;
    }

    public void setUser_idx(int user_idx) {
        this.user_idx = user_idx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    @Override
    public String toString() {
        return  "(" + this.user_idx + ")" + "이름 : " + name + " / 파트 : " + part;
    }
}
