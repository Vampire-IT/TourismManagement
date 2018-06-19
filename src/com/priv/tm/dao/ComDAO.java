package com.priv.tm.dao;

import com.priv.tm.base.CType;
import com.priv.tm.base.Complain;
import com.priv.tm.util.DBUtils;
import com.priv.tm.util.DaoUtil;
import com.priv.tm.util.SQLUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ComDAO {
    private DaoUtil daoUtil;
    public ComDAO(){
        daoUtil = new DaoUtil();}

    //添加方法
    public void insert(Complain c) throws SQLException {
        String sql = SQLUtils.getSQLInsert("complain");
        daoUtil.update(sql,c.getcName(),c.getcTel(),c.getcTargetType(),c.getcTarget(),c.getcType(),c.getcCont(),c.getcRecorder(),c.getcTime(),c.getcRemark(),c.getcMark());
        System.out.println(c.getcTime());
    }

    //删除方法
    public void delete(String id) throws SQLException {
        String sql = SQLUtils.getSQLDelete("complain");
        daoUtil.update(sql,id);
    }

    //修改方法
    public void update(Complain c)throws SQLException {
        String sql = SQLUtils.getSQLUpdate("complain");
        daoUtil.update(sql,c.getcName(),c.getcTel(),c.getcTargetType(),c.getcTarget(),c.getcType(),c.getcCont(),c.getcRecorder(),c.getcTime(),c.getcRemark(),c.getcId());
    }
    public void updateMack(String id)throws SQLException {
        String sql = SQLUtils.getSQLMark();
        daoUtil.update(sql,"1",id);
    }

    public List<Complain> find(String cTarget, String cName, String mark){
        List<Complain> complainList = new ArrayList<Complain>();
        String sql = SQLUtils.getSQLSelect("complain");
        if(cTarget != null) {
            sql += " AND C_Target = '" + cTarget + "'";
        }
        if(cName != null) {
            sql += " AND C_Name = '" + cName + "'";
        }
        if(mark != null) {
            sql += " AND C_Mark = '" + mark + "'";
        }
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while(rs.next()) {
                Complain c = new Complain();
                c.setcId(rs.getInt("C_Id"));
                c.setcName(rs.getString("C_Name"));
                c.setcTel(rs.getString("C_Tel"));
                c.setcTargetType(rs.getString("C_TargetType"));
                c.setcTarget(rs.getString("C_Target"));
                c.setcTName(rs.getString("C_T_Name"));
                c.setcCont(rs.getString("C_Cont"));
                c.setcRecorder(rs.getString("C_Recorder"));
                c.setcTime(rs.getString("C_Time"));
                c.setcRemark(rs.getString("C_Remark"));
                c.setcMark(rs.getString("C_Mark"));
                complainList.add(c);
            }
            DBUtils.close(rs, stat, conn);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return complainList;
    }

    public Complain query(String cId){
        Complain c = new Complain();
        String sql = SQLUtils.getSQLSelect("complain");
        sql += " AND C_Id = " + cId;
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while(rs.next()) {
                c.setcId(rs.getInt("C_Id"));
                c.setcName(rs.getString("C_Name"));
                c.setcTel(rs.getString("C_Tel"));
                c.setcTargetType(rs.getString("C_TargetType"));
                c.setcTarget(rs.getString("C_Target"));
                c.setcTName(rs.getString("C_T_Name"));
                c.setcCont(rs.getString("C_Cont"));
                c.setcRecorder(rs.getString("C_Recorder"));
                c.setcTime(rs.getString("C_Time"));
                c.setcRemark(rs.getString("C_Remark"));
            }
            DBUtils.close(rs, stat, conn);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return c;
    }
}

