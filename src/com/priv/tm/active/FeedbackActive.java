package com.priv.tm.active;


import com.priv.tm.base.Dispose;
import com.priv.tm.base.Feedback;
import com.priv.tm.dao.FeedbackDAO;

import java.sql.SQLException;

public class FeedbackActive {
    private FeedbackDAO feedbackDAO;
    public FeedbackActive() {
        feedbackDAO = new FeedbackDAO();
    }

    //添加方法
    public void insertF(Feedback f) {
        try {
            feedbackDAO.insert(f);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //修改方法
    public void updateF(Feedback f) {
        try {
            feedbackDAO.update(f);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Feedback queryF(String cId){
        return feedbackDAO.query(cId);
    }
}

