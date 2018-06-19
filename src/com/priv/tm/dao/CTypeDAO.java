package com.priv.tm.dao;

import com.priv.tm.base.CType;
import com.priv.tm.util.DBUtils;
import com.priv.tm.util.DaoUtil;
import com.priv.tm.util.SQLUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CTypeDAO {
    private DaoUtil daoUtil;
    public CTypeDAO(){
        daoUtil = new DaoUtil();}

    //添加方法
    public void insert(CType ct) throws SQLException {
        String sql = SQLUtils.getSQLInsert("ctype");
        daoUtil.update(sql,ct.getcTName(),ct.getcTDesc(),ct.getcTState());
    }

    //删除方法
    public void delete(String id) throws SQLException {
        String sql = SQLUtils.getSQLDelete("ctype");
        daoUtil.update(sql,id);
    }

    //修改方法
    public void update(CType ct)throws SQLException {
        String sql = SQLUtils.getSQLUpdate("ctype");
        daoUtil.update(sql,ct.getcTName(),ct.getcTDesc(),ct.getcTId());
    }

    //修改投诉类别状态
    public void upState(CType ct)throws SQLException {
        String sql = SQLUtils.getSQLupState();
        daoUtil.update(sql,ct.getcTState(),ct.getcTId());
    }


    public List<CType> find(String ctName, String state){
        List<CType> cTypeList = new ArrayList<CType>();
        String sql = SQLUtils.getSQLSelect("ctype");
        if(ctName != null) {
            sql += " AND C_T_Name = '" + ctName + "'";
        }
        if(state != null) {
            sql += " AND C_T_State = " + state;
        }
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while(rs.next()) {
                CType ct = new CType();
                ct.setcTId(rs.getInt("C_T_Id"));
                ct.setcTName(rs.getString("C_T_Name"));
                ct.setcTDesc(rs.getString("C_T_Desc"));
                ct.setcTState(rs.getString("C_T_State"));
                cTypeList.add(ct);
            }
            DBUtils.close(rs, stat, conn);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return cTypeList;
    }

    public CType query(String cTId){
        CType ct = new CType();
        String sql = SQLUtils.getSQLSelect("ctype");
        sql += " AND C_T_Id = " + cTId;
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while(rs.next()) {
                ct.setcTId(rs.getInt("C_T_Id"));
                ct.setcTName(rs.getString("C_T_Name"));
                ct.setcTDesc(rs.getString("C_T_Desc"));
                ct.setcTState(rs.getString("C_T_State"));
            }
            DBUtils.close(rs, stat, conn);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return ct;
    }
}

