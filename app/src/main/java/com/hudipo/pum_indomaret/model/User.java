package com.hudipo.pum_indomaret.model;
import com.google.gson.annotations.SerializedName;

public class User {
    private int emp_id;
    private String emp_num;
    private String emp_name;
    private String emp_email;

    public User(int emp_id, String emp_num, String emp_name, String emp_email) {
        this.emp_id = emp_id;
        this.emp_num = emp_num;
        this.emp_name = emp_name;
        this.emp_email = emp_email;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public String getEmp_num() {
        return emp_num;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public String getEmp_email() {
        return emp_email;
    }
}