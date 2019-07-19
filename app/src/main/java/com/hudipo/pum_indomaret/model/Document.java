package com.hudipo.pum_indomaret.model;

import java.util.Date;

public class Document {

    private int DOC_ID;
    private String DOCTYPE;
    private String DOC_NUM;
    private String DOC_DATE;
    private Double DOC_AMOUNT;
    private String VENDOR_NUM;
    private String VENDOR_NAME;
    private String VENDOR_SITE_CODE;
    private String DOC_CURR;

    public Document(int DOC_ID, String DOCTYPE, String DOC_NUM, String DOC_DATE, Double DOC_AMOUNT,
                    String VENDOR_NUM, String VENDOR_NAME, String VENDOR_SITE_CODE, String DOC_CURR) {
        this.DOC_ID = DOC_ID;
        this.DOCTYPE = DOCTYPE;
        this.DOC_NUM = DOC_NUM;
        this.DOC_DATE = DOC_DATE;
        this.DOC_AMOUNT = DOC_AMOUNT;
        this.VENDOR_NUM = VENDOR_NUM;
        this.VENDOR_NAME = VENDOR_NAME;
        this.VENDOR_SITE_CODE = VENDOR_SITE_CODE;
        this.DOC_CURR = DOC_CURR;
    }

    public int getDOC_ID() {
        return DOC_ID;
    }

    public String getDOCTYPE() {
        return DOCTYPE;
    }

    public String getDOC_NUM() {
        return DOC_NUM;
    }

    public String getDOC_DATE() {
        return DOC_DATE;
    }

    public Double getDOC_AMOUNT() {
        return DOC_AMOUNT;
    }

    public String getVENDOR_NUM() {
        return VENDOR_NUM;
    }

    public String getVENDOR_NAME() {
        return VENDOR_NAME;
    }

    public String getVENDOR_SITE_CODE() {
        return VENDOR_SITE_CODE;
    }

    public String getDOC_CURR() {
        return DOC_CURR;
    }
}
