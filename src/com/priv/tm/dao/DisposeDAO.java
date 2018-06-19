package com.priv.tm.dao;

import com.priv.tm.base.Dispose;
import com.priv.tm.util.DBUtils;
import com.priv.tm.util.DaoUtil;
import com.priv.tm.util.SQLUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisposeDAO {
    private DaoUtil daoUtil;
    public DisposeDAO(){
        daoUtil = new DaoUtil();}

    //添加方法
    public void insert(Dispose d) throws SQLException {
        String sql = SQLUtils.getSQLInsert("dispose");
        daoUtil.update(sql,d.getcId(),d.getdName(),d.getdTime(),d.getdFinish(),d.getdCont());
    }

    //修改方法
    public void update(Dispose d)throws SQLException {
        String sql = SQLUtils.getSQLUpdate("dispose");
        daoUtil.update(sql,d.getdName(),d.getdTime(),d.getdFinish(),d.getdCont(),d.getcId());
    }

    public Dispose query(String cId){
        Dispose d = new Dispose();
        String sql = SQLUtils.getSQLSelect("dispose");
        sql += " AND C_Id = " + cId;
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while(rs.next()) {
                d.setdId(rs.getInt("D_Id"));
                d.setcId(rs.getInt("C_Id"));
                d.setdName(rs.getString("D_Name"));
                d.setdTime(rs.getString("D_Time"));
                d.setdFinish(rs.getString("D_Finish"));
                d.setdCont(rs.getString("D_Cont"));
            }
            DBUtils.close(rs, stat, conn);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return d;
    }
}

