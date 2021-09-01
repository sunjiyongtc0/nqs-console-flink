package com.eystar.console.startup.entity.gwdata;

import java.io.Serializable;

public class GwHttpData  extends GwData implements Serializable {

    private String realIp;

    private String jumpIplist;

    private String detail;

    private Double tcpCost;

    private Double pageAvgSpeed;


    private Double elementsLocalnetRate;

    private Double elementsSuccessRate;

    private Double sslCost;

    private Double dnsCost;

    private Double elementLoadCost;

    private Double pageTotalCost;

    private Double firstByteCost;

    private Double firstScreenCost;

    private Double textCost;

    private Double avgSpeed;

    private Double pageSize;

    private Double transBodyCost;

    private Double connCost;

    private Integer elementsSum;

    private Integer elementsSuccessSum;

    private Integer elementsFailSum;

    private Integer httpCode;

    private Integer elementsLocalnetSum;

    private Integer errorCode;

    @Override
    public String toString() {
        return "GwHttpData{" +
                "realIp='" + realIp + '\'' +
                ", jumpIplist='" + jumpIplist + '\'' +
                ", detail='" + detail + '\'' +
                ", tcpCost=" + tcpCost +
                ", pageAvgSpeed=" + pageAvgSpeed +
                ", elementsLocalnetRate=" + elementsLocalnetRate +
                ", elementsSuccessRate=" + elementsSuccessRate +
                ", sslCost=" + sslCost +
                ", dnsCost=" + dnsCost +
                ", elementLoadCost=" + elementLoadCost +
                ", pageTotalCost=" + pageTotalCost +
                ", firstByteCost=" + firstByteCost +
                ", firstScreenCost=" + firstScreenCost +
                ", textCost=" + textCost +
                ", avgSpeed=" + avgSpeed +
                ", pageSize=" + pageSize +
                ", transBodyCost=" + transBodyCost +
                ", connCost=" + connCost +
                ", elementsSum=" + elementsSum +
                ", elementsSuccessSum=" + elementsSuccessSum +
                ", elementsFailSum=" + elementsFailSum +
                ", httpCode=" + httpCode +
                ", elementsLocalnetSum=" + elementsLocalnetSum +
                ", errorCode=" + errorCode +
                '}';
    }

    public String getRealIp() {
        return realIp;
    }

    public void setRealIp(String realIp) {
        this.realIp = realIp;
    }

    public String getJumpIplist() {
        return jumpIplist;
    }

    public void setJumpIplist(String jumpIplist) {
        this.jumpIplist = jumpIplist;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Double getTcpCost() {
        return tcpCost;
    }

    public void setTcpCost(Double tcpCost) {
        this.tcpCost = tcpCost;
    }

    public Double getPageAvgSpeed() {
        return pageAvgSpeed;
    }

    public void setPageAvgSpeed(Double pageAvgSpeed) {
        this.pageAvgSpeed = pageAvgSpeed;
    }


    public Double getElementsLocalnetRate() {
        return elementsLocalnetRate;
    }

    public void setElementsLocalnetRate(Double elementsLocalnetRate) {
        this.elementsLocalnetRate = elementsLocalnetRate;
    }

    public Double getElementsSuccessRate() {
        return elementsSuccessRate;
    }

    public void setElementsSuccessRate(Double elementsSuccessRate) {
        this.elementsSuccessRate = elementsSuccessRate;
    }

    public Double getSslCost() {
        return sslCost;
    }

    public void setSslCost(Double sslCost) {
        this.sslCost = sslCost;
    }

    public Double getDnsCost() {
        return dnsCost;
    }

    public void setDnsCost(Double dnsCost) {
        this.dnsCost = dnsCost;
    }

    public Double getElementLoadCost() {
        return elementLoadCost;
    }

    public void setElementLoadCost(Double elementLoadCost) {
        this.elementLoadCost = elementLoadCost;
    }

    public Double getPageTotalCost() {
        return pageTotalCost;
    }

    public void setPageTotalCost(Double pageTotalCost) {
        this.pageTotalCost = pageTotalCost;
    }

    public Double getFirstByteCost() {
        return firstByteCost;
    }

    public void setFirstByteCost(Double firstByteCost) {
        this.firstByteCost = firstByteCost;
    }

    public Double getFirstScreenCost() {
        return firstScreenCost;
    }

    public void setFirstScreenCost(Double firstScreenCost) {
        this.firstScreenCost = firstScreenCost;
    }

    public Double getTextCost() {
        return textCost;
    }

    public void setTextCost(Double textCost) {
        this.textCost = textCost;
    }

    public Double getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(Double avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    public Double getPageSize() {
        return pageSize;
    }

    public void setPageSize(Double pageSize) {
        this.pageSize = pageSize;
    }

    public Double getTransBodyCost() {
        return transBodyCost;
    }

    public void setTransBodyCost(Double transBodyCost) {
        this.transBodyCost = transBodyCost;
    }

    public Double getConnCost() {
        return connCost;
    }

    public void setConnCost(Double connCost) {
        this.connCost = connCost;
    }

    public Integer getElementsSum() {
        return elementsSum;
    }

    public void setElementsSum(Integer elementsSum) {
        this.elementsSum = elementsSum;
    }

    public Integer getElementsSuccessSum() {
        return elementsSuccessSum;
    }

    public void setElementsSuccessSum(Integer elementsSuccessSum) {
        this.elementsSuccessSum = elementsSuccessSum;
    }

    public Integer getElementsFailSum() {
        return elementsFailSum;
    }

    public void setElementsFailSum(Integer elementsFailSum) {
        this.elementsFailSum = elementsFailSum;
    }

    public Integer getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(Integer httpCode) {
        this.httpCode = httpCode;
    }

    public Integer getElementsLocalnetSum() {
        return elementsLocalnetSum;
    }

    public void setElementsLocalnetSum(Integer elementsLocalnetSum) {
        this.elementsLocalnetSum = elementsLocalnetSum;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}