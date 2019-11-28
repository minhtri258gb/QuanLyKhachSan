/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.DichVuDAO;
import DAO.HoaDonDAO;
import DAO.PhieuDichVuDAO;
import DAO.PhieuThuePhongDAO;
import DTO.DichVu;
import DTO.HoaDon;
import DTO.PhieuDichVu;
import DTO.PhieuThuePhong;
import Tools.DateUtil;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Massan
 */
public class ThongKe
{
	public static void init(JPanel chrTN, JPanel chrDV, JPanel chrDS)
	{
		thuNhap(chrTN);
		tanSuatDV(chrDV);
		doanhSo(chrDS);
	}
	
	public static void thuNhap(JPanel chr)
	{
		// Danh sach nam 10 nam
		ArrayList<Integer> l_tong = new ArrayList<>();
		for (int i=0; i<10; i++)
			l_tong.add(0);
		
		ArrayList<HoaDon> l_hoadon = HoaDonDAO.load();
		int curYear = DateUtil.getYear(DateUtil.getCurDate());
		for (HoaDon hd : l_hoadon)
		{
			String date = hd.getNgayLap();
			int idnam = curYear - DateUtil.getYear(date);
			if (idnam >= 10)
				continue;
			l_tong.set(idnam, l_tong.get(idnam) + hd.getTongtien());
		}
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int i=9; i>=0; i--)
		{
			dataset.addValue(l_tong.get(i), "VND" , String.valueOf(curYear - i));
		}
		
		JFreeChart lineChart = ChartFactory.createLineChart("Tổng thu nhập từng năm", "Năm", "Tổng thu nhập",
				dataset, PlotOrientation.VERTICAL, true, true, false);

		ChartPanel chartPanel = new ChartPanel(lineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
		
		chr.setLayout(new BorderLayout());
		chr.add(chartPanel, BorderLayout.CENTER);
		chr.validate();
	}
	
	public static void tanSuatDV(JPanel chr)
	{
		ArrayList<DichVu> dsdv = DichVuDAO.load();
		ArrayList<PhieuDichVu> dspdv = PhieuDichVuDAO.load();
		
		ArrayList<Integer> dstk = new ArrayList<>();
		for (int i=0; i<dsdv.size(); i++)
			dstk.add(0);
		
		for (PhieuDichVu pdv : dspdv)
			for (DichVu dv : dsdv)
				if (pdv.getMaDV() == dv.getMaDV())
				{
					int id = dsdv.indexOf(dv);
					dstk.set(id, dstk.get(id)+1);
					break;
				}
		
		int max = 1;
		for (Integer num : dstk)
			if (num > max)
				num = max;
		
		// Draw Chart
		DefaultPieDataset dataset = new DefaultPieDataset( );

		int maxdv = dsdv.size();
		for (int i=0; i<maxdv; i++)
			dataset.setValue( dsdv.get(i).getTenDV() , dstk.get(i)/max);
		
		JFreeChart chart = ChartFactory.createPieChart("Tần suất sử dụng dịch vụ", dataset, true, true, false);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
		
		chr.setLayout(new BorderLayout());
		chr.add(chartPanel, BorderLayout.CENTER);
		chr.validate();
	}
	
	public static void doanhSo(JPanel chr)
	{
		// Danh sach nam 5 nam
		ArrayList<Integer> l_tong = new ArrayList<>();
		for (int i=0; i<5; i++)
			l_tong.add(0);
		
		int curYear = DateUtil.getYear(DateUtil.getCurDate());
		ArrayList<PhieuThuePhong> dsptp = PhieuThuePhongDAO.load();
		
		
		for (PhieuThuePhong ptp : dsptp)
		{
			int idnam = curYear - DateUtil.getYear(ptp.getNgayDen());
			if (idnam >= 5)
				continue;
			l_tong.set(idnam, l_tong.get(idnam) + 1);
		}
		
		// Draw Chart
		DefaultCategoryDataset dataset = new DefaultCategoryDataset( );

		for (int i=4; i>=0; i--)
			dataset.addValue(Double.valueOf(l_tong.get(i)), "Khách hàng", String.valueOf(curYear - i));
		
		JFreeChart chart = ChartFactory.createBarChart("Số lượng khách hàng", "Năm", "Người", dataset,
				PlotOrientation.VERTICAL, true, true, false);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
		
		chr.setLayout(new BorderLayout());
		chr.add(chartPanel, BorderLayout.CENTER);
		chr.validate();
	}
	
}
