package com.hudipo.pum_indomaret.model;

import com.google.gson.annotations.SerializedName;

public class Department {

    @SerializedName("DEPT_ID")
    private int DEPT_ID;

    @SerializedName("NAME")
    private String NAME;


    public Department(int DEPT_ID, String NAME) {
        this.DEPT_ID = DEPT_ID;
        this.NAME = NAME;
    }

    public int getDEPT_ID() {
        return DEPT_ID;
    }

    public void setDEPT_ID(int DEPT_ID) {
        this.DEPT_ID = DEPT_ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }
}
