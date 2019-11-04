/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.HoaDon;

/**
 *
 * @author Massan
 */
public class HoaDonDAO
{
	public ArrayList<HoaDon> load()
	{
		ArrayList<HoaDon> l_hoadon = new ArrayList<HoaDon>();
		
		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT * FROM HoaDon");
		
		try
		{
			while(rs.next())
			{
				HoaDon hd = new HoaDon(rs.getInt(1), rs.getInt(2), rs.getInt(3));

				hd.setNgayLap(rs.getString(4));
				hd.setTongtien(rs.getInt(5));
				l_hoadon.add(hd);
			}
		}
		catch(SQLException e)
		{
			System.out.println("[HoaDonDAO:load] error sql: "+e);
		}
		
		DB.disconnect();
		
		return l_hoadon;
	}
	
	public void add(HoaDon hd)
	{
		Database DB = new Database();
		DB.connect();
		
		String sql = "INSERT INTO HoaDon (makh, manv, ngaylap, tongtien) VALUES ('";
		sql += hd.getMaKH()+"', '";
		sql += hd.getMaNV()+"', '";
		sql += hd.getNgayLap()+"', '";
		sql += hd.getTongtien()+"');";
		
		DB.update(sql);
		DB.disconnect();
	}

	public void delete(int mahd)
	{
		Database DB = new Database();
		DB.connect();
		DB.update("DELETE FROM HoaDon WHERE HoaDon.mahd="+mahd);
		DB.disconnect();
	}

	public void edit(HoaDon hd)
	{
		Database DB = new Database();
		DB.connect();
		
		String sql = "UPDATE HoaDon SET ";
		sql += "ngaylap='"					+hd.getNgayLap();
		sql += "', tongtien='"					+hd.getTongtien();
		sql += "' WHERE HoaDon.mahd = "		+hd.getMaHD()+";";
		
		DB.update(sql);
		DB.disconnect();
	}
	
	public HoaDon getFromMaKH(int makh)
	{
		// TODO
		System.out.print("[HoaDon:getFromMaKH] noitice: chua lam");
		return null;
	}
	
	public HoaDon getFromMaPhg(int maphg)
	{
		// TODO
		System.out.print("[HoaDon:getFromMaPhg] noitice: chua lam");
		return null;
	}
	
}
