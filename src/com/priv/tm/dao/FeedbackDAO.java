package com.priv.tm.dao;

import com.priv.tm.base.Feedback;
import com.priv.tm.util.DBUtils;
import com.priv.tm.util.DaoUtil;
import com.priv.tm.util.SQLUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FeedbackDAO {
    private DaoUtil daoUtil;
    public FeedbackDAO(){
        daoUtil = new DaoUtil();}

    //添加方法
    public void insert(Feedback f) throws SQLException {
        String sql = SQLUtils.getSQLInsert("feedback");
        daoUtil.update(sql,f.getcId(),f.getfName(),f.getfTime(),f.getfCont());
    }

    //修改方法
    public void update(Feedback f)throws SQLException {
        String sql = SQLUtils.getSQLUpdate("feedback");
        daoUtil.update(sql,f.getfName(),f.getfTime(),f.getfCont(),f.getcId());
    }
    
    public Feedback query(String cId){
        Feedback f = new Feedback();
        String sql = SQLUtils.getSQLSelect("feedback");
        sql += " AND C_Id = " + cId;
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while(rs.next()) {
                f.setfId(rs.getInt("F_Id"));
                f.setcId(rs.getInt("C_Id"));
                f.setfName(rs.getString("F_Name"));
                f.setfTime(rs.getString("F_Time"));
                f.setfCont(rs.getString("F_Cont"));
            }
            DBUtils.close(rs, stat, conn);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return f;
    }
}

