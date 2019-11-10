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
public class LoaiPhong
{
	private final int m_maloaiphg;
	private String m_tenloaiphg;
	private String m_mota;
        private int m_gia;
	
	public LoaiPhong(int maloaiphg)
	{
		m_maloaiphg = maloaiphg;
	}

	public int getMaLoaiPhg()
	{
		return m_maloaiphg;
	}

	public String getTenLoaiPhg()
	{
		return m_tenloaiphg;
	}

	public void setTenloaiphg(String tenloaiphg)
	{
		m_tenloaiphg = tenloaiphg;
	}

	public String getMota()
	{
		return m_mota;
	}

	public void setMota(String mota)
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
