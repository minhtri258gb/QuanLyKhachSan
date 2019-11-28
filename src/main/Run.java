package main;

import BUS.TaiKhoanBUS;
import GUI.DangNhapGUI;
import GUI.LeTanGUI;
import GUI.QuanLyGUI;
import java.sql.SQLException;

/**
 *
 * @author Pro One Laptop
 */
public class Run
{
    public static void main(String[] args)
	{
		DangNhapGUI dn=new DangNhapGUI("Quản lý khách sạn");
		dn.showWindow();
//		fastrun(true);
	}
	
	private static void fastrun(boolean quanly)
	{
		try
		{
			if (quanly)
				TaiKhoanBUS.login("nv2", "123");
			else
				TaiKhoanBUS.login("nv1", "123");
			
			if (TaiKhoanBUS.getUser().getQuyen() == 1)
			{
				QuanLyGUI nv= new QuanLyGUI();                
				nv.setVisible(true);
			} else {
				LeTanGUI nv= new LeTanGUI();                
				nv.setVisible(true);
			}
		}
		catch (SQLException e)
		{

		}
	}
}
