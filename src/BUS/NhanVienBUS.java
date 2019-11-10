/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DTO.*;
import DAO.*;

/**
 *
 * @author Massan
 */
public class NhanVienBUS
{
	public static NhanVien getnvbyMa(int manv)
        {
            
           NhanVien nvlogin= DAO.NhanVienDAO.getnvbyMa(manv);
            return nvlogin;
        }
}
