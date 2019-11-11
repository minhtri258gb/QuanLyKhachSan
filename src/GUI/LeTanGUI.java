package GUI;

import BUS.KhachHangBUS;
import BUS.PhongBUS;
import BUS.TaiKhoanBUS;
import DTO.KhachHang;
import DTO.Phong;
import Tools.DateUtil;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
public class LeTanGUI extends javax.swing.JFrame {
    public LeTanGUI() throws SQLException {
        initComponents();
        this.pack();
        setLocationRelativeTo(null);
        setExtendedState(this.MAXIMIZED_BOTH);
        txttennvlogin.setText(TaiKhoanBUS.getUser().getTenTK());
        //Begin Tabquanlykhachhang 
        txtmakh.setEditable(false);
        //jScrollPane2.setSize(1000, 400);
        //End Tabquanlykhachhang 
        //Begin  tabquanlythuephong 
        
        //End Tabquanlythuephong
        //Begin  tabquanlythuedichvu
        //code here
        //End Tabquanlythuedichvu
        //Begin  tabquanlythuephong
        //code here
        //End Tabquanlythuephong
        try {
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();// đối tượng thao tác với ô trong table
            renderer.setHorizontalAlignment(JLabel.LEFT);// Căn trai dữ liệu bảng
            tblkh.setRowHeight(30);
            BUS.KhachHangBUS.HienThongkh(tblkh);
            tblkh.setDefaultRenderer(Object.class, renderer);

        } catch (Exception ex) {
            Logger.getLogger(LeTanGUI.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error in LeTanGUI: " + ex.getMessage());
        }
    }
    public void enabledFrame() {
        this.setEnabled(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txttennvlogin = new javax.swing.JLabel();
        tabletan = new javax.swing.JTabbedPane();
        tabquanlykhachhang = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbgioitinh = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtquoctich = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jButtonthemkh = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        txttenkh = new javax.swing.JTextField();
        txthokh = new javax.swing.JTextField();
        txtsdt = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtcmnn = new javax.swing.JTextField();
        dcrngaysinh = new com.toedter.calendar.JDateChooser();
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
        jLabel26 = new javax.swing.JLabel();
        jButtonsuakh = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtmakh = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtsdtm = new javax.swing.JTextField();
        dcrngaysinhmoi = new com.toedter.calendar.JDateChooser();
        jLabel27 = new javax.swing.JLabel();
        txttimkienkhachhang = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblkh = new javax.swing.JTable();
        tabdatphong = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblphong = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        btndatphong = new javax.swing.JButton();
        txtsophg = new javax.swing.JTextField();
        txtgia = new javax.swing.JTextField();
        txtloaiphg = new javax.swing.JTextField();
        cbbsonguoi = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbldanhsachdadat = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        txthokhdp = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txttenkhdp = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtmakhdp = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        txtsdtdp = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txttimkhdp = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblkhdp = new javax.swing.JTable();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txtsophongdangdat = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        tablaphoadon = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblhoadon = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lễ Tân");
        setBackground(new java.awt.Color(255, 195, 191));
        setName("frmNhanVien"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1650, 1080));

        jPanel3.setBackground(new java.awt.Color(255, 233, 226));
        jPanel3.setPreferredSize(new java.awt.Dimension(1159, 614));

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 106, 122), 2));
        jPanel1.setPreferredSize(new java.awt.Dimension(1300, 81));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 38, 66));
        jLabel1.setText("LỄ TÂN");

        btnLogout.setBackground(new java.awt.Color(153, 255, 255));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logout.png"))); // NOI18N
        btnLogout.setToolTipText("Đăng xuất");
        btnLogout.setBorder(null);
        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jLabel25.setBackground(new java.awt.Color(153, 255, 255));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/employee.png"))); // NOI18N

        jLabel31.setText("ĐĂNG XUẤT");

        jLabel22.setText("Xin chào NV:");

        txttennvlogin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txttennvlogin.setForeground(new java.awt.Color(255, 51, 51));
        txttennvlogin.setText("qq");
        txttennvlogin.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(419, 419, 419))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttennvlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addGap(56, 56, 56))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(jLabel22)
                            .addComponent(txttennvlogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel1)
                    .addComponent(jLabel25))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabletan.setBackground(new java.awt.Color(255, 204, 153));
        tabletan.setOpaque(true);
        tabletan.setPreferredSize(new java.awt.Dimension(1280, 640));
        tabletan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabletanMouseClicked(evt);
            }
        });

        tabquanlykhachhang.setBackground(new java.awt.Color(255, 233, 226));
        tabquanlykhachhang.setPreferredSize(new java.awt.Dimension(1154, 600));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(83, 58, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Quản lý khách hàng");

        jPanel2.setBackground(new java.awt.Color(240, 255, 182));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 2));

        jLabel4.setText("Ngày sinh:");

        jLabel5.setText("Họ khách hàng:");

        jLabel6.setText("Tên khách hàng:");

        jLabel7.setText("Giới tính:");

        cmbgioitinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        cmbgioitinh.setEditor(null);

        jLabel8.setText("Email:");

        jLabel10.setText("Số CMND:");

        jLabel9.setText("Quốc tịch:");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(83, 58, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Thêm khách hàng");

        jButtonthemkh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/adduser.png"))); // NOI18N
        jButtonthemkh.setText("thêm");
        jButtonthemkh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonthemkhActionPerformed(evt);
            }
        });

        jLabel20.setText("SDT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txthokh, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(txttenkh)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dcrngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbgioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonthemkh)
                        .addGap(27, 27, 27)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtsdt)
                    .addComponent(txtcmnn, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addComponent(txtemail)
                    .addComponent(txtquoctich))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtcmnn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel20)
                            .addComponent(txthokh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(txttenkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbgioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtquoctich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addComponent(dcrngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonthemkh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(240, 255, 182));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 2));
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

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(83, 58, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Sửa thông tin");

        jButtonsuakh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edituser.png"))); // NOI18N
        jButtonsuakh.setText("sửa");
        jButtonsuakh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonsuakhActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("Mã khách hàng:");

        jLabel21.setText("SDT");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtmakh, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addGap(94, 94, 94))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtsdtm)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cmbgioitinhm, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txttenkhm, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(txthokhm))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtcmnnm)
                    .addComponent(txtemailm)
                    .addComponent(txtquoctichm)
                    .addComponent(dcrngaysinhmoi, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonsuakh)
                .addGap(185, 185, 185))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(34, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtmakh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
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
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbgioitinhm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtcmnnm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)
                        .addComponent(jLabel16)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtquoctichm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel21)
                    .addComponent(txtsdtm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonsuakh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setText("Tìm kiếm:");

        txttimkienkhachhang.setForeground(new java.awt.Color(0, 0, 255));
        txttimkienkhachhang.setToolTipText("Nhập thông tin cần tìm kiếm");
        txttimkienkhachhang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttimkienkhachhangKeyReleased(evt);
            }
        });

        jScrollPane3.setBackground(new java.awt.Color(255, 233, 226));

        tblkh.setBackground(new java.awt.Color(255, 233, 226));
        tblkh.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 1, true));
        tblkh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khách hàng", "Ho", "Tên", "Giới tính", "Ngày sinh", "SDT", "Email", "CMNN", "Quốc tịch"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblkh.setToolTipText("Bảng khách hàng");
        tblkh.setPreferredSize(new java.awt.Dimension(675, 200));
        tblkh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblkhMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblkh);
        if (tblkh.getColumnModel().getColumnCount() > 0) {
            tblkh.getColumnModel().getColumn(0).setResizable(false);
            tblkh.getColumnModel().getColumn(1).setResizable(false);
            tblkh.getColumnModel().getColumn(2).setResizable(false);
            tblkh.getColumnModel().getColumn(3).setResizable(false);
            tblkh.getColumnModel().getColumn(4).setResizable(false);
            tblkh.getColumnModel().getColumn(5).setResizable(false);
            tblkh.getColumnModel().getColumn(6).setResizable(false);
            tblkh.getColumnModel().getColumn(7).setResizable(false);
            tblkh.getColumnModel().getColumn(8).setResizable(false);
        }

        javax.swing.GroupLayout tabquanlykhachhangLayout = new javax.swing.GroupLayout(tabquanlykhachhang);
        tabquanlykhachhang.setLayout(tabquanlykhachhangLayout);
        tabquanlykhachhangLayout.setHorizontalGroup(
            tabquanlykhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabquanlykhachhangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabquanlykhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabquanlykhachhangLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(71, 71, 71))
                    .addGroup(tabquanlykhachhangLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(tabquanlykhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabquanlykhachhangLayout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txttimkienkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tabquanlykhachhangLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(83, Short.MAX_VALUE))
                    .addComponent(jScrollPane3)))
        );
        tabquanlykhachhangLayout.setVerticalGroup(
            tabquanlykhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabquanlykhachhangLayout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tabquanlykhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tabquanlykhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txttimkienkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        tabletan.addTab("Quản lý khách hàng", tabquanlykhachhang);

        tabdatphong.setBackground(new java.awt.Color(255, 233, 226));
        tabdatphong.setEnabled(false);
        tabdatphong.setPreferredSize(new java.awt.Dimension(1443, 663));
        tabdatphong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabdatphongMouseClicked(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(255, 233, 226));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(83, 58, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Quản Lý Phòng");
        jLabel12.setOpaque(true);

        tblphong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblphong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblphongMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblphong);

        jPanel10.setBackground(new java.awt.Color(240, 255, 182));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 2));

        jLabel37.setText("Giá");

        jLabel38.setText("Số phòng");

        jLabel39.setText("Loại phòng");

        jLabel40.setText("Số người");

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(83, 58, 255));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Thông tin phòng");

        btndatphong.setText("Đặt phòng");
        btndatphong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndatphongActionPerformed(evt);
            }
        });

        txtsophg.setEditable(false);

        cbbsonguoi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtsophg)
                            .addComponent(txtgia)
                            .addComponent(txtloaiphg)
                            .addComponent(cbbsonguoi, 0, 155, Short.MAX_VALUE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(btndatphong)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(txtsophg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(txtloaiphg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel40)
                    .addComponent(cbbsonguoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(txtgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btndatphong, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbldanhsachdadat.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(tbldanhsachdadat);

        jPanel5.setBackground(new java.awt.Color(240, 255, 182));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 2));
        jPanel5.setPreferredSize(new java.awt.Dimension(524, 245));

        jLabel28.setText("Họ khách hàng:");

        jLabel29.setText("Tên khách hàng:");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(83, 58, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("thông tin khách hàng đặt phòng");

        jLabel36.setForeground(new java.awt.Color(204, 0, 0));
        jLabel36.setText("Mã khách hàng:");

        jLabel41.setText("SDT:");

        jButton1.setText("đổi phòng");

        txttimkhdp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttimkhdpKeyReleased(evt);
            }
        });

        tblkhdp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblkhdp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblkhdpMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblkhdp);

        jLabel42.setText("Tìm khách hàng:");

        jLabel43.setText("Số phòng đang đặt:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                            .addComponent(jLabel36)
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtmakhdp, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsophongdangdat, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(txtsdtdp)
                            .addComponent(txttenkhdp)
                            .addComponent(txthokhdp))))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txttimkhdp, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtmakhdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel42)
                        .addComponent(txttimkhdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txthokhdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttenkhdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41)
                            .addComponent(txtsdtdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43)
                            .addComponent(txtsophongdangdat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );

        javax.swing.GroupLayout tabdatphongLayout = new javax.swing.GroupLayout(tabdatphong);
        tabdatphong.setLayout(tabdatphongLayout);
        tabdatphongLayout.setHorizontalGroup(
            tabdatphongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabdatphongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabdatphongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(tabdatphongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
            .addGroup(tabdatphongLayout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 1162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        tabdatphongLayout.setVerticalGroup(
            tabdatphongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabdatphongLayout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(tabdatphongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(tabdatphongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );

        tabletan.addTab("quản lý phòng", tabdatphong);

        jPanel6.setBackground(new java.awt.Color(255, 233, 226));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1208, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 522, Short.MAX_VALUE)
        );

        tabletan.addTab("Thuê dịch vụ", jPanel6);

        tablaphoadon.setBackground(new java.awt.Color(255, 233, 226));
        tablaphoadon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 2));

        jLabel2.setBackground(new java.awt.Color(255, 233, 226));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(83, 58, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thanh toán");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 226));
        jScrollPane1.setForeground(new java.awt.Color(0, 0, 255));

        tblhoadon.setBackground(new java.awt.Color(255, 255, 226));
        tblhoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Title 2"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblhoadon.setToolTipText("Bảng Thông tin mua bán");
        jScrollPane1.setViewportView(tblhoadon);

        javax.swing.GroupLayout tablaphoadonLayout = new javax.swing.GroupLayout(tablaphoadon);
        tablaphoadon.setLayout(tablaphoadonLayout);
        tablaphoadonLayout.setHorizontalGroup(
            tablaphoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1204, Short.MAX_VALUE)
            .addGroup(tablaphoadonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tablaphoadonLayout.setVerticalGroup(
            tablaphoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablaphoadonLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(205, Short.MAX_VALUE))
        );

        tabletan.addTab("Lập hóa đơn", tablaphoadon);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabletan, javax.swing.GroupLayout.DEFAULT_SIZE, 1213, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1213, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(tabletan, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1213, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        setBounds(0, 0, 1229, 748);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed

    }//GEN-LAST:event_btnLogoutActionPerformed
    private void btndatphongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndatphongActionPerformed
        PhongGUI phgGUI = new PhongGUI();
        if(!txtmakhdp.getText().isEmpty())
        phgGUI.datphong(tblphong, Integer.valueOf(txtmakhdp.getText()));
        else
        ThongBao.noitice("Chưa chọn khách hàng!");
    }//GEN-LAST:event_btndatphongActionPerformed

//    public void setTextFieldsuakh() {
//        txtmakh.setEditable(fa);
//        txthokh.setEditable(false);
//        txttenkh.setEditable(false);
//        //txtngaysinh.setEditable(false);
//        txtemail.setEditable(false);
//        txtcmnn.setEditable(false);
//        cmbgioitinh.setEnabled(false);
//    }

    private void tblkhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblkhMouseClicked

        int row = tblkh.getSelectedRow();
        int makh=Integer.valueOf(tblkh.getValueAt(row, 0).toString());  
        KhachHangBUS  khbus=new KhachHangBUS();
        KhachHang kh = khbus.getkhbyid(makh);
        txtmakh.setText(String.valueOf(kh.getMaKH()));
        txthokhm.setText(kh.getHo());
        txttenkhm.setText(kh.getTen());
        cmbgioitinhm.setSelectedItem(kh.getGioiTinh()+1); 
        txtsdtm.setText(String.valueOf(kh.getSoDienThoai()));
        txtemailm.setText(kh.getEmail());
        txtcmnnm.setText(String.valueOf(kh.getCMND()));
        txtquoctichm.setText(kh.getQuocTich());
        dcrngaysinhmoi.setDate(DateUtil.convert(kh.getNgaySinh()));
    }//GEN-LAST:event_tblkhMouseClicked
    private void txttimkienkhachhangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttimkienkhachhangKeyReleased
        try {
            BUS.KhachHangBUS.TimKiemkh(tblkh, txttimkienkhachhang.getText());
        } catch (SQLException ex) {
            Logger.getLogger(LeTanGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txttimkienkhachhangKeyReleased
    private void jButtonsuakhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonsuakhActionPerformed
        if (txthokhm.getText().length() == 0 || txthokhm.getText().length() > 28) {
            JOptionPane.showMessageDialog(null, "họ không hợp lệ", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (txttenkhm.getText().length() == 0 || txttenkhm.getText().length() > 7) {
            JOptionPane.showMessageDialog(null, "tên không hợp lệ", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (cmbgioitinhm.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "chọn giới tính.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!RegexExpression.checkPhoneNumber(txtsdtm.getText())) {
            JOptionPane.showMessageDialog(null, "Số đt không hợp lệ.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!RegexExpression.isValidemail(txtemailm.getText())) {
            JOptionPane.showMessageDialog(null, "email không hợp lệ.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!RegexExpression.checkcmnd(txtcmnnm.getText())) {
            JOptionPane.showMessageDialog(null, "cmnn k hợp lệ.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (txtquoctichm.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "quốc tịch trống.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int gt;
            if (cmbgioitinhm.getSelectedItem().toString() == "Nam") {
                gt = 0;

            } else {
                gt = 1;
            }
            int makh = Integer.valueOf(txtmakh.getText());
            String ho = txthokhm.getText();
            String ten = txttenkhm.getText();
            Date date = dcrngaysinhmoi.getDate();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String ngaysinh = formatter.format(date);
            int sdt = Integer.valueOf(txtsdtm.getText());
            String email = txtemailm.getText();
            int cmnn = Integer.valueOf(txtcmnnm.getText());
            String qt = txtquoctichm.getText();
            BUS.KhachHangBUS.edit(makh, ho, ten, gt, ngaysinh, sdt, email, cmnn, qt);
            try {
                AutomaticallyClosedMsgBox(1500, "Đang sửa.\nXin hãy đợi....");
                JOptionPane.showMessageDialog(null, "sửa thành công.", "Information", JOptionPane.INFORMATION_MESSAGE);
                BUS.KhachHangBUS.HienThongkh(tblkh);

            } catch (Exception ex) {

                Logger.getLogger(LeTanGUI.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButtonsuakhActionPerformed
    private void jButtonthemkhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonthemkhActionPerformed

        if (txthokh.getText().length() == 0 || txthokh.getText().length() > 28) {
            JOptionPane.showMessageDialog(null, "họ không hợp lệ", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (txttenkh.getText().length() == 0 || txttenkh.getText().length() > 7) {
            JOptionPane.showMessageDialog(null, "tên không hợp lệ", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (cmbgioitinh.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "chọn giới tính.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!RegexExpression.checkPhoneNumber(txtsdt.getText())) {
            JOptionPane.showMessageDialog(null, "Số đt không hợp lệ.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!RegexExpression.isValidemail(txtemail.getText())) {
            JOptionPane.showMessageDialog(null, "email không hợp lệ.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!RegexExpression.checkcmnd(txtcmnn.getText())) {
            JOptionPane.showMessageDialog(null, "cmnn k hợp lệ.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (txtquoctich.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "quốc tịch trống.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int gt;
            if (cmbgioitinh.getSelectedItem().toString() == "Nam") {
                gt = 0;
            } else {
                gt = 1;
            }
            String ho = txthokh.getText();
            String ten = txttenkh.getText();
            Date date = dcrngaysinh.getDate();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String ngaysinh = formatter.format(date);
            ThongBao.print(ngaysinh);
            int sdt = Integer.valueOf(txtsdt.getText());
            String email = txtemail.getText();
            int cmnn = Integer.valueOf(txtcmnn.getText());
            String qt = txtquoctich.getText();
            BUS.KhachHangBUS.add(ho, ten, gt, ngaysinh, sdt, email, cmnn, qt);
            try {
                AutomaticallyClosedMsgBox(1500, "Đang thêm.\nXin hãy đợi....");
                JOptionPane.showMessageDialog(null, "Thêm thành công.", "Information", JOptionPane.INFORMATION_MESSAGE);
                BUS.KhachHangBUS.HienThongkh(tblkh);

            } catch (Exception ex) {

                Logger.getLogger(LeTanGUI.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButtonthemkhActionPerformed

    private void tblphongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblphongMouseClicked
     int row = tblphong.getSelectedRow();
        int maphg=Integer.valueOf(tblphong.getValueAt(row, 0).toString());  
        PhongBUS  PhongBUS=new PhongBUS();
        Phong phg = PhongBUS.getphgbyid(maphg);
        txtsophg.setText(String.valueOf(phg.getMaphg()));
        txtloaiphg.setText(tblphong.getValueAt(row, 1).toString());
        txtgia.setText(tblphong.getValueAt(row, 3).toString());
        txtsophg.setEditable(false);
        txtloaiphg.setEditable(false);
       txtgia.setEditable(false);
    }//GEN-LAST:event_tblphongMouseClicked

    private void txttimkhdpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttimkhdpKeyReleased
       
        
        try {
            BUS.KhachHangBUS.LoadTablekhdp(tblkhdp, txttimkhdp.getText());
        } catch (SQLException ex) {
            Logger.getLogger(LeTanGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txttimkhdpKeyReleased

    private void tabdatphongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabdatphongMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabdatphongMouseClicked

    private void tabletanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabletanMouseClicked
        PhongGUI phgGUI = new PhongGUI();
        phgGUI.LoadTable(tblphong);
        try {
            BUS.KhachHangBUS.LoadTablekhdp(tblkhdp, "1");
        } catch (SQLException ex) {
            Logger.getLogger(LeTanGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
             
    }//GEN-LAST:event_tabletanMouseClicked

    private void tblkhdpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblkhdpMouseClicked
       int row = tblkhdp.getSelectedRow();
        int makh=Integer.valueOf(tblkhdp.getValueAt(row, 0).toString());  
        KhachHangBUS  khbus=new KhachHangBUS();
        KhachHang khdp=KhachHangBUS.getkhbyid(makh);
        txtmakhdp.setText(String.valueOf(khdp.getMaKH()));
        txthokhdp.setText(khdp.getHo());
        txttenkhdp.setText(khdp.getTen());
        txtsdtdp.setText(String.valueOf(khdp.getSoDienThoai()));
        txtsophongdangdat.setText("1");
        txtmakhdp.setEditable(false);
        txthokhdp.setEditable(false);
        txttenkhdp.setEditable(false);
        txtsdtdp.setEditable(false);
    }//GEN-LAST:event_tblkhdpMouseClicked
    public void AutomaticallyClosedMsgBox(long time, String text) {
        JOptionPane jop = new JOptionPane();
        jop.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        jop.setMessage(text);
        JDialog dialog = jop.createDialog(null, "Thông báo");

        // Set timer
        new Thread(() -> {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            dialog.dispose();
        }).start();

        dialog.setVisible(true);
    }
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LeTanGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {

                new LeTanGUI().setVisible(true);

            } catch (SQLException ex) {
                Logger.getLogger(LeTanGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btndatphong;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbsonguoi;
    private javax.swing.JComboBox<String> cmbgioitinh;
    private javax.swing.JComboBox<String> cmbgioitinhm;
    private com.toedter.calendar.JDateChooser dcrngaysinh;
    private com.toedter.calendar.JDateChooser dcrngaysinhmoi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonsuakh;
    private javax.swing.JButton jButtonthemkh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JPanel tabdatphong;
    private javax.swing.JPanel tablaphoadon;
    private javax.swing.JTabbedPane tabletan;
    private javax.swing.JPanel tabquanlykhachhang;
    private javax.swing.JTable tbldanhsachdadat;
    private javax.swing.JTable tblhoadon;
    private javax.swing.JTable tblkh;
    private javax.swing.JTable tblkhdp;
    private javax.swing.JTable tblphong;
    private javax.swing.JTextField txtcmnn;
    private javax.swing.JTextField txtcmnnm;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtemailm;
    private javax.swing.JTextField txtgia;
    private javax.swing.JTextField txthokh;
    private javax.swing.JTextField txthokhdp;
    private javax.swing.JTextField txthokhm;
    private javax.swing.JTextField txtloaiphg;
    private javax.swing.JTextField txtmakh;
    private javax.swing.JTextField txtmakhdp;
    private javax.swing.JTextField txtquoctich;
    private javax.swing.JTextField txtquoctichm;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txtsdtdp;
    private javax.swing.JTextField txtsdtm;
    private javax.swing.JTextField txtsophg;
    private javax.swing.JTextField txtsophongdangdat;
    private javax.swing.JTextField txttenkh;
    private javax.swing.JTextField txttenkhdp;
    private javax.swing.JTextField txttenkhm;
    private javax.swing.JLabel txttennvlogin;
    private javax.swing.JTextField txttimkhdp;
    private javax.swing.JTextField txttimkienkhachhang;
    // End of variables declaration//GEN-END:variables

}
