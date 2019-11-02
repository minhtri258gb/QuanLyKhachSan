/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import java.util.ArrayList;

import DTO.KhachHang;
import DAO.KhachHangDAO;

/**
 *
 * @author tuan gh
 */
public class KhachHangBUS
{
    // ok
	public ArrayList<KhachHang> m_listKhachHang;

	public KhachHangBUS()
	{
		KhachHangDAO khDAO = new KhachHangDAO();
		m_listKhachHang = khDAO.load();
	}
}
