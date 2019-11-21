/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.PhieuDichVu;

/**
 *
 * @author Massan
 */
public class PhieuDichVuDAO {

	public static PhieuDichVu get(int mapdv) {
		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT * FROM PhieuDichVu WHERE mapdv=" + mapdv);

		try {
			while (rs.next()) {
				PhieuDichVu pdv = new PhieuDichVu(rs.getInt(1), rs.getInt(2));

				pdv.setNgayDat(rs.getString(3));
				pdv.setSoLuong(rs.getInt(4));

				DB.disconnect();

				return pdv;
			}
		} catch (SQLException e) {
			System.out.println("[PhieuDichVuDAO:get] error sql: " + e);
		}

		DB.disconnect();

		return null;
	}
	public static void edit(PhieuDichVu pdv)
	{
		
	}

	public int getnewidphieudichvu() {
		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT MAX(mapdv) FROM phieudichvu");

		try {
			while (rs.next()) {
				int newid = rs.getInt(1) + 1;
				DB.disconnect();
				return newid;
			}
		} catch (SQLException e) {
			System.out.println("[ChiTietHoaDonDAO:getNewID] error sql: " + e);
		}

		DB.disconnect();

		return -1;
	}

	public static void add(PhieuDichVu pdv) {
		Database DB = new Database();
		DB.connect();

		String sql = "INSERT INTO phieudichvu (madv, ngaydat, soluong) VALUES ('";
		sql += pdv.getMaDV() + "', '";
		sql += pdv.getNgayDat() + "', '";
		sql += pdv.getSoLuong() + "');";

		DB.update(sql);
		DB.disconnect();
	}
	public static int getNewID()
	{
		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT MAX(mapdv) FROM phieudichvu");
		
		try
		{
			while(rs.next())
			{
				int newid = rs.getInt(1) + 1;
				DB.disconnect();
				return newid;
			}
		}
		catch(SQLException e)
		{
			System.out.println("[PhieuDichVuDAO:getNewID] error sql: "+e);
		}
		
		DB.disconnect();
		
		return -1;
	}

}
