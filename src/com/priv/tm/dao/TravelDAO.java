package com.priv.tm.dao;

import com.priv.tm.base.Travel;
import com.priv.tm.util.DBUtils;
import com.priv.tm.util.DaoUtil;
import com.priv.tm.util.SQLUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TravelDAO {
    private DaoUtil daoUtil;
    public TravelDAO(){
        daoUtil = new DaoUtil();}
    //添加方法
    public void insert(Travel t) throws SQLException {
        String sql = SQLUtils.getSQLInsert("travel");
        daoUtil.update(sql,t.gettName(),t.gettLinkman(),t.gettTel(),t.gettFax(),t.gettQq(),t.gettEmail(),t.gettAddr(),t.gettDesc());
    }

    //删除方法
    public void delete(String id) throws SQLException {
        String sql = SQLUtils.getSQLDelete("travel");
        daoUtil.update(sql,id);
    }

    //修改方法
    public void update(Travel t)throws SQLException {
        String sql = SQLUtils.getSQLUpdate("travel");
        daoUtil.update(sql,t.gettName(),t.gettLinkman(),t.gettTel(),t.gettFax(),t.gettQq(),t.gettEmail(),t.gettAddr(),t.gettDesc(),t.gettId());
    }

    public List<Travel> find(String tName){
        List<Travel> travelList = new ArrayList<Travel>();
        String sql = SQLUtils.getSQLSelect("travel");
        if(tName != null) {
            sql += " AND T_Name like '%" + tName + "%'";
        }
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while(rs.next()) {
                Travel t = new Travel();
                t.settId(rs.getInt("T_Id"));
                t.settName(rs.getString("T_Name"));
                t.settLinkman(rs.getString("T_Linkman"));
                t.settTel(rs.getString("T_Tel"));
                t.settFax(rs.getString("T_Fax"));
                t.settQq(rs.getString("T_QQ"));
                t.settEmail(rs.getString("T_Email"));
                t.settAddr(rs.getString("T_Addr"));
                t.settDesc(rs.getString("T_Desc"));
                travelList.add(t);
            }
            DBUtils.close(rs, stat, conn);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return travelList;
    }

    public Travel query(String tId){
        Travel t = new Travel();
        String sql = SQLUtils.getSQLSelect("travel");
        sql += " AND T_Id = " + tId;
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while(rs.next()) {
                t.settId(rs.getInt("T_Id"));
                t.settName(rs.getString("T_Name"));
                t.settLinkman(rs.getString("T_Linkman"));
                t.settTel(rs.getString("T_Tel"));
                t.settFax(rs.getString("T_Fax"));
                t.settQq(rs.getString("T_QQ"));
                t.settEmail(rs.getString("T_Email"));
                t.settAddr(rs.getString("T_Addr"));
                t.settDesc(rs.getString("T_Desc"));
            }
            DBUtils.close(rs, stat, conn);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return t;
    }
}

