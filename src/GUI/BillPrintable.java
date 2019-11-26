/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.PhongBUS;
import DAO.ChiTietHoaDonDAO;
import DAO.DichVuDAO;
import DAO.HoaDonDAO;
import DAO.KhachHangDAO;
import DAO.PhieuDichVuDAO;
import DTO.ChiTietHoaDon;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.FontMetrics;
import DTO.HoaDon;
import DTO.PhieuDichVu;
import Tools.DateUtil;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.util.ArrayList;

/**
 *
 * @author tuan gh
 */
public class BillPrintable implements Printable {
    
   private final HoaDon hd;
   private int tongtien;
    public BillPrintable(HoaDon hd,int tt)
	{
		this.hd=hd;
		this.tongtien=tt;
	}
    
  @Override
  public int print(Graphics graphics, PageFormat pageFormat,int pageIndex) 
  throws PrinterException 
  {    
      ArrayList<ChiTietHoaDon> cthd=ChiTietHoaDonDAO.load(hd.getMaHD());
	  ArrayList<PhieuDichVu> listpdv = new ArrayList<>();
	  for (ChiTietHoaDon ct : cthd) {
			if (PhieuDichVuDAO.get(ct.getMaCTHD()) != null) {

				listpdv.addAll(PhieuDichVuDAO.get(ct.getMaCTHD()));
			}				
		}
                
        
      int result = NO_SUCH_PAGE;    
        if (pageIndex == 0) {                    
        
            Graphics2D g2d = (Graphics2D) graphics;                    

            double width = pageFormat.getImageableWidth();                    
           
            g2d.translate((int) pageFormat.getImageableX(),(int) pageFormat.getImageableY()); 

            ////////// code by alqama//////////////

            FontMetrics metrics=g2d.getFontMetrics(new Font("Arial",Font.BOLD,7));
        //    int idLength=metrics.stringWidth("000000");
            //int idLength=metrics.stringWidth("00");
            int idLength=metrics.stringWidth("000");
            int amtLength=metrics.stringWidth("000000");
            int qtyLength=metrics.stringWidth("00000");
            int priceLength=metrics.stringWidth("000000");
            int prodLength=(int)width - idLength - amtLength - qtyLength - priceLength-17;

        //    int idPosition=0;
        //    int productPosition=idPosition + idLength + 2;
        //    int pricePosition=productPosition + prodLength +10;
        //    int qtyPosition=pricePosition + priceLength + 2;
        //    int amtPosition=qtyPosition + qtyLength + 2;
            
            int productPosition = 0;
            int discountPosition= prodLength+5;
            int pricePosition = discountPosition +idLength+10;
            int qtyPosition=pricePosition + priceLength + 4;
            int amtPosition=qtyPosition + qtyLength;
            
            
              
        try{
            /*Draw Header*/
            int y=20;
            int yShift = 10;
            int headerRectHeight=15;
            int headerRectHeighta=40;
            
            ///////////////// Product names Get ///////////
                String  pn1a="";
                
            ///////////////// Product names Get ///////////
                
            
            ///////////////// Product price Get ///////////
                int pp1a=1;
                
                int sum=pp1a;
            ///////////////// Product price Get ///////////
                
             g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
            g2d.drawString("-------------------------------------",12,y);y+=yShift;
            g2d.drawString("      Hóa đơn khách hàng       ",12,y);y+=yShift;
            g2d.drawString("-------------------------------------",12,y);y+=headerRectHeight;
			g2d.drawString(" Khách Hàng:"+KhachHangDAO.getKhachHang(hd.getMaKH()).getTen(),10,y);y+=yShift;
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
            g2d.drawString(" Phòng       số ngày          Giá   ",10,y);y+=yShift;
            g2d.drawString("-------------------------------------",10,y);y+=headerRectHeight;
            for(ChiTietHoaDon printcthd:cthd)
			{
				int songay=0;
				if(DateUtil.getDay(DateUtil.getCurDate())==DateUtil.getDay(printcthd.getPhieuThuePhong().getNgayDen()))
			{
				songay=1;
			}
			else{
			songay=DateUtil.getDay(DateUtil.getCurDate())-DateUtil.getDay(printcthd.getPhieuThuePhong().getNgayDen());
			}
				g2d.drawString(" "+printcthd.getPhieuThuePhong().getMaPHG()+"          "+songay+"           "+PhongBUS.getGiaLPhg(PhongBUS.getPhong(printcthd.getPhieuThuePhong().getMaPHG()).getMaloaiphg())+"  ",10,y);y+=yShift;
			}
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
            g2d.drawString(" Số phòng thuê: "+cthd.size()+"               ",10,y);y+=yShift;
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
			g2d.drawString("Phòng     Dịch vụ   số lượng   Giá    ",10,y);y+=yShift;
            g2d.drawString("-------------------------------------",10,y);y+=headerRectHeight;
			for(PhieuDichVu pdv:listpdv)
			{
				g2d.drawString(" "+ChiTietHoaDonDAO.getcthdbypdv(pdv).getPhieuThuePhong().getMaPHG()+"       "+DichVuDAO.getDichVu(pdv.getMaDV()).getTenDV()+"      "+pdv.getSoLuong()+"      "+DichVuDAO.getDichVu(pdv.getMaDV()).getGia()+"  ",10,y);y+=yShift;
			}
			g2d.drawString("-------------------------------------",10,y);y+=headerRectHeight;
			g2d.drawString(" Số dịch vụ sử dụng: "+listpdv.size()+"               ",10,y);y+=yShift;
			g2d.drawString("-------------------------------------",10,y);y+=headerRectHeight;
			g2d.drawString("         Tổng tiền:"+this.tongtien+"       ",12,y);y+=yShift;
			
			g2d.drawString("-------------------------------------",10,y);y+=headerRectHeight;
            g2d.drawString("        mọi đánh giá xin liên hệ        ",10,y);y+=yShift;
            g2d.drawString("             03111111111             ",10,y);y+=yShift;
            g2d.drawString("*************************************",10,y);y+=yShift;
            g2d.drawString("    THANKS TO VISIT OUR HOTEL   ",10,y);y+=yShift;
            g2d.drawString("*************************************",10,y);y+=yShift;
                   
           
             
           
            
//            g2d.setFont(new Font("Monospaced",Font.BOLD,10));
//            g2d.drawString("Customer Shopping Invoice", 30,y);y+=yShift; 
          

    }
    catch(Exception r){
    r.printStackTrace();
    }

              result = PAGE_EXISTS;    
          }    
          return result;    
      }
  public static PageFormat getPageFormat(PrinterJob pj)
{
    
    PageFormat pf = pj.defaultPage();
    Paper paper = pf.getPaper();    

    double middleHeight =8.0;  
    double headerHeight = 2.0;                  
    double footerHeight = 2.0;                  
    double width = convert_CM_To_PPI(8);      //printer know only point per inch.default value is 72ppi
    double height = convert_CM_To_PPI(headerHeight+middleHeight+footerHeight); 
    paper.setSize(width, height);
    paper.setImageableArea(                    
        0,
        10,
        width,            
        height - convert_CM_To_PPI(1)
    );   //define boarder size    after that print area width is about 180 points
            
    pf.setOrientation(PageFormat.PORTRAIT);           //select orientation portrait or landscape but for this time portrait
    pf.setPaper(paper);    

    return pf;
}
    
    protected static double convert_CM_To_PPI(double cm) {            
	        return toPPI(cm * 0.393600787);            
}
 
protected static double toPPI(double inch) {            
	        return inch * 72d;            
} 
   }

