/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.PhieuDichVu;
import GUI.ThongBao;
import java.util.ArrayList;

/**
 *
 * @author Massan
 */
public class PhieuDichVuDAO
{
	public static ArrayList<PhieuDichVu> load()
	{
		Database DB = new Database();
		DB.connect();
		ArrayList<PhieuDichVu> l_phieudv = new ArrayList<>();
		String sql="SELECT * FROM phieudichvu";
		ResultSet rs = DB.execution(sql);
		try {
			while (rs.next())
			{
				PhieuDichVu pdv = new PhieuDichVu(rs.getInt(1), rs.getInt(2));
				pdv.setNgayDat(rs.getString(3));
				pdv.setSoLuong(rs.getInt(4));
				l_phieudv.add(pdv);							
			}
		} catch (SQLException e) {
			ThongBao.warning("[PhieuDichVuDAO:load] " + e);
		}

		DB.disconnect();
		return l_phieudv;
	}
	
	public static ArrayList<PhieuDichVu> get(int macthd)
	{
		Database DB = new Database();
		DB.connect();
		ArrayList<PhieuDichVu> l_phieudv = new ArrayList<>();
		String sql="SELECT * FROM PhieuDichVu WHERE macthd=" + macthd;
		ResultSet rs = DB.execution(sql);
		try {
			while (rs.next())
			{
				PhieuDichVu pdv = new PhieuDichVu(rs.getInt(1), rs.getInt(2));
				pdv.setNgayDat(rs.getString(3));
				pdv.setSoLuong(rs.getInt(4));
				pdv.setM_machitiethoadon(rs.getInt(5));
				l_phieudv.add(pdv);							
			}
			
		} catch (SQLException e) {
			ThongBao.warning("[PhieuDichVuDAO:get] " + e);
			return null;
		}

		DB.disconnect();

		return l_phieudv;
	}
	public static void edit(PhieuDichVu pdv)
	{
		
	}

	public int getnewidphieudichvu() {
		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT MAX(mapdv) FROM phieudichvu");

		try {
			while (rs.next()) {
				int newid = rs.getInt(1) + 1;
				DB.disconnect();
				return newid;
			}
		} catch (SQLException e) {
			System.out.println("[ChiTietHoaDonDAO:getNewID] error sql: " + e);
		}

		DB.disconnect();

		return -1;
	}

	public static void add(PhieuDichVu pdv) {
		Database DB = new Database();
		DB.connect();

		String sql = "INSERT INTO phieudichvu (madv, ngaydat, soluong,macthd) VALUES ('";
		sql += pdv.getMaDV() + "', '";
		sql += pdv.getNgayDat() + "', '";
		sql += pdv.getSoLuong() + "','";
		sql += pdv.getM_machitiethoadon()+ "');";
		DB.update(sql);
		DB.disconnect();
	}
	public static int getNewID()
	{
		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT MAX(mapdv) FROM phieudichvu");
		
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
			System.out.println("[PhieuDichVuDAO:getNewID] error sql: "+e);
		}
		
		DB.disconnect();
		
		return -1;
	}

}
