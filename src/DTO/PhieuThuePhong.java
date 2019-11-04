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
public class PhieuThuePhong
{
	private final int m_maptp;
	private int m_maphg;
	private String m_ngayden;
	private String m_ngaydi;
	
	
	public PhieuThuePhong(int maptp)
	{
		m_maptp = maptp;
	}
	
	public int getMaPTP()
	{
		return m_maptp;
	}
	
	public int getMaPHG()
	{
		return m_maphg;
	}

	public void setMaPhg(int maphg)
	{
		m_maphg = maphg;
	}

	public String getNgayDen()
	{
		return m_ngayden;
	}

	public void setNgayDen(String ngayden)
	{
		m_ngayden = ngayden;
	}

	public String getNgayDi()
	{
		return m_ngaydi;
	}

	public void setNgayDi(String ngaydi)
	{
		m_ngaydi = ngaydi;
	}
	
}
