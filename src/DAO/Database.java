/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
			String url = "jdbc:mysql://localhost:3306/"+databaseName+"?useUnicode=true&characterEncoding=UTF-8";
			conn = DriverManager.getConnection(url, username, password);
			Class.forName("com.mysql.jdbc.Driver");
			stmt = conn.createStatement();
		}
		catch(SQLException | ClassNotFoundException e)
		{
			System.out.println("[error] MainDatabase: "+e);
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
			System.out.println("[error] Database: "+e);
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
			System.out.println("[error] MainDatabase: "+e);
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
			System.out.println("[error] MainDatabase: "+e);
		}
	}

}
