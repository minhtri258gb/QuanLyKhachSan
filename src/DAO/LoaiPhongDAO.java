/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.LoaiPhong;
import GUI.ThongBao;

/**
 *
 * @author Massan
 */
public class LoaiPhongDAO
{
	
	public static ArrayList<LoaiPhong> load()
	{
		ArrayList<LoaiPhong> l_loaiphong = new ArrayList<>();
		
		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT * FROM loaiphong");
		
		try
		{
			while(rs.next())
			{
				LoaiPhong lphg = new LoaiPhong(rs.getInt(1));
				lphg.setTenloaiphg(rs.getString(2));
				lphg.setMota(rs.getString(3));
				lphg.setGia(rs.getInt(4));
				l_loaiphong.add(lphg);
			}
		}
		catch(SQLException e)
		{
			ThongBao.warning("[LoaiPhongDAO:load] "+e);
		}
		
		DB.disconnect();
		
		return l_loaiphong;
	}
	
	public static LoaiPhong getLoaiPhong(int malphg)
	{
		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT * FROM loaiphong WHERE maloaiphg='"+malphg+"'");
		
		try
		{
			while(rs.next())
			{
				LoaiPhong lphg = new LoaiPhong(rs.getInt(1));
				lphg.setTenloaiphg(rs.getString(2));
				lphg.setMota(rs.getString(3));
				lphg.setGia(rs.getInt(4));
				
				DB.disconnect();
				return lphg;
			}
		}
		catch(SQLException e)
		{
			ThongBao.warning("[LoaiPhongDAO:getLoaiPhong] "+e);
		}
		
		DB.disconnect();
		
		return null;
	}
	
	public static void add(LoaiPhong lphg)
	{
		Database DB = new Database();
		DB.connect();
		
		String sql = "INSERT INTO loaiphong (loaiphong, mota, gia) VALUES ('";
		sql += lphg.getTenLoaiPhg()+"', '";
		sql += lphg.getMota()+"', '";
		sql += lphg.getGia()+"');";
		
		DB.update(sql);
		DB.disconnect();
	}

	public static void delete(int maloaiphg)
	{
		Database DB = new Database();
		DB.connect();
		DB.update("DELETE FROM loaiphong WHERE maloaiphg="+maloaiphg);
		DB.disconnect();
	}

	public static void edit(LoaiPhong lphg)
	{
		Database DB = new Database();
		DB.connect();
		
		String sql = "UPDATE loaiphong SET ";
		sql += "loaiphong='"			+lphg.getTenLoaiPhg();
		sql += "', mota='"				+lphg.getMota();
		sql += "', gia='"				+lphg.getGia();
		sql += "' WHERE maloaiphg = "	+lphg.getMaLoaiPhg()+";";
		
		DB.update(sql);
		DB.disconnect();
	}

	public static int getNewID()
	{
		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT MAX(maloaiphg) FROM loaiphong");
		
		try
		{
			while(rs.next())
			{
				int newid = rs.getInt(1) + 1;
				DB.disconnect();
				return newid;
			}
		}
		catch(SQLException e)
		{
			System.out.println("[LoaiPhongDAO:getNewID] error sql: "+e);
		}
		
		DB.disconnect();
		
		return -1;
	}
	
}
