/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.PhieuThuePhong;

/**
 *
 * @author Massan
 */
public class PhieuThuePhongDAO
{
	public static PhieuThuePhong get(int maptp)
	{
		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT * FROM PhieuThuePhong WHERE maptp="+maptp);
		
		try
		{
			while(rs.next())
			{
				PhieuThuePhong ptp = new PhieuThuePhong(rs.getInt(1));
				
				ptp.setMaPhg(rs.getInt(2));
				ptp.setNgayDen(rs.getString(3));
				ptp.setNgayDi(rs.getString(4));
				
				DB.disconnect();
				
				return ptp;
			}
		}
		catch(SQLException e)
		{
			System.out.println("[PhieuThuePhongDAO:get] error sql: "+e);
		}
		
		DB.disconnect();
		
		return null;
	}
	
	public static void add(PhieuThuePhong ptp)
	{
		Database DB = new Database();
		DB.connect();
		
		String sql = "INSERT INTO PhieuThuePhong (maphg, ngayden, ngaydi) VALUES ('";
		sql += ptp.getMaPHG()+"', '";
		sql += ptp.getNgayDen()+"', '";
		sql += ptp.getNgayDi()+"');";
		
		DB.update(sql);
		DB.disconnect();
	}

	public void delete(int maptp)
	{
		Database DB = new Database();
		DB.connect();
		DB.update("DELETE FROM PhieuThuePhong WHERE PhieuThuePhong.maptp="+maptp);
		DB.disconnect();
	}

	public static void edit(PhieuThuePhong ptp)
	{
		Database DB = new Database();
		DB.connect();
		
		String sql = "UPDATE PhieuThuePhong SET ";
		sql += "maphg='"							+ptp.getMaPHG();
		sql += "', ngayden='"						+ptp.getNgayDen();
		sql += "', ngaydi='"						+ptp.getNgayDi();
		sql += "' WHERE PhieuThuePhong.maptp = "	+ptp.getMaPTP()+";";
		
		DB.update(sql);
		DB.disconnect();
	}
	
	public static int getNewID()
	{
		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT MAX(maptp) FROM PhieuThuePhong");
		
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
			System.out.println("[PhieuThuePhongDAO:getNewID] error sql: "+e);
		}
		
		DB.disconnect();
		
		return -1;
	}
	
}
