package com.priv.tm.base;

/**
 * 饭店类
 */

public class Restaurant {

    private int rId;//编号
    private String rName;//饭店名称
    private String rAvgPrice;//人均价
    private String rTel;//联系电话
    private String rUrl;//饭店网址
    private String rBusRoute;//乘车路线
    private String rParkSpace;//停车位
    private String rOpening;//营业时间
    private String rAddr;//饭店地址
    private String rDesc;//酒店介绍
    private String rPic;//图片

    public Restaurant() {
    }

    public Restaurant(String rName, String rAvgPrice, String rTel, String rUrl, String rBusRoute, String rParkSpace, String rOpening, String rAddr, String rDesc) {
        this.rName = rName;
        this.rAvgPrice = rAvgPrice;
        this.rTel = rTel;
        this.rUrl = rUrl;
        this.rBusRoute = rBusRoute;
        this.rParkSpace = rParkSpace;
        this.rOpening = rOpening;
        this.rAddr = rAddr;
        this.rDesc = rDesc;
        this.rPic = rPic;
    }

    public Restaurant(int rId, String rName, String rAvgPrice, String rTel, String rUrl, String rBusRoute, String rParkSpace, String rOpening, String rAddr, String rDesc) {
        this.rId = rId;
        this.rName = rName;
        this.rAvgPrice = rAvgPrice;
        this.rTel = rTel;
        this.rUrl = rUrl;
        this.rBusRoute = rBusRoute;
        this.rParkSpace = rParkSpace;
        this.rOpening = rOpening;
        this.rAddr = rAddr;
        this.rDesc = rDesc;
    }

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getrAvgPrice() {
        return rAvgPrice;
    }

    public void setrAvgPrice(String rAvgPrice) {
        this.rAvgPrice = rAvgPrice;
    }

    public String getrTel() {
        return rTel;
    }

    public void setrTel(String rTel) {
        this.rTel = rTel;
    }

    public String getrUrl() {
        return rUrl;
    }

    public void setrUrl(String rUrl) {
        this.rUrl = rUrl;
    }

    public String getrBusRoute() {
        return rBusRoute;
    }

    public void setrBusRoute(String rBusRoute) {
        this.rBusRoute = rBusRoute;
    }

    public String getrParkSpace() {
        return rParkSpace;
    }

    public void setrParkSpace(String rParkSpace) {
        this.rParkSpace = rParkSpace;
    }

    public String getrOpening() {
        return rOpening;
    }

    public void setrOpening(String rOpening) {
        this.rOpening = rOpening;
    }

    public String getrAddr() {
        return rAddr;
    }

    public void setrAddr(String rAddr) {
        this.rAddr = rAddr;
    }

    public String getrDesc() {
        return rDesc;
    }

    public void setrDesc(String rDesc) {
        this.rDesc = rDesc;
    }

    public String getrPic() {
        return rPic;
    }

    public void setrPic(String rPic) {
        this.rPic = rPic;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "rId=" + rId +
                ", rName='" + rName + '\'' +
                ", rAvgPrice='" + rAvgPrice + '\'' +
                ", rTel='" + rTel + '\'' +
                ", rUrl='" + rUrl + '\'' +
                ", rBusRoute='" + rBusRoute + '\'' +
                ", rParkSpace='" + rParkSpace + '\'' +
                ", rOpening='" + rOpening + '\'' +
                ", rAddr='" + rAddr + '\'' +
                ", rDesc='" + rDesc + '\'' +
                ", rPic='" + rPic + '\'' +
                '}';
    }
}

