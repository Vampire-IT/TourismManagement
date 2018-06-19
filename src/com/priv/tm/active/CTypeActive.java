package com.priv.tm.active;


import com.priv.tm.base.CType;
import com.priv.tm.dao.CTypeDAO;
import java.sql.SQLException;
import java.util.List;

public class CTypeActive {
    private CTypeDAO cTypeDAO;
    public CTypeActive() {
        cTypeDAO = new CTypeDAO();
    }

    //添加方法
    public void insertCT(CType ct) {
        try {
            cTypeDAO.insert(ct);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //删除方法
    public void deleteCT(String id) {
        try {
            cTypeDAO.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //修改方法
    public void updateCT(CType ct) {
        try {
            cTypeDAO.update(ct);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //修改投诉类别状态
    public void upStateCT(CType ct) {
        try {
            cTypeDAO.upState(ct);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CType> findCT(String ctName, String state){
        return cTypeDAO.find(ctName, state);
    }

    public CType queryCT(String cTId){
        return cTypeDAO.query(cTId);
    }
}

