/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.HoaDonBUS;
import BUS.KhachHangBUS;
import BUS.PhongBUS;
import DAO.ChiTietHoaDonDAO;
import DAO.DichVuDAO;
import DAO.HoaDonDAO;
import DAO.PhieuDichVuDAO;
import DAO.PhieuThuePhongDAO;
import DAO.PhongDAO;
import DTO.ChiTietHoaDon;
import DTO.HoaDon;
import DTO.KhachHang;
import DTO.PhieuDichVu;
import DTO.PhieuThuePhong;
import DTO.Phong;
import Tools.DateUtil;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author tuan gh
 */
public class thanhtoan extends javax.swing.JDialog {

	/**
	 * Creates new form thanhtoan
	 */
	public thanhtoan(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		this.pack();
		setLocationRelativeTo(null);
		loadkh();
		loadtblphongdat();
		loadtbldichvudat();
		String makh = LeTanGUI.it.getmakhdatphong();
		HoaDon hoadonkh = HoaDonBUS.gethoadonbymakh(Integer.valueOf(makh));
//        ArrayList<ChiTietHoaDon> listcthd=hoadonkh.l_chitiet;
//		ArrayList<PhieuDichVu> listpdv=new ArrayList<>();
//		int tienphong=0;
//		int tiendv=0;
//		int tongtien=0;
//		for(ChiTietHoaDon ct:hoadonkh.l_chitiet)
//		{
//			if(PhieuDichVuDAO.get(ct.getMaCTHD())!=null)
//			{
//				
//			listpdv.addAll(PhieuDichVuDAO.get(ct.getMaCTHD()));
//			}
//			ct.getPhieuThuePhong()
//		}
//		
//		for(PhieuDichVu pdvtt:listpdv)
//		{
//			tiendv +=pdvtt.getSoLuong()*DichVuDAO.getDichVu(pdvtt.getMaDV()).getGia();
//		}

		//HoaDon hd=;
	}

	void loadkh() {
		int makh = Integer.valueOf(LeTanGUI.it.getmakhdatphong());
		KhachHang kh = KhachHangBUS.getkhbyid(makh);
		txthokhm.setText(kh.getHo());
		txthokhm.setEditable(false);
		txttenkhm.setText(kh.getTen());
		txttenkhm.setEditable(false);
		cmbgioitinhm.setSelectedItem(kh.getGioiTinh() + 1);
		cmbgioitinhm.setEditable(false);
		txtsdtm.setText(String.valueOf(kh.getSoDienThoai()));
		txtsdtm.setEditable(false);
		txtemailm.setText(kh.getEmail());
		txtemailm.setEditable(false);
		txtcmnnm.setText(String.valueOf(kh.getCMND()));
		txtcmnnm.setEditable(false);
		txtquoctichm.setText(kh.getQuocTich());
		txtquoctichm.setEditable(false);
		dcrngaysinhmoi.setDate(DateUtil.convert(kh.getNgaySinh()));
	}

	void loadtblphongdat() {
		ArrayList<ChiTietHoaDon> listcthd;
		int makh = Integer.valueOf(LeTanGUI.it.getmakhdatphong());
		HoaDon hoadonkh = HoaDonBUS.gethoadonbymakh(makh);

		listcthd = hoadonkh.l_chitiet;
		String[] columnNames = {"Số phòng", "Loại phòng", "ngày đặt", "ngày trả", "Giá"};
		Object[][] data = new Object[listcthd.size()][columnNames.length];
		int i = 0;
		for (ChiTietHoaDon cthd : listcthd) {
			data[i][0] = cthd.getPhieuThuePhong().getMaPHG();
			data[i][1] = PhongBUS.getTenLPhg(PhongBUS.getPhong(cthd.getPhieuThuePhong().getMaPHG()).getMaloaiphg());
			data[i][2] = hoadonkh.getNgayLap();
			data[i][3] = cthd.getPhieuThuePhong().getNgayDi();
			data[i][4] = PhongBUS.getGiaLPhg(PhongBUS.getPhong(cthd.getPhieuThuePhong().getMaPHG()).getMaloaiphg());
			i++;
		}
		TableModel tableModel = new DefaultTableModel(data, columnNames);
		// TODO set editable column 3
		tblphgdat.setModel(tableModel);

	}

	void loadtbldichvudat() {
		ArrayList<PhieuDichVu> listphv = new ArrayList<>();
		int makh = Integer.valueOf(LeTanGUI.it.getmakhdatphong());
		HoaDon hoadonkh = HoaDonBUS.gethoadonbymakh(makh);

		String[] columnNames = {"Mã Phòng", "Tên dịch vụ", "Ngày đặt", "số lượng", "giá"};
		for (ChiTietHoaDon ct : hoadonkh.l_chitiet) {
			if (PhieuDichVuDAO.get(ct.getMaCTHD()) != null) {
				listphv.addAll(PhieuDichVuDAO.get(ct.getMaCTHD()));
			}
		}

		Object[][] data = new Object[listphv.size()][columnNames.length];
		int i = 0;
		for (PhieuDichVu pdvd : listphv) {
			data[i][0] = ChiTietHoaDonDAO.getcthdbypdv(pdvd).getPhieuThuePhong().getMaPHG();
			data[i][1] = DichVuDAO.getDichVu(pdvd.getMaDV()).getTenDV();
			data[i][2] = pdvd.getNgayDat();
			data[i][3] = pdvd.getSoLuong();
			data[i][4] = DichVuDAO.getDichVu(pdvd.getMaDV()).getGia();
			i++;
		}
		TableModel tableModel = new DefaultTableModel(data, columnNames);
		// TODO set editable column 3
		tbldichvudat.setModel(tableModel);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        pnKhu = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txttongtien = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldichvudat = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblphgdat = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txthokhm = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txttenkhm = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cmbgioitinhm = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        txtemailm = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtcmnnm = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtquoctichm = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtsdtm = new javax.swing.JTextField();
        dcrngaysinhmoi = new com.toedter.calendar.JDateChooser();
        pnBT = new javax.swing.JPanel();
        btninhoadon = new javax.swing.JButton();
        btnthoatdv = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnKhu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnKhu.setForeground(new java.awt.Color(0, 90, 227));
        pnKhu.setPreferredSize(new java.awt.Dimension(326, 237));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(229, 70, 70));
        jLabel10.setText("THANH TOÁN");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("Tổng tiền");

        txttongtien.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        tbldichvudat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbldichvudat);

        tblphgdat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblphgdat);

        jLabel1.setForeground(new java.awt.Color(51, 0, 255));
        jLabel1.setText("các dịch vụ đã sử dụng");

        jLabel9.setForeground(new java.awt.Color(51, 0, 255));
        jLabel9.setText("các phòng  sử dụng");

        jPanel4.setPreferredSize(new java.awt.Dimension(524, 245));

        jLabel13.setText("Ngày sinh:");

        jLabel14.setText("Họ khách hàng:");

        jLabel15.setText("Tên khách hàng:");

        jLabel16.setText("Giới tính:");

        cmbgioitinhm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));
        cmbgioitinhm.setEditor(null);

        jLabel17.setText("Email:");

        jLabel18.setText("Số CMND:");

        jLabel19.setText("Quốc tịch:");

        jLabel21.setText("SDT");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbgioitinhm, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsdtm, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttenkhm, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txthokhm, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtcmnnm)
                    .addComponent(txtemailm)
                    .addComponent(txtquoctichm)
                    .addComponent(dcrngaysinhmoi, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(txthokhm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14))
                    .addComponent(dcrngaysinhmoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtemailm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel15)
                    .addComponent(txttenkhm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcmnnm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel16)
                    .addComponent(cmbgioitinhm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtquoctichm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel21)
                    .addComponent(txtsdtm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout pnKhuLayout = new javax.swing.GroupLayout(pnKhu);
        pnKhu.setLayout(pnKhuLayout);
        pnKhuLayout.setHorizontalGroup(
            pnKhuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKhuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnKhuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnKhuLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnKhuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txttongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(pnKhuLayout.createSequentialGroup()
                .addGap(422, 422, 422)
                .addComponent(jLabel10)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnKhuLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnKhuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );
        pnKhuLayout.setVerticalGroup(
            pnKhuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKhuLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnKhuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnKhuLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnKhuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(pnKhuLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))))
        );

        btninhoadon.setText("In hóa đơn");
        btninhoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninhoadonActionPerformed(evt);
            }
        });

        btnthoatdv.setText("Thoát");
        btnthoatdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthoatdvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBTLayout = new javax.swing.GroupLayout(pnBT);
        pnBT.setLayout(pnBTLayout);
        pnBTLayout.setHorizontalGroup(
            pnBTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBTLayout.createSequentialGroup()
                .addGap(272, 272, 272)
                .addComponent(btninhoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addComponent(btnthoatdv, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnBTLayout.setVerticalGroup(
            pnBTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBTLayout.createSequentialGroup()
                .addGap(0, 23, Short.MAX_VALUE)
                .addGroup(pnBTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btninhoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnthoatdv, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(pnBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnKhu, javax.swing.GroupLayout.PREFERRED_SIZE, 894, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnKhu, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnthoatdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthoatdvActionPerformed
		LeTanGUI.it.enabledFrame();
		this.dispose();
    }//GEN-LAST:event_btnthoatdvActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
		LeTanGUI.it.enabledFrame();
    }//GEN-LAST:event_formWindowClosing

    private void btninhoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninhoadonActionPerformed
		String makh = LeTanGUI.it.getmakhdatphong();
		HoaDon hoadonkh = HoaDonBUS.gethoadonbymakh(Integer.valueOf(makh));
		ArrayList<ChiTietHoaDon> listcthd = hoadonkh.l_chitiet;
		ArrayList<PhieuDichVu> listpdv = new ArrayList<>();
		int tiendv=0;
		int tienphg=0;
		int tongtien=0;
		
		for (ChiTietHoaDon ct : listcthd) {
			if (PhieuDichVuDAO.get(ct.getMaCTHD()) != null) {

				listpdv.addAll(PhieuDichVuDAO.get(ct.getMaCTHD()));
			}
			for (PhieuDichVu pdvtt : listpdv) {
			tiendv += pdvtt.getSoLuong() * DichVuDAO.getDichVu(pdvtt.getMaDV()).getGia();
			
		}
			PhieuThuePhong ptpupdate=ct.getPhieuThuePhong();
			ptpupdate.setNgayDi(DateUtil.getCurDate());
			PhieuThuePhongDAO.edit(ptpupdate);	
			if(DateUtil.getDay(DateUtil.getCurDate())==DateUtil.getDay(ct.getPhieuThuePhong().getNgayDen()))
			{
				tienphg +=PhongBUS.getGiaLPhg(PhongBUS.getPhong(ct.getPhieuThuePhong().getMaPHG()).getMaloaiphg());
			}
			else{
			tienphg +=PhongBUS.getGiaLPhg(PhongBUS.getPhong(ct.getPhieuThuePhong().getMaPHG()).getMaloaiphg())
					*(DateUtil.getDay(DateUtil.getCurDate())-DateUtil.getDay(ct.getPhieuThuePhong().getNgayDen()));
			}
			int temp=tienphg+tiendv;
			ct.setThanhtien(temp);
			ChiTietHoaDonDAO.edit(ct);
			tongtien +=tiendv+tienphg;
			Phong traphg=PhongBUS.getPhong(ct.getPhieuThuePhong().getMaPHG());
			traphg.setTinhtrang("ổn định");
			PhongDAO.edit(traphg);
			
		}	
		hoadonkh.setTongtien(tongtien);
		HoaDonDAO.edit(hoadonkh);
		ThongBao.noitice("thanh toán thành công.");
		//xuất file pdf
		LeTanGUI.it.enabledFrame();
		this.dispose();
		LeTanGUI.it.updatetblphongdat(Integer.valueOf(LeTanGUI.it.getmakhdatphong()));
		LeTanGUI.it.updatetblphong();


    }//GEN-LAST:event_btninhoadonActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(thanhtoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(thanhtoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(thanhtoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(thanhtoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the dialog */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				thanhtoan dialog = new thanhtoan(new javax.swing.JFrame(), true);
				dialog.addWindowListener(new java.awt.event.WindowAdapter() {
					@Override
					public void windowClosing(java.awt.event.WindowEvent e) {
						System.exit(0);
					}
				});
				dialog.setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btninhoadon;
    private javax.swing.JButton btnthoatdv;
    private javax.swing.JComboBox<String> cmbgioitinhm;
    private com.toedter.calendar.JDateChooser dcrngaysinhmoi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnBT;
    private javax.swing.JPanel pnKhu;
    private javax.swing.JTable tbldichvudat;
    private javax.swing.JTable tblphgdat;
    private javax.swing.JTextField txtcmnnm;
    private javax.swing.JTextField txtemailm;
    private javax.swing.JTextField txthokhm;
    private javax.swing.JTextField txtquoctichm;
    private javax.swing.JTextField txtsdtm;
    private javax.swing.JTextField txttenkhm;
    private javax.swing.JTextField txttongtien;
    // End of variables declaration//GEN-END:variables
}
