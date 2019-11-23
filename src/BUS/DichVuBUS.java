/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.DichVuDAO;
import DTO.DichVu;
import Tools.TableUtil;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Massan
 */
public class DichVuBUS
{
	
	public static void init(JTable tbl)
	{
		updateTable(tbl);
	}
	 
	public static DichVu getDichVu(int madv)
	{
		return DichVuDAO.getDichVu(madv);
	}
	
	public ArrayList<DichVu> load()
	{
		return DichVuDAO.load();
	}
	
	public int getgiadvbyma(String name)
    {
        DichVuDAO dv =new DichVuDAO();
        for(DichVu dvc:dv.load())
        {
            if(dvc.getTenDV().equals(name)){
                return dvc.getGia();
            }
        }
        return 0;
    }
    
	public void thue(int maphg, int madv, int soluong)
	{
		/*
		
		Giai thich:
		
		tim cthd theo: cthd -> phieudatphong -> phong = maphg
		
		if cthd -> phieudichvu == null
			create new phieudichvu
			...
		else cthd -> phieudichvu != null
			create new chitiethoadon
			chitiethoadon -> (cthd -> phieudatphong)
			chitiethoadon -> (create new phieudichvu)
		
		
		SELECT column_names
		FROM table_name
		WHERE column_name IS NOT NULL;
		
		*/
		
		// get hoadon from maphg
		// find cthd empty phieudichvu
		
		// get ngay dat
		// Tao phieu dich vu
		
		// add phieudichvu vao cthd
		
		// add phieu dich vu to database
		// update cthd
	}
	
	public static void uploadTable(JTable tbl, ArrayList<DichVu> list)
	{
		String[] columnNames = {"Mã","Tên","Giá","Mô tả"};
		Object[][] data = new Object[list.size()][columnNames.length];
		int i = 0;
		for (DichVu dv : list)
		{
			data[i][0] = dv.getMaDV();
			data[i][1] = dv.getTenDV();
			data[i][2] = dv.getGia();
			data[i][3] = dv.getMoTa();
			i++;
		}
		TableModel tableModel = new DefaultTableModel(data, columnNames);
		tbl.setModel(tableModel);
	}
	
	public static void updateTable(JTable tbl)
	{
		ArrayList<DichVu> list = DichVuDAO.load();
		uploadTable(tbl, list);
	}
	
	public static void loadInfo(JTable tbl, JTextField formMa, JTextField formT, JTextField formG, JTextArea formMT)
	{
		DichVu dv = DichVuDAO.getDichVu(TableUtil.getMaFromTable(tbl));
		
		formMa.setText(String.valueOf(dv.getMaDV()));
		formT.setText(dv.getTenDV());
		formG.setText(String.valueOf(dv.getGia()));
		formMT.setText(dv.getMoTa());
	}
	
}
