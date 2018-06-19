package com.priv.tm.base;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Dispose {

    private int dId;
    private int cId;
    private String dName;
    private String dTime;
    private String dFinish;
    private String dCont;

    public Dispose() {
    }

    public Dispose(int cId, String dName, String dFinish, String dCont) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        this.cId = cId;
        this.dName = dName;
        this.dTime = sdf.format(date);
        this.dFinish = dFinish;
        this.dCont = dCont;
    }

    public Dispose(int dId, int cId, String dName, String dFinish, String dCont) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        this.dId = dId;
        this.cId = cId;
        this.dName = dName;
        this.dTime = sdf.format(date);
        this.dFinish = dFinish;
        this.dCont = dCont;
    }

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getdTime() {
        return dTime;
    }

    public void setdTime(String dTime) {
        this.dTime = dTime;
    }

    public String getdFinish() {
        return dFinish;
    }

    public void setdFinish(String dFinish) {
        this.dFinish = dFinish;
    }

    public String getdCont() {
        return dCont;
    }

    public void setdCont(String dCont) {
        this.dCont = dCont;
    }

    @Override
    public String toString() {
        return "Dispose{" +
                "dId=" + dId +
                ", cId='" + cId + '\'' +
                ", dName='" + dName + '\'' +
                ", dTime='" + dTime + '\'' +
                ", dFinish='" + dFinish + '\'' +
                ", dCont='" + dCont + '\'' +
                '}';
    }
}

