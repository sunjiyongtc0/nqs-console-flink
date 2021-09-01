package com.eystar.console.startup.entity.gwdata;

import java.io.Serializable;
import java.util.Date;

public class GwData   implements Serializable {

    private static final long serialVersionUID = 1L;


    private String id;
    private String probeId;
    private String probeName;
    private String probeIp;
    private String probeAlias;
    private String pppoeUsername;
    private String vendor;
    private String pc;
    private String loid;
    private String serialNum;
    private String taskParamId;
    private String taskParamName;
    private String taskTypeName;
    private String taskId;
    private String taskMd5;
    private String accessTypeName;
    private Long testTime;
    private Long testTimeD;
    private Long testTimeH;
    private Long testTimeM;
    private Long testTimeW;
    private String destId;
    private String destName;
    private String destAddr;
    private Long provinceCode;
    private String provinceName;
    private Long cityCode;
    private String cityName;
    private Long districtCode;
    private String districtName;
    private Long townCode;
    private String townName;
    private Integer taskFrom;
    private String hostProvince;
    private String hostCity;
    private String operator;
    private Integer netType;
    private Integer isAlarm;
    private String alarmInfo;
    private Double score;
    private String hostIp;

    private Long createTime;
    private Date monthTime;
    @Override
    public String toString() {
        return "GwData{" +
                "id='" + id + '\'' +
                ", accessTypeName='" + accessTypeName + '\'' +
                ", testTime=" + testTime +
                ", destId='" + destId + '\'' +
                ", destAddr='" + destAddr + '\'' +
                ", provinceCode=" + provinceCode +
                ", provinceName='" + provinceName + '\'' +
                ", cityCode=" + cityCode +
                ", cityName='" + cityName + '\'' +
                ", districtCode=" + districtCode +
                ", districtName='" + districtName + '\'' +
                ", probeId='" + probeId + '\'' +
                ", townCode=" + townCode +
                ", townName='" + townName + '\'' +
                ", taskFrom=" + taskFrom +
                ", testTimeH=" + testTimeH +
                ", probeAlias='" + probeAlias + '\'' +
                ", testTimeD=" + testTimeD +
                ", destName='" + destName + '\'' +
                ", probeIp='" + probeIp + '\'' +
                ", probeName='" + probeName + '\'' +
                ", pppoeUsername='" + pppoeUsername + '\'' +
                ", loid='" + loid + '\'' +
                ", hostCity='" + hostCity + '\'' +
                ", serialNum='" + serialNum + '\'' +
                ", taskParamId='" + taskParamId + '\'' +
                ", testTimeW=" + testTimeW +
                ", taskParamName='" + taskParamName + '\'' +
                ", taskId='" + taskId + '\'' +
                ", taskTypeName='" + taskTypeName + '\'' +
                ", alarmInfo='" + alarmInfo + '\'' +
                ", vendor='" + vendor + '\'' +
                ", taskMd5='" + taskMd5 + '\'' +
                ", hostProvince='" + hostProvince + '\'' +
                ", pc='" + pc + '\'' +
                ", operator='" + operator + '\'' +
                ", netType=" + netType +
                ", testTimeM=" + testTimeM +
                ", isAlarm=" + isAlarm +
                ", createTime=" + createTime +
                ", monthTime=" + monthTime +
                ", hostIp='" + hostIp + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }
    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getAccessTypeName() {
        return accessTypeName;
    }

    public void setAccessTypeName(String accessTypeName) {
        this.accessTypeName = accessTypeName;
    }

    public Long getTestTime() {
        return testTime;
    }

    public void setTestTime(Long testTime) {
        this.testTime = testTime;
    }

    public String getDestId() {
        return destId;
    }

    public void setDestId(String destId) {
        this.destId = destId;
    }

    public String getDestAddr() {
        return destAddr;
    }

    public void setDestAddr(String destAddr) {
        this.destAddr = destAddr;
    }

    public Long getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(Long provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Long getCityCode() {
        return cityCode;
    }

    public void setCityCode(Long cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(Long districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getProbeId() {
        return probeId;
    }

    public void setProbeId(String probeId) {
        this.probeId = probeId;
    }

    public Long getTownCode() {
        return townCode;
    }

    public void setTownCode(Long townCode) {
        this.townCode = townCode;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public Integer getTaskFrom() {
        return taskFrom;
    }

    public void setTaskFrom(Integer taskFrom) {
        this.taskFrom = taskFrom;
    }

    public Long getTestTimeH() {
        return testTimeH;
    }

    public void setTestTimeH(Long testTimeH) {
        this.testTimeH = testTimeH;
    }

    public String getProbeAlias() {
        return probeAlias;
    }

    public void setProbeAlias(String probeAlias) {
        this.probeAlias = probeAlias;
    }

    public Long getTestTimeD() {
        return testTimeD;
    }

    public void setTestTimeD(Long testTimeD) {
        this.testTimeD = testTimeD;
    }

    public String getDestName() {
        return destName;
    }

    public void setDestName(String destName) {
        this.destName = destName;
    }

    public String getProbeIp() {
        return probeIp;
    }

    public void setProbeIp(String probeIp) {
        this.probeIp = probeIp;
    }

    public String getProbeName() {
        return probeName;
    }

    public void setProbeName(String probeName) {
        this.probeName = probeName;
    }

    public String getPppoeUsername() {
        return pppoeUsername;
    }

    public void setPppoeUsername(String pppoeUsername) {
        this.pppoeUsername = pppoeUsername;
    }

    public String getLoid() {
        return loid;
    }

    public void setLoid(String loid) {
        this.loid = loid;
    }

    public String getHostCity() {
        return hostCity;
    }

    public void setHostCity(String hostCity) {
        this.hostCity = hostCity;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getTaskParamId() {
        return taskParamId;
    }

    public void setTaskParamId(String taskParamId) {
        this.taskParamId = taskParamId;
    }

    public Long getTestTimeW() {
        return testTimeW;
    }

    public void setTestTimeW(Long testTimeW) {
        this.testTimeW = testTimeW;
    }

    public String getTaskParamName() {
        return taskParamName;
    }

    public void setTaskParamName(String taskParamName) {
        this.taskParamName = taskParamName;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskTypeName() {
        return taskTypeName;
    }

    public void setTaskTypeName(String taskTypeName) {
        this.taskTypeName = taskTypeName;
    }

    public String getAlarmInfo() {
        return alarmInfo;
    }

    public void setAlarmInfo(String alarmInfo) {
        this.alarmInfo = alarmInfo;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getTaskMd5() {
        return taskMd5;
    }

    public void setTaskMd5(String taskMd5) {
        this.taskMd5 = taskMd5;
    }

    public String getHostProvince() {
        return hostProvince;
    }

    public void setHostProvince(String hostProvince) {
        this.hostProvince = hostProvince;
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Integer getNetType() {
        return netType;
    }

    public void setNetType(Integer netType) {
        this.netType = netType;
    }

    public Long getTestTimeM() {
        return testTimeM;
    }

    public void setTestTimeM(Long testTimeM) {
        this.testTimeM = testTimeM;
    }

    public Integer getIsAlarm() {
        return isAlarm;
    }

    public void setIsAlarm(Integer isAlarm) {
        this.isAlarm = isAlarm;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Date getMonthTime() {
        return monthTime;
    }

    public void setMonthTime(Date monthTime) {
        this.monthTime = monthTime;
    }

    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }
}
