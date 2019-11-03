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
public class ChiTietHoaDon
{
	private final int m_macthd;
	private PhieuThuePhong m_ptp;
	private PhieuDichVu m_pdv;
	private int m_thanhtien;

	
	public ChiTietHoaDon(int macthd)
	{
		m_macthd = macthd;
	}

	public int getMacthd()
	{
		return m_macthd;
	}

	public PhieuThuePhong getPhieuThuePhong()
	{
		return m_ptp;
	}

	public void setPhieuThuePhong(PhieuThuePhong ptp)
	{
		m_ptp = ptp;
	}

	public PhieuDichVu getPhieuDichVu()
	{
		return m_pdv;
	}

	public void setMapdv(PhieuDichVu pdv)
	{
		m_pdv = pdv;
	}

	public int getThanhtien()
	{
		return m_thanhtien;
	}

	public void setThanhtien(int thanhtien)
	{
		m_thanhtien = thanhtien;
	}
	
}
