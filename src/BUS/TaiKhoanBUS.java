/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.NhanVienDAO;
import DAO.TaiKhoanDAO;
import DTO.NhanVien;
import DTO.TaiKhoan;
import GUI.ThongBao;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Massan
 */
public class TaiKhoanBUS
{
	private static TaiKhoan m_user;
	
	public static void init(JTable tbl)
	{
		ArrayList<TaiKhoan> ds = TaiKhoanDAO.load();
		uploadTable(tbl, ds);
	}

	public TaiKhoanBUS()
	{
		m_user = null;
	}
	
	public static TaiKhoan getUser()
	{
		return m_user;
	}
	
	public static boolean login(String tentk, String matkhau)
	{
		TaiKhoan tk = TaiKhoanDAO.getTaiKhoan(tentk);
		
		if(tk != null && tk.getMatkhau().equals(matkhau))
		{
			m_user = tk;
			return true;
		}
		return false;
	}
	
	public static void logout()
	{
		m_user = null;
	}
	
	public ArrayList<TaiKhoan> find(String honv, String tennv, int sdt, String email, String chucvu)
	{
		TaiKhoanDAO tkDAO = new TaiKhoanDAO();
		return tkDAO.find(honv, tennv, sdt, email, chucvu);
	}
	
	public TaiKhoan find_unique(String tentk)
	{
		if (tentk.isEmpty())
			return null;
		
		TaiKhoanDAO tkDAO = new TaiKhoanDAO();
		
		return tkDAO.find(tentk);
	}
	
	public static void uploadTable(JTable tbl, ArrayList<TaiKhoan> list)
	{
		String[] columnNames = {"Tài khoản","Mật khẩu","Quyền"};
		Object[][] data = new Object[list.size()][columnNames.length];
		int i = 0;
		for (TaiKhoan tk : list)
		{
			data[i][0] = tk.getTenTK();
			data[i][1] = tk.getMatkhau();
			data[i][2] = tk.getQuyen() == 0 ? "Không" : "Có" ;

			i++;
		}
		TableModel tableModel = new DefaultTableModel(data, columnNames);
		tbl.setModel(tableModel);
	}
    
	public void updateTable(JTable tbl) throws Exception
	{
		TaiKhoanDAO tkDAO = new TaiKhoanDAO();
		ArrayList<TaiKhoan> dstk = tkDAO.load();
		uploadTable(tbl, dstk);
	}
	
	public static void loadInfo(JTable tbl, JTextField formTK, JTextField formMK, JCheckBox formQuyen, JTextField formMaNV,
			JTextField formHo, JTextField formTen, JTextField formSDT, JTextField formEmail, JTextField formCV)
	{
		TaiKhoan tk = TaiKhoanDAO.getTaiKhoan((String) tbl.getValueAt(tbl.getSelectedRow(), 0));
		NhanVien nv = NhanVienDAO.getNhanVien(tk.getMaNV());
		
		formTK.setText(tk.getTenTK());
		formMK.setText(tk.getMatkhau());
		formQuyen.setSelected(tk.getQuyen() != 0);
		formMaNV.setText(String.valueOf(tk.getMaNV()));
		formHo.setText(nv.getHo());
		formTen.setText(nv.getTen());
		formSDT.setText('0'+String.valueOf(nv.getSDT()));
		formEmail.setText(nv.getEmail());
		formCV.setText(nv.getChucVu());
	}
	
	public ArrayList<TaiKhoan> getList()
	{
		return TaiKhoanDAO.load();
	}
	
	public static boolean validateForm(String tentk, String matkhau, int manv)
	{
		if (tentk.isEmpty())
			ThongBao.warning("Chưa điền tên tài khoản");
		else if (matkhau.isEmpty())
			ThongBao.warning("Chưa điền tên tài khoản");
		else if (manv == 0 || DAO.NhanVienDAO.getNhanVien(manv) == null)
			ThongBao.warning("Mã nhân viên không hợp lệ");
		else
			return true;
		return false;
	}
	
	public static void add(JTextField formTenTK, JTextField formMK, JCheckBox formQ, JTextField formMaNV)
	{
		String tentk = formTenTK.getText();
		String matkhau = formMK.getText();
		int quyen = formQ.isSelected() ? 1 : 0;
		
		int manv = 0;
		if (!formMaNV.getText().isEmpty())
			manv = Integer.valueOf(formMaNV.getText());
		
		if (validateForm(tentk, matkhau, manv))
		{
			TaiKhoan tk = new TaiKhoan(tentk);
			tk.setMatkhau(matkhau);
			tk.setQuyen(quyen);
			tk.setMaNV(manv);
			TaiKhoanDAO.add(tk);
		}
	}
	
	public static void edit(JTextField formTenTK, JTextField formMK, JCheckBox formQ, JTextField formMaNV)
	{
		String tentk = formTenTK.getText();
		String matkhau = formMK.getText();
		int quyen = formQ.isSelected() ? 1 : 0;
		int manv = Integer.valueOf(formMaNV.getText());
		
		if (validateForm(tentk, matkhau, manv))
		{
			TaiKhoan tk = TaiKhoanDAO.getTaiKhoan(tentk);
			tk.setMatkhau(matkhau);
			tk.setQuyen(quyen);
			tk.setMaNV(manv);
			TaiKhoanDAO.edit(tk);
		}
	}
	
}
