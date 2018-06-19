package com.priv.tm.active;


import com.priv.tm.base.Dispose;
import com.priv.tm.dao.DisposeDAO;

import java.sql.SQLException;

public class DisposeActive {
    private DisposeDAO disposeDao;
    public DisposeActive() {
        disposeDao = new DisposeDAO();
    }

    //添加方法
    public void insertD(Dispose d) {
        try {
            disposeDao.insert(d);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //修改方法
    public void updateD(Dispose d) {
        try {
            disposeDao.update(d);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Dispose queryD(String cId){
        return disposeDao.query(cId);
    }
}

