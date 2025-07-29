/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Util.UAuth;
import Util.UDialog;
import View.doanhthu;
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
     lblNhanVien.addMouseListener(new MouseAdapter() {
         @Override
           public void mouseClicked(MouseEvent e) {
            if(!UAuth.QuanLy()){
                   UDialog.alert("Bạn không phải Quản Lý!");
               }
               if(UAuth.QuanLy()){
                   
                   setView(new QLNV());
               }
           }
        });
        lblDoanhThu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setView(new doanhthu());
            }
        });
        lblBanAn.addMouseListener(new MouseAdapter() {
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
//        lblHoaDon.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                setView(new HoaDonPanel(false));
//        }
//        });
//
        lblCTDB.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setView(new CTDB()); 
            }
        });
        lblKhachHang.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setView(new QLKH()); 
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
        addHoverTextEffect(lblNhanVien, normal, hover);
        addHoverTextEffect(lblDoanhThu, normal, hover);
        addHoverTextEffect(lblBanAn, normal, hover);
        addHoverTextEffect(lblHoaDon, normal, hover);
        addHoverTextEffect(lblCTHD, normal, hover);
        addHoverTextEffect(lblMonAn, normal, hover);
        addHoverTextEffect(lblGoiMon, normal, hover);
        addHoverTextEffect(lblKhuVuc, normal, hover);
        addHoverTextEffect(lblKhachHang, normal, hover);
        addHoverTextEffect(lblDoanhThu, normal, hover);
        addHoverTextEffect(lblThongTinCaNhan, normal, hover);
        addHoverTextEffect(lblThoat, normal, hover);
        addHoverTextEffect(lblDangXuat, normal, hover);
        addHoverTextEffect(lblLoaiMon, normal, hover);
        addHoverTextEffect(lblVoucher, normal, hover);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        lblLoaiMon = new javax.swing.JLabel();
        lblMonAn = new javax.swing.JLabel();
        lblBanAn = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblThongTinCaNhan = new javax.swing.JLabel();
        lblKhachHang = new javax.swing.JLabel();
        lblKhuVuc = new javax.swing.JLabel();
        lblHoaDon = new javax.swing.JLabel();
        lblVoucher = new javax.swing.JLabel();
        lblDatBan = new javax.swing.JLabel();
        lblCTDB = new javax.swing.JLabel();
        lblCTHD = new javax.swing.JLabel();
        lblDangXuat = new javax.swing.JLabel();
        lblNhanVien = new javax.swing.JLabel();
        lblDoanhThu = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        lblGoiMon = new javax.swing.JLabel();
        lblThoat = new javax.swing.JLabel();
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

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo.png"))); // NOI18N
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
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

        jPanel2.setBackground(new java.awt.Color(227, 202, 165));

        jLabel44.setBackground(new java.awt.Color(255, 255, 255));
        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Menu");

        lblLoaiMon.setBackground(new java.awt.Color(255, 255, 255));
        lblLoaiMon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblLoaiMon.setForeground(new java.awt.Color(255, 255, 255));
        lblLoaiMon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLoaiMon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon loại món.png"))); // NOI18N
        lblLoaiMon.setText("Loại món");

        lblMonAn.setBackground(new java.awt.Color(255, 255, 255));
        lblMonAn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblMonAn.setForeground(new java.awt.Color(255, 255, 255));
        lblMonAn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMonAn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon món ăn.png"))); // NOI18N
        lblMonAn.setText("Món ăn");

        lblBanAn.setBackground(new java.awt.Color(255, 255, 255));
        lblBanAn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblBanAn.setForeground(new java.awt.Color(255, 255, 255));
        lblBanAn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBanAn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon bàn ăn.png"))); // NOI18N
        lblBanAn.setText("Bàn ăn");

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        lblThongTinCaNhan.setBackground(new java.awt.Color(255, 255, 255));
        lblThongTinCaNhan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblThongTinCaNhan.setForeground(new java.awt.Color(255, 255, 255));
        lblThongTinCaNhan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThongTinCaNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon thông tin cá nhân.png"))); // NOI18N
        lblThongTinCaNhan.setText("Thông tin cá nhân");

        lblKhachHang.setBackground(new java.awt.Color(255, 255, 255));
        lblKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        lblKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon khách hàng.png"))); // NOI18N
        lblKhachHang.setText("Khách hàng");

        lblKhuVuc.setBackground(new java.awt.Color(255, 255, 255));
        lblKhuVuc.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblKhuVuc.setForeground(new java.awt.Color(255, 255, 255));
        lblKhuVuc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKhuVuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon khu vực.png"))); // NOI18N
        lblKhuVuc.setText("Khu vực");

        lblHoaDon.setBackground(new java.awt.Color(255, 255, 255));
        lblHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        lblHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon hóa đơn.png"))); // NOI18N
        lblHoaDon.setText("Hóa đơn");

        lblVoucher.setBackground(new java.awt.Color(255, 255, 255));
        lblVoucher.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblVoucher.setForeground(new java.awt.Color(255, 255, 255));
        lblVoucher.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVoucher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon voucher.png"))); // NOI18N
        lblVoucher.setText("Voucher");

        lblDatBan.setBackground(new java.awt.Color(255, 255, 255));
        lblDatBan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDatBan.setForeground(new java.awt.Color(255, 255, 255));
        lblDatBan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDatBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon đặt bàn.png"))); // NOI18N
        lblDatBan.setText("Đặt bàn");

        lblCTDB.setBackground(new java.awt.Color(255, 255, 255));
        lblCTDB.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCTDB.setForeground(new java.awt.Color(255, 255, 255));
        lblCTDB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCTDB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon chi tiết đặt món.png"))); // NOI18N
        lblCTDB.setText("Chi tiết đặt bàn");

        lblCTHD.setBackground(new java.awt.Color(255, 255, 255));
        lblCTHD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCTHD.setForeground(new java.awt.Color(255, 255, 255));
        lblCTHD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCTHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon chi tiết hóa đơn.png"))); // NOI18N
        lblCTHD.setText("Chi tiết hóa đơn");

        lblDangXuat.setBackground(new java.awt.Color(255, 255, 255));
        lblDangXuat.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblDangXuat.setForeground(new java.awt.Color(255, 255, 255));
        lblDangXuat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDangXuat.setText("Đăng xuất");

        lblNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        lblNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        lblNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon nhân viên.png"))); // NOI18N
        lblNhanVien.setText("Nhân viên");

        lblDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDoanhThu.setForeground(new java.awt.Color(255, 255, 255));
        lblDoanhThu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDoanhThu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon hỗ trợ.png"))); // NOI18N
        lblDoanhThu.setText("Doanh Thu");

        jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("x");

        lblGoiMon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblGoiMon.setForeground(new java.awt.Color(255, 255, 255));
        lblGoiMon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGoiMon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon giảm giá theo mùa.png"))); // NOI18N
        lblGoiMon.setText("Gọi món");

        lblThoat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblThoat.setForeground(new java.awt.Color(255, 255, 255));
        lblThoat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThoat.setText("Thoát");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMonAn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblLoaiMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator2)
            .addComponent(lblThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblGoiMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblThongTinCaNhan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblDatBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblKhuVuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblVoucher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblCTHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblCTDB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblBanAn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel63))
                    .addComponent(lblNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblThongTinCaNhan)
                .addGap(18, 18, 18)
                .addComponent(lblMonAn)
                .addGap(18, 18, 18)
                .addComponent(lblLoaiMon)
                .addGap(18, 18, 18)
                .addComponent(lblHoaDon)
                .addGap(18, 18, 18)
                .addComponent(lblDatBan)
                .addGap(21, 21, 21)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(lblNhanVien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblKhachHang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCTDB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCTHD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblBanAn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblKhuVuc)
                .addGap(18, 18, 18)
                .addComponent(lblVoucher)
                .addGap(18, 18, 18)
                .addComponent(lblDoanhThu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblGoiMon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(lblThoat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDangXuat)
                .addGap(22, 22, 22))
        );

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1372, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        // TODO add your handling code here:
        openmenu();
    }//GEN-LAST:event_jLabel22MouseClicked

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
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblBanAn;
    private javax.swing.JLabel lblCTDB;
    private javax.swing.JLabel lblCTHD;
    private javax.swing.JLabel lblDangXuat;
    private javax.swing.JLabel lblDatBan;
    private javax.swing.JLabel lblDoanhThu;
    private javax.swing.JLabel lblGoiMon;
    private javax.swing.JLabel lblHoaDon;
    private javax.swing.JLabel lblKhachHang;
    private javax.swing.JLabel lblKhuVuc;
    private javax.swing.JLabel lblLoaiMon;
    private javax.swing.JLabel lblMonAn;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblThoat;
    private javax.swing.JLabel lblThongTinCaNhan;
    private javax.swing.JLabel lblVoucher;
    // End of variables declaration//GEN-END:variables
}
