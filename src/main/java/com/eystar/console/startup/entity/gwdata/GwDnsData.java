package com.eystar.console.startup.entity.gwdata;

import java.io.Serializable;
import java.util.Date;

public class GwDnsData extends  GwData implements Serializable {


    private Double timeCost;

    private Double successRate;

    private String detail;
    private Integer errorCode;

    public Double getTimeCost() {
        return timeCost;
    }

    public void setTimeCost(Double timeCost) {
        this.timeCost = timeCost;
    }

    public Double getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(Double successRate) {
        this.successRate = successRate;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

}