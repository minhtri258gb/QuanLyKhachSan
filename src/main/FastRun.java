package main;

import BUS.TaiKhoanBUS;
import GUI.DangNhapGUI;
import GUI.LeTanGUI;
import java.sql.SQLException;

/**
 *
 * @author Pro One Laptop
 */
public class FastRun {

    public static void main(String[] args) {
        try {
            TaiKhoanBUS.login("nv1", "123");
            LeTanGUI nv= new LeTanGUI();                
            nv.setVisible(true);
        } catch (SQLException e) {
            
        }
        }

}
