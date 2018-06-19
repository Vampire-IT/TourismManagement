package com.priv.tm.active;


import com.priv.tm.base.Performance;
import com.priv.tm.dao.PerfDAO;

import java.sql.SQLException;
import java.util.List;

public class PerfActive {
    private PerfDAO perfDAO;
    public PerfActive() {
        perfDAO = new PerfDAO();
    }

    //添加方法
    public void insertP(Performance p) {
        try {
            perfDAO.insert(p);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //删除方法
    public void deleteP(String id) {
        try {
            perfDAO.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //修改方法
    public void updateP(Performance p) {
        try {
            perfDAO.update(p);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Performance> findP(String pAddr, String pName){
        return perfDAO.find(pAddr, pName);
    }

    public Performance queryP(String pId){
        return perfDAO.query(pId);
    }
}

