package com.hudipo.retrofitandroid.model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("emp_id")
    private int emp_id;

     @SerializedName("emp_name")
    private String emp_name;

    @SerializedName("emp_email")
    private String emp_email;

    public User(int emp_id, String emp_name, String emp_email) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_email = emp_email;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_email() {
        return emp_email;
    }

    public void setEmp_email(String emp_email) {
        this.emp_email = emp_email;
    }
}
