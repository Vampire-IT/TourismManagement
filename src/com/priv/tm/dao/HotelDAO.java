package com.priv.tm.dao;

import com.priv.tm.base.Hotel;
import com.priv.tm.util.DBUtils;
import com.priv.tm.util.DaoUtil;
import com.priv.tm.util.SQLUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO {
    private DaoUtil daoUtil;
    public HotelDAO(){
        daoUtil = new DaoUtil();}
    //添加方法
    public void insert(Hotel h) throws SQLException {
        String sql = SQLUtils.getSQLInsert("hotel");
        daoUtil.update(sql,h.gethName(),h.gethRating(),h.gethStanPrice(),h.gethDiscPrice(),h.gethTel(),h.gethUrl(),h.gethBusRoute(),h.gethParkSpace(),h.gethOpening(),h.gethAddr(),h.gethDesc(),h.gethPic());
    }

    //删除方法
    public void delete(String id) throws SQLException {
        String sql = SQLUtils.getSQLDelete("hotel");
        daoUtil.update(sql,id);
    }

    //修改方法
    public void update(Hotel h)throws SQLException {
        String sql = SQLUtils.getSQLUpdate("hotel");
        daoUtil.update(sql,h.gethName(),h.gethRating(),h.gethStanPrice(),h.gethDiscPrice(),h.gethTel(),h.gethUrl(),h.gethBusRoute(),h.gethParkSpace(),h.gethOpening(),h.gethAddr(),h.gethDesc(),h.gethPic(),h.gethId());
    }

    public List<Hotel> find(String hAddr, String hName, String hRatin){
        List<Hotel> hotelList = new ArrayList<Hotel>();
        String sql = SQLUtils.getSQLSelect("hotel");
        if(hAddr != null) {
            sql += " AND H_Addr like '%" + hAddr + "%'";
        }
        if(hName != null) {
            sql += " AND H_Name = '" + hName + "'";
        }
        if(hRatin != null) {
            sql += " AND H_Rating = '" + hRatin + "'";
        }
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while(rs.next()) {
                Hotel h = new Hotel();
                h.sethId(rs.getInt("H_Id"));
                h.sethName(rs.getString("H_Name"));
                h.sethRating(rs.getString("H_Rating"));
                h.sethStanPrice(rs.getString("H_StanPrice"));
                h.sethDiscPrice(rs.getString("H_DiscPrice"));
                h.sethTel(rs.getString("H_Tel"));
                h.sethUrl(rs.getString("H_Url"));
                h.sethBusRoute(rs.getString("H_BusRoute"));
                h.sethParkSpace(rs.getString("H_ParkSpace"));
                h.sethOpening(rs.getString("H_Opening"));
                h.sethAddr(rs.getString("H_Addr"));
                h.sethDesc(rs.getString("H_Desc"));
                h.sethPic(rs.getString("H_Pic"));
                hotelList.add(h);
            }
            DBUtils.close(rs, stat, conn);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return hotelList;
    }

    public Hotel query(String hId){
        Hotel h = new Hotel();
        String sql = SQLUtils.getSQLSelect("hotel");
        sql += " AND H_Id = " + hId;
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while(rs.next()) {
                h.sethId(rs.getInt("H_Id"));
                h.sethName(rs.getString("H_Name"));
                h.sethRating(rs.getString("H_Rating"));
                h.sethStanPrice(rs.getString("H_StanPrice"));
                h.sethDiscPrice(rs.getString("H_DiscPrice"));
                h.sethTel(rs.getString("H_Tel"));
                h.sethUrl(rs.getString("H_Url"));
                h.sethBusRoute(rs.getString("H_BusRoute"));
                h.sethParkSpace(rs.getString("H_ParkSpace"));
                h.sethOpening(rs.getString("H_Opening"));
                h.sethAddr(rs.getString("H_Addr"));
                h.sethDesc(rs.getString("H_Desc"));
                h.sethPic(rs.getString("H_Pic"));
            }
            DBUtils.close(rs, stat, conn);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return h;
    }
}

