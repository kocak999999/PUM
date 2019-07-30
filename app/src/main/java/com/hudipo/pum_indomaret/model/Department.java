package com.hudipo.pum_indomaret.model;

import com.google.gson.annotations.SerializedName;

public class Department {

    private int DEPT_ID;
    private String NAME;
    private String DESCRIPTION;


    public Department(int DEPT_ID, String NAME, String DESCRIPTION) {
        this.DEPT_ID = DEPT_ID;
        this.NAME = NAME;
        this.DESCRIPTION = DESCRIPTION;
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

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }
}
