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
public class PhieuThuePhong
{
	private final int m_maptp;
	private final int m_maphg;
	private LocalDate m_ngayden;
	private LocalDate m_ngaydi;
	
	
	public PhieuThuePhong(int maptp, int maphg)
	{
		m_maptp = maptp;
		m_maphg = maphg;
	}
	
	public int getMaPTP()
	{
		return m_maptp;
	}
	
	public int getMaPHG()
	{
		return m_maphg;
	}

	public LocalDate getNgayDen()
	{
		return m_ngayden;
	}

	public void setNgayDen(LocalDate ngayden)
	{
		m_ngayden = ngayden;
	}

	public LocalDate getNgayDi()
	{
		return m_ngaydi;
	}

	public void setNgayDi(LocalDate ngaydi)
	{
		m_ngaydi = ngaydi;
	}
	
}
