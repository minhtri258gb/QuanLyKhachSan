/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVien;
import Tools.DateUtil;
import Tools.TableUtil;
import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Massan
 */
public class NhanVienBUS
{
	public static NhanVien getNhanVien(int manv)
	{
		return NhanVienDAO.getNhanVien(manv);
	}
	
	public static void init(JTable tbl)
	{
		ArrayList<NhanVien> dsnv = NhanVienDAO.load();
		uploadTable(tbl, dsnv);
	}

	public ArrayList<NhanVien> find(String ho, String ten, int gioitinh, String chucvu, int luong)
	{
		NhanVienDAO nvDAO = new NhanVienDAO();
		return nvDAO.find(ho, ten, gioitinh, chucvu, luong);
	}
	
	public NhanVien find_unique(int sdt, String email)
	{
		NhanVienDAO nvDAO = new NhanVienDAO();
		
		if(sdt != 0)
			return nvDAO.find_sdt(sdt);
		else if(!email.isEmpty())
			return nvDAO.find_email(email);
		
		return null;
	}
	
	public static void uploadTable(JTable tbl, ArrayList<NhanVien> list)
	{
		String[] columnNames = {"Mã","Họ","Tên","Giới tính","Ngày sinh","SĐT","Email","Ngày vào","Chức vụ","Lương"};
		Object[][] data = new Object[list.size()][columnNames.length];
		int i = 0;
		for (NhanVien nv : list)
		{
			data[i][0] = nv.getMaNV();
			data[i][1] = nv.getHo();
			data[i][2] = nv.getTen();
			if(nv.getGioiTinh()==0)
				data[i][3] = "nam";
			else
				data[i][3] = "nữ";

			data[i][4] = nv.getNgaySinh();
			data[i][5] = nv.getSDT();
			data[i][6] = nv.getEmail();
			data[i][7] = nv.getNgayVao();
			data[i][8] = nv.getChucVu();
			data[i][9] = nv.getLuong();

			i++;
		}
		TableModel tableModel = new DefaultTableModel(data, columnNames);
		tbl.setModel(tableModel);
	}
    
	public void updateTable(JTable tbl) throws Exception
	{
		NhanVienDAO nvDAO = new NhanVienDAO();
		ArrayList<NhanVien> dsnv = nvDAO.load();
		uploadTable(tbl, dsnv);
	}
	
	public void add(String ho, String ten, int gioitinh, String ngaysinh, int sdt, String email, String ngayvao, String chucvu, int luong)
	{
		NhanVienDAO nvDAO = new NhanVienDAO();
		
		NhanVien nv = new NhanVien(nvDAO.getNewID());
		nv.setHo(ho);
		nv.setTen(ten);
		nv.setGioiTinh(gioitinh);
		nv.setNgaySinh(ngaysinh);
		nv.setSDT(sdt);
		nv.setEmail(email);
		nv.setNgayVao(ngayvao);
		nv.setChucVu(chucvu);
		nv.setLuong(luong);
		
		nvDAO.add(nv);
	}
	
	public void edit(int manv, String ho, String ten, int gioitinh, String ngaysinh,
			int sdt, String email, String ngayvao, String chucvu, int luong)
	{
		NhanVien nv = new NhanVien(manv);
		nv.setHo(ho);
		nv.setTen(ten);
		nv.setGioiTinh(gioitinh);
		nv.setNgaySinh(ngaysinh);
		nv.setSDT(sdt);
		nv.setEmail(email);
		nv.setNgayVao(ngayvao);
		nv.setChucVu(chucvu);
		nv.setLuong(luong);
		
		NhanVienDAO nvDAO = new NhanVienDAO();
		nvDAO.edit(nv);
	}
	
	public static void loadInfo(JTable tbl, JTextField formMa, JTextField formHo, JTextField formTen, JComboBox<String> formGt,
			JDateChooser formNS, JTextField formSDT, JTextField formEmail, JDateChooser formNV, JTextField formCV, JTextField formL)
	{
		NhanVien nv = NhanVienDAO.getNhanVien(TableUtil.getMaFromTable(tbl));
		formMa.setText(String.valueOf(nv.getMaNV()));
		formHo.setText(nv.getHo());
		formTen.setText(nv.getTen());
		formGt.setSelectedIndex(nv.getGioiTinh());
		formNS.setDate(DateUtil.convert(nv.getNgaySinh()));
		formSDT.setText('0'+String.valueOf(nv.getSDT()));
		formEmail.setText(nv.getEmail());
		formNV.setDate(DateUtil.convert(nv.getNgayVao()));
		formCV.setText(nv.getChucVu());
		formL.setText(String.valueOf(nv.getLuong()));
	}
	
}
