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
public class ChiTietPhong
{
	private final int m_mactphg;
	private int m_matb;
	private short m_soluong;

	
	public ChiTietPhong(int mactphg)
	{
		m_mactphg = mactphg;
	}

	public int getMaCTPhg()
	{
		return m_mactphg;
	}

	public int getMaTB()
	{
		return m_matb;
	}

	public void setMaTB(int matb)
	{
		m_matb = matb;
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
