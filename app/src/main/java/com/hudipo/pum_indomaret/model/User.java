package com.hudipo.pum_indomaret.model;
import com.google.gson.annotations.SerializedName;

public class User {
    private int EMP_ID;
    private String EMP_NUM;
    private String NAME;
    private String EMAIL;

    public User(int EMP_ID, String EMP_NUM, String NAME, String EMAIL) {
        this.EMP_ID = EMP_ID;
        this.EMP_NUM = EMP_NUM;
        this.NAME = NAME;
        this.EMAIL = EMAIL;
    }


    public int getEMP_ID() {
        return EMP_ID;
    }

    public String getEMP_NUM() {
        return EMP_NUM;
    }

    public String getNAME() {
        return NAME;
    }

    public String getEMAIL() {
        return EMAIL;
    }
}