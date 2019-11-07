/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.KhachHangBUS;
import BUS.NhanVienBUS;
import DAO.KhachHangDAO;
import DAO.NhanVienDAO;
import DTO.KhachHang;
import DTO.NhanVien;
import Tools.DateUtil;
import java.text.SimpleDateFormat;  
import java.util.Date; 

/**
 *
 * @author Massan
 */
public class Test {
	
	 
  
public static void main(String[] args) {  
    NhanVien ab=(NhanVien) NhanVienBUS.getnvbylogin("nv1", "123");
    System.out.println(ab.getMaNV()); 
}  
}
	

