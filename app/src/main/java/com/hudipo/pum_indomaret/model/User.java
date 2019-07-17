package com.hudipo.pum_indomaret.model;

import com.google.gson.annotations.SerializedName;

public class User {

    private int user_id;
    private String emp_num;
    @SerializedName("name")
    private String emp_name;
//    private String dept_id;
//    private int pin;


    public User(int user_id, String emp_num,String emp_name) {
        this.user_id = user_id;
        this.emp_num = emp_num;
        this.emp_name = emp_name;

    }

    public int getUser_id() {
        return user_id;
    }

    public String getEmp_num() {
        return emp_num;
    }

    public String getEmp_name() {
        return emp_name;
    }
}
