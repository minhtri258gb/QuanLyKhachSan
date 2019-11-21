/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.HoaDonBUS;
import BUS.PhieuThuePhongBUS;
import BUS.PhongBUS;
import DTO.ChiTietHoaDon;
import DTO.HoaDon;
import DTO.LoaiPhong;
import DTO.Phong;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author tuan gh
 */
public class PhongGUI
{
    public void LoadTable(JTable tbl,ArrayList<Phong> l_phong)
    {
        PhongBUS phgBUS = new PhongBUS();
        //ArrayList<Phong> l_phong = phgBUS.load();
        ArrayList<LoaiPhong> l_loaiphong = phgBUS.loadLPhg();
        
        String[] columnNames = {"Số phòng","Loại phòng","Số người", "Tình trạng", "Giá"};
        Object[][] data = new Object[l_phong.size()][columnNames.length];
        int i=0;
        for (Phong phg : l_phong)
        {
            data[i][0] = phg.getMaphg();
            data[i][1] = phgBUS.getTenLPhg(phg.getMaloaiphg());
            data[i][2] = 1;
            data[i][3] = phg.getTinhtrang();
            data[i][4] = phgBUS.getGiaLPhg(phg.getMaloaiphg());
            i++;
        }
        TableModel tableModel = new DefaultTableModel(data, columnNames);
        // TODO set editable column 3
        tbl.setModel(tableModel);
    }
    
    public void datphong(JTable tbl, int makh)
    {
        PhongBUS phgBUS = new PhongBUS();
        ArrayList<Integer> maphgs = new ArrayList<>();
        TableModel mdl = tbl.getModel();
        int[] selectedRows = tbl.getSelectedRows(); 
        int i = 0;
        for(int row : selectedRows)
        {
            int maphg=Integer.valueOf(String.valueOf(mdl.getValueAt(row, 0)));            
            i++;
           maphgs.add(maphg);
        }    
        phgBUS.datPhong(makh, maphgs);
    }
    public static void  loadtblphongdangthue(JTable tbl,int makh)
    {
        PhongBUS phgBUS = new PhongBUS();
        ArrayList<ChiTietHoaDon> listcthd;
        HoaDon hoadonkh=HoaDonBUS.gethoadonbymakh(makh);
		System.out.println(hoadonkh.getMaHD());
        if(hoadonkh==null)
        {
            String[] columnNames = {"Số phòng","Loại phòng", "ngày đặt", "Giá"};
             Object[][] data = new Object[1][1];
             data[0][0]="trống";
            TableModel tableModel = new DefaultTableModel(data, columnNames);
            tbl.setModel(tableModel);
            
        }else{
            listcthd=hoadonkh.l_chitiet;
        String[] columnNames = {"Số phòng","Loại phòng", "ngày đặt", "Giá"};
        Object[][] data = new Object[listcthd.size()][columnNames.length];
        int i=0;
        for (ChiTietHoaDon cthd : listcthd)
        {                           
            data[i][0] = cthd.getPhieuThuePhong().getMaPHG();      
            data[i][1] =PhongBUS.getTenLPhg(PhongBUS.getphongbyma(cthd.getPhieuThuePhong().getMaPHG()).getMaloaiphg()) ;
            data[i][2] = hoadonkh.getNgayLap();
            data[i][3] =PhongBUS.getGiaLPhg(PhongBUS.getphongbyma(cthd.getPhieuThuePhong().getMaPHG()).getMaloaiphg());           
            i++;
        }
        TableModel tableModel = new DefaultTableModel(data, columnNames);
        // TODO set editable column 3
        tbl.setModel(tableModel);
    }
    }
}
