/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author Massan
 */
public class NhanVien
{
	private final int m_manv;
	private String m_ho;
	private String m_ten;
	private byte m_gioitinh;
	private Date m_ngaysinh;
	private int m_sdt;
	private String m_email;
	private Date m_ngayvao;
	private String m_chucvu;
	private int m_luong;

	
	public NhanVien(int manv)
	{
		this.m_manv = manv;
	}

	public int getMaNV()
	{
		return m_manv;
	}

	public String getHo()
	{
		return m_ho;
	}

	public void setHo(String ho)
	{
		m_ho = ho;
	}

	public String getTen()
	{
		return m_ten;
	}

	public void setTen(String ten)
	{
		m_ten = ten;
	}

	public byte getGioiTinh()
	{
		return m_gioitinh;
	}

	public void setGioiTinh(byte gioitinh)
	{
		m_gioitinh = gioitinh;
	}

	public Date getNgaySinh()
	{
		return m_ngaysinh;
	}

	public void setNgaySinh(Date ngaysinh)
	{
		m_ngaysinh = ngaysinh;
	}

	public int getSDT()
	{
		return m_sdt;
	}

	public void setSDT(int sdt)
	{
		m_sdt = sdt;
	}

	public String getEmail()
	{
		return m_email;
	}

	public void setEmail(String email)
	{
		m_email = email;
	}

	public Date getNgayVao()
	{
		return m_ngayvao;
	}

	public void setNgayVao(Date ngayvao)
	{
		m_ngayvao = ngayvao;
	}

	public String getChucVu()
	{
		return m_chucvu;
	}

	public void setChucVu(String chucvu)
	{
		m_chucvu = chucvu;
	}

	public int getLuong()
	{
		return m_luong;
	}

	public void setLuong(int luong)
	{
		m_luong = luong;
	}
	
}
