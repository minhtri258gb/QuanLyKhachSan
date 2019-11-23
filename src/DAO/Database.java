/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import GUI.ThongBao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Massan
 */
public class Database
{

    private static Connection conn;
    private static Statement stmt;
    private static ResultSet rs;
	
	
	void connect()
	{
		String databaseName = "quanlykhachsan";
		String username = "root";
		String password = "";

		try
		{
                    Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/"+databaseName+"?useUnicode=true&characterEncoding=UTF-8";
			conn = DriverManager.getConnection(url, username, password);
			
			stmt = conn.createStatement();
		}
		catch(ClassNotFoundException e)
		{
			ThongBao.error("[Database:connect] Thiếu thư viện tích hợp: "+e);
			System.exit(1);
		}
		catch(SQLException e)
		{
			ThongBao.error("[Database:connect] Lỗi kết nối database:\n"+e);
			System.exit(1);
		}
	}
	
	ResultSet execution(String sql)
	{
		try
		{
			rs = stmt.executeQuery(sql);
		}
		catch(SQLException e)
		{
			ThongBao.warning("[Database:execution] "+e);
		}
		return rs;
	}
	
	void update(String sql)
	{
		try
		{
			stmt.executeUpdate(sql);
		}
		catch(SQLException e)
		{
			ThongBao.warning("[Database:update] "+e);
		}
	}
	
	void disconnect()
	{
		try
		{
			if(rs != null)
				rs.close();
			stmt.close();
			conn.close();
		}
		catch(SQLException e)
		{
			ThongBao.warning("[Database:disconnect] "+e);
		}
	}

}
