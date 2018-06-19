package com.priv.tm.base;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 投诉类
 */

public class Complain {

    private int cId;//投诉单号
    private String cName;//投诉人
    private String cTel;//投诉电话
    private String cTargetType;//投诉对象类别
    private String cTarget;//投诉对象
    private int cType;//投诉类别
    private String cTName;//投诉类别名称
    private String cCont;//投诉内容
    private String cRecorder;//记录人
    private String cTime;//记录时间
    private String cRemark;//备注
    private String cMark;//分派标记

    public Complain() {
    }

    public Complain(String cName, String cTel, String cTargetType, String cTarget, int cType, String cCont, String cRecorder, String cRemark) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        this.cName = cName;
        this.cTel = cTel;
        this.cTargetType = cTargetType;
        this.cTarget = cTarget;
        this.cType = cType;
        this.cCont = cCont;
        this.cRecorder = cRecorder;
        this.cTime = sdf.format(date);
        this.cRemark = cRemark;
        this.cMark = "0";
    }

    public Complain(int cId, String cName, String cTel, String cTargetType, String cTarget, int cType, String cCont, String cRecorder,String cRemark) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        this.cId = cId;
        this.cName = cName;
        this.cTel = cTel;
        this.cTargetType = cTargetType;
        this.cTarget = cTarget;
        this.cType = cType;
        this.cCont = cCont;
        this.cRecorder = cRecorder;
        this.cTime = sdf.format(date);
        this.cRemark = cRemark;
        this.cMark = "0";
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcTel() {
        return cTel;
    }

    public void setcTel(String cTel) {
        this.cTel = cTel;
    }

    public String getcTargetType() {
        return cTargetType;
    }

    public void setcTargetType(String cTargetType) {
        this.cTargetType = cTargetType;
    }

    public String getcTarget() {
        return cTarget;
    }

    public void setcTarget(String cTarget) {
        this.cTarget = cTarget;
    }

    public int getcType() {
        return cType;
    }

    public void setcType(Integer cType) {
        this.cType = cType;
    }

    public String getcTName() {
        return cTName;
    }

    public void setcTName(String cTName) {
        this.cTName = cTName;
    }

    public String getcCont() {
        return cCont;
    }

    public void setcCont(String cCont) {
        this.cCont = cCont;
    }

    public String getcRecorder() {
        return cRecorder;
    }

    public void setcRecorder(String cRecorder) {
        this.cRecorder = cRecorder;
    }

    public String getcTime() {
        return cTime;
    }

    public void setcTime(String cTime) {
        this.cTime = cTime;
    }

    public String getcRemark() {
        return cRemark;
    }

    public void setcRemark(String cRemark) {
        this.cRemark = cRemark;
    }

    public void setcType(int cType) {
        this.cType = cType;
    }

    public String getcMark() {
        return cMark;
    }

    public void setcMark(String cMark) {
        this.cMark = cMark;
    }

    @Override
    public String toString() {
        return "Complain{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", cTel='" + cTel + '\'' +
                ", cTargetType='" + cTargetType + '\'' +
                ", cTarget='" + cTarget + '\'' +
                ", cType=" + cType +
                ", cTName=" + cTName +
                ", cCont='" + cCont + '\'' +
                ", cRecorder='" + cRecorder + '\'' +
                ", cTime='" + cTime + '\'' +
                ", cRemark='" + cRemark + '\'' +
                '}';
    }
}

