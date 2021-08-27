package com.eystar.console.startup.entity.gwdata;

import java.io.Serializable;
import java.util.Date;

public class GwPingData extends GwData implements Serializable {

    private static final long serialVersionUID = 1L;
    private Double score;

    private Double rtt;

    private Double jitter;

    private Double lostRate;


    private Integer errorCode;


    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getRtt() {
        return rtt;
    }

    public void setRtt(Double rtt) {
        this.rtt = rtt;
    }

    public Double getJitter() {
        return jitter;
    }

    public void setJitter(Double jitter) {
        this.jitter = jitter;
    }

    public Double getLostRate() {
        return lostRate;
    }

    public void setLostRate(Double lostRate) {
        this.lostRate = lostRate;
    }


    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(super.getId());
        sb.append(", probeId=").append(super.getProbeId());
        sb.append(", probeName=").append(super.getProbeName());
        sb.append(", score=").append(score);
        sb.append(", rtt=").append(rtt);
        sb.append(", jitter=").append(jitter);
        sb.append(", lostRate=").append(lostRate);
        sb.append(", hostIp=").append(super.getHostIp());
        sb.append(", errorCode=").append(errorCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}