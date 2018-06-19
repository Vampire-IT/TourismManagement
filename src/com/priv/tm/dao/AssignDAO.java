package com.priv.tm.dao;

import com.priv.tm.base.Assign;
import com.priv.tm.util.DBUtils;
import com.priv.tm.util.DaoUtil;
import com.priv.tm.util.SQLUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AssignDAO {
    private DaoUtil daoUtil;
    public AssignDAO(){
        daoUtil = new DaoUtil();}

    //添加方法
    public void insert(Assign a) throws SQLException {
        String sql = SQLUtils.getSQLInsert("assign");
        daoUtil.update(sql,a.getcId(),a.getUsername(),a.getResult());
    }

    public void updateResult(String result, String id)throws SQLException {
        String sql = SQLUtils.getSQLResult();
        daoUtil.update(sql,result,id);
    }

    public List<Assign> find(String Username,String cTarget,String cName){
        List<Assign> assignList = new ArrayList<Assign>();
        String sql = SQLUtils.getSQLSelect("assign");
        if(Username != null) {
            sql += " AND a.Username = '" + Username + "'";
        }
        if(cTarget != null) {
            sql += " AND c.C_Target = '" + cTarget + "'";
        }
        if(cName != null) {
            sql += " AND c.C_Name = '" + cName + "'";
        }
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while(rs.next()) {
                Assign a = new Assign();
                a.setcId(rs.getInt("C_Id"));
                a.setcName(rs.getString("C_Name"));
                a.setcTel(rs.getString("C_Tel"));
                a.setcTargetType(rs.getString("C_TargetType"));
                a.setcTarget(rs.getString("C_Target"));
                a.setcTName(rs.getString("C_T_Name"));
                a.setcCont(rs.getString("C_Cont"));
                a.setcRecorder(rs.getString("C_Recorder"));
                a.setcTime(rs.getString("C_Time"));
                a.setcRemark(rs.getString("C_Remark"));
                a.setResult(rs.getString("Result"));
                a.setUsername(rs.getString("a.Username"));
                assignList.add(a);
            }
            DBUtils.close(rs, stat, conn);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return assignList;
    }
}

