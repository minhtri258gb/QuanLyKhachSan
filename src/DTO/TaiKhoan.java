/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Massan
 */
public class TaiKhoan
{
	private  String m_tentk;
	private String m_matkhau;
	private int m_manv;
	private int m_quyen;

	
	public TaiKhoan()
	{
	}

	public String getTenTK()
	{
		return m_tentk;
	}
        public void set_tentk(String tentk)
        {
            this.m_tentk=tentk;
        }

	public String getMatkhau()
	{
		return m_matkhau;
	}

	public void setMatkhau(String matkhau)
	{
		m_matkhau = matkhau;
	}

	public int getMaNV()
	{
		return m_manv;
	}

	public void setMaNV(int manv)
	{
		m_manv = manv;
	}

	public int getQuyen()
	{
		return m_quyen;
	}

	public void setQuyen(int quyen)
	{
		m_quyen = quyen;
	}
	
}
