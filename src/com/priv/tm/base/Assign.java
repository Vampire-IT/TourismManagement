package com.priv.tm.base;

public class Assign {
    private int aId;
    private int cId;
    private String username;
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
    private String result;

    public Assign() {
    }


    public Assign(int cId, String username) {
        this.cId = cId;
        this.username = username;
        this.result = "0";
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public void setcType(int cType) {
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Assign{" +
                "aId=" + aId +
                ", cId=" + cId +
                ", username='" + username + '\'' +
                ", cName='" + cName + '\'' +
                ", cTel='" + cTel + '\'' +
                ", cTargetType='" + cTargetType + '\'' +
                ", cTarget='" + cTarget + '\'' +
                ", cType=" + cType +
                ", cTName='" + cTName + '\'' +
                ", cCont='" + cCont + '\'' +
                ", cRecorder='" + cRecorder + '\'' +
                ", cTime='" + cTime + '\'' +
                ", cRemark='" + cRemark + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
