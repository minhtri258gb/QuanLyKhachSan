/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author tuan gh
 */
public class KhachHang
{
	private final int m_makh;
	private String m_ho;
	private String m_ten;
	private int m_gioitinh;
	private String m_ngaysinh;
	private int m_sdt;
	private String m_email;
	private int m_cmnd;
	private String m_quoctich;

	public KhachHang(int m_makh)
	{
		this.m_makh = m_makh;
	}

    public KhachHang(int m_makh, String m_ho, String m_ten, int m_gioitinh, String m_ngaysinh, int m_sdt, String m_email, int m_cmnd, String m_quoctich) {
        this.m_makh = m_makh;
        this.m_ho = m_ho;
        this.m_ten = m_ten;
        this.m_gioitinh = m_gioitinh;
        this.m_ngaysinh = m_ngaysinh;
        this.m_sdt = m_sdt;
        this.m_email = m_email;
        this.m_cmnd = m_cmnd;
        this.m_quoctich = m_quoctich;
    }

   
        

	public int getMaKH()
	{
		return m_makh;
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
	
	// 1: nu; 0: nam
	public int getGioiTinh()
	{
		return m_gioitinh;
	}

	public void setGioiTinh(int gioitinh)
	{
		m_gioitinh = gioitinh;
	}
	
	public String getNgaySinh()
	{
		return m_ngaysinh;
	}

	public void setNgaySinh(String ngaysinh)
	{
		m_ngaysinh = ngaysinh;
	}
	
	public int getSoDienThoai()
	{
		return m_sdt;
	}

	public void setSoDienThoai(int sdt)
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
	
	public int getCMND()
	{
		return m_cmnd;
	}

	public void setCMND(int cmnd)
	{
		m_cmnd = cmnd;
	}
	
	public String getQuocTich()
	{
		return m_quoctich;
	}

	public void setQuocTich(String quoctich)
	{
		m_quoctich = quoctich;
	}
	
}
