package com.priv.tm.base;

/**
 * 旅行社类
 */

public class Travel {

    private int tId;//编号
    private String tName;//旅行社
    private String tLinkman;//联系人
    private String tTel;//联系电话
    private String tFax;//传真号码
    private String tQq;//腾讯QQ
    private String tEmail;//电子邮件
    private String tAddr;//联系地址
    private String tDesc;//介绍

    public Travel() {
    }

    public Travel(String tName, String tLinkman, String tTel, String tFax, String tQq, String tEmail, String tAddr, String tDesc) {
        this.tName = tName;
        this.tLinkman = tLinkman;
        this.tTel = tTel;
        this.tFax = tFax;
        this.tQq = tQq;
        this.tEmail = tEmail;
        this.tAddr = tAddr;
        this.tDesc = tDesc;
    }

    public Travel(int tId, String tName, String tLinkman, String tTel, String tFax, String tQq, String tEmail, String tAddr, String tDesc) {
        this.tId = tId;
        this.tName = tName;
        this.tLinkman = tLinkman;
        this.tTel = tTel;
        this.tFax = tFax;
        this.tQq = tQq;
        this.tEmail = tEmail;
        this.tAddr = tAddr;
        this.tDesc = tDesc;
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String gettLinkman() {
        return tLinkman;
    }

    public void settLinkman(String tLinkman) {
        this.tLinkman = tLinkman;
    }

    public String gettTel() {
        return tTel;
    }

    public void settTel(String tTel) {
        this.tTel = tTel;
    }

    public String gettFax() {
        return tFax;
    }

    public void settFax(String tFax) {
        this.tFax = tFax;
    }

    public String gettQq() {
        return tQq;
    }

    public void settQq(String tQq) {
        this.tQq = tQq;
    }

    public String gettEmail() {
        return tEmail;
    }

    public void settEmail(String tEmail) {
        this.tEmail = tEmail;
    }

    public String gettAddr() {
        return tAddr;
    }

    public void settAddr(String tAddr) {
        this.tAddr = tAddr;
    }

    public String gettDesc() {
        return tDesc;
    }

    public void settDesc(String tDesc) {
        this.tDesc = tDesc;
    }

    @Override
    public String toString() {
        return "Travel{" +
                "tId=" + tId +
                ", tName='" + tName + '\'' +
                ", tLinkman='" + tLinkman + '\'' +
                ", tTel='" + tTel + '\'' +
                ", tFax='" + tFax + '\'' +
                ", tQq='" + tQq + '\'' +
                ", tEmail='" + tEmail + '\'' +
                ", tAddr='" + tAddr + '\'' +
                ", tDesc='" + tDesc + '\'' +
                '}';
    }
}

