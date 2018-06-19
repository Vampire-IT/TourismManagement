package com.priv.tm.base;

/**
 * 景区类
 */

public class Scenic {

    private int sId;//编号
    private String sName;//景区名称
    private String sType;//景区类别
    private String sStanPrice;//标准价格
    private String sDiscPrice;//折扣价格
    private String sTel;//联系电话
    private String sUrl;//景区网址
    private String sBusRoute;//乘车路线
    private String sParkSpace;//停车位
    private String sOpening;//营业时间
    private String sAddr;//景区地址
    private String sDesc;//景区介绍
    private String sPic;//图片

    public Scenic() {
    }

    public Scenic(String sName, String sType, String sStanPrice, String sDiscPrice, String sTel, String sUrl, String sBusRoute, String sParkSpace, String sOpening, String sAddr, String sDesc) {
        this.sName = sName;
        this.sType = sType;
        this.sStanPrice = sStanPrice;
        this.sDiscPrice = sDiscPrice;
        this.sTel = sTel;
        this.sUrl = sUrl;
        this.sBusRoute = sBusRoute;
        this.sParkSpace = sParkSpace;
        this.sOpening = sOpening;
        this.sAddr = sAddr;
        this.sDesc = sDesc;
    }

    public Scenic(int sId, String sName, String sType, String sStanPrice, String sDiscPrice, String sTel, String sUrl, String sBusRoute, String sParkSpace, String sOpening, String sAddr, String sDesc) {
        this.sId = sId;
        this.sName = sName;
        this.sType = sType;
        this.sStanPrice = sStanPrice;
        this.sDiscPrice = sDiscPrice;
        this.sTel = sTel;
        this.sUrl = sUrl;
        this.sBusRoute = sBusRoute;
        this.sParkSpace = sParkSpace;
        this.sOpening = sOpening;
        this.sAddr = sAddr;
        this.sDesc = sDesc;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsType() {
        return sType;
    }

    public void setsType(String sType) {
        this.sType = sType;
    }

    public String getsStanPrice() {
        return sStanPrice;
    }

    public void setsStanPrice(String sStanPrice) {
        this.sStanPrice = sStanPrice;
    }

    public String getsDiscPrice() {
        return sDiscPrice;
    }

    public void setsDiscPrice(String sDiscPrice) {
        this.sDiscPrice = sDiscPrice;
    }

    public String getsTel() {
        return sTel;
    }

    public void setsTel(String sTel) {
        this.sTel = sTel;
    }

    public String getsUrl() {
        return sUrl;
    }

    public void setsUrl(String sUrl) {
        this.sUrl = sUrl;
    }

    public String getsBusRoute() {
        return sBusRoute;
    }

    public void setsBusRoute(String sBusRoute) {
        this.sBusRoute = sBusRoute;
    }

    public String getsParkSpace() {
        return sParkSpace;
    }

    public void setsParkSpace(String sParkSpace) {
        this.sParkSpace = sParkSpace;
    }

    public String getsOpening() {
        return sOpening;
    }

    public void setsOpening(String sOpening) {
        this.sOpening = sOpening;
    }

    public String getsAddr() {
        return sAddr;
    }

    public void setsAddr(String sAddr) {
        this.sAddr = sAddr;
    }

    public String getsDesc() {
        return sDesc;
    }

    public void setsDesc(String sDesc) {
        this.sDesc = sDesc;
    }

    public String getsPic() {
        return sPic;
    }

    public void setsPic(String sPic) {
        this.sPic = sPic;
    }

    @Override
    public String toString() {
        return "Scenic{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", sType='" + sType + '\'' +
                ", sStanPrice='" + sStanPrice + '\'' +
                ", sDiscPrice='" + sDiscPrice + '\'' +
                ", sTel='" + sTel + '\'' +
                ", sUrl='" + sUrl + '\'' +
                ", sBusRoute='" + sBusRoute + '\'' +
                ", sParkSpace='" + sParkSpace + '\'' +
                ", sOpening='" + sOpening + '\'' +
                ", sAddr='" + sAddr + '\'' +
                ", sDesc='" + sDesc + '\'' +
                ", sPic='" + sPic + '\'' +
                '}';
    }
}

