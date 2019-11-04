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
public class PhieuDichVuDAO
{
	public PhieuDichVu get(int mapdv)
	{
		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT * FROM PhieuDichVu WHERE mapdv="+mapdv);
		
		try
		{
			while(rs.next())
			{
				PhieuDichVu pdv = new PhieuDichVu(rs.getInt(1), rs.getInt(2));
				
				pdv.setNgayDat(rs.getString(3));
				pdv.setSoLuong(rs.getInt(4));
				
				DB.disconnect();
				
				return pdv;
			}
		}
		catch(SQLException e)
		{
			System.out.println("[PhieuDichVuDAO:get] error sql: "+e);
		}
		
		DB.disconnect();
		
		return null;
	}
}
