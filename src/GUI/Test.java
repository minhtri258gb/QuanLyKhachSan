/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.KhachHang;
import BUS.KhachHangBUS;
import DAO.KhachHangDAO;

/**
 *
 * @author Massan
 */
public class Test {
	
	public static void main(String[] args)
	{
		KhachHangBUS khBUS = new KhachHangBUS();
		
		KhachHang kh = khBUS.m_listKhachHang.get(0);
		kh.setTen("Van Thanh");
		
		KhachHangDAO khDAO = new KhachHangDAO();
		khDAO.edit(kh);
	}
	
}
