package org.sopt.model.builder;

import org.sopt.model.Professor;

public class ProfessorBuilder {
    private int proId;
    private String name, dept, telephone, subject;

    public ProfessorBuilder setProId(int proId) {
        this.proId = proId;
        return this;
    }

    public ProfessorBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ProfessorBuilder setDept(String dept) {
        this.dept = dept;
        return this;
    }

    public ProfessorBuilder setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public ProfessorBuilder setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public Professor build() {
        return new Professor(this.proId, this.name, this.dept, this.telephone, this.subject);
    }
}
