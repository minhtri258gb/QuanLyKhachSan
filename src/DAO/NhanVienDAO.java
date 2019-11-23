/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.NhanVien;
import GUI.ThongBao;

/**
 *
 * @author Massan
 */
public class NhanVienDAO
{
	public static ArrayList<NhanVien> load()
	{
		ArrayList<NhanVien> l_nhanvien = new ArrayList<>();
		
		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT * FROM nhanvien");
		
		try
		{
			while(rs.next())
			{
				NhanVien nv = new NhanVien(rs.getInt(1));

				nv.setHo(rs.getString(2));
				nv.setTen(rs.getString(3));
				nv.setGioiTinh(rs.getByte(4));
				nv.setNgaySinh(rs.getString(5));
				nv.setSDT(rs.getInt(6));
				nv.setEmail(rs.getString(3));
				nv.setNgayVao(rs.getString(5));
				nv.setChucVu(rs.getString(3));
				nv.setLuong(rs.getInt(6));
				l_nhanvien.add(nv);
			}
		}
		catch(SQLException e)
		{
			ThongBao.error("[DichVuDAO:load] "+e);
		}
		
		DB.disconnect();
		
		return l_nhanvien;
	}
	
	public static NhanVien getNhanVien(int manv)
	{
		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT * FROM nhanvien WHERE manv="+manv);
		
		try
		{
			while(rs.next())
			{
				NhanVien nv = new NhanVien(rs.getInt(1));

				nv.setHo(rs.getString(2));
				nv.setTen(rs.getString(3));
				nv.setGioiTinh(rs.getInt(4));
				nv.setNgaySinh(rs.getString(5));
				nv.setSDT(rs.getInt(6));
				nv.setEmail(rs.getString(7));
				nv.setNgayVao(rs.getString(8));
				nv.setChucVu(rs.getString(9));
				nv.setLuong(rs.getInt(10));
				
				DB.disconnect();
				
				return nv;
			}
		}
		catch(SQLException e)
		{
			ThongBao.error("[NhanVienDAO:find] error sql: "+e);
		}
		
		DB.disconnect();
		
		return null;
	}
	
	public void add(NhanVien nv)
	{
		Database DB = new Database();
		DB.connect();
		
		String sql = "INSERT INTO nhanvien (ho, ten, gioitinh, ngaysinh, sdt, email, ngayvao, chucvu, luong) VALUES ('";
		sql += nv.getHo()+"', '";
		sql += nv.getTen()+"', '";
		sql += nv.getGioiTinh()+"', '";
		sql += nv.getNgaySinh()+"', '";
		sql += nv.getSDT()+"', '";
		sql += nv.getEmail()+"', '";
		sql += nv.getNgayVao()+"', '";
		sql += nv.getChucVu()+"', '";
		sql += nv.getLuong()+"');";
		
		DB.update(sql);
		DB.disconnect();
	}

	public void delete(int manv)
	{
		Database DB = new Database();
		DB.connect();
		DB.update("DELETE FROM nhanvien WHERE manv="+manv);
		DB.disconnect();
	}

	public void edit(NhanVien nv)
	{
		Database DB = new Database();
		DB.connect();
		
		String sql = "UPDATE NhanVien SET ";
		sql += "ho='"						+nv.getHo();
		sql += "', ten='"					+nv.getTen();
		sql += "', gioitinh='"				+nv.getGioiTinh();
		sql += "', ngaysinh='"				+nv.getNgaySinh();
		sql += "', sdt='"					+nv.getSDT();
		sql += "', email='"				+nv.getEmail();
		sql += "', ngayvao='"				+nv.getNgayVao();
		sql += "', chucvu='"				+nv.getChucVu();
		sql += "', luong='"				+nv.getLuong();
		sql += "' WHERE NhanVien.manv = "	+nv.getMaNV()+";";
		
		DB.update(sql);
		DB.disconnect();
	}

	public static int getNewID()
	{
		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT MAX(manv) FROM nhanvien");
		
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
			ThongBao.warning("[NhanVienDAO:load] error sql: "+e);
		}
		
		DB.disconnect();
		
		return -1;
	}
	
	public ArrayList<NhanVien> find(String ho, String ten, int gioitinh, String chucvu, int luong)
	{
		ArrayList<NhanVien> l_khachhang = new ArrayList<>();
		
		Database DB = new Database();
		DB.connect();

		String sql = "SELECT * FROM nhanvien WHERE ";
		
		if(!ho.isEmpty())
			sql += "ho='" + ho + "' AND";
		if(!ten.isEmpty())
			sql += "ten='" + ten + "' AND";
		if(gioitinh >= 0)
			sql += "gioitinh='" + gioitinh + "' AND";
		if(chucvu.length() == 10)
			sql += "chucvu='" + chucvu + "' AND";
		if(luong != 0)
			sql += "luong='" + luong + "' AND";
		
		sql = sql.substring(0, sql.length() - 4);
		
		ResultSet rs = DB.execution(sql);
		
		try
		{
			while(rs.next())
			{
				NhanVien nv = new NhanVien(rs.getInt(1));

				nv.setHo(rs.getString(2));
				nv.setTen(rs.getString(3));
				nv.setGioiTinh(rs.getInt(4));
				nv.setNgaySinh(rs.getString(5));
				nv.setSDT(rs.getInt(6));
				nv.setEmail(rs.getString(7));
				nv.setNgayVao(rs.getString(8));
				nv.setChucVu(rs.getString(9));
				nv.setLuong(rs.getInt(10));
				l_khachhang.add(nv);
			}
		}
		catch(SQLException e)
		{
			ThongBao.error("[NhanVienDAO:find] error sql: "+e);
		}
		
		DB.disconnect();
		
		return l_khachhang;
	}

	public NhanVien find_sdt(int sdt)
	{
		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT * FROM nhanvien WHERE sdt="+sdt);
		
		try
		{
			while(rs.next())
			{
				NhanVien nv = new NhanVien(rs.getInt(1));

				nv.setHo(rs.getString(2));
				nv.setTen(rs.getString(3));
				nv.setGioiTinh(rs.getInt(4));
				nv.setNgaySinh(rs.getString(5));
				nv.setSDT(rs.getInt(6));
				nv.setEmail(rs.getString(7));
				nv.setNgayVao(rs.getString(8));
				nv.setChucVu(rs.getString(9));
				nv.setLuong(rs.getInt(10));
				
				DB.disconnect();
				
				return nv;
			}
		}
		catch(SQLException e)
		{
			ThongBao.error("[NhanVienDAO:find] error sql: "+e);
		}
		
		DB.disconnect();
		
		return null;
	}

	public NhanVien find_email(String email)
	{
		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT * FROM nhanvien WHERE email="+email);
		
		try
		{
			while(rs.next())
			{
				NhanVien nv = new NhanVien(rs.getInt(1));

				nv.setHo(rs.getString(2));
				nv.setTen(rs.getString(3));
				nv.setGioiTinh(rs.getInt(4));
				nv.setNgaySinh(rs.getString(5));
				nv.setSDT(rs.getInt(6));
				nv.setEmail(rs.getString(7));
				nv.setNgayVao(rs.getString(8));
				nv.setChucVu(rs.getString(9));
				nv.setLuong(rs.getInt(10));
				
				DB.disconnect();
				
				return nv;
			}
		}
		catch(SQLException e)
		{
			ThongBao.error("[NhanVienDAO:find] error sql: "+e);
		}
		
		DB.disconnect();
		
		return null;
	}
}
