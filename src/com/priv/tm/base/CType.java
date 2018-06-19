package com.priv.tm.base;

/**
 * 投诉类别类
 */
public class CType {

    private int cTId;//编号
    private String cTName;//投诉名称
    private String cTDesc;//描述
    private String cTState;//状态

    public CType() {
    }

    public CType(String cTName, String cTDesc, String cTState) {
        this.cTName = cTName;
        this.cTDesc = cTDesc;
        this.cTState = cTState;
    }

    public CType(int cTId, String cTState) {
        this.cTId = cTId;
        this.cTState = cTState;
    }

    public CType(int cTId, String cTName, String cTDesc) {

        this.cTId = cTId;
        this.cTName = cTName;
        this.cTDesc = cTDesc;
    }

    public int getcTId() {
        return cTId;
    }

    public void setcTId(int cTId) {
        this.cTId = cTId;
    }

    public String getcTName() {
        return cTName;
    }

    public void setcTName(String cTName) {
        this.cTName = cTName;
    }

    public String getcTDesc() {
        return cTDesc;
    }

    public void setcTDesc(String cTDesc) {
        this.cTDesc = cTDesc;
    }

    public String getcTState() {
        return cTState;
    }

    public void setcTState(String cTState) {
        this.cTState = cTState;
    }

    @Override
    public String toString() {
        return "CType{" +
                "cTId=" + cTId +
                ", cTName='" + cTName + '\'' +
                ", cTDesc='" + cTDesc + '\'' +
                ", cTState='" + cTState + '\'' +
                '}';
    }
}

