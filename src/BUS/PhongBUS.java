/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

/**
 *
 * @author Massan
 */
public class PhongBUS
{
	public void datPhong(int makh, int[] maphgs)
	{
		// get id nhan vien
		// tao hoa don
		
		for(int i=0; i<maphgs.length; i++)
		{
			// tao chi tiet hoa don
			// tao phieu dat phong
		}
		
		// link
		
		// luu database
	}
	
	public void doiPhong(int makh, int maphg_old, int maphg_new)
	{
		// get hoa don
		// HoaDonBUS.getFromMaKH(makh)
		
		// get chi tiet hoa don co maptp == phieu thue phong co maphg == maphg_old
		// hoadon.findCT_withMaPHG(maphg_old)
		
		// update old = new
		// cthd.phieuthuephong.maphg = maphg_new
		
		// update database
		// PhieuThuePhongDAO.update(phieuthuephong)
	}
}
