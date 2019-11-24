/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChiTietHoaDonDAO;
import DAO.HoaDonDAO;
import DAO.LoaiPhongDAO;
import DAO.PhieuThuePhongDAO;
import DAO.PhongDAO;
import DTO.ChiTietHoaDon;
import DTO.HoaDon;
import DTO.LoaiPhong;
import DTO.PhieuThuePhong;
import DTO.Phong;
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
public class PhongBUS
{

	public static void init(JTable tbl, JTable tbll)
	{
		PhongBUS.updateTablebyTang(tbl, -1);
		
		ArrayList<LoaiPhong> lstlp = LoaiPhongDAO.load();
		PhongBUS.uploadTableLP(tbll, lstlp);
	}
	
    public ArrayList<Phong> load()
	{
        return PhongDAO.load();
    }

	public static Phong getPhong(int maphg)
	{
		return PhongDAO.getPhong(maphg);
	}

    public ArrayList<LoaiPhong> loadLPhg()
    {
        return LoaiPhongDAO.load();
    }
    
    public ArrayList<Phong> getphongtrong() {
        ArrayList<Phong> listphongtrong = new ArrayList();
        for (Phong phongtrong : this.load()) {
            if ("ổn định".equals(phongtrong.getTinhtrang())) {

                listphongtrong.add(phongtrong);
            }
        }
        return listphongtrong;
    }

    public ArrayList<Phong> getphongdangchothue() {
        ArrayList<Phong> listphongdangchothue = new ArrayList();
        for (Phong phongdangthue : this.load()) {
            if ("đang dùng".equals(phongdangthue.getTinhtrang())) {

                listphongdangchothue.add(phongdangthue);
            }
        }
        return listphongdangchothue;
    }

    public ArrayList<Phong> getphongdangsua() {
        ArrayList<Phong> listphongdangsua = new ArrayList();
        for (Phong phongdangsua : this.load()) {
            if ("sửa chữa".equals(phongdangsua.getTinhtrang())) {

                listphongdangsua.add(phongdangsua);
            }
        }
        return listphongdangsua;
    }

    public static void doiphong(JTable tblPo, JTable tblPn)
	{
		int maphg_old = TableUtil.getMaFromTable(tblPo);
		int maphg_new = TableUtil.getMaFromTable(tblPn);
		
        HoaDon hd = HoaDonDAO.getFromMaPhg(maphg_old);
		if(hd == null)
		{
			ThongBao.warning("Chua dat phong");
			return;
		}
		
		if (hd.l_chitiet.isEmpty())
		{
			ThongBao.noitice("[PhongBUS:doiPhong] Chua dat phong");
			return;
		}
		
        for (ChiTietHoaDon cthd : hd.l_chitiet)
		{
            PhieuThuePhong ptp = cthd.getPhieuThuePhong();
            if (ptp != null && ptp.getMaPHG() == maphg_old)
			{
                if (DateUtil.compare(ptp.getNgayDen(), DateUtil.getCurDate()) == 1)
				{
                    PhieuThuePhong ptpcu=ptp;
                    ptpcu.setNgayDi(DateUtil.getCurDate());
                    PhieuThuePhongDAO.edit(ptpcu);
                    //tạo phieu thuê phòng mới
                    PhieuThuePhong ptpm=new PhieuThuePhong(PhieuThuePhongDAO.getNewID());
                    ptpm.setMaPhg(maphg_new);
                    ptpm.setNgayDen(DateUtil.getCurDate());
                    ptpm.setNgayDi("");
                    PhieuThuePhongDAO.add(ptpm);
					
					// 
					boolean isadd = false;
					for (ChiTietHoaDon cthd2 : hd.l_chitiet)
					{
						if(cthd2.getPhieuThuePhong() == null)
						{
							cthd2.setPhieuThuePhong(ptpm);
							ChiTietHoaDonDAO.edit(cthd2);
							isadd = true;
						}
					}
					if(!isadd)
					{
						ChiTietHoaDon cthdnew = new ChiTietHoaDon(ChiTietHoaDonDAO.getNewID());
						cthdnew.setPhieuDichVu(null);
						cthdnew.setPhieuThuePhong(ptpm);
						cthdnew.setThanhtien(0);
						ChiTietHoaDonDAO.add(cthdnew, hd.getMaHD());
					}
                } else {
                    ptp.setMaPhg(maphg_new);
                    PhieuThuePhongDAO.edit(ptp);
                }
				
				// Update tinh trang phong
				Phong updatephongdoi = PhongDAO.getPhong(maphg_old);
				updatephongdoi.setTinhtrang("ổn định");
				PhongDAO.edit(updatephongdoi);
				Phong updatephongdoi1 = PhongDAO.getPhong(maphg_new);
				updatephongdoi.setTinhtrang("đang dùng");
				PhongDAO.edit(updatephongdoi1);
				break;
            }

        }
		
		ThongBao.noitice("đổi thành công.");
//		TODO updateTable
    }

    public static String getTenLPhg(int maloaiphong) {
        LoaiPhongDAO loaiphong = new LoaiPhongDAO();
        ArrayList<LoaiPhong> list = loaiphong.load();
        for (LoaiPhong lphg : list) {
            if (lphg.getMaLoaiPhg() == maloaiphong) {
                return lphg.getTenLoaiPhg();
            }
        }
        return "";
    }

    public static int getGiaLPhg(int maloaiphong) {
        LoaiPhongDAO loaiphong = new LoaiPhongDAO();
        ArrayList<LoaiPhong> list = loaiphong.load();
        for (LoaiPhong lphg : list) {
            if (lphg.getMaLoaiPhg() == maloaiphong) {
                return lphg.getGia();
            }
        }
        return 0;
    }
	
//	public void datPhong(int makh, ArrayList<Integer> maphgs)
//	{
//		// Tao hoa don
//		HoaDonDAO hdDAO = new HoaDonDAO();
//		int manv = TaiKhoanBUS.getUser().getMaNV();
//		int mahd = hdDAO.getNewID();
//		HoaDon hd = new HoaDon(mahd, makh, manv);
//		hd.setNgayLap(DateUtil.getCurDate());
//		hd.setTongtien(0);
//		
//		// Tạo phiếu thuê phòng và chi tiết hóa đơn
//		PhieuThuePhongDAO ptpDAO = new PhieuThuePhongDAO();
//		ChiTietHoaDonDAO cthdDAO = new ChiTietHoaDonDAO();
//		int maptp = ptpDAO.getNewID();
//		int macthd = cthdDAO.getNewID();
//		ArrayList<PhieuThuePhong> l_ptp = new ArrayList<>();
//		for(int i=0;i<maphgs.size();i++)
//		{
//			PhieuThuePhong ptp = new PhieuThuePhong(maptp + i);
//			ptp.setMaPhg(maphgs.get(i));
//			ptp.setNgayDen(DateUtil.getCurDate());
//			ptp.setNgayDi("");
//			l_ptp.add(ptp);
//			
//			ChiTietHoaDon cthd = new ChiTietHoaDon(macthd + i);
//			cthd.setPhieuThuePhong(ptp);
//			cthd.setPhieuDichVu(null);
//			cthd.setThanhtien(0);
//			
//			hd.l_chitiet.add(cthd);
//		}
//		
//		ThongBao.noitice("Đặt phòng thành công");
//	}
	
	public static void datphong(JTextField formKHMa, JTable tblPhg)
	{
		// Kiem tra hoa don khach hang
		int makh = 0;
		if(!formKHMa.getText().isEmpty())
			makh = Integer.valueOf(formKHMa.getText());
		
		if(makh == 0)
		{
			ThongBao.warning("Chưa chọn khách hàng");
			return;
		}
		
//		int maphg = TableUtil.getMaFormTable(tblPhg); // FIXME
		if (tblPhg.getSelectedRow() == -1)
		{
			ThongBao.warning("Chưa chọn phòng");
			return;
		}
		int maphg = (int) tblPhg.getValueAt(tblPhg.getSelectedRow(), 0);
		
		int manv = TaiKhoanBUS.getUser().getMaNV();
		
		// Kiem tra dat phong
		Phong phg = PhongDAO.getPhong(maphg);
		if (!"ổn định".equals(phg.getTinhtrang()))
		{
			ThongBao.warning("Phòng đang bận");
			return;
		}
		
		HoaDon hd = HoaDonDAO.getFromMaKH(makh);
		if (hd==null)
		{
			// Tao hoa don moi
			hd = new HoaDon(HoaDonDAO.getNewID(), makh, manv);
			hd.setNgayLap(DateUtil.getCurDate());
			PhieuThuePhong ptp = new PhieuThuePhong(PhieuThuePhongDAO.getNewID());
			ptp.setMaPhg(maphg);
			ptp.setNgayDen(DateUtil.getCurDate());
			ptp.setNgayDi("");
			ChiTietHoaDon cthdm=new ChiTietHoaDon(ChiTietHoaDonDAO.getNewID());
			cthdm.setPhieuThuePhong(ptp);
			cthdm.setThanhtien(0);
			cthdm.setPhieuDichVu(null);
			PhieuThuePhongDAO.add(ptp);
			ChiTietHoaDonDAO.add(cthdm, hd.getMaHD());
			HoaDonDAO.add(hd);
			phg.setTinhtrang("đang dùng");
		    PhongDAO.edit(phg);
			ThongBao.noitice("Đặt thành công");
			return;
		}
		
		// Them phieu thue phong
		PhieuThuePhong ptp = new PhieuThuePhong(PhieuThuePhongDAO.getNewID());
		ptp.setMaPhg(maphg);
		ptp.setNgayDen(DateUtil.getCurDate());
		ptp.setNgayDi("");
		PhieuThuePhongDAO.add(ptp);
		
		boolean isadd = false;
		for (ChiTietHoaDon cthd : hd.l_chitiet)
		{
			if (cthd.getPhieuThuePhong() == null)
			{
				cthd.setPhieuThuePhong(ptp);
				ChiTietHoaDonDAO.edit(cthd);
				isadd = true;
			}
		}
		if (!isadd)
		{
			ChiTietHoaDon cthd = new ChiTietHoaDon(ChiTietHoaDonDAO.getNewID());
			cthd.setPhieuDichVu(null);
			cthd.setPhieuThuePhong(ptp);
			cthd.setThanhtien(0);
			ChiTietHoaDonDAO.add(cthd, hd.getMaHD());
			hd.l_chitiet.add(cthd);
		}
		
		// Chuyen tinh trang
		phg.setTinhtrang("đang dùng");
		PhongDAO.edit(phg);
		
		// Thong bao
		ThongBao.noitice("Đặt thành công");
//		updateTable(tblPhg);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static boolean addphong(JTable tblp, JTable tbllp, JTextField formSoP, JTextField formTT)
	{
		int sophg = 0;
		if (!formSoP.getText().isEmpty())
			sophg = Integer.valueOf(formSoP.getText());
		
		String tinhtrang = formTT.getText();
		int malphg = TableUtil.getMaFromTable(tbllp);
		
		if (validateForm(sophg, malphg, tinhtrang))
		{
			Phong p = new Phong(sophg);
			p.setMaloaiphg(malphg);
			p.setTinhtrang(tinhtrang);
			PhongDAO.add(p);
			return true;
		}
		return false;
	}
	
	public static boolean addloaiphong(JTextField formT, JTextField formG, JTextArea formMT)
	{
		int malphg = LoaiPhongDAO.getNewID();
		
		String tenl = formT.getText();
		
		int gia = 0;
		if (!formG.getText().isEmpty())
			gia = Integer.valueOf(formG.getText());
		
		String mota = formMT.getText();
		
		if (validateForm2(malphg, tenl, gia, mota))
		{
			LoaiPhong lp = new LoaiPhong(malphg);
			lp.setTenloaiphg(tenl);
			lp.setGia(gia);
			lp.setMota(mota);
			LoaiPhongDAO.add(lp);
			return true;
		}
		return false;
	}
	
	public static boolean editphong(JTable tblp, JTable tbllp, JTextField formSoP, JTextField formTT)
	{
		int sophg = 0;
		if (!formSoP.getText().isEmpty())
			sophg = Integer.valueOf(formSoP.getText());
		
		String tinhtrang = formTT.getText();
		int malphg = TableUtil.getMaFromTable(tbllp);
		
		if (validateForm(sophg, malphg, tinhtrang))
		{
			Phong p = PhongDAO.getPhong(sophg);
			p.setMaloaiphg(malphg);
			p.setTinhtrang(tinhtrang);
			PhongDAO.edit(p);
			return true;
		}
		return false;
	}
	
	public static boolean editloaiphong(JTable tbll, JTextField formT, JTextField formG, JTextArea formMT)
	{
		int malphg = TableUtil.getMaFromTable(tbll);
		
		String tenl = formT.getText();
		
		int gia = 0;
		if (!formG.getText().isEmpty())
			gia = Integer.valueOf(formG.getText());
		
		String mota = formMT.getText();
		
		if (validateForm2(malphg, tenl, gia, mota))
		{
			LoaiPhong lp = LoaiPhongDAO.getLoaiPhong(malphg);
			lp.setTenloaiphg(tenl);
			lp.setGia(gia);
			lp.setMota(mota);
			LoaiPhongDAO.edit(lp);
			return true;
		}
		return false;
	}
	
	public static void deletephong(JTable tblp)
	{
		int maphg = TableUtil.getMaFromTable(tblp);
		if (maphg != 1)
			PhongDAO.delete(maphg);
	}
	
	public static void deleteloaiphong(JTable tbllp)
	{
		int malphg = TableUtil.getMaFromTable(tbllp);
		if (malphg != 1)
			PhongDAO.delete(malphg);
	}
	
	public static void uploadTableP(JTable tbl, ArrayList<Phong> lst)
	{
		String[] columnNames = {"Số phòng","Tình trạng"};
		Object[][] data = new Object[lst.size()][columnNames.length];
		
		int i = 0;
		for (Phong p : lst)
		{
			data[i][0] = p.getMaphg();
			data[i][1] = p.getTinhtrang();
			i++;
		}
		TableModel tableModel = new DefaultTableModel(data, columnNames);
		tbl.setModel(tableModel);
	}
	
	public static void uploadTableLP(JTable tbl, ArrayList<LoaiPhong> lst)
	{
		String[] columnNames = {"mã", "Tên Loại","Giá", "Mô tả"};
		Object[][] data = new Object[lst.size()][columnNames.length];
		
		int i = 0;
		for (LoaiPhong lp : lst)
		{
			data[i][0] = lp.getMaLoaiPhg();
			data[i][1] = lp.getTenLoaiPhg();
			data[i][2] = lp.getGia();
			data[i][3] = lp.getMota();
			i++;
		}
		TableModel tableModel = new DefaultTableModel(data, columnNames);
		tbl.setModel(tableModel);
	}
	
	public static void updateTablebyTang(JTable tbl, int tang)
	{
		PhongDAO pDAO = new PhongDAO();
		ArrayList<Phong> lstfull = pDAO.load();
		
		if (tang == -1)
			uploadTableP(tbl, lstfull);
		else
		{
			ArrayList<Phong> lst = new ArrayList<>();
			for(Phong p : lstfull)
				if (p.getMaphg() / 100 == tang)
					lst.add(p);
			uploadTableP(tbl, lst);
		}
	}
	
	public static void updateTableL(JTable tbl)
	{
		ArrayList<LoaiPhong> lst = LoaiPhongDAO.load();
		uploadTableLP(tbl, lst);
	}
	
	public static void loadInfo(JTable tblp, JTable tbllp, JTextField formSoP, JTextField formTT, JTextField formLP, JTextField formG, JTextArea formMT)
	{
		int sophg = TableUtil.getMaFromTable(tblp);
		Phong phg = PhongDAO.getPhong(sophg);
		int malphg = phg.getMaloaiphg();
		LoaiPhong lphg = LoaiPhongDAO.getLoaiPhong(malphg);
		
		formSoP.setText(String.valueOf(phg.getMaphg()));
		formTT.setText(phg.getTinhtrang());
		formLP.setText(lphg.getTenLoaiPhg());
		formG.setText(String.valueOf(lphg.getGia()));
		formMT.setText(lphg.getMota());
		
		tbllp.setRowSelectionInterval(malphg-1, malphg-1);
	}
	
	public static void loadInfo2(JTable tbllp, JTextField formT, JTextField formG, JTextArea formMT)
	{
		int malphg = TableUtil.getMaFromTable(tbllp);
		LoaiPhong lphg = LoaiPhongDAO.getLoaiPhong(malphg);
		
		formT.setText(lphg.getTenLoaiPhg());
		formG.setText(String.valueOf(lphg.getGia()));
		formMT.setText(lphg.getMota());
	}
	
	private static boolean validateForm(int sophg, int malphg, String tinhtrang)
	{
		if (sophg == 0 || sophg > 9999)
			ThongBao.warning("So phong khong hop le");
		else if (tinhtrang.isEmpty())
			ThongBao.warning("Tinh trang phong khong hop le");
		else if (malphg == -1 || LoaiPhongDAO.getLoaiPhong(malphg) == null)
			ThongBao.warning("Loai phong khong hop le");
		else
			return true;
		return false;
	}
	
	private static boolean validateForm2(int malphg, String ten, int gia, String mota)
	{
		if (malphg == -1)
			ThongBao.warning("Chưa chọn loại phòng");
		else if (ten.isEmpty())
			ThongBao.warning("Ten loai phong khong hop le");
		else if (gia == 0)
			ThongBao.warning("gia phong khong hop le");
		else if (mota.isEmpty())
			ThongBao.warning("mo ta khong hop le");
		else
			return true;
		return false;
	}
	
}