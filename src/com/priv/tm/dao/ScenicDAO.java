package com.priv.tm.dao;

import com.priv.tm.base.Scenic;
import com.priv.tm.util.DBUtils;
import com.priv.tm.util.DaoUtil;
import com.priv.tm.util.SQLUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ScenicDAO {
    private DaoUtil daoUtil;
    public ScenicDAO(){
        daoUtil = new DaoUtil();}
    //添加方法
    public void insert(Scenic s) throws SQLException {
        String sql = SQLUtils.getSQLInsert("scenic");
        daoUtil.update(sql,s.getsName(),s.getsType(),s.getsStanPrice(),s.getsDiscPrice(),s.getsTel(),s.getsUrl(),s.getsBusRoute(),s.getsParkSpace(),s.getsOpening(),s.getsAddr(),s.getsDesc(),s.getsPic());
    }

    //删除方法
    public void delete(String id) throws SQLException {
        String sql = SQLUtils.getSQLDelete("scenic");
        daoUtil.update(sql,id);
    }

    //修改方法
    public void update(Scenic s)throws SQLException {
        String sql = SQLUtils.getSQLUpdate("scenic");
        daoUtil.update(sql,s.getsName(),s.getsType(),s.getsStanPrice(),s.getsDiscPrice(),s.getsTel(),s.getsUrl(),s.getsBusRoute(),s.getsParkSpace(),s.getsOpening(),s.getsAddr(),s.getsDesc(),s.getsPic(),s.getsId());
    }

    public List<Scenic> find(String sAddr, String sName){
        List<Scenic> scenicList = new ArrayList<Scenic>();
        String sql = SQLUtils.getSQLSelect("scenic");
        if(sAddr != null) {
            sql += " AND S_Addr like '%" + sAddr + "%'";
        }
        if(sName != null) {
            sql += " AND S_Name = '" + sName + "'";
        }
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while(rs.next()) {
                Scenic s = new Scenic();
                s.setsId(rs.getInt("S_Id"));
                s.setsName(rs.getString("S_Name"));
                s.setsType(rs.getString("S_Type"));
                s.setsStanPrice(rs.getString("S_StanPrice"));
                s.setsDiscPrice(rs.getString("S_DiscPrice"));
                s.setsTel(rs.getString("S_Tel"));
                s.setsUrl(rs.getString("S_Url"));
                s.setsBusRoute(rs.getString("S_BusRoute"));
                s.setsParkSpace(rs.getString("S_ParkSpace"));
                s.setsOpening(rs.getString("S_Opening"));
                s.setsAddr(rs.getString("S_Addr"));
                s.setsDesc(rs.getString("S_Desc"));
                s.setsPic(rs.getString("S_Pic"));
                scenicList.add(s);
            }
            DBUtils.close(rs, stat, conn);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return scenicList;
    }

    public Scenic query(String sId){
        Scenic s = new Scenic();
        String sql = SQLUtils.getSQLSelect("scenic");
        sql += " AND S_Id = " + sId;
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while(rs.next()) {
                s.setsId(rs.getInt("S_Id"));
                s.setsName(rs.getString("S_Name"));
                s.setsType(rs.getString("S_Type"));
                s.setsStanPrice(rs.getString("S_StanPrice"));
                s.setsDiscPrice(rs.getString("S_DiscPrice"));
                s.setsTel(rs.getString("S_Tel"));
                s.setsUrl(rs.getString("S_Url"));
                s.setsBusRoute(rs.getString("S_BusRoute"));
                s.setsParkSpace(rs.getString("S_ParkSpace"));
                s.setsOpening(rs.getString("S_Opening"));
                s.setsAddr(rs.getString("S_Addr"));
                s.setsDesc(rs.getString("S_Desc"));
                s.setsPic(rs.getString("S_Pic"));
            }
            DBUtils.close(rs, stat, conn);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return s;
    }
}

