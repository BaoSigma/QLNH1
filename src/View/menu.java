/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Util.UAuth;
import Util.UDialog;
import View.doanhThuView;
import View.goimon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author micro
 */
public class menu extends javax.swing.JFrame {

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
     lblThongTinCaNhan.addMouseListener(new MouseAdapter() {
         @Override
           public void mouseClicked(MouseEvent e) {

                   
                   setView(new IN4());
               
           }
        });

        lblKhuVuc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setView(new BanAnView());
            }
        });

        lblCTHD.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setView(new CTHD()); 
            }
        });
        lblGoiMon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setView(new goimon());
            }
        });
        lblLoaiMon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setView(new QLLM());
            }
        });
        lblHoaDon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setView(new HoaDonView());
        }
        });

        lblCTDB.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setView(new CTDB()); 
            }
        });

        lblMonAn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setView(new QLMA()); 
            }
        });

        lblKhuVuc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setView(new QLKV());
            }
        });
        lblLoaiMon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setView(new QLLM());
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
                setView(new DBFORM());
            }
        });

  }

    public void setView(JPanel panel) {
        jPanel11.removeAll();
        jPanel11.setLayout(new BorderLayout());
        jPanel11.add(panel);
        jPanel11.revalidate();
        jPanel11.repaint();

        currentPanel = panel;

    }
    int rong = 300;
    int dai = 800;

    /**
     * Creates new form Menu
     */
    public void hover() {
        Color normal = new Color(0, 0, 0, 0);
        Color hover = new Color(255, 255, 255, 180);
        addHoverTextEffect(lblKhuVuc, normal, hover);
        addHoverTextEffect(lblHoaDon, normal, hover);
        addHoverTextEffect(lblCTHD, normal, hover);
        addHoverTextEffect(lblMonAn, normal, hover);

        addHoverTextEffect(lblLoaiMon, normal, hover);
        addHoverTextEffect(lblThoat, normal, hover);
        addHoverTextEffect(lblDangXuat, normal, hover);
        addHoverTextEffect(lblThongTinCaNhan, normal, hover);
        addHoverTextEffect(lblCTDB, normal, hover);
        addHoverTextEffect(lblDatBan, normal, hover);

    }

    public menu() {
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
        jLabel44 = new javax.swing.JLabel();
        lblMonAn = new javax.swing.JLabel();
        lblLoaiMon = new javax.swing.JLabel();
        lblHoaDon = new javax.swing.JLabel();
        lblCTDB = new javax.swing.JLabel();
        lblCTHD = new javax.swing.JLabel();
        lblDangXuat = new javax.swing.JLabel();
        lblKhuVuc = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        lblThoat = new javax.swing.JLabel();
        lblGoiMon = new javax.swing.JLabel();
        lblThongTinCaNhan = new javax.swing.JLabel();
        lblBanAn1 = new javax.swing.JLabel();
        lblDatBan = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1423, 811));
        setPreferredSize(new java.awt.Dimension(1423, 811));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(227, 202, 165));

        jLabel44.setBackground(new java.awt.Color(255, 255, 255));
        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Menu");

        lblMonAn.setBackground(new java.awt.Color(255, 255, 255));
        lblMonAn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblMonAn.setForeground(new java.awt.Color(255, 255, 255));
        lblMonAn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMonAn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon món ăn.png"))); // NOI18N
        lblMonAn.setText("Món ăn");

        lblLoaiMon.setBackground(new java.awt.Color(255, 255, 255));
        lblLoaiMon.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblLoaiMon.setForeground(new java.awt.Color(255, 255, 255));
        lblLoaiMon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLoaiMon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon thông tin cá nhân.png"))); // NOI18N
        lblLoaiMon.setText("Loại món");

        lblHoaDon.setBackground(new java.awt.Color(255, 255, 255));
        lblHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        lblHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon hóa đơn.png"))); // NOI18N
        lblHoaDon.setText("Hóa đơn");
        lblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHoaDonMouseClicked(evt);
            }
        });

        lblCTDB.setBackground(new java.awt.Color(255, 255, 255));
        lblCTDB.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblCTDB.setForeground(new java.awt.Color(255, 255, 255));
        lblCTDB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCTDB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon chi tiết đặt món.png"))); // NOI18N
        lblCTDB.setText("Chi tiết đặt bàn");

        lblCTHD.setBackground(new java.awt.Color(255, 255, 255));
        lblCTHD.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblCTHD.setForeground(new java.awt.Color(255, 255, 255));
        lblCTHD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCTHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon chi tiết hóa đơn.png"))); // NOI18N
        lblCTHD.setText("Chi tiết hóa đơn");

        lblDangXuat.setBackground(new java.awt.Color(255, 255, 255));
        lblDangXuat.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblDangXuat.setForeground(new java.awt.Color(255, 255, 255));
        lblDangXuat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDangXuat.setText("Đăng xuất");

        lblKhuVuc.setBackground(new java.awt.Color(255, 255, 255));
        lblKhuVuc.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblKhuVuc.setForeground(new java.awt.Color(255, 255, 255));
        lblKhuVuc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKhuVuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon khu vực.png"))); // NOI18N
        lblKhuVuc.setText("Khu vực");

        jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("x");
        jLabel63.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel63MouseClicked(evt);
            }
        });

        lblThoat.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblThoat.setForeground(new java.awt.Color(255, 255, 255));
        lblThoat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon thoát.png"))); // NOI18N
        lblThoat.setText("Thoát");

        lblGoiMon.setBackground(new java.awt.Color(0, 0, 0));
        lblGoiMon.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblGoiMon.setForeground(new java.awt.Color(255, 255, 255));
        lblGoiMon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGoiMon.setText("Gọi món");

        lblThongTinCaNhan.setBackground(new java.awt.Color(255, 255, 255));
        lblThongTinCaNhan.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblThongTinCaNhan.setForeground(new java.awt.Color(255, 255, 255));
        lblThongTinCaNhan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThongTinCaNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon thông tin cá nhân.png"))); // NOI18N
        lblThongTinCaNhan.setText("Thông tin cá nhân");

        lblBanAn1.setBackground(new java.awt.Color(255, 255, 255));
        lblBanAn1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblBanAn1.setForeground(new java.awt.Color(255, 255, 255));
        lblBanAn1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBanAn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon bàn ăn.png"))); // NOI18N
        lblBanAn1.setText("Bàn ăn");

        lblDatBan.setBackground(new java.awt.Color(255, 255, 255));
        lblDatBan.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblDatBan.setForeground(new java.awt.Color(255, 255, 255));
        lblDatBan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDatBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon bàn ăn.png"))); // NOI18N
        lblDatBan.setText("Đặt bàn");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblMonAn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblLoaiMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel63)
                .addGap(16, 16, 16))
            .addComponent(lblKhuVuc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblCTHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblGoiMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblBanAn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblDatBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblThongTinCaNhan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCTDB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDangXuat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblKhuVuc)
                .addGap(21, 21, 21)
                .addComponent(lblBanAn1)
                .addGap(18, 18, 18)
                .addComponent(lblMonAn)
                .addGap(18, 18, 18)
                .addComponent(lblHoaDon)
                .addGap(18, 18, 18)
                .addComponent(lblDatBan)
                .addGap(18, 18, 18)
                .addComponent(lblCTHD)
                .addGap(18, 18, 18)
                .addComponent(lblGoiMon)
                .addGap(18, 18, 18)
                .addComponent(lblLoaiMon)
                .addGap(18, 18, 18)
                .addComponent(lblCTDB)
                .addGap(18, 18, 18)
                .addComponent(lblThongTinCaNhan)
                .addGap(70, 70, 70)
                .addComponent(lblThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDangXuat)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 0, 0, 810));

        jPanel11.setBackground(new java.awt.Color(255, 251, 233));
        jPanel11.setMinimumSize(new java.awt.Dimension(1316, 597));
        jPanel11.setPreferredSize(new java.awt.Dimension(1316, 597));
        jPanel11.setVerifyInputWhenFocusTarget(false);
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel17.setText("GỌI MÓN");
        jPanel11.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel69.setText("300");
        jPanel11.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, -1, 41));

        jLabel70.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel70.setText("000");
        jPanel11.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, -1, 20));

        jLabel71.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel71.setText("VNĐ/món");
        jPanel11.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, -1, -1));

        jLabel72.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel72.setText("chỉ từ");
        jPanel11.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, -1, -1));

        jLabel73.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel73.setText("COMBO");
        jPanel11.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, -1, -1));

        jLabel74.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel74.setText("chỉ từ");
        jPanel11.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, 70, -1));

        jLabel75.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel75.setText("1000");
        jPanel11.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, -1, 42));

        jLabel76.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel76.setText("000");
        jPanel11.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, 43, 22));

        jLabel77.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel77.setText("chỉ từ");
        jPanel11.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 210, 70, -1));

        jLabel78.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel78.setText("700");
        jPanel11.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 260, -1, 42));

        jLabel79.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel79.setText("000");
        jPanel11.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 260, 43, 22));

        jLabel80.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel80.setText("PHÒNG VIP");
        jPanel11.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 200, -1, -1));

        jLabel81.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel81.setText("VNĐ/món");
        jPanel11.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, -1, 20));

        jLabel82.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel82.setText("VNĐ/phòng");
        jPanel11.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 280, -1, -1));

        jLabel83.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel83.setText("TRẺ EM");
        jPanel11.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 200, -1, -1));

        jLabel84.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel84.setText("Miễn phí");
        jPanel11.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 250, -1, -1));

        jLabel85.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel85.setText("<1m");
        jPanel11.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 280, -1, -1));

        jLabel86.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel86.setText("-50%");
        jPanel11.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 250, 60, 40));

        jLabel87.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel87.setText("<1m5");
        jPanel11.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 280, -1, -1));

        jPanel12.setBackground(new java.awt.Color(0, 0, 0));
        jPanel12.setPreferredSize(new java.awt.Dimension(1, 100));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 210, 1, -1));

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

        jPanel11.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 1, -1));

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

        jPanel11.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 210, 1, -1));

        jLabel43.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        jLabel43.setText("Basix");
        jPanel11.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Nâng tầm vị giác");
        jPanel11.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 30, 120, 20));

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/đường kẻ nâng tầm vị giác.png"))); // NOI18N
        jPanel11.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 1190, 90));

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ảnh nâng tầm vị giác.png"))); // NOI18N
        jPanel11.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 0, 80, -1));

        jLabel1.setBackground(new java.awt.Color(208, 179, 143));
        jLabel1.setOpaque(true);
        jPanel11.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1420, 90));

        getContentPane().add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1420, 700));

        jPanel1.setBackground(new java.awt.Color(173, 139, 115));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo.png"))); // NOI18N
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 90));

        jLabel15.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Nhà Hàng Basix");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ảnh đặt bàn.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 20, 100, -1));

        jLabel47.setBackground(new java.awt.Color(173, 139, 115));
        jLabel47.setOpaque(true);
        jPanel1.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1380, 90));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, -4, 1430, 120));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        // TODO add your handling code here:
        openmenu();
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel63MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel63MouseClicked
        // TODO add your handling code here:
        closemenu();
    }//GEN-LAST:event_jLabel63MouseClicked

    private void lblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoaDonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblHoaDonMouseClicked

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
            
        }
        //</editor-fold>

        /* Create and display the form */
        try {
                    UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatLightLaf());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (UAuth.user == null) {
                    UDialog.alert("Bạn cần phải đăng nhập");
                    new login().setVisible(true);
                    return;
                } else {
                    new menu().setVisible(true);
                }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lblBanAn1;
    private javax.swing.JLabel lblCTDB;
    private javax.swing.JLabel lblCTHD;
    private javax.swing.JLabel lblDangXuat;
    private javax.swing.JLabel lblDatBan;
    private javax.swing.JLabel lblGoiMon;
    private javax.swing.JLabel lblHoaDon;
    private javax.swing.JLabel lblKhuVuc;
    private javax.swing.JLabel lblLoaiMon;
    private javax.swing.JLabel lblMonAn;
    private javax.swing.JLabel lblThoat;
    private javax.swing.JLabel lblThongTinCaNhan;
    // End of variables declaration//GEN-END:variables
}
