/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.ChiTietHoaDon;

/**
 *
 * @author Massan
 */
public class ChiTietHoaDonDAO
{
	public ArrayList<ChiTietHoaDon> get(int mahd)
	{
		ArrayList<ChiTietHoaDon> l_chitiet = new ArrayList<>();
		ArrayList<Integer> l_maptp = new ArrayList<>();
		ArrayList<Integer> l_mapdv = new ArrayList<>();
		
		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT * FROM ChiTietHoaDon WHERE mahd="+mahd);
		
		try
		{
			while(rs.next())
			{
				ChiTietHoaDon cthd = new ChiTietHoaDon(rs.getInt(1));
				cthd.setThanhtien(rs.getInt(5));
				
				l_maptp.add(rs.getInt(3));
				l_mapdv.add(rs.getInt(4));
				l_chitiet.add(cthd);
			}
		}
		catch(SQLException e)
		{
			System.out.println("[ChiTietHoaDonDAO:get] error sql: "+e);
		}
		
		DB.disconnect();
		
		PhieuThuePhongDAO ptpDAO = new PhieuThuePhongDAO();
		PhieuDichVuDAO pdvDAO = new PhieuDichVuDAO();
		
		int sizeArr = l_chitiet.size();
		for(int i=0; i<sizeArr; i++)
		{
			int id = l_maptp.get(i);
			if(id != 0)
				l_chitiet.get(i).setPhieuThuePhong(ptpDAO.get(id));
			
			id = l_mapdv.get(i);
			if(id != 0)
				l_chitiet.get(i).setPhieuDichVu(pdvDAO.get(id));
		}
		
		return l_chitiet;
	}
	
	public void add(ChiTietHoaDon cthd, int mahd)
	{
		Database DB = new Database();
		DB.connect();
		
		String sql = "INSERT INTO ChiTietHoaDon (mahd, maptp, mapdv, thanhtien) VALUES ('";
		sql += mahd+"', '";
		sql += cthd.getPhieuThuePhong().getMaPTP()+"', '";
		sql += cthd.getPhieuDichVu().getMaPDV()+"', '0');";
		
		DB.update(sql);
		DB.disconnect();
	}

	public void delete(int macthd)
	{
		Database DB = new Database();
		DB.connect();
		DB.update("DELETE FROM ChiTietHoaDon WHERE ChiTietHoaDon.macthd="+macthd);
		DB.disconnect();
	}

	public void edit(ChiTietHoaDon cthd)
	{
		Database DB = new Database();
		DB.connect();
		
		String sql = "UPDATE ChiTietHoaDon SET ";
		sql += "maptp='"							+cthd.getPhieuThuePhong().getMaPTP();
		sql += "', mapdv='"						+cthd.getPhieuDichVu().getMaPDV();
		sql += "', thanhtien='"					+cthd.getThanhtien();
		sql += "' WHERE ChiTietHoaDon.macthd = "	+cthd.getMaCTHD()+";";
		
		DB.update(sql);
		DB.disconnect();
	}
	
	public int getNewID()
	{
		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT MAX(macthd) FROM ChiTietHoaDon");
		
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
			System.out.println("[ChiTietHoaDonDAO:getNewID] error sql: "+e);
		}
		
		DB.disconnect();
		
		return -1;
	}
	
}
