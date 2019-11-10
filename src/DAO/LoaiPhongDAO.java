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

/**
 *
 * @author Massan
 */
public class LoaiPhongDAO
{
	
	public ArrayList<LoaiPhong> load()
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
			System.out.println("[LoaiPhongDAO:load] error sql: "+e);
		}
		
		DB.disconnect();
		
		return l_loaiphong;
	}
	
	public void add(LoaiPhong phg)
	{
		Database DB = new Database();
		DB.connect();
		
		String sql = "INSERT INTO loaiphong (loaiphong, mota, gia) VALUES ('";
		sql += phg.getTenLoaiPhg()+"', '";
		sql += phg.getMota()+"', '";
		sql += phg.getGia()+"');";
		
		DB.update(sql);
		DB.disconnect();
	}

	public void delete(int maloaiphg)
	{
		Database DB = new Database();
		DB.connect();
		DB.update("DELETE FROM loaiphong WHERE loaiphong.maloaiphg="+maloaiphg);
		DB.disconnect();
	}

	public void edit(LoaiPhong lphg)
	{
		Database DB = new Database();
		DB.connect();
		
		String sql = "UPDATE loaiphong SET ";
		sql += "loaiphong='"                    +lphg.getTenLoaiPhg();
		sql += "', mota='"                      +lphg.getMota();
		sql += "', gia='"                       +lphg.getGia();
		sql += "' WHERE loaiphong.maloaiphg = " +lphg.getMaLoaiPhg()+";";
		
		DB.update(sql);
		DB.disconnect();
	}

}
