package com.hudipo.pum_indomaret.model;

public class CreatePum {
    private String emp_name;
    private String EMP_dept;
    private String use_date;
    private String resp_date;
    private String doc_num;
    private String trx_type;
    private String decription;
    private String currency;
    private String amount;
    private String upload_file;

    public CreatePum(String emp_name, String EMP_dept, String use_date, String resp_date, String doc_num, String trx_type, String decription, String currency, String amount, String upload_file) {
        this.emp_name = emp_name;
        this.EMP_dept = EMP_dept;
        this.use_date = use_date;
        this.resp_date = resp_date;
        this.doc_num = doc_num;
        this.trx_type = trx_type;
        this.decription = decription;
        this.currency = currency;
        this.amount = amount;
        this.upload_file = upload_file;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEMP_dept() {
        return EMP_dept;
    }

    public void setEMP_dept(String EMP_dept) {
        this.EMP_dept = EMP_dept;
    }

    public String getUse_date() {
        return use_date;
    }

    public void setUse_date(String use_date) {
        this.use_date = use_date;
    }

    public String getResp_date() {
        return resp_date;
    }

    public void setResp_date(String resp_date) {
        this.resp_date = resp_date;
    }

    public String getDoc_num() {
        return doc_num;
    }

    public void setDoc_num(String doc_num) {
        this.doc_num = doc_num;
    }

    public String getTrx_type() {
        return trx_type;
    }

    public void setTrx_type(String trx_type) {
        this.trx_type = trx_type;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getUpload_file() {
        return upload_file;
    }

    public void setUpload_file(String upload_file) {
        this.upload_file = upload_file;
    }
}
