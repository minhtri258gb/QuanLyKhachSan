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
public class PhieuDichVu
{
	private final int m_mapdv;
	private final int m_madv;
	private String m_ngaydat;
	private int m_soluong;
	private int m_machitiethoadon;

	public void setM_machitiethoadon(int m_machitiethoadon) {
		this.m_machitiethoadon = m_machitiethoadon;
	}

	public int getM_machitiethoadon() {
		return m_machitiethoadon;
	}
	
	
	public PhieuDichVu(int mapdv, int madv)
	{
		m_mapdv = mapdv;
		m_madv = madv;
	}
	
	public int getMaPDV()
	{
		return m_mapdv;
	}
	
	public int getMaDV()
	{
		return m_madv;
	}
	
	public String getNgayDat()
	{
		return m_ngaydat;
	}

	public void setNgayDat(String ngaydat)
	{
		m_ngaydat = ngaydat;
	}

	public int getSoLuong()
	{
		return m_soluong;
	}

	public void setSoLuong(int soluong)
	{
		m_soluong = soluong;
	}

}
