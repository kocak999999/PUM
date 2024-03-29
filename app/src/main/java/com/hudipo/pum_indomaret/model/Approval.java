package com.hudipo.pum_indomaret.model;

public class Approval {

    private String str_pum_number_approval;
    private String str_pum_name_approval;
    private String str_pum_amount_approval;

    public Approval(String str_pum_number_approval,
                    String str_pum_name_approval,
                    String str_pum_amount_approval) {
        this.str_pum_number_approval = str_pum_number_approval;
        this.str_pum_name_approval = str_pum_name_approval;
        this.str_pum_amount_approval = str_pum_amount_approval;
    }

    public String getStr_pum_number_approval() {
        return str_pum_number_approval;
    }

    public String getStr_pum_name_approval() {
        return str_pum_name_approval;
    }

    public String getStr_pum_amount_approval() {
        return str_pum_amount_approval;
    }
}
