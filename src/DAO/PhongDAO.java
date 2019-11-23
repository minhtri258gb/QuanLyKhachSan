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
import GUI.ThongBao;

/**
 *
 * @author Massan
 */
public class PhongDAO
{
	
	public static ArrayList<Phong> load()
	{
		ArrayList<Phong> l_dichvu = new ArrayList<>();
		
		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT * FROM phong");
		
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
			ThongBao.warning("[PhongDAO:load] "+e);
		}
		
		DB.disconnect();
		
		return l_dichvu;
	}
	
	public static Phong getPhong(int maphg)
	{
		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT * FROM phong WHERE maphg='"+maphg+"'");
		
		try
		{
			while(rs.next())
			{
				Phong phg = new Phong(rs.getInt(1));

				phg.setMaloaiphg(rs.getInt(2));
				phg.setTinhtrang(rs.getString(3));
				
				DB.disconnect();
				return phg;
			}
		}
		catch(SQLException e)
		{
			ThongBao.warning("[PhongDAO:getPhong] "+e);
		}
		
		DB.disconnect();
		
		return null;
	}
	
	public static void add(Phong phg)
	{
		Database DB = new Database();
		DB.connect();
		
		String sql = "INSERT INTO Phong (maphg, maloaiphg, tinhtrang) VALUES ('";
		sql += phg.getMaphg()+"', '";
		sql += phg.getMaloaiphg()+"', '";
		sql += phg.getTinhtrang()+"')";
		
		DB.update(sql);
		DB.disconnect();
	}

	public static void delete(int maphg)
	{
		Database DB = new Database();
		DB.connect();
		DB.update("DELETE FROM phong WHERE maphg="+maphg);
		DB.disconnect();
	}

	public static void edit(Phong phg)
	{
		Database DB = new Database();
		DB.connect();
		
		String sql = "UPDATE phong SET ";
		sql += "maloaiphg='"				+phg.getMaloaiphg();
		sql += "', tinhtrang='"			+phg.getTinhtrang();
		sql += "' WHERE maphg = "			+phg.getMaphg()+";";
		
		DB.update(sql);
		DB.disconnect();
	}

}
