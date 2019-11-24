/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.HoaDon;
import Tools.DateUtil;

/**
 *
 * @author Massan
 */
public class HoaDonDAO {

	public static ArrayList<HoaDon> load() {
		ArrayList<HoaDon> l_hoadon = new ArrayList<>();

		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT * FROM HoaDon");

		try {
			while (rs.next()) {
				HoaDon hd = new HoaDon(rs.getInt(1), rs.getInt(2), rs.getInt(3));

				hd.setNgayLap(rs.getString(4));
				hd.setTongtien(rs.getInt(5));
				l_hoadon.add(hd);
			}
		} catch (SQLException e) {
			System.out.println("[HoaDonDAO:load] error sql: " + e);
		}

		DB.disconnect();

		return l_hoadon;
	}

	public static void add(HoaDon hd) {
		Database DB = new Database();
		DB.connect();

		String sql = "INSERT INTO HoaDon (makh, manv, ngaylap, tongtien) VALUES ('";
		sql += hd.getMaKH() + "', '";
		sql += hd.getMaNV() + "', '";
		sql += hd.getNgayLap() + "', '";
		sql += hd.getTongtien() + "');";
		DB.update(sql);
		DB.disconnect();
	}

	public static void delete(int mahd) {
		Database DB = new Database();
		DB.connect();
		DB.update("DELETE FROM HoaDon WHERE HoaDon.mahd=" + mahd);
		DB.disconnect();
	}

	public static void edit(HoaDon hd) {
		Database DB = new Database();
		DB.connect();

		String sql = "UPDATE HoaDon SET ";
		sql += "ngaylap='" + hd.getNgayLap();
		sql += "', tongtien='" + hd.getTongtien();
		sql += "' WHERE HoaDon.mahd = " + hd.getMaHD() + ";";

		DB.update(sql);
		DB.disconnect();
	}

	public static int getNewID() {
		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT MAX(mahd) FROM HoaDon");

		try {
			while (rs.next()) {
				int newid = rs.getInt(1) + 1;
				DB.disconnect();
				return newid;
			}
		} catch (SQLException e) {
			System.out.println("[HoaDonDAO:getNewID] error sql: " + e);
		}

		DB.disconnect();

		return -1;
	}

	public static HoaDon getFromMaKH(int makh) {
		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT * FROM HoaDon WHERE makh=" + makh);

		ArrayList<HoaDon> l_hoadon = new ArrayList<>();
		try {
			while (rs.next()) {
				HoaDon hd = new HoaDon(rs.getInt(1), rs.getInt(2), rs.getInt(3));
				hd.setNgayLap(rs.getString(4));
				hd.setTongtien(rs.getInt(5));
				l_hoadon.add(hd);
			}
		} catch (SQLException e) {
			System.out.println("[HoaDonDAO:load] error sql: " + e);
		}

		DB.disconnect();

		// Tim hoa don lap gan nhat
		HoaDon hd = null;
		
		for (HoaDon hdi : l_hoadon) {
			if(hdi.getTongtien()==0)
				hd=hdi;
			
//			if (hd == null) {
//				hd = hdi;
//			} else if (DateUtil.compare(hdi.getNgayLap(), hd.getNgayLap()) == 1) {
//				hd = hdi;
//			}
		}

		if (hd == null) {
			return null;
		} else {
			hd.l_chitiet = ChiTietHoaDonDAO.load(hd.getMaHD());
		}

		return hd;
	}

	public static HoaDon getFromMaPhg(int maphg) {
		Database DB = new Database();
		DB.connect();

		String sql = "SELECT hd.* ";
		sql += "FROM HoaDon hd, ChiTietHoaDon cthd, PhieuThuePhong ptp ";
		sql += "WHERE hd.mahd=cthd.mahd AND cthd.maptp=ptp.maptp AND ptp.maphg=" + maphg;

		ResultSet rs = DB.execution(sql);

		ArrayList<HoaDon> l_hoadon = new ArrayList<>();
		try {
			while (rs.next()) {
				HoaDon hd = new HoaDon(rs.getInt(1), rs.getInt(2), rs.getInt(3));
				hd.setNgayLap(rs.getString(4));
				hd.setTongtien(rs.getInt(5));
				l_hoadon.add(hd);
			}
		} catch (SQLException e) {
			System.out.println("[HoaDonDAO:load] error sql: " + e);
		}

		DB.disconnect();

		// Tim hoa don lap gan nhat
		HoaDon hd = null;

		for (HoaDon hdi : l_hoadon) {
			if (hd == null) {
				hd = hdi;
			} else if (DateUtil.compare(hdi.getNgayLap(), hd.getNgayLap()) == 1) {
				hd = hdi;
			}
			
		}
		if(hd==null)
			return null;
		return hd;
	}

}
