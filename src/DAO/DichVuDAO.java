/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.DichVu;

/**
 *
 * @author Massan
 */
public class DichVuDAO
{
	public ArrayList<DichVu> load()
	{
		ArrayList<DichVu> l_dichvu = new ArrayList<DichVu>();
		
		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT * FROM DichVu");
		
		try
		{
			while(rs.next())
			{
				DichVu dv = new DichVu(rs.getInt(1));

				dv.setTenDV(rs.getString(2));
				dv.setMoTa(rs.getString(3));
				dv.setGia(rs.getInt(4));
				l_dichvu.add(dv);
			}
		}
		catch(SQLException e)
		{
			System.out.println("[DichVuDAO:load] error sql: "+e);
		}
		
		DB.disconnect();
		
		return l_dichvu;
	}
	
	public void add(DichVu dv)
	{
		Database DB = new Database();
		DB.connect();
		
		String sql = "INSERT INTO DichVu (tendv, mota, gia) VALUES ('";
		sql += dv.getTenDV()+"', '";
		sql += dv.getMoTa()+"', '";
		sql += dv.getGia()+"');";
		
		DB.update(sql);
		DB.disconnect();
	}

	public void delete(int madv)
	{
		Database DB = new Database();
		DB.connect();
		DB.update("DELETE FROM DichVu WHERE DichVu.madv="+madv);
		DB.disconnect();
	}

	public void edit(DichVu dv)
	{
		Database DB = new Database();
		DB.connect();
		
		String sql = "UPDATE DichVu SET ";
		sql += "tendv='"					+dv.getTenDV();
		sql += "', mota='"					+dv.getMoTa();
		sql += "', gia='"					+dv.getGia();
		sql += "' WHERE DichVu.madv = "		+dv.getMaDV()+";";
		
		DB.update(sql);
		DB.disconnect();
	}

}
