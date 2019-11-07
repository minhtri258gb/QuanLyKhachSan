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

/**
 *
 * @author Massan
 */
public class NhanVienDAO
{
	public ArrayList<NhanVien> load()
	{
		ArrayList<NhanVien> l_nhanvien = new ArrayList<NhanVien>();
		
		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT * FROM NhanVien");
		
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
			System.out.println("[DichVuDAO:load] error sql: "+e);
		}
		
		DB.disconnect();
		
		return l_nhanvien;
	}
	public static NhanVien getnvbylogin(String username,String password)
        {
            NhanVien nv=null;
            Database DB = new Database();
            DB.connect();
            String sql="SELECT n.manv, n.ho, n.ten ,n.gioitinh, n.sdt, n.ngaysinh,n.email, n.ngayvao, n.chucvu,n.luong "
                    + "From nhanvien n ,taikhoan t "
                    + "where n.manv=t.manv and t.tentk='"+username+"' and t.matkhau='"+password+"'";
            ResultSet rs = DB.execution(sql);
            try
		{
			while(rs.next())
			{
				 nv = new NhanVien(rs.getInt(1));

				nv.setHo(rs.getString(2));
				nv.setTen(rs.getString(3));
				nv.setGioiTinh(rs.getInt(4));
				nv.setNgaySinh(rs.getString(5));
				nv.setSDT(rs.getInt(6));
				nv.setEmail(rs.getString(7));
				nv.setNgayVao(rs.getString(8));
				nv.setChucVu(rs.getString(9));
                                nv.setLuong(rs.getInt(10));				
			}
		}
		catch(SQLException e)
		{
                        
			System.out.println("[KhachHangDAO:find] error sql: "+e);
                       
		}
		
		DB.disconnect();
                return nv;
        }
	public void add(NhanVien nv)
	{
		Database DB = new Database();
		DB.connect();
		
		String sql = "INSERT INTO DichVu (ho ten, gioitinh, ngaysinh, sdt, email, ngayvao, chucvu, luong) VALUES ('";
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
		DB.update("DELETE FROM NhanVien WHERE NhanVien.manv="+manv);
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

}
