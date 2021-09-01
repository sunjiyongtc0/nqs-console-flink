package com.eystar.console.startup.entity.gwdata;

import java.io.Serializable;

public class GwFlashData extends  GwData implements Serializable {

    private String realUrl;

    private String hostIp;

    private Double connCost;

    private Double dnsCost;

    private Double bufferCost;

    private Double contentSize;

    private Double avgSpeed;

    private Double firstByteCost;

    private Double firstPauseCost;

    private Double bitrate;

    private Double playDuration;

    private Double pauseCost;

    private Double pauseCount;

    private Double carltonRate;


    private Integer errorCode;

    @Override
    public String toString() {
        return "GwFlashData{" +
                "realUrl='" + realUrl + '\'' +
                ", hostIp='" + hostIp + '\'' +
                ", connCost=" + connCost +
                ", dnsCost=" + dnsCost +
                ", bufferCost=" + bufferCost +
                ", contentSize=" + contentSize +
                ", avgSpeed=" + avgSpeed +
                ", firstByteCost=" + firstByteCost +
                ", firstPauseCost=" + firstPauseCost +
                ", bitrate=" + bitrate +
                ", playDuration=" + playDuration +
                ", pauseCost=" + pauseCost +
                ", pauseCount=" + pauseCount +
                ", carltonRate=" + carltonRate +
                ", errorCode=" + errorCode +
                '}';
    }

    public String getRealUrl() {
        return realUrl;
    }

    public void setRealUrl(String realUrl) {
        this.realUrl = realUrl;
    }

    @Override
    public String getHostIp() {
        return hostIp;
    }

    @Override
    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    public Double getConnCost() {
        return connCost;
    }

    public void setConnCost(Double connCost) {
        this.connCost = connCost;
    }

    public Double getDnsCost() {
        return dnsCost;
    }

    public void setDnsCost(Double dnsCost) {
        this.dnsCost = dnsCost;
    }

    public Double getBufferCost() {
        return bufferCost;
    }

    public void setBufferCost(Double bufferCost) {
        this.bufferCost = bufferCost;
    }

    public Double getContentSize() {
        return contentSize;
    }

    public void setContentSize(Double contentSize) {
        this.contentSize = contentSize;
    }

    public Double getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(Double avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    public Double getFirstByteCost() {
        return firstByteCost;
    }

    public void setFirstByteCost(Double firstByteCost) {
        this.firstByteCost = firstByteCost;
    }

    public Double getFirstPauseCost() {
        return firstPauseCost;
    }

    public void setFirstPauseCost(Double firstPauseCost) {
        this.firstPauseCost = firstPauseCost;
    }

    public Double getBitrate() {
        return bitrate;
    }

    public void setBitrate(Double bitrate) {
        this.bitrate = bitrate;
    }

    public Double getPlayDuration() {
        return playDuration;
    }

    public void setPlayDuration(Double playDuration) {
        this.playDuration = playDuration;
    }

    public Double getPauseCost() {
        return pauseCost;
    }

    public void setPauseCost(Double pauseCost) {
        this.pauseCost = pauseCost;
    }

    public Double getPauseCount() {
        return pauseCount;
    }

    public void setPauseCount(Double pauseCount) {
        this.pauseCount = pauseCount;
    }

    public Double getCarltonRate() {
        return carltonRate;
    }

    public void setCarltonRate(Double carltonRate) {
        this.carltonRate = carltonRate;
    }



    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}