package com.priv.tm.base;

/**
 * 住宿类
 */

public class Hotel {

    private int hId;//编号
    private String hName;//酒店名称
    private String hRating;//酒店星级
    private String hStanPrice;//标准价格
    private String hDiscPrice;//折扣价格
    private String hTel;//联系电话
    private String hUrl;//酒店网址
    private String hBusRoute;//乘车路线
    private String hParkSpace;//停车位
    private String hOpening;//营业时间
    private String hAddr;//酒店地址
    private String hDesc;//酒店介绍
    private String hPic;//图片

    public Hotel() {
    }

    public Hotel(String hName, String hRating, String hStanPrice, String hDiscPrice, String hTel, String hUrl, String hBusRoute, String hParkSpace, String hOpening, String hAddr, String hDesc) {
        this.hName = hName;
        this.hRating = hRating;
        this.hStanPrice = hStanPrice;
        this.hDiscPrice = hDiscPrice;
        this.hTel = hTel;
        this.hUrl = hUrl;
        this.hBusRoute = hBusRoute;
        this.hParkSpace = hParkSpace;
        this.hOpening = hOpening;
        this.hAddr = hAddr;
        this.hDesc = hDesc;
    }

    public Hotel(int hId, String hName, String hRating, String hStanPrice, String hDiscPrice, String hTel, String hUrl, String hBusRoute, String hParkSpace, String hOpening, String hAddr, String hDesc) {
        this.hId = hId;
        this.hName = hName;
        this.hRating = hRating;
        this.hStanPrice = hStanPrice;
        this.hDiscPrice = hDiscPrice;
        this.hTel = hTel;
        this.hUrl = hUrl;
        this.hBusRoute = hBusRoute;
        this.hParkSpace = hParkSpace;
        this.hOpening = hOpening;
        this.hAddr = hAddr;
        this.hDesc = hDesc;
    }

    public int gethId() {
        return hId;
    }

    public void sethId(int hId) {
        this.hId = hId;
    }

    public String gethName() {
        return hName;
    }

    public void sethName(String hName) {
        this.hName = hName;
    }

    public String gethRating() {
        return hRating;
    }

    public void sethRating(String hRating) {
        this.hRating = hRating;
    }

    public String gethStanPrice() {
        return hStanPrice;
    }

    public void sethStanPrice(String hStanPrice) {
        this.hStanPrice = hStanPrice;
    }

    public String gethDiscPrice() {
        return hDiscPrice;
    }

    public void sethDiscPrice(String hDiscPrice) {
        this.hDiscPrice = hDiscPrice;
    }

    public String gethTel() {
        return hTel;
    }

    public void sethTel(String hTel) {
        this.hTel = hTel;
    }

    public String gethUrl() {
        return hUrl;
    }

    public void sethUrl(String hUrl) {
        this.hUrl = hUrl;
    }

    public String gethBusRoute() {
        return hBusRoute;
    }

    public void sethBusRoute(String hBusRoute) {
        this.hBusRoute = hBusRoute;
    }

    public String gethParkSpace() {
        return hParkSpace;
    }

    public void sethParkSpace(String hParkSpace) {
        this.hParkSpace = hParkSpace;
    }

    public String gethOpening() {
        return hOpening;
    }

    public void sethOpening(String hOpening) {
        this.hOpening = hOpening;
    }

    public String gethAddr() {
        return hAddr;
    }

    public void sethAddr(String hAddr) {
        this.hAddr = hAddr;
    }

    public String gethDesc() {
        return hDesc;
    }

    public void sethDesc(String hDesc) {
        this.hDesc = hDesc;
    }

    public String gethPic() {
        return hPic;
    }

    public void sethPic(String hPic) {
        this.hPic = hPic;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hId=" + hId +
                ", hName='" + hName + '\'' +
                ", hRating='" + hRating + '\'' +
                ", hStanPrice='" + hStanPrice + '\'' +
                ", hDiscPrice='" + hDiscPrice + '\'' +
                ", hTel='" + hTel + '\'' +
                ", hUrl='" + hUrl + '\'' +
                ", hBusRoute='" + hBusRoute + '\'' +
                ", hParkSpace='" + hParkSpace + '\'' +
                ", hOpening='" + hOpening + '\'' +
                ", hAddr='" + hAddr + '\'' +
                ", hDesc='" + hDesc + '\'' +
                ", hPic='" + hPic + '\'' +
                '}';
    }
}

