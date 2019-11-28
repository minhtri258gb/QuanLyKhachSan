/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChiTietHoaDonDAO;
import DAO.HoaDonDAO;
import DAO.PhieuDichVuDAO;
import DAO.PhieuThuePhongDAO;
import DTO.ChiTietHoaDon;
import DTO.HoaDon;
import DTO.PhieuDichVu;
import DTO.PhieuThuePhong;
import Tools.DateUtil;
import Tools.TableUtil;
import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Massan
 */
public class HoaDonBUS
{
	public void traPhong(int makh)
	{
		HoaDon hd = HoaDonDAO.getFromMaKH(makh);
		hd.l_chitiet = ChiTietHoaDonDAO.load(hd.getMaHD());

		for (ChiTietHoaDon cthd : hd.l_chitiet) {
			PhieuThuePhong ptp = cthd.getPhieuThuePhong();
			ptp.setNgayDi(DateUtil.getCurDate());
			PhieuThuePhongDAO.edit(ptp);
		}
	}

	public void thanhToan(int makh) {
//		HoaDonDAO hdDAO = new HoaDonDAO();
//		ChiTietHoaDonDAO cthdDAO = new ChiTietHoaDonDAO();
//		PhongDAO phgDAO = new PhongDAO();
//		DichVuDAO dvDAO = new DichVuDAO();
//		
//		HoaDon hd = hdDAO.getFromMaKH(makh);
//		hd.l_chitiet = cthdDAO.get(hd.getMaHD());
//		
//		for(ChiTietHoaDon cthd : hd.l_chitiet)
//		{
//			int gia = phgDAO.getGia(cthd.getPhieuThuePhong().getMaPHG());
//			
//			if(cthd.getPhieuDichVu() != null)
//				gia += dvDAO.getGia(cthd.getPhieuDichVu().getMaDV());
//			
//			cthd.setThanhtien(gia);
//			
//			hd.setTongtien(hd.getTongtien() + gia);
//			
//			cthdDAO.edit(cthd);
//		}
//		
//		hdDAO.edit(hd);
	}

	public static HoaDon gethoadonbymakh(int makh)
	{
		return HoaDonDAO.getFromMaKH(makh);
	}
	
	public static void find(JTable tbl, JTextField formKH, JTextField formNV, JCheckBox formNL, JDateChooser formN1,
			JTextField formG1, JTextField formG2, JTextField formPhg, JTextField formDV)
	{
		int makh = 0, manv = 0, gia1 = 0, gia2 = 0, maphg = 0, madv = 0;
		String nl1 = "";
		if (!formKH.getText().isEmpty())
			makh = Integer.valueOf(formKH.getText());
		if (!formNV.getText().isEmpty())
			manv = Integer.valueOf(formNV.getText());
		if (formNL.isSelected())
		{
			nl1 = DateUtil.toString(formN1.getDate());
		}
		if (!formG1.getText().isEmpty())
			gia1 = Integer.valueOf(formG1.getText());
		if (!formG2.getText().isEmpty())
			gia2 = Integer.valueOf(formG2.getText());
		if (!formPhg.getText().isEmpty())
			maphg = Integer.valueOf(formPhg.getText());
		if (!formDV.getText().isEmpty())
			madv = Integer.valueOf(formDV.getText());
		
		ArrayList<HoaDon> l_hoadon = HoaDonDAO.find(makh, manv, nl1, gia1, gia2, maphg, madv);
		uploadTable(tbl, l_hoadon);
	}
	
	public static void showTabQL(JTextField formMaKH, JTable tbl, JTextField formMaKH2)
	{
		int makh = 0;
		if (!formMaKH.getText().isEmpty())
			makh = Integer.valueOf(formMaKH.getText());
		
		if (makh != 0)
		{
			formMaKH2.setText(String.valueOf(makh));
			updateTable(formMaKH, tbl);
		}
	}
	
	public static void selectHD(JTable tbl, JTable tbl1, JTable tbl2, JTextField formMaNV, JDateChooser formNL1,
			JTextField formGia1, JTextField formGia2)
	{
		int mahd = TableUtil.getMaFromTable(tbl);
		HoaDon hd = HoaDonDAO.getHoaDon(mahd);
		
		Date ngaylap = DateUtil.convert(hd.getNgayLap());
		String gia = String.valueOf(hd.getTongtien());
		
		formMaNV.setText(String.valueOf(hd.getMaNV()));
		formNL1.setDate(ngaylap);
		formGia1.setText(gia);
		formGia2.setText(gia);
		
		ArrayList<PhieuThuePhong> dsptp = new ArrayList<>();
		ArrayList<PhieuDichVu> dspdv = new ArrayList<>();
		for (ChiTietHoaDon cthd : hd.l_chitiet)
		{
			if (cthd.getPhieuThuePhong() != null)
				dsptp.add(cthd.getPhieuThuePhong());
			
			ArrayList<PhieuDichVu> sublistdv = PhieuDichVuDAO.get(cthd.getMaCTHD());
			for (PhieuDichVu psub : sublistdv)
				dspdv.add(psub);
		}
		
		uploadTable1(tbl1, dsptp);
		uploadTable2(tbl2, dspdv);
	}
	
	public static void updateTable(JTextField formMaKH, JTable tbl)
	{
		int makh = 0;
		if (!formMaKH.getText().isEmpty())
			makh = Integer.valueOf(formMaKH.getText());
		ArrayList<HoaDon> dshd = HoaDonDAO.load(makh);
		uploadTable(tbl, dshd);
	}
	
	public static void uploadTable(JTable tbl, ArrayList<HoaDon> list)
	{
		String[] columnNames = {"Mã","Ngày lập","Tổng tiền"};
		Object[][] data = new Object[list.size()][columnNames.length];
		int i = 0;
		for (HoaDon hd : list)
		{
			data[i][0] = hd.getMaHD();
			data[i][1] = hd.getNgayLap();
			data[i][2] = hd.getTongtien();
			i++;
		}
		TableModel tableModel = new DefaultTableModel(data, columnNames);
		tbl.setModel(tableModel);
	}
    
	public static void uploadTable1(JTable tbl, ArrayList<PhieuThuePhong> list)
	{
		String[] columnNames = {"Mã","Số phòng","Ngày đến","Ngày đi"};
		Object[][] data = new Object[list.size()][columnNames.length];
		int i = 0;
		for (PhieuThuePhong ptp : list)
		{
			data[i][0] = ptp.getMaPTP();
			data[i][1] = ptp.getMaPHG();
			data[i][2] = ptp.getNgayDen();
			data[i][3] = ptp.getNgayDi();
			i++;
		}
		TableModel tableModel = new DefaultTableModel(data, columnNames);
		tbl.setModel(tableModel);
	}
    
	public static void uploadTable2(JTable tbl, ArrayList<PhieuDichVu> list)
	{
		String[] columnNames = {"Mã","Dịch vụ","Ngày đặt","Số lượng"};
		Object[][] data = new Object[list.size()][columnNames.length];
		int i = 0;
		for (PhieuDichVu pdv : list)
		{
			data[i][0] = pdv.getMaPDV();
			data[i][1] = pdv.getMaDV();
			data[i][2] = pdv.getNgayDat();
			data[i][3] = pdv.getSoLuong();
			i++;
		}
		TableModel tableModel = new DefaultTableModel(data, columnNames);
		tbl.setModel(tableModel);
	}
    
}
