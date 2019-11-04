/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.Phong;

/**
 *
 * @author Massan
 */
public class PhongDAO
{
	
	public ArrayList<Phong> load()
	{
		ArrayList<Phong> l_dichvu = new ArrayList<>();
		
		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT * FROM Phong");
		
		try
		{
			while(rs.next())
			{
				Phong phg = new Phong(rs.getInt(1));

				phg.setMaloaiphg(rs.getInt(2));
				phg.setTinhtrang(rs.getString(3));
				phg.setGia(rs.getInt(4));
				// TODO List CHITIET
				l_dichvu.add(phg);
			}
		}
		catch(SQLException e)
		{
			System.out.println("[DichVuDAO:load] error sql: "+e);
		}
		
		DB.disconnect();
		
		return l_dichvu;
	}
	
	public void add(Phong phg)
	{
		Database DB = new Database();
		DB.connect();
		
		String sql = "INSERT INTO Phong (maloaiphg, tinhtrang, gia) VALUES ('";
		sql += phg.getMaloaiphg()+"', '";
		sql += phg.getTinhtrang()+"', '";
		sql += phg.getGia()+"');";
		
		DB.update(sql);
		DB.disconnect();
	}

	public void delete(int maphg)
	{
		Database DB = new Database();
		DB.connect();
		DB.update("DELETE FROM Phong WHERE Phong.maphg="+maphg);
		DB.disconnect();
	}

	public void edit(Phong phg)
	{
		Database DB = new Database();
		DB.connect();
		
		String sql = "UPDATE Phong SET ";
		sql += "maloaiphg='"				+phg.getMaloaiphg();
		sql += "', tinhtrang='"			+phg.getTinhtrang();
		sql += "', gia='"					+phg.getGia();
		sql += "' WHERE Phong.maphg = "	+phg.getMaphg()+";";
		
		DB.update(sql);
		DB.disconnect();
	}

	public int getGia(int maphg)
	{
		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT l.gia FROM Phong p, LoaiPhong lp WHERE lp.malphg=p.malphg AND p.maphg="+maphg);
		
		try
		{
			while(rs.next())
			{
				int gia = rs.getInt(1);
				DB.disconnect();
				return gia;
			}
		}
		catch(SQLException e)
		{
			System.out.println("[DichVuDAO:load] error sql: "+e);
		}
		
		DB.disconnect();
		
		return 0;
	}
	
}
