/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import java.util.ArrayList;

import DTO.KhachHang;
import DAO.KhachHangDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author tuan gh
 */
public class KhachHangBUS
{
	public static ArrayList<KhachHang> m_listKhachHang;
	public KhachHang m_selected;

	
	public KhachHangBUS()
	{
		KhachHangDAO khDAO = new KhachHangDAO();
		m_listKhachHang = khDAO.load();
		
		m_selected = null;
	}
        public static void LoadTable(JTable tbl, List list){
        List<KhachHang> dskh = list;
        String[] columnNames = {"Mã kh","Họ","Tên","Giới tính","Ngày sinh","SĐT","Email","CMNN","Quốc tịch"};
        Object[][] data = new Object[dskh.size()][9];
        int i = 0;
        for (KhachHang kh : dskh) {
            data[i][0] = i;
            data[i][1] = kh.getHo();
            data[i][2] = kh.getTen();
            if(kh.getGioiTinh()==0)
            {
                data[i][3] = "nam";
            }
            else{
                data[i][3] = "nữ";
            }
            
            data[i][4] = kh.getNgaySinh();
            data[i][5] = kh.getSoDienThoai();
            data[i][6] = kh.getEmail();
            data[i][7] = kh.getCMND();
            data[i][8] = kh.getQuocTich();
            
            i++;
        }
        TableModel tableModel = new DefaultTableModel(data, columnNames);
        tbl.setModel(tableModel);
    }
    
    public static void HienThongkh(JTable tbl) throws Exception {
        ArrayList<KhachHang> dskh = KhachHangDAO.load();
        LoadTable(tbl, dskh);
    }
	
	public static void add(String ho, String ten, int gioitinh, String ngaysinh, int sdt, String email, int cmnd, String quoctich)
	{
		KhachHangDAO khDAO = new KhachHangDAO();
		
		KhachHang kh = new KhachHang(khDAO.getNewID());
		kh.setHo(ho);
		kh.setTen(ten);
		kh.setGioiTinh(gioitinh);
		kh.setNgaySinh(ngaysinh);
		kh.setSoDienThoai(sdt);
		kh.setEmail(email);
		kh.setCMND(cmnd);
		kh.setQuocTich(quoctich);
		
		khDAO.add(kh);
	}
	
	public void delete(int makh)
	{
		KhachHangDAO khDAO = new KhachHangDAO();
		khDAO.delete(makh);
	}
	
	public static void edit(int makh, String ho, String ten, int gioitinh, String ngaysinh, int sdt, String email, int cmnd, String quoctich)
	{
		KhachHang kh = new KhachHang(makh);
		kh.setHo(ho);
		kh.setTen(ten);
		kh.setGioiTinh(gioitinh);
		kh.setNgaySinh(ngaysinh);
		kh.setSoDienThoai(sdt);
		kh.setEmail(email);
		kh.setCMND(cmnd);
		kh.setQuocTich(quoctich);
		
		KhachHangDAO khDAO = new KhachHangDAO();
		khDAO.edit(kh);
	}
	
	public ArrayList<KhachHang> find(String ho, String ten, int gioitinh, String ngaysinh)
	{
		KhachHangDAO khDAO = new KhachHangDAO();
		return khDAO.find(ho, ten, gioitinh, ngaysinh);
	}
	
	public KhachHang find_unique(int sdt, int cmnd, String email)
	{
		KhachHangDAO khDAO = new KhachHangDAO();
		
		if(sdt != 0)
			return khDAO.find_sdt(sdt);
		else if(cmnd != 0)
			return khDAO.find_cmnd(cmnd);
		else if(!email.isEmpty())
			return khDAO.find_email(email);
		
		return null;
	}
	
	public ArrayList<KhachHang> filter(ArrayList<KhachHang> listKH, String ho, String ten, int gioitinh, String ngaysinh, String quoctich)
	{
		if(!ho.isEmpty())
		{
			for(KhachHang kh : listKH)
				if(kh.getHo() != ho)
					listKH.remove(kh);
		}
		else if(!ten.isEmpty())
		{
			for(KhachHang kh : listKH)
				if(kh.getTen() != ten)
					listKH.remove(kh);
		}
		else if(gioitinh >= 0)
		{
			for(KhachHang kh : listKH)
				if(kh.getGioiTinh() != gioitinh)
					listKH.remove(kh);
		}
		else if(!ngaysinh.isEmpty())
		{
			for(KhachHang kh : listKH)
				if(kh.getNgaySinh() != ngaysinh)
					listKH.remove(kh);
		}
		else if(!quoctich.isEmpty())
		{
			for(KhachHang kh : listKH)
				if(kh.getQuocTich() != quoctich)
					listKH.remove(kh);
		}
		
		return listKH;
	}
	public static void TimKiemkh(JTable tbl, String info) throws SQLException{
        List<KhachHang> dskhtk= DAO.KhachHangDAO.TimKiemkhachhang(info);
        LoadTable(tbl, dskhtk);
    }
}
