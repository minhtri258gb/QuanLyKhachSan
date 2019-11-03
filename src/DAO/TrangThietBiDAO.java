/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.TrangThietBi;

/**
 *
 * @author Massan
 */
public class TrangThietBiDAO
{
	public ArrayList<TrangThietBi> load()
	{
		ArrayList<TrangThietBi> l_TTB = new ArrayList<TrangThietBi>();
		
		Database DB = new Database();
		DB.connect();

		ResultSet rs = DB.execution("SELECT * FROM TrangThietBi");
		
		try
		{
			while(rs.next())
			{
				TrangThietBi ttb = new TrangThietBi(rs.getInt(1));

				ttb.setTenTB(rs.getString(2));
				l_TTB.add(ttb);
			}
		}
		catch(SQLException e)
		{
			System.out.println("[TrangThietBiDAO:load] error sql: "+e);
		}
		
		DB.disconnect();
		
		return l_TTB;
	}
	
	public void add(TrangThietBi ttb)
	{
		Database DB = new Database();
		DB.connect();
		DB.update("INSERT INTO TrangThietBi (tentb) VALUES ('" + ttb.getTenTB() + "');");
		DB.disconnect();
	}

	public void delete(int matb)
	{
		Database DB = new Database();
		DB.connect();
		DB.update("DELETE FROM TrangThietBi WHERE TrangThietBi.matb = " + matb);
		DB.disconnect();
	}

	public void edit(TrangThietBi ttb)
	{
		Database DB = new Database();
		DB.connect();
		DB.update("UPDATE TrangThietBi SET ten='"+ttb.getTenTB()+"'  WHERE TrangThietBi.matb="+ttb.getMaTB()+";");
		DB.disconnect();
	}

}
