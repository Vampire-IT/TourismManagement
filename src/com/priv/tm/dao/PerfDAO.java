package com.priv.tm.dao;

import com.priv.tm.base.Hotel;
import com.priv.tm.base.Performance;
import com.priv.tm.util.DBUtils;
import com.priv.tm.util.DaoUtil;
import com.priv.tm.util.SQLUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PerfDAO {
    private DaoUtil daoUtil;
    public PerfDAO(){
        daoUtil = new DaoUtil();}
    //添加方法
    public void insert(Performance p) throws SQLException {
        String sql = SQLUtils.getSQLInsert("perf");
        daoUtil.update(sql,p.getpName(),p.getpPrice(),p.getpTel(),p.getpAddr(),p.getpBusRoute(),p.getpOpening(),p.getpDesc(),p.getpPic());
    }

    //删除方法
    public void delete(String id) throws SQLException {
        String sql = SQLUtils.getSQLDelete("perf");
        daoUtil.update(sql,id);
    }

    //修改方法
    public void update(Performance p)throws SQLException {
        String sql = SQLUtils.getSQLUpdate("perf");
        daoUtil.update(sql,p.getpName(),p.getpPrice(),p.getpTel(),p.getpAddr(),p.getpBusRoute(),p.getpOpening(),p.getpDesc(),p.getpPic(),p.getpId());
    }

    public List<Performance> find(String pAddr, String pName){
        List<Performance> perfList = new ArrayList<Performance>();
        String sql = SQLUtils.getSQLSelect("perf");
        if(pAddr != null) {
            sql += " AND P_Addr like '%" + pAddr + "%'";
        }
        if(pName != null) {
            sql += " AND P_Name = '" + pName + "'";
        }
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while(rs.next()) {
                Performance p = new Performance();
                p.setpId(rs.getInt("P_Id"));
                p.setpName(rs.getString("P_Name"));
                p.setpPrice(rs.getString("P_Price"));
                p.setpTel(rs.getString("P_Tel"));
                p.setpAddr(rs.getString("P_Addr"));
                p.setpBusRoute(rs.getString("P_BusRoute"));
                p.setpOpening(rs.getString("P_Opening"));
                p.setpDesc(rs.getString("P_Desc"));
                p.setpPic(rs.getString("P_Pic"));
                perfList.add(p);
            }
            DBUtils.close(rs, stat, conn);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return perfList;
    }

    public Performance query(String pId){
        Performance p = new Performance();
        String sql = SQLUtils.getSQLSelect("perf");
        sql += " AND P_Id = " + pId;
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while(rs.next()) {
                p.setpId(rs.getInt("P_Id"));
                p.setpName(rs.getString("P_Name"));
                p.setpPrice(rs.getString("P_Price"));
                p.setpTel(rs.getString("P_Tel"));
                p.setpAddr(rs.getString("P_Addr"));
                p.setpBusRoute(rs.getString("P_BusRoute"));
                p.setpOpening(rs.getString("P_Opening"));
                p.setpDesc(rs.getString("P_Desc"));
                p.setpPic(rs.getString("P_Pic"));
            }
            DBUtils.close(rs, stat, conn);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return p;
    }
}

