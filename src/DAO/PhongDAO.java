/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.Phong;

/**
 *
 * @author Massan
 */
public class PhongDAO
{
	
	public ArrayList<Phong> load()
	{
		ArrayList<Phong> l_dichvu = new ArrayList<>();
		
		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT * FROM Phong");
		
		try
		{
			while(rs.next())
			{
				Phong phg = new Phong(rs.getInt(1));

				phg.setMaloaiphg(rs.getInt(2));
				phg.setTinhtrang(rs.getString(3));
				// TODO List CHITIET
				l_dichvu.add(phg);
			}
		}
		catch(SQLException e)
		{
			System.out.println("[PhongDAO:load] error sql: "+e);
		}
		
		DB.disconnect();
		
		return l_dichvu;
	}
	
	public void add(Phong phg)
	{
		Database DB = new Database();
		DB.connect();
		
		String sql = "INSERT INTO Phong (maloaiphg, tinhtrang) VALUES ('";
		sql += phg.getMaloaiphg()+"', '";
		sql += phg.getTinhtrang()+"', '";
		
		DB.update(sql);
		DB.disconnect();
	}

	public void delete(int maphg)
	{
		Database DB = new Database();
		DB.connect();
		DB.update("DELETE FROM Phong WHERE Phong.maphg="+maphg);
		DB.disconnect();
	}

	public static void edit(Phong phg)
	{
		Database DB = new Database();
		DB.connect();
		
		String sql = "UPDATE Phong SET ";
		sql += "maloaiphg='"				+phg.getMaloaiphg();
		sql += "', tinhtrang='"			+phg.getTinhtrang();
		sql += "' WHERE Phong.maphg = "	+phg.getMaphg()+";";
		
		DB.update(sql);
		DB.disconnect();
	}
	public static Phong getphong(int maphong)
	{
		
		Phong phg=new Phong(maphong);
		Database DB = new Database();
		DB.connect();
		String sql="select * from phong where maphg='"+maphong+"'";
		ResultSet rs=DB.execution(sql);
		try
		{
			while(rs.next())
			{

				phg.setMaloaiphg(rs.getInt(2));
				phg.setTinhtrang(rs.getString(3));
			}
		}
		catch(SQLException e)
		{
			System.out.println("[PhongDAO:load] error sql: "+e);
		}
		DB.disconnect();
		return phg;
		
		
	}

}
