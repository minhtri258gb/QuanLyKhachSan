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
public class Phong
{
	private final int m_maphg;
	private int m_maloaiphg;
	private String m_tinhtrang;
	private int m_gia;
	

	public Phong(int maphg)
	{
		m_maphg = maphg;
	}

	public int getMaphg()
	{
		return m_maphg;
	}

	public int getMaloaiphg()
	{
		return m_maloaiphg;
	}

	public void setMaloaiphg(int maloaiphg)
	{
		m_maloaiphg = maloaiphg;
	}

	public String getTinhtrang()
	{
		return m_tinhtrang;
	}

	public void setTinhtrang(String tinhtrang)
	{
		m_tinhtrang = tinhtrang;
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
