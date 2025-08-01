/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Util.UAuth;
import Util.UDialog;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author micro
 */
public class menuKH extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(menuKH.class.getName());
private JPanel currentPanel;

    public void addHoverTextEffect(JLabel label, Color normalColor, Color hoverColor) {
        label.setOpaque(true);
        label.setBackground(normalColor);

        label.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label.setBackground(hoverColor);
                repaint();
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label.setBackground(normalColor);
                repaint();
            }
        });
    }

    private void initLabelEvents() {
    
        lblThucDon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setView(new goimon());
            }
        });

        lblThongTinCaNhan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setView(new IN4());
            }
        });
        lblThoat.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });
        lblDangXuat.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new login().setVisible(true);
                
            }
        });

        lblDatBan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setView(new DatBanForm());
            }
        });
  }

    public void setView(JPanel panel) {
        jPanel5.removeAll();
        jPanel5.setLayout(new BorderLayout());
        jPanel5.add(panel);
        jPanel5.revalidate();
        jPanel5.repaint();

        currentPanel = panel;

    }
    int rong = 240;
    int dai = 850;

    /**
     * Creates new form Menu
     */
    public void hover() {
        Color normal = new Color(0, 0, 0, 0);
        Color hover = new Color(255, 255, 255, 180);
       
        addHoverTextEffect(lblThucDon, normal, hover);

        addHoverTextEffect(lblThongTinCaNhan, normal, hover);
        addHoverTextEffect(lblThoat, normal, hover);
        addHoverTextEffect(lblDangXuat, normal, hover);

        addHoverTextEffect(lblVoucher, normal, hover);

        addHoverTextEffect(lblDatBan, normal, hover);

    }

    public menuKH() {
        initComponents();
        openmenu();
        initLabelEvents(); // <-- Gọi ở đây
        hover();
        setLocationRelativeTo(null);
        

    }

    public void openmenu() {
//        if (currentPanel instanceof NhanVienPanel nv) {
//            nv.setButtonVisible(true);
//        } else if (currentPanel instanceof CaLamPanel cl) {
//            cl.setButtonVisible(true);
//        } else if (currentPanel instanceof TheDDPanel the) {
//            the.setButtonVisible(true);
//        } else if (currentPanel instanceof HoaDonPanel hd) {
//            hd.setButtonVisible(true);
//        } else if (currentPanel instanceof ChiTietPanel ct) {
//            ct.setButtonVisible(true);
//        } else if (currentPanel instanceof SanPhamPanel sp) {
//            sp.setButtonVisible(true);
//        } else if (currentPanel instanceof PhanLoai pl) {
//            pl.setButtonVisible(true);
//        }
//        
        new Thread(() -> {
            jPanel2.getParent().setComponentZOrder(jPanel2, 0);

            for (int i = 0; i < rong; i++) {
                jPanel2.setSize(i, dai);
                try {
                    Thread.sleep(2);
                } catch (InterruptedException ex) {
                    Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();

    }

    public void closemenu() {
//       // if (currentPanel instanceof NhanVienPanel nv) {
//            nv.setButtonVisible(false);
//        } else if (currentPanel instanceof CaLamPanel cl) {
//            cl.setButtonVisible(false);
//        } else if (currentPanel instanceof TheDDPanel the) {
//            the.setButtonVisible(false);
//        } else if (currentPanel instanceof HoaDonPanel hd) {
//            hd.setButtonVisible(false);
//        } else if (currentPanel instanceof ChiTietPanel ct) {
//            ct.setButtonVisible(false);
//        } else if (currentPanel instanceof SanPhamPanel sp) {
//            sp.setButtonVisible(false);
//        } else if (currentPanel instanceof PhanLoai pl) {
//            pl.setButtonVisible(false);
//        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = rong; i > 0; i--) {
                    jPanel2.setSize(i, dai);

                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        lblThucDon = new javax.swing.JLabel();
        lblVoucher = new javax.swing.JLabel();
        lblDangXuat = new javax.swing.JLabel();
        lblDatBan = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        lblThoat = new javax.swing.JLabel();
        lblThongTinCaNhan = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(227, 202, 165));

        jLabel46.setBackground(new java.awt.Color(255, 255, 255));
        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Menu");

        lblThucDon.setBackground(new java.awt.Color(255, 255, 255));
        lblThucDon.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblThucDon.setForeground(new java.awt.Color(255, 255, 255));
        lblThucDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThucDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon thực đơn.png"))); // NOI18N
        lblThucDon.setText("Thực đơn");

        lblVoucher.setBackground(new java.awt.Color(255, 255, 255));
        lblVoucher.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblVoucher.setForeground(new java.awt.Color(255, 255, 255));
        lblVoucher.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVoucher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon voucher.png"))); // NOI18N
        lblVoucher.setText("Voucher");

        lblDangXuat.setBackground(new java.awt.Color(255, 255, 255));
        lblDangXuat.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblDangXuat.setForeground(new java.awt.Color(255, 255, 255));
        lblDangXuat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDangXuat.setText("Đăng xuất");

        lblDatBan.setBackground(new java.awt.Color(255, 255, 255));
        lblDatBan.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblDatBan.setForeground(new java.awt.Color(255, 255, 255));
        lblDatBan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDatBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon bàn ăn.png"))); // NOI18N
        lblDatBan.setText("Đặt bàn");

        jLabel67.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("x");

        lblThoat.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblThoat.setForeground(new java.awt.Color(255, 255, 255));
        lblThoat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThoat.setText("Thoát");

        lblThongTinCaNhan.setBackground(new java.awt.Color(255, 255, 255));
        lblThongTinCaNhan.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblThongTinCaNhan.setForeground(new java.awt.Color(255, 255, 255));
        lblThongTinCaNhan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThongTinCaNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon thông tin cá nhân.png"))); // NOI18N
        lblThongTinCaNhan.setText("Thông tin cá nhân");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblThucDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel67)
                .addGap(16, 16, 16))
            .addComponent(lblThoat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(lblVoucher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDatBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(lblThongTinCaNhan, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel46)
                .addGap(18, 18, 18)
                .addComponent(lblThongTinCaNhan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(lblThucDon)
                .addGap(120, 120, 120)
                .addComponent(lblDatBan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblVoucher)
                .addGap(121, 121, 121)
                .addComponent(lblThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo.png"))); // NOI18N
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 90));

        jLabel15.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Nhà Hàng Basix");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ảnh đặt bàn.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 0, 100, -1));

        jLabel47.setBackground(new java.awt.Color(173, 139, 115));
        jLabel47.setOpaque(true);
        jPanel1.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1380, 90));

        jPanel5.setBackground(new java.awt.Color(255, 251, 233));
        jPanel5.setMinimumSize(new java.awt.Dimension(1316, 597));
        jPanel5.setPreferredSize(new java.awt.Dimension(1316, 597));
        jPanel5.setVerifyInputWhenFocusTarget(false);
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel13.setText("GỌI MÓN");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel24.setText("300");
        jPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, -1, 41));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel25.setText("000");
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, -1, 20));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel26.setText("VNĐ/món");
        jPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, -1, -1));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel27.setText("chỉ từ");
        jPanel5.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, -1, -1));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel28.setText("COMBO");
        jPanel5.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, -1, -1));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel29.setText("chỉ từ");
        jPanel5.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, 70, -1));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel30.setText("1000");
        jPanel5.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, -1, 42));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel31.setText("000");
        jPanel5.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, 43, 22));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel32.setText("chỉ từ");
        jPanel5.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 210, 70, -1));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel33.setText("700");
        jPanel5.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 260, -1, 42));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel34.setText("000");
        jPanel5.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 260, 43, 22));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel35.setText("PHÒNG VIP");
        jPanel5.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 200, -1, -1));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel36.setText("VNĐ/món");
        jPanel5.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, -1, 20));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel37.setText("VNĐ/phòng");
        jPanel5.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 280, -1, -1));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel38.setText("TRẺ EM");
        jPanel5.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 200, -1, -1));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel39.setText("Miễn phí");
        jPanel5.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 250, -1, -1));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel40.setText("<1m");
        jPanel5.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 280, -1, -1));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel41.setText("-50%");
        jPanel5.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 250, 60, 40));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel42.setText("<1m5");
        jPanel5.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 280, -1, -1));

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));
        jPanel6.setPreferredSize(new java.awt.Dimension(1, 100));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 210, 1, -1));

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 1, -1));

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 210, 1, -1));

        jLabel43.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        jLabel43.setText("Basix");
        jPanel5.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Nâng tầm vị giác");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1104, 30, 120, 20));

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/đường kẻ nâng tầm vị giác.png"))); // NOI18N
        jPanel5.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 0, 1190, 90));

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ảnh nâng tầm vị giác.png"))); // NOI18N
        jPanel5.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 0, 80, -1));

        jLabel1.setBackground(new java.awt.Color(208, 179, 143));
        jLabel1.setOpaque(true);
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1340, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1385, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new menuKH().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lblDangXuat;
    private javax.swing.JLabel lblDatBan;
    private javax.swing.JLabel lblThoat;
    private javax.swing.JLabel lblThongTinCaNhan;
    private javax.swing.JLabel lblThucDon;
    private javax.swing.JLabel lblVoucher;
    // End of variables declaration//GEN-END:variables
}
