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
import javax.swing.JTextField;

/**
 *
 * @author Massan
 */
public class PhongBUS {

    public ArrayList<Phong> load() {
        PhongDAO phgDAO = new PhongDAO();
        return phgDAO.load();
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

    public ArrayList<LoaiPhong> loadLPhg() {
        LoaiPhongDAO lphgDAO = new LoaiPhongDAO();
        return lphgDAO.load();
    }

    public void datPhong(int makh, ArrayList<Integer> maphgs) {
        // Tao hoa don
        HoaDonDAO hdDAO = new HoaDonDAO();
        int manv = TaiKhoanBUS.getUser().getMaNV();
        int mahd = hdDAO.getNewID();
        HoaDon hd = new HoaDon(mahd, makh, manv);
        hd.setNgayLap(DateUtil.getCurDate());
        hd.setTongtien(0);

        // Tạo phiếu thuê phòng và chi tiết hóa đơn
        PhieuThuePhongDAO ptpDAO = new PhieuThuePhongDAO();
        ChiTietHoaDonDAO cthdDAO = new ChiTietHoaDonDAO();
        int maptp = PhieuThuePhongDAO.getNewID();
        int macthd = cthdDAO.getNewID();
        for (int i = 0; i < maphgs.size(); i++) {
            PhieuThuePhong ptp = new PhieuThuePhong(maptp + 1);
            ptp.setMaPhg(maphgs.get(i));
            ptp.setNgayDen(DateUtil.getCurDate());
            ptp.setNgayDi("");
            ptpDAO.add(ptp);
            PhongDAO phgdao = new PhongDAO();
            Phong phg = PhongDAO.getphong(maphgs.get(i));
            phg.setTinhtrang("đang dùng");
            phgdao.edit(phg);

            ChiTietHoaDon cthd = new ChiTietHoaDon(macthd + 1);
            cthd.setPhieuThuePhong(ptp);
            cthd.setPhieuDichVu(null);
            cthd.setThanhtien(0);
            cthdDAO.add(cthd, mahd);

            hd.l_chitiet.add(cthd);
        }
        hdDAO.add(hd);

        ThongBao.noitice("Đặt phòng thành công");
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
				Phong updatephongdoi = PhongDAO.getphong(maphg_old);
				updatephongdoi.setTinhtrang("ổn định");
				PhongDAO.edit(updatephongdoi);
				Phong updatephongdoi1 = PhongDAO.getphong(maphg_new);
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
	public static Phong getphongbyma(int maphg)
	{
		return PhongDAO.getphong(maphg);
	}

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
		Phong phg = PhongDAO.getphong(maphg);
		if (!"ổn định".equals(phg.getTinhtrang()))
		{
			ThongBao.warning("Phòng đang bận");
			return;
		}
		
		HoaDon hd = HoaDonDAO.getFromMaKH(makh);
		if (hd.getTongtien() != 0)
		{
			// Tao hoa don moi
			hd = new HoaDon(HoaDonDAO.getNewID(), makh, manv);
			HoaDonDAO.add(hd);
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
	
}