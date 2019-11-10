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
import java.sql.SQLException;
import java.text.SimpleDateFormat;  
import java.util.ArrayList;
import java.util.Date; 
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Massan
 */
public class Test {
	
	 
  
public static void main(String[] args) {  
    
    try {
        ArrayList<KhachHang> a= KhachHangDAO.TimKiemkhachhang("1");
        System.out.println(a.size());
    } catch (SQLException ex) {
        Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
    }
}  
}
	

