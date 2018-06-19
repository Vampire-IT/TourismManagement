package com.priv.tm.dao;

import com.priv.tm.base.Hotel;
import com.priv.tm.base.Restaurant;
import com.priv.tm.util.DBUtils;
import com.priv.tm.util.DaoUtil;
import com.priv.tm.util.SQLUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RestDAO {
    private DaoUtil daoUtil;
    public RestDAO(){
        daoUtil = new DaoUtil();}
    //添加方法
    public void insert(Restaurant r) throws SQLException {
        String sql = SQLUtils.getSQLInsert("rest");
        daoUtil.update(sql,r.getrName(),r.getrAvgPrice(),r.getrTel(),r.getrUrl(),r.getrBusRoute(),r.getrParkSpace(),r.getrOpening(),r.getrAddr(),r.getrDesc(),r.getrPic());
    }

    //删除方法
    public void delete(String id) throws SQLException {
        String sql = SQLUtils.getSQLDelete("rest");
        daoUtil.update(sql,id);
    }

    //修改方法
    public void update(Restaurant r)throws SQLException {
        String sql = SQLUtils.getSQLUpdate("rest");
        daoUtil.update(sql,r.getrName(),r.getrAvgPrice(),r.getrTel(),r.getrUrl(),r.getrBusRoute(),r.getrParkSpace(),r.getrOpening(),r.getrAddr(),r.getrDesc(),r.getrPic(),r.getrId());
    }

    public List<Restaurant> find(String rAddr, String rName){
        List<Restaurant> restList = new ArrayList<Restaurant>();
        String sql = SQLUtils.getSQLSelect("rest");
        if(rAddr != null) {
            sql += " AND R_Addr like '%" + rAddr + "%'";
        }
        if(rName != null) {
            sql += " AND R_Name = '" + rName + "'";
        }
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while(rs.next()) {
                Restaurant r = new Restaurant();
                r.setrId(rs.getInt("R_Id"));
                r.setrName(rs.getString("R_Name"));
                r.setrAvgPrice(rs.getString("R_AvgPrice"));
                r.setrTel(rs.getString("R_Tel"));
                r.setrUrl(rs.getString("R_Url"));
                r.setrBusRoute(rs.getString("R_BusRoute"));
                r.setrParkSpace(rs.getString("R_ParkSpace"));
                r.setrOpening(rs.getString("R_Opening"));
                r.setrAddr(rs.getString("R_Addr"));
                r.setrDesc(rs.getString("R_Desc"));
                r.setrPic(rs.getString("R_Pic"));
                restList.add(r);
            }
            DBUtils.close(rs, stat, conn);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return restList;
    }

    public Restaurant query(String rId){
        Restaurant r = new Restaurant();
        String sql = SQLUtils.getSQLSelect("rest");
        sql += " AND R_Id = " + rId;
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while(rs.next()) {
                r.setrId(rs.getInt("R_Id"));
                r.setrName(rs.getString("R_Name"));
                r.setrAvgPrice(rs.getString("R_AvgPrice"));
                r.setrTel(rs.getString("R_Tel"));
                r.setrUrl(rs.getString("R_Url"));
                r.setrBusRoute(rs.getString("R_BusRoute"));
                r.setrParkSpace(rs.getString("R_ParkSpace"));
                r.setrOpening(rs.getString("R_Opening"));
                r.setrAddr(rs.getString("R_Addr"));
                r.setrDesc(rs.getString("R_Desc"));
                r.setrPic(rs.getString("R_Pic"));
            }
            DBUtils.close(rs, stat, conn);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return r;
    }
}

