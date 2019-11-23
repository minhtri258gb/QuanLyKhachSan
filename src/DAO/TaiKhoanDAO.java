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
import GUI.ThongBao;

/**
 *
 * @author Massan
 */
public class TaiKhoanDAO
{
	public static ArrayList<TaiKhoan> load()
	{
		ArrayList<TaiKhoan> l_TaiKhoan = new ArrayList<>();
		
		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT * FROM TaiKhoan");
		
		try
		{
			while(rs.next())
			{
				TaiKhoan kh = new TaiKhoan(rs.getString(2));
				kh.setMaNV(rs.getInt(1));
				kh.setMatkhau(rs.getString(3));
				kh.setQuyen( rs.getInt(4));
				l_TaiKhoan.add(kh);
			}
		}
		catch(SQLException e)
		{
			ThongBao.warning("[TaiKhoanDAO:load] error sql: "+e);
		}
		
		DB.disconnect();
		
		return l_TaiKhoan;
	}
	
	public static TaiKhoan getTaiKhoan(String tentk)
	{
		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT * FROM taikhoan WHERE tentk='"+tentk+"'");
		
		try
		{
			while(rs.next())
			{
				TaiKhoan tk = new TaiKhoan(rs.getString(2));

				tk.setMaNV(rs.getInt(1));
				tk.setMatkhau(rs.getString(3));
				tk.setQuyen(rs.getInt(4));
				
				DB.disconnect();
				
				return tk;
			}
		}
		catch(SQLException e)
		{
			ThongBao.error("[TaiKhoanDAO:getTaiKhoan] error sql: "+e);
		}
		
		DB.disconnect();
		
		return null;
	}
	
	public static void add(TaiKhoan tk)
	{
		Database DB = new Database();
		DB.connect();
		
		String sql = "INSERT INTO taokhoan (matkhau, manv, quyen) VALUES ('";
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

	public static void edit(TaiKhoan tk)
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

	public ArrayList<TaiKhoan> find(String honv, String tennv, int sdt, String email, String chucvu)
	{
		ArrayList<TaiKhoan> l_taikhoan = new ArrayList<>();
		
		Database DB = new Database();
		DB.connect();

		String sql = "SELECT tk.* FROM taikhoan tk INNER JOIN nhanvien nv ON tk.manv = nv.manv WHERE ";
		
		if(!honv.isEmpty())
			sql += "ho='" + honv + "' AND";
		if(!tennv.isEmpty())
			sql += "ten='" + tennv + "' AND";
		if(sdt != 0)
			sql += "sdt='" + sdt + "' AND";
		if(!email.isEmpty())
			sql += "email='" + email + "' AND";
		if(!chucvu.isEmpty())
			sql += "chucvu='" + chucvu + "' AND";
		
		sql = sql.substring(0, sql.length() - 4);
		
		ResultSet rs = DB.execution(sql);
		
		try
		{
			while(rs.next())
			{
				TaiKhoan tk = new TaiKhoan(rs.getString(2));
				
				tk.setMaNV(rs.getInt(1));
				tk.setMatkhau(rs.getString(3));
				tk.setQuyen(rs.getInt(4));
				
				l_taikhoan.add(tk);
			}
		}
		catch(SQLException e)
		{
			GUI.ThongBao.error("[TaiKhoanDAO:find] error sql: "+e);
		}
		
		DB.disconnect();
		
		return l_taikhoan;
	}

	public TaiKhoan find(String tentk)
	{
		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT * FROM taikhoan WHERE tentk='"+tentk+"'");
		
		try
		{
			while(rs.next())
			{
				TaiKhoan tk = new TaiKhoan(rs.getString(2));
				
				tk.setMaNV(rs.getInt(1));
				tk.setMatkhau(rs.getString(3));
				tk.setQuyen(rs.getInt(4));
				
				DB.disconnect();
				
				return tk;
			}
		}
		catch(SQLException e)
		{
			GUI.ThongBao.error("[TaiKhoanDAO:find] error sql: "+e);
		}
		
		DB.disconnect();
		
		return null;
	}

}
