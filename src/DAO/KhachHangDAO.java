/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.KhachHang;

/**
 *
 * @author tuan gh
 */
public class KhachHangDAO
{
	public ArrayList<KhachHang> load()
	{
		ArrayList<KhachHang> listKhachHang = new ArrayList<KhachHang>();
		
		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT * FROM KhachHang");
		
		try
		{
			while(rs.next())
			{
				KhachHang kh = new KhachHang(rs.getInt(1));

				kh.setHo(rs.getString(2));
				kh.setTen(rs.getString(3));
				kh.setGioiTinh(rs.getInt(4));
				kh.setNgaySinh(rs.getString(5));
				kh.setSoDienThoai(rs.getInt(6));
				kh.setEmail(rs.getString(7));
				kh.setCMND(rs.getInt(8));
				kh.setQuocTich(rs.getString(9));
				listKhachHang.add(kh);
			}
		}
		catch(SQLException e)
		{
			System.out.println("[KhachHangDAO:load] error sql: "+e);
        }
		
		DB.disconnect();
		
		return listKhachHang;
	}
	
	public void add(KhachHang kh)
	{
		Database DB = new Database();
		DB.connect();
		
		String sql = "INSERT INTO `KhachHang` (`ho`, `ten`, `gioitinh`, `ngaysinh`, `sdt`, `email`, `cmnd`, `quoctich`) VALUES ('";
		sql += kh.getHo()+"', '";
		sql += kh.getTen()+"', '";
		sql += kh.getGioiTinh()+"', '";
		sql += kh.getNgaySinh()+"', '";
		sql += kh.getSoDienThoai()+"', '";
		sql += kh.getEmail()+"', '";
		sql += kh.getCMND()+"', '";
		sql += kh.getQuocTich()+"');";
		
		DB.update(sql);
		DB.disconnect();
	}

	public void delete(int makh)
	{
		Database DB = new Database();
		DB.connect();
		
		String sql = "DELETE FROM `KhachHang` WHERE `Khachhang`.`makh` = " + makh;
		DB.update(sql);
		DB.disconnect();
	}

	public void edit(KhachHang kh)
	{
		Database DB = new Database();
		DB.connect();
		
		String sql = "UPDATE `KhachHang` SET ";
		sql += "`ho` = '"						+kh.getHo();
		sql += "', `ten` = '"					+kh.getTen();
		sql += "', `gioitinh` = '"				+kh.getGioiTinh();
		sql += "', `ngaysinh` = '"				+kh.getNgaySinh();
		sql += "', `sdt` = '"					+kh.getSoDienThoai();
		sql += "', `email` = '"				+kh.getEmail();
		sql += "', `cmnd` = '"					+kh.getCMND();
		sql += "', `quoctich` = '"				+kh.getQuocTich();
		sql += "' WHERE `KhachHang`.`makh` = "	+kh.getMaKH()+";";
		
		DB.update(sql);
		DB.disconnect();
	}

}
