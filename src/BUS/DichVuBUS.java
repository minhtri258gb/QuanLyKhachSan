/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.DichVuDAO;
import DTO.DichVu;
import java.util.ArrayList;

/**
 *
 * @author Massan
 */
public class DichVuBUS
{
	public void thue(int maphg, int madv, int soluong)
	{
		/*
		
		Giai thich:
		
		tim cthd theo: cthd -> phieudatphong -> phong = maphg
		
		if cthd -> phieudichvu == null
			create new phieudichvu
			...
		else cthd -> phieudichvu != null
			create new chitiethoadon
			chitiethoadon -> (cthd -> phieudatphong)
			chitiethoadon -> (create new phieudichvu)
		
		
		SELECT column_names
		FROM table_name
		WHERE column_name IS NOT NULL;
		
		*/
		
		// get hoadon from maphg
		// find cthd empty phieudichvu
		
		// get ngay dat
		// Tao phieu dich vu
		
		// add phieudichvu vao cthd
		
		// add phieu dich vu to database
		// update cthd
	}
        public ArrayList<DichVu> getdv()
        {
            DichVuDAO dv=new DichVuDAO();
            return dv.load();
        }
        public int getgiadvbyma(String name)
    {
        DichVuDAO dv =new DichVuDAO();
        for(DichVu dvc:dv.load())
        {
            if(dvc.getTenDV().equals(name)){
                return dvc.getGia();
            }
                
            
        }
        return 0;
    }
        
        public static DichVu getDichVu(int madv)
        {
            return DichVuDAO.getDichVu(madv);
        }
}
