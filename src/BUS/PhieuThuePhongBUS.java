/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.PhieuThuePhongDAO;
import DTO.PhieuThuePhong;

/**
 *
 * @author tuan gh
 */
public class PhieuThuePhongBUS {
    public static PhieuThuePhong getphieuthuephongbymaptp(int maptp)
        {
            PhieuThuePhongDAO ptp=new PhieuThuePhongDAO();
           return ptp.get(maptp);
        }
}
