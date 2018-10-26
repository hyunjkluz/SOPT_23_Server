package org.sopt.model.builder;

import org.sopt.model.Department;

public class DepartmentBuilder {
    private int deptId;
    private String name, telephone, type;

    public DepartmentBuilder setDeptId(int deptId) {
        this.deptId = deptId;
        return this;
    }

    public DepartmentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public DepartmentBuilder setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public DepartmentBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public Department build() {
        return new Department(this.deptId, this.name, this.telephone, this.type);
    }
}
