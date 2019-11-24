/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChiTietHoaDonDAO;
import DAO.DichVuDAO;
import DAO.PhieuDichVuDAO;
import DTO.ChiTietHoaDon;
import DTO.DichVu;
import DTO.PhieuDichVu;
import GUI.ThongBao;
import Tools.DateUtil;
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
public class DichVuBUS {

	public static void init(JTable tbl) {
		updateTable(tbl);
	}

	public static DichVu getDichVu(int madv) {
		return DichVuDAO.getDichVu(madv);
	}

	public ArrayList<DichVu> load() {
		return DichVuDAO.load();
	}

	public int getgiadvbyma(String name) {
		DichVuDAO dv = new DichVuDAO();
		for (DichVu dvc : dv.load()) {
			if (dvc.getTenDV().equals(name)) {
				return dvc.getGia();
			}
		}
		return 0;
	}

	public static void thue(ArrayList<DichVu> l_dichvu, ArrayList<Integer> l_soluong, int ma_phg, int mahd) {
		int ma_cthd = -1;
		for (ChiTietHoaDon cthd : ChiTietHoaDonDAO.load(mahd)) {
			if (ma_phg == cthd.getPhieuThuePhong().getMaPHG()) {
				ma_cthd = cthd.getMaCTHD();
				break;
			}

		}
		int i = 0;
		boolean isadd = false;
		for (DichVu dv : l_dichvu) {

			PhieuDichVu pdv = new PhieuDichVu(PhieuDichVuDAO.getNewID(), dv.getMaDV());
			pdv.setM_machitiethoadon(ma_cthd);
			pdv.setNgayDat(DateUtil.getCurDate());
			pdv.setSoLuong(l_soluong.get(i));
			PhieuDichVuDAO.add(pdv);
			i++;
			isadd = true;

		}
		if (isadd == true) {
			ThongBao.noitice("Đặt thành công.");
		} 
		else 
		{
			ThongBao.error("[class dichvuBUS: thue]");
		}
	}

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
