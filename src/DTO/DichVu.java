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
public class DichVu
{
	private final int m_madv;
	private String m_tendv;
	private String m_mota;
	private int m_gia;

	
	public DichVu(int madv)
	{
		m_madv = madv;
	}

	public int getMaDV()
	{
		return m_madv;
	}

	public String getTenDV()
	{
		return m_tendv;
	}

	public void setTenDV(String tendv)
	{
		m_tendv = tendv;
	}

	public String getMoTa()
	{
		return m_mota;
	}

	public void setMoTa(String mota)
	{
		m_mota = mota;
	}

	public int getGia()
	{
		return m_gia;
	}

	public void setGia(int gia)
	{
		m_gia = gia;
	}
	
}
