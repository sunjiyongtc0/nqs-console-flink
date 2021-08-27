package com.eystar.console.startup.entity.gwdata;

import java.io.Serializable;
import java.util.Date;

public class GwDnsData extends  GwData implements Serializable {

    private static final long serialVersionUID = 1L;


    private Double score;

    private Double timeCost;

    private Double successRate;

    private String detail;




    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

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


}