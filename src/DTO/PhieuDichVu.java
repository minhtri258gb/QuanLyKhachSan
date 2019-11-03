/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.time.LocalDate;

/**
 *
 * @author Massan
 */
public class PhieuDichVu
{
	private final int m_mapdv;
	private final int m_madv;
	private LocalDate m_ngaydat;
	private short m_soluong;
	
	
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
	
	public LocalDate getNgayDat()
	{
		return m_ngaydat;
	}

	public void setNgayDat(LocalDate ngaydat)
	{
		m_ngaydat = ngaydat;
	}

	public short getSoLuong()
	{
		return m_soluong;
	}

	public void setSoLuong(short soluong)
	{
		m_soluong = soluong;
	}

}
