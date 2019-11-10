/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.TaiKhoanDAO;
import DTO.TaiKhoan;

/**
 *
 * @author Massan
 */
public class TaiKhoanBUS
{
	private static TaiKhoan m_user;
	
	
	public TaiKhoanBUS()
	{
		m_user = null;
	}
	
	public static TaiKhoan getUser()
	{
		return m_user;
	}
	
	public static boolean login(String tentk, String matkhau)
	{
		TaiKhoanDAO tkDAO = new TaiKhoanDAO();
		
		TaiKhoan tk = tkDAO.get(tentk,matkhau);
		
		if(tk != null)
                {
                    m_user = tk;
                    return true;
                }
                return false;
	}
	
	public static void logout()
	{
		m_user = null;
	}
}
