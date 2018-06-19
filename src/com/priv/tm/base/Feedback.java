package com.priv.tm.base;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Feedback {

    private int fId;
    private int cId;
    private String fName;
    private String fTime;
    private String fCont;

    public Feedback(int fId, int cId, String fName, String fCont) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        this.fId = fId;
        this.cId = cId;
        this.fName = fName;
        this.fTime = sdf.format(date);
        this.fCont = fCont;
    }

    public Feedback(int cId, String fName, String fCont) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        this.cId = cId;
        this.fName = fName;
        this.fTime = sdf.format(date);
        this.fCont = fCont;
    }

    public Feedback() {

    }

    public int getfId() {
        return fId;
    }

    public void setfId(int fId) {
        this.fId = fId;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfTime() {
        return fTime;
    }

    public void setfTime(String fTime) {
        this.fTime = fTime;
    }

    public String getfCont() {
        return fCont;
    }

    public void setfCont(String fCont) {
        this.fCont = fCont;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "fId=" + fId +
                ", cId='" + cId + '\'' +
                ", fName='" + fName + '\'' +
                ", fTime='" + fTime + '\'' +
                ", fCont='" + fCont + '\'' +
                '}';
    }
}

