package com.hudipo.pum_indomaret.model;

import com.google.gson.annotations.SerializedName;

public class Department {

    private int dept_id;
    private String name;
    private String description;


    public Department(int dept_id, String name, String description) {
        this.dept_id = dept_id;
        this.name = name;
        this.description = description;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
