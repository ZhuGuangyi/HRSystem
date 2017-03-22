package com.leon.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC封装，JDBC工具类
 * 
 * @author spring
 */
public class DbUtil
{
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static String dbDriver;
	private static String dbUrl;
	private static String dbUsername;
	private static String dbPwd;

	static
	{
		try
		{
			// 读取db.properties配置文件
			readProp();
			// 加载驱动
			loadDriver();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 读取db.properties配置文件中的内容
	 * 
	 * @throws IOException
	 */
	public static void readProp() throws IOException
	{
		Properties properties = new Properties();
		properties.load(DbUtil.class.getResourceAsStream("/conf/db.properties"));
		dbDriver = (String) properties.getProperty("dbDriver");
		dbUrl = (String) properties.getProperty("dbUrl");
		dbUsername = (String) properties.getProperty("dbUsername");
		dbPwd = (String) properties.getProperty("dbPwd");
	}

	/**
	 * 1.加载驱动
	 * 
	 * @throws ClassNotFoundException
	 */
	public static void loadDriver() throws ClassNotFoundException
	{
		Class.forName(dbDriver);
	}

	/**
	 * 2.创建连接
	 * 
	 * @throws SQLException
	 */
	public static void getConnect() throws SQLException
	{
		conn = DriverManager.getConnection(dbUrl, dbUsername, dbPwd);
		System.out.println("数据库连接成功!");
	}

	/**
	 * 3.创建PreparedStatement对象，同时给?注入值
	 * 
	 * @param sql
	 * @param params
	 * @throws SQLException
	 */
	public static void getPstmt(String sql, Object[] params)
			throws SQLException
	{
		getConnect();
		pstmt = conn.prepareStatement(sql);
		// 给？注入值
		for (int i = 0; i < params.length; i++)
		{
			pstmt.setObject(i + 1, params[i]);
		}
	}

	/**
	 * 4.执行统一的增删改操作
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public static boolean executeUpdate(String sql, Object[] params)
	{
		int flag = 0;
		try
		{
			getPstmt(sql, params);
			flag = pstmt.executeUpdate();
			close(rs);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return flag != 0 ? true : false;
	}

	/**
	 * 5.执行统一的查询操作
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public static ResultSet executeQuery(String sql, Object[] params)
	{
		try
		{
			getPstmt(sql, params);
			rs = pstmt.executeQuery();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 6.关闭资源
	 * 
	 * @param rs
	 */
	public static void close(ResultSet rs)
	{
		try
		{
			if (rs != null)
			{
				rs.close();
			}
			if (pstmt != null)
			{
				pstmt.close();
			}
			if (conn != null)
			{
				conn.close();
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
