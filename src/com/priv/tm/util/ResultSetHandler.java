package com.priv.tm.util;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 结果处理器接口
 * @author DCYT
 *
 */
public interface ResultSetHandler {
	
	public Object doHandler(ResultSet rs)throws SQLException;
	
	
}
