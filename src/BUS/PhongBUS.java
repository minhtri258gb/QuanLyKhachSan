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
import java.util.ArrayList;

/**
 *
 * @author Massan
 */
public class PhongBUS
{
    public ArrayList<Phong> load()
    {
        PhongDAO phgDAO = new PhongDAO();
        return phgDAO.load();
    }
    
    public ArrayList<LoaiPhong> loadLPhg()
    {
        LoaiPhongDAO lphgDAO = new LoaiPhongDAO();
        return lphgDAO.load();
    }
    
	public void datPhong(int makh, ArrayList<Integer> maphgs)
	{
		HoaDonDAO hdDAO = new HoaDonDAO();
		
		int manv = TaiKhoanBUS.getUser().getMaNV();
		int mahd = hdDAO.getNewID();
		
		HoaDon hd = new HoaDon(mahd, makh, manv);
		hd.setNgayLap(DateUtil.getCurDate());
		hd.setTongtien(0);
		
		ChiTietHoaDonDAO cthdDAO = new ChiTietHoaDonDAO();
		PhieuThuePhongDAO ptpDAO = new PhieuThuePhongDAO();
		
		int macthd = cthdDAO.getNewID();
		int maptp = ptpDAO.getNewID();
                
		for(int i=0; i<maphgs.size(); i++)
		{
                    PhieuThuePhong ptp = new PhieuThuePhong(maptp);
                    ptp.setMaPhg(maphgs.get(i));
                    ptp.setNgayDen(DateUtil.getCurDate());
                    ptp.setNgayDi("");

                    ChiTietHoaDon cthd = new ChiTietHoaDon(macthd);
                    cthd.setPhieuThuePhong(ptp);
                    cthd.setPhieuDichVu(null);
                    cthd.setThanhtien(0);

                    hd.l_chitiet.add(cthd);

                    macthd++;
                    maptp++;
			
//			ptpDAO.add(ptp);
//			cthdDAO.add(cthd, mahd);
		}
		
//		hdDAO.add(hd);
                ThongBao.noitice("Đặt phòng thành công");
	}
	
	public void doiPhong(int makh, int maphg_old, int maphg_new)
	{
		HoaDonDAO hdDAO = new HoaDonDAO();
		PhieuThuePhongDAO ptpDAO = new PhieuThuePhongDAO();
		
		HoaDon hd = hdDAO.getFromMaPhg(maphg_old);
		
		for(ChiTietHoaDon cthd : hd.l_chitiet)
		{
			PhieuThuePhong ptp = cthd.getPhieuThuePhong();
			if(ptp.getMaPHG() == maphg_old)
			{
				ptp.setMaPhg(maphg_new);
				ptpDAO.edit(ptp);
				break;
			}
		}
	}
        
        public String getTenLPhg(int maloaiphong, ArrayList<LoaiPhong> list)
        {
            for(LoaiPhong lphg : list)
                if(lphg.getMaLoaiPhg() == maloaiphong)
                    return lphg.getTenLoaiPhg();
            return "";
        }
        
        public int getGiaLPhg(int maloaiphong, ArrayList<LoaiPhong> list)
        {
            for(LoaiPhong lphg : list)
                if(lphg.getMaLoaiPhg() == maloaiphong)
                    return lphg.getGia();
            return 0;
        }
}
