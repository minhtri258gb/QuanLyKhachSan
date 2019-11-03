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
public class TrangThietBi
{
	private final int m_matb;
	private String m_tentb;

	
	public TrangThietBi(int matb)
	{
		m_matb = matb;
	}

	public int getMaTB()
	{
		return m_matb;
	}

	public String getTenTB()
	{
		return m_tentb;
	}

	public void setTenTB(String tentb)
	{
		m_tentb = tentb;
	}
	
}
