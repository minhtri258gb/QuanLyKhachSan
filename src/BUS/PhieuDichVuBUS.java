/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.DichVuDAO;
import DAO.PhieuDichVuDAO;
import DTO.DichVu;
import DTO.PhieuDichVu;

/**
 *
 * @author tuan gh
 */
public class PhieuDichVuBUS {
    public static int getnewidphieudichvu()
    {
        PhieuDichVuDAO pdv =new PhieuDichVuDAO();
       return pdv.getnewidphieudichvu();
    }
    public static void add(PhieuDichVu pdv)
    {
        PhieuDichVuDAO pdvdao=new PhieuDichVuDAO();
        pdvdao.add(pdv);
    }
    
            
}
