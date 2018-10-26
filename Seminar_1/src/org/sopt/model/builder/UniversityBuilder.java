package org.sopt.model.builder;

import org.sopt.model.University;

public class UniversityBuilder {
    private int uniId;
    private String name, telephone, address;

    public UniversityBuilder setUniId(int uniId) {
        this.uniId = uniId;
        return this;
    }

    public UniversityBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UniversityBuilder setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public UniversityBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public University build() {
        return new University(this.uniId, this.name, this.telephone, this.address);
    }
}
