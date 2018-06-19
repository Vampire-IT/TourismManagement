package com.priv.tm.util;
/**
 * 总控制类
 * 将增删改方法抽象化
 */


import java.sql.*;

public class DaoUtil {
	
	//增删改方法的抽象
	public void update(String sql,Object...args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			
			if(args != null) {
				for (int i = 0; i < args.length; i++) {
					ps.setObject(i+1, args[i]);
				}
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(null, ps, conn);
		}
	}
	
	//实现查询方法的抽象
		public Object qurey(String sql, ResultSetHandler handler, Object...args){
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			try{
				conn = DBUtils.getConnection();
				ps = conn.prepareStatement(sql);
				if(args != null){
					for (int i = 0;i < args.length;i++) {
						ps.setObject(i+1, args[i]);
					}
				}
				rs = ps.executeQuery();
				return handler.doHandler(rs);
			}catch(SQLException e){
				e.printStackTrace();
				return null;
			}finally{
				DBUtils.close(rs, ps, conn);
			}
		}
}
