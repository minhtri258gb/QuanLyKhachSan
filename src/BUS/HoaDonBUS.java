/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChiTietHoaDonDAO;
import DAO.DichVuDAO;
import DAO.HoaDonDAO;
import DAO.PhieuThuePhongDAO;
import DAO.PhongDAO;
import DTO.ChiTietHoaDon;
import DTO.HoaDon;
import DTO.PhieuThuePhong;
import Tools.DateUtil;

/**
 *
 * @author Massan
 */
public class HoaDonBUS
{
	public void traPhong(int makh)
	{
		HoaDonDAO hdDAO = new HoaDonDAO();
		ChiTietHoaDonDAO cthdDAO = new ChiTietHoaDonDAO();
		PhieuThuePhongDAO ptpDAO = new PhieuThuePhongDAO();
		
		HoaDon hd = hdDAO.getFromMaKH(makh);
		hd.l_chitiet = cthdDAO.get(hd.getMaHD());
		
		for(ChiTietHoaDon cthd : hd.l_chitiet)
		{
			PhieuThuePhong ptp = cthd.getPhieuThuePhong();
			ptp.setNgayDi(DateUtil.getCurDate());
			ptpDAO.edit(ptp);
		}
	}
	
	public void thanhToan(int makh)
	{
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
	
}
