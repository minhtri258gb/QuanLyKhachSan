/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.TaiKhoan;

/**
 *
 * @author Massan
 */
public class TaiKhoanDAO
{
	public ArrayList<TaiKhoan> load()
	{
		ArrayList<TaiKhoan> l_TaiKhoan = new ArrayList<TaiKhoan>();
		
		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT * FROM TaiKhoan");
		
		try
		{
			while(rs.next())
			{
				TaiKhoan kh = new TaiKhoan(rs.getString(1));

				kh.setMatkhau(rs.getString(2));
				kh.setMaNV(rs.getInt(3));
				kh.setQuyen(rs.getByte(4));
				l_TaiKhoan.add(kh);
			}
		}
		catch(SQLException e)
		{
			System.out.println("[TaiKhoanDAO:load] error sql: "+e);
		}
		
		DB.disconnect();
		
		return l_TaiKhoan;
	}
	
	public void add(TaiKhoan tk)
	{
		Database DB = new Database();
		DB.connect();
		
		String sql = "INSERT INTO TaiKhoan (matkhau, manv, quyen) VALUES ('";
		sql += tk.getMatkhau()+"', '";
		sql += tk.getMaNV()+"', '";
		sql += tk.getQuyen()+"');";
		
		DB.update(sql);
		DB.disconnect();
	}

	public void delete(String tentk)
	{
		Database DB = new Database();
		DB.connect();
		DB.update("DELETE FROM TaiKhoan WHERE TaiKhoan.tentk="+tentk);
		DB.disconnect();
	}

	public void edit(TaiKhoan tk)
	{
		Database DB = new Database();
		DB.connect();
		
		String sql = "UPDATE TaiKhoan SET ";
		sql += "matkhau='"					+tk.getMatkhau();
		sql += "', manv='"					+tk.getMaNV();
		sql += "', quyen='"					+tk.getQuyen();
		sql += "' WHERE TaiKhoan.tentk = "		+tk.getTenTK()+";";
		
		DB.update(sql);
		DB.disconnect();
	}

}
