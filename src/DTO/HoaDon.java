/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author Massan
 */
public class HoaDon
{
	private final int m_mahd;
	private final int m_makh;
	private final int m_manv;
	private Date m_ngaylap;
	private int m_tongtien;
	public ArrayList<ChiTietHoaDon> l_chitiet;
	
	
	public HoaDon(int mahd, int makh, int manv)
	{
		m_mahd = mahd;
		m_makh = makh;
		m_manv = manv;
	}
	
	public int getMaHD()
	{
		return m_mahd;
	}
	
	public int getMaKH()
	{
		return m_makh;
	}
	
	public int getMaNV()
	{
		return m_manv;
	}
	
	public Date getNgayLap()
	{
		return m_ngaylap;
	}
	
	public void setNgayLap(Date date)
	{
		m_ngaylap = date;
	}

	public int getTongtien()
	{
		return m_tongtien;
	}

	public void setTongtien(int tongtien)
	{
		m_tongtien = tongtien;
	}
	
}
