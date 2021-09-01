package com.eystar.console.startup.entity.gwdata;

import java.io.Serializable;

public class GwHttpDetailData extends GwData implements Serializable {

    private static final long serialVersionUID = 1L;


    private String parentId;

    private String elementName;

    private Integer elementNum;

    private String elementUrl;

    private Double dnsCost;

    private Double connCost;

    private Double elementDownloadCost;

    private Double firstByteCost;

    private Double elementTotalCost;

    private Long threadNum;

    private Integer elementStatus;

    private Double elementSize;

    private Double avgSpeed;

    private Integer elementHttpCode;

    private Integer isLocalnet;

    private Double tcpCost;

    private Double sslCost;

    private Integer errorCode;


    @Override
    public String toString() {
        return "GwHttpDetailData{" +
                "parentId='" + parentId + '\'' +
                ", elementName='" + elementName + '\'' +
                ", elementNum=" + elementNum +
                ", elementUrl='" + elementUrl + '\'' +
                ", dnsCost=" + dnsCost +
                ", connCost=" + connCost +
                ", elementDownloadCost=" + elementDownloadCost +
                ", firstByteCost=" + firstByteCost +
                ", elementTotalCost=" + elementTotalCost +
                ", threadNum=" + threadNum +
                ", elementStatus=" + elementStatus +
                ", elementSize=" + elementSize +
                ", avgSpeed=" + avgSpeed +
                ", elementHttpCode=" + elementHttpCode +
                ", isLocalnet=" + isLocalnet +
                ", tcpCost=" + tcpCost +
                ", sslCost=" + sslCost +
                ", errorCode=" + errorCode +
                '}';
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public Integer getElementNum() {
        return elementNum;
    }

    public void setElementNum(Integer elementNum) {
        this.elementNum = elementNum;
    }

    public String getElementUrl() {
        return elementUrl;
    }

    public void setElementUrl(String elementUrl) {
        this.elementUrl = elementUrl;
    }

    public Double getDnsCost() {
        return dnsCost;
    }

    public void setDnsCost(Double dnsCost) {
        this.dnsCost = dnsCost;
    }

    public Double getConnCost() {
        return connCost;
    }

    public void setConnCost(Double connCost) {
        this.connCost = connCost;
    }

    public Double getElementDownloadCost() {
        return elementDownloadCost;
    }

    public void setElementDownloadCost(Double elementDownloadCost) {
        this.elementDownloadCost = elementDownloadCost;
    }

    public Double getFirstByteCost() {
        return firstByteCost;
    }

    public void setFirstByteCost(Double firstByteCost) {
        this.firstByteCost = firstByteCost;
    }

    public Double getElementTotalCost() {
        return elementTotalCost;
    }

    public void setElementTotalCost(Double elementTotalCost) {
        this.elementTotalCost = elementTotalCost;
    }

    public Long getThreadNum() {
        return threadNum;
    }

    public void setThreadNum(Long threadNum) {
        this.threadNum = threadNum;
    }

    public Integer getElementStatus() {
        return elementStatus;
    }

    public void setElementStatus(Integer elementStatus) {
        this.elementStatus = elementStatus;
    }

    public Double getElementSize() {
        return elementSize;
    }

    public void setElementSize(Double elementSize) {
        this.elementSize = elementSize;
    }

    public Double getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(Double avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    public Integer getElementHttpCode() {
        return elementHttpCode;
    }

    public void setElementHttpCode(Integer elementHttpCode) {
        this.elementHttpCode = elementHttpCode;
    }

    public Integer getIsLocalnet() {
        return isLocalnet;
    }

    public void setIsLocalnet(Integer isLocalnet) {
        this.isLocalnet = isLocalnet;
    }

    public Double getTcpCost() {
        return tcpCost;
    }

    public void setTcpCost(Double tcpCost) {
        this.tcpCost = tcpCost;
    }

    public Double getSslCost() {
        return sslCost;
    }

    public void setSslCost(Double sslCost) {
        this.sslCost = sslCost;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}