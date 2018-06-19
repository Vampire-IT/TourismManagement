package com.priv.tm.base;

/**
 * 实景演出类
 */

public class Performance {

    private int pId;//编号
    private String pName;//演出名称
    private String pPrice;//门票价格
    private String pTel;//联系电话
    private String pAddr;//演出地址
    private String pBusRoute;//乘车路线
    private String pOpening;//营业时间
    private String pDesc;//演出介绍
    private String pPic;//图片

    public Performance() {
    }

    public Performance(String pName, String pPrice, String pTel, String pAddr, String pBusRoute, String pOpening, String pDesc) {
        this.pName = pName;
        this.pPrice = pPrice;
        this.pTel = pTel;
        this.pAddr = pAddr;
        this.pBusRoute = pBusRoute;
        this.pOpening = pOpening;
        this.pDesc = pDesc;
    }

    public Performance(int pId, String pName, String pPrice, String pTel, String pAddr, String pBusRoute, String pOpening, String pDesc) {
        this.pId = pId;
        this.pName = pName;
        this.pPrice = pPrice;
        this.pTel = pTel;
        this.pAddr = pAddr;
        this.pBusRoute = pBusRoute;
        this.pOpening = pOpening;
        this.pDesc = pDesc;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpPrice() {
        return pPrice;
    }

    public void setpPrice(String pPrice) {
        this.pPrice = pPrice;
    }

    public String getpTel() {
        return pTel;
    }

    public void setpTel(String pTel) {
        this.pTel = pTel;
    }

    public String getpAddr() {
        return pAddr;
    }

    public void setpAddr(String pAddr) {
        this.pAddr = pAddr;
    }

    public String getpBusRoute() {
        return pBusRoute;
    }

    public void setpBusRoute(String pBusRoute) {
        this.pBusRoute = pBusRoute;
    }

    public String getpOpening() {
        return pOpening;
    }

    public void setpOpening(String pOpening) {
        this.pOpening = pOpening;
    }

    public String getpDesc() {
        return pDesc;
    }

    public void setpDesc(String pDesc) {
        this.pDesc = pDesc;
    }

    public String getpPic() {
        return pPic;
    }

    public void setpPic(String pPic) {
        this.pPic = pPic;
    }

    @Override
    public String toString() {
        return "Performance{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", pPrice='" + pPrice + '\'' +
                ", pTel='" + pTel + '\'' +
                ", pAddr='" + pAddr + '\'' +
                ", pBusRoute='" + pBusRoute + '\'' +
                ", pOpening='" + pOpening + '\'' +
                ", pDesc='" + pDesc + '\'' +
                ", pPic='" + pPic + '\'' +
                '}';
    }
}

