/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import DAO.ModelDAO.DatBanDAO;
import DAO.impl.DatBanimpl;
import DAO.impl.OrderImpl;
import Model.BanAn;
import Model.DatBan;
import Model.DatBanINFOR;
import Model.HoaDon;

import Model.MonAn;
import Util.UAuth;
import Util.UDialog;
import Util.UJdbc;
import com.github.lgooddatepicker.zinternaltools.WrapLayout;
import java.awt.Component;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.Date;
import java.sql.Time;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author baoha
 */
public class DBFORM extends javax.swing.JPanel {
    private static DatBanimpl dao = new DatBanimpl();
    
    private DatBan db;
    private List<BanAn> list;
    OrderImpl daor = new OrderImpl();
    List<MonAn> MonAn = new ArrayList<>();
    List<BanAn> items = new ArrayList<>();
    private BanAn b;
    private final Map<String, Double> donGiaTheoMon = new HashMap<>();
    public DBFORM(boolean visible) {
        initComponents();

        db = new DatBan();

        // Cấu hình giao diện
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        panel.setLayout(new WrapLayout(WrapLayout.LEADING, 20, 20));

        // Load bàn lên giao diện
        loadTang1();
       chinhsuatrencot();
    setButtonVisible(visible);
    }
    public void setButtonVisible(boolean visible) {
    jButton1.setVisible(visible);
} 
    public void init(){
        String tang = cboTang.getSelectedItem().toString();
        panel.removeAll();
    if(tang.equals("Tầng 1")){
            loadTang1();
    }
    if(tang.equals("Tầng 2")){
            loadTang2();
    }   
    panel.revalidate();
    panel.repaint();
    }
          public void chinhsuatrencot(){
// Dừng chỉnh sửa khi người dùng rời ô nhập
tblGoimon.putClientProperty("terminateEditOnFocusLost", true);

// Lắng nghe sự kiện sửa bảng
tblGoimon.getModel().addTableModelListener(new TableModelListener() {
    @Override
    public void tableChanged(TableModelEvent e) {
        if (e.getType() == TableModelEvent.UPDATE) {
            int row = e.getFirstRow();
            int column = e.getColumn();

            if (column == 2) { // Cột số lượng
                DefaultTableModel model = (DefaultTableModel) tblGoimon.getModel();
                try {
                    int soLuong = Integer.parseInt(model.getValueAt(row, 2).toString());
                    double tongTienCu = Double.parseDouble(model.getValueAt(row, 3).toString());
                    double donGia = tongTienCu / (soLuong == 0 ? 1 : soLuong); // Tính đơn giá tạm
                    double thanhTien = soLuong * donGia;
                    model.setValueAt(thanhTien, row, 3);
                } catch (Exception ex) {
                    System.err.println("Lỗi cập nhật thành tiền tại dòng " + row + ": " + ex.getMessage());
                }
            }

            capNhatTongTien(); // Luôn cập nhật tổng tiền
        }
    }
});

    }

private void updateThanhTien(int row) {
    DefaultTableModel model = (DefaultTableModel) tblGoimon.getModel();
    try {
        String soLuongStr = model.getValueAt(row, 2).toString();
        if (soLuongStr.isEmpty()) return;

        int soLuong = Integer.parseInt(soLuongStr);

        // Lấy đơn giá từ thành tiền cũ hoặc từ DB
        double thanhTienCu = Double.parseDouble(model.getValueAt(row, 3).toString());
        double donGia = thanhTienCu / (soLuong == 0 ? 1 : soLuong);

        double thanhTienMoi = soLuong * donGia;
        model.setValueAt(thanhTienMoi, row, 3);

        capNhatTongTien();
    } catch (Exception ex) {
        // Nếu người dùng đang nhập chữ thì bỏ qua
    }
}

public void loadTang1() {
    String tang = "KV01";
    try {
        list = dao.DatBanCoTang(tang);
        for (BanAn ba : list) {
            panel.add(new carddatban(ba, this));  // Truyền 'this' (DBFORM hiện tại)
        }
    } catch (SQLException E) {
        E.printStackTrace();
    }
}

public void loadTang2() {
    String tang = "KV02";
    try {
        list = dao.DatBanCoTang(tang);
        for (BanAn ba : list) {
            panel.add(new carddatban(ba, this));  // Truyền 'this' (DBFORM hiện tại)
        }
    } catch (SQLException E) {
        E.printStackTrace();
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cboTang = new javax.swing.JComboBox<>();
        jtabSP = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDoUong = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblMonLau = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblMonNuong = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblMonNhe = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        cboBanAn = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        cboPTTT = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTimkiem = new javax.swing.JTextField();
        btnXacNhan = new javax.swing.JButton();
        btnHuyBo1 = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblGoimon = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setContentAreaFilled(false);
        jButton1.setEnabled(false);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, 350, 1420, 390));

        panel.setPreferredSize(new java.awt.Dimension(325, 938));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 938, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panel);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 145, -1, 930));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel2.setText("Số tầng: ");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        cboTang.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        cboTang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tầng 1", "Tầng 2" }));
        cboTang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTangActionPerformed(evt);
            }
        });
        add(cboTang, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));

        tblDoUong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã món", "Tên", "Giá", "Ảnh"
            }
        ));
        tblDoUong.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblDoUongAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tblDoUong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDoUongMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDoUong);

        jtabSP.addTab("Đồ uống", jScrollPane2);

        tblMonLau.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tên loại", "Tên", "Giá", "Ảnh"
            }
        ));
        tblMonLau.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblMonLauAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tblMonLau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMonLauMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblMonLau);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1090, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 885, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE))
        );

        jtabSP.addTab("Món lẩu", jPanel2);

        tblMonNuong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tên loại", "Tên", "Giá", "Ảnh"
            }
        ));
        tblMonNuong.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblMonNuongAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tblMonNuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMonNuongMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblMonNuong);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 885, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE))
        );

        jtabSP.addTab("Món nướng", jPanel3);

        tblMonNhe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tên loại", "Tên", "Giá", "Ảnh"
            }
        ));
        tblMonNhe.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblMonNheAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tblMonNhe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMonNheMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblMonNhe);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1090, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 885, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE))
        );

        jtabSP.addTab("Món nhẹ", jPanel4);

        add(jtabSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 1090, 920));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Bàn ăn:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 90, 120, 34));

        cboBanAn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboBanAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboBanAnMouseClicked(evt);
            }
        });
        cboBanAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboBanAnActionPerformed(evt);
            }
        });
        add(cboBanAn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 130, 234, 31));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("THÀNH TIỀN:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 750, 135, 54));

        lblTongTien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTongTien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongTien.setText("0.0");
        add(lblTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(1780, 750, 110, 54));

        cboPTTT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cboPTTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền mặt", "chuyển khoản", "khác" }));
        cboPTTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPTTTActionPerformed(evt);
            }
        });
        add(cboPTTT, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 680, 310, 70));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Phương thức thanh toán:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 640, 310, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel3.setText("Tìm kiếm:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, -1, -1));
        add(txtTimkiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 100, 294, 30));

        btnXacNhan.setBackground(new java.awt.Color(173, 139, 115));
        btnXacNhan.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnXacNhan.setForeground(new java.awt.Color(255, 255, 255));
        btnXacNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon xác nhận.png"))); // NOI18N
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });
        add(btnXacNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 100, 130, 38));

        btnHuyBo1.setBackground(new java.awt.Color(173, 139, 115));
        btnHuyBo1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnHuyBo1.setForeground(new java.awt.Color(255, 255, 255));
        btnHuyBo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon hủy bỏ.png"))); // NOI18N
        btnHuyBo1.setText("Hủy bỏ");
        btnHuyBo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyBo1ActionPerformed(evt);
            }
        });
        add(btnHuyBo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 810, 153, 61));

        btnDel.setBackground(new java.awt.Color(173, 139, 115));
        btnDel.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnDel.setForeground(new java.awt.Color(255, 255, 255));
        btnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon xóabỏ.png"))); // NOI18N
        btnDel.setText("Xóa bỏ");
        btnDel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });
        add(btnDel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1760, 810, 156, 61));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setContentAreaFilled(false);
        jButton2.setEnabled(false);
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1670, 1080));

        jPanel5.setBackground(new java.awt.Color(173, 139, 115));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Đặt Bàn");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 1709, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, -1));

        tblGoimon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã món", "Tên sản phẩm", "Số lượng", "Tổng tiền"
            }
        ));
        tblGoimon.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblGoimonAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                tblGoimonAncestorMoved(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tblGoimon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGoimonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblGoimonMouseEntered(evt);
            }
        });
        jScrollPane4.setViewportView(tblGoimon);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 180, 470, 450));
    }// </editor-fold>//GEN-END:initComponents

    private void cboTangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTangActionPerformed
        // TODO add your handling code here:
        init();
    }//GEN-LAST:event_cboTangActionPerformed

    private void tblDoUongAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblDoUongAncestorAdded
        // TODO add your handling code here:
        filltoTableDoUong();

    }//GEN-LAST:event_tblDoUongAncestorAdded

    private void tblDoUongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDoUongMouseClicked
        // TODO add your handling code here:
        int row = tblDoUong.getSelectionModel().getLeadSelectionIndex(); // luôn chính xác dòng đang click
        if (row != -1) {
            Object oMaMon = tblDoUong.getValueAt(row, 0);
            Object oTenMon = tblDoUong.getValueAt(row, 1);
            Object oGia = tblDoUong.getValueAt(row, 2);

            if (oTenMon != null && oGia != null) {
                String MaMon = oMaMon.toString();
                String tenMon = oTenMon.toString();
                double gia = (oGia instanceof Number) ? ((Number) oGia).doubleValue() : Double.parseDouble(oGia.toString());

                filltoTableGoiMon(MaMon, tenMon, gia); // dùng TenMon làm mã tạm
            } else {
                UDialog.alert( "Một trong các cột bị null!");
            }

        }

    }//GEN-LAST:event_tblDoUongMouseClicked

    private void tblMonLauAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblMonLauAncestorAdded
        // TODO add your handling code here:
        filltoTableMonLau();
    }//GEN-LAST:event_tblMonLauAncestorAdded

    private void tblMonLauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMonLauMouseClicked
        // TODO add your handling code here:
        int row = tblMonLau.getSelectionModel().getLeadSelectionIndex(); // luôn chính xác dòng đang click

        if (row != -1) {
            Object oMaMon = tblMonLau.getValueAt(row, 0);
            Object oTenMon = tblMonLau.getValueAt(row, 1);
            Object oGia = tblMonLau.getValueAt(row, 2);

            if (oTenMon != null && oGia != null) {
                String MaMon = oMaMon.toString();
                String tenMon = oTenMon.toString();
                double gia = (oGia instanceof Number) ? ((Number) oGia).doubleValue() : Double.parseDouble(oGia.toString());

                filltoTableGoiMon(MaMon, tenMon, gia); // dùng TenMon làm mã tạm
            } else {
                UDialog.alert( "Một trong các cột bị null!");
            }
        }
    }//GEN-LAST:event_tblMonLauMouseClicked

    private void tblMonNuongAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblMonNuongAncestorAdded
        // TODO add your handling code here:
        filltoTableMonNuong();
    }//GEN-LAST:event_tblMonNuongAncestorAdded

    private void tblMonNuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMonNuongMouseClicked
        // TODO add your handling code here:
        int row = tblMonNuong.getSelectionModel().getLeadSelectionIndex(); // luôn chính xác dòng đang click

        if (row != -1) {
            Object oMaMon = tblMonNuong.getValueAt(row, 0);
            Object oTenMon = tblMonNuong.getValueAt(row, 1);
            Object oGia = tblMonNuong.getValueAt(row, 2);

            if (oTenMon != null && oGia != null) {
                String MaMon = oMaMon.toString();
                String tenMon = oTenMon.toString();
                double gia = (oGia instanceof Number) ? ((Number) oGia).doubleValue() : Double.parseDouble(oGia.toString());

                filltoTableGoiMon(tenMon, tenMon, gia); // dùng TenMon làm mã tạm
            } else {
                UDialog.alert( "Một trong các cột bị null!");
            }
        }
    }//GEN-LAST:event_tblMonNuongMouseClicked

    private void tblMonNheAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblMonNheAncestorAdded
        // TODO add your handling code here:
        filltoTableMonnhe();
    }//GEN-LAST:event_tblMonNheAncestorAdded

    private void tblMonNheMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMonNheMouseClicked
        // TODO add your handling code here:
        int row = tblMonNhe.getSelectionModel().getLeadSelectionIndex(); // luôn chính xác dòng đang click

        if (row != -1) {
            Object oMaMon = tblMonNuong.getValueAt(row, 0);
            Object oTenMon = tblMonNhe.getValueAt(row, 1);
            Object oGia = tblMonNhe.getValueAt(row, 2);
            if (oTenMon != null && oGia != null) {
                String MaMon = oMaMon.toString();
                String tenMon = oTenMon.toString();
                double gia = (oGia instanceof Number) ? ((Number) oGia).doubleValue() : Double.parseDouble(oGia.toString());

                filltoTableGoiMon(tenMon, tenMon, gia); // dùng TenMon làm mã tạm
            } else {
                UDialog.alert( "Một trong các cột bị null!");
            }

        }
    }//GEN-LAST:event_tblMonNheMouseClicked

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        // TODO add your handling code here:
        timkiem();
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void cboBanAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboBanAnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboBanAnActionPerformed

    private void cboBanAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboBanAnMouseClicked
        // TODO add your handling code here:
        filltoCombo();
    }//GEN-LAST:event_cboBanAnMouseClicked

    private void btnXacNhan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhan1ActionPerformed


    }//GEN-LAST:event_btnXacNhan1ActionPerformed

    private void btnHuyBo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyBo1ActionPerformed
        // TODO add your handling code here:
        HuyBo();
    }//GEN-LAST:event_btnHuyBo1ActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        // TODO add your handling code here:
        Xoa();
    }//GEN-LAST:event_btnDelActionPerformed

    private void cboPTTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPTTTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboPTTTActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblGoimonAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblGoimonAncestorAdded
        // TODO add your handling code here:

    }//GEN-LAST:event_tblGoimonAncestorAdded

    private void tblGoimonAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblGoimonAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_tblGoimonAncestorMoved

    private void tblGoimonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGoimonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblGoimonMouseClicked

    private void tblGoimonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGoimonMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_tblGoimonMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnHuyBo1;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JComboBox<String> cboBanAn;
    private javax.swing.JComboBox<String> cboPTTT;
    private javax.swing.JComboBox<String> cboTang;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jtabSP;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JPanel panel;
    private javax.swing.JTable tblDoUong;
    private javax.swing.JTable tblGoimon;
    private javax.swing.JTable tblMonLau;
    private javax.swing.JTable tblMonNhe;
    private javax.swing.JTable tblMonNuong;
    private javax.swing.JTextField txtTimkiem;
    // End of variables declaration//GEN-END:variables
     
    public void Xoa(){
        int selectedRow = tblGoimon.getSelectedRow();
if (selectedRow != -1) {
    DefaultTableModel model = (DefaultTableModel) tblGoimon.getModel();
    int soLuong = Integer.parseInt(model.getValueAt(selectedRow, 2).toString());
    if (soLuong > 1) {
        soLuong -= 1;
        model.setValueAt(soLuong, selectedRow, 2);
        double donGia = Double.parseDouble(model.getValueAt(selectedRow, 3).toString()) / (soLuong + 1);
        double thanhTienMoi = soLuong * donGia;
        model.setValueAt(thanhTienMoi, selectedRow, 3);
    } else {
        model.removeRow(selectedRow);
    }
    capNhatTongTien();
} else {
    UDialog.alert("Vui lòng chọn món cần xóa!");
}
    }
public void capNhatTongTien() {
    DefaultTableModel model = (DefaultTableModel) tblGoimon.getModel();
    double tong = 0;
    for (int i = 0; i < model.getRowCount(); i++) {
        Object val = model.getValueAt(i, 3); 
        if (val != null) {
            try {
                tong += Double.parseDouble(val.toString()); 
            } catch (NumberFormatException e) {}
        }
    }
    lblTongTien.setText(String.format("%.1f", tong));
}


    public List<DatBanINFOR> XacNhan(String maKH, String maBan, Date ngayDat, LocalTime gioDat, int soNguoi, String maNV) {
        HoaDon entity = new HoaDon();
    OrderImpl dao = new OrderImpl();
    entity.setTenKH(maKH);
            entity.setMaNV(UAuth.user.getMaNV());
            
    List<DatBanINFOR> ds = new ArrayList<>();
    String HTTT = cboPTTT.getSelectedItem().toString();
    String ghiChu = "";
    entity.setHinhThucTT(HTTT);
    entity.setMaBan(maBan);
    entity = dao.create(entity);
    DefaultTableModel model = (DefaultTableModel) tblGoimon.getModel();

        // Duyệt qua từng dòng trong bảng gọi món để thêm chi tiết hóa đơn
        for (int i = 0; i < model.getRowCount(); i++) {
            String maSP = model.getValueAt(i, 0).toString();
            int soLuong = Integer.parseInt(model.getValueAt(i, 2).toString());
            String ghi = "";
            String trangThai = "Đã đặt";
            dao.insertChiTietHoaDon(entity.getMaHD(), maSP, soLuong, ghi, trangThai);
        }
        BanAn ba = new BanAn();
        ba.setMaBan(maBan);
        ba.setTrangThai("Đã đặt");
        dao.capnhattrangthai(ba);
    for (int i = 0; i < tblGoimon.getRowCount(); i++) {
        Object maMonObj = tblGoimon.getValueAt(i, 0);
        Object slObj = tblGoimon.getValueAt(i, 2);

        if (maMonObj == null || slObj == null) continue;

        String maMon = maMonObj.toString().trim();
        String slText = slObj.toString().trim();

        if (maMon.isEmpty() || slText.isEmpty()) continue;

        try {
            int soLuong = Integer.parseInt(slText);
            ds.add(new DatBanINFOR(maKH, maBan, ngayDat, gioDat, soNguoi, maNV, HTTT, maMon, soLuong, ghiChu));
        } catch (NumberFormatException ex) {
            System.err.println("⚠ Số lượng không hợp lệ tại dòng " + i + ": " + slText);
        }
    }
    return ds;
}
    public void filltoTableDoUong() {
DefaultTableModel model = (DefaultTableModel) tblDoUong.getModel();
        model.setRowCount(0);
        tblDoUong.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {{ setHorizontalAlignment(CENTER); }});

        tblDoUong.setRowHeight(160);
        TableColumnModel columnModel = tblDoUong.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100); 
        columnModel.getColumn(1).setPreferredWidth(200); 
        columnModel.getColumn(2).setPreferredWidth(100); 
        columnModel.getColumn(3).setPreferredWidth(200);
        MonAn = daor.DoUong();
        MonAn.forEach(item -> {
             String imagePath = "src/main/resources/img" + item.getHinhAnh();
              ImageIcon icon = new ImageIcon(imagePath);
                Image scaledImage = icon.getImage().getScaledInstance(194, 149, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledImage);
            Object[] rowData = {
                item.getMaMon(),
                item.getTenMon(),
                item.getDonGia(),
                scaledIcon,
                false
            };
            model.addRow(rowData);
        });
        tblDoUong.getColumnModel().getColumn(3).setCellRenderer(new DefaultTableCellRenderer() {

            
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        if(value instanceof ImageIcon) {
            JLabel lbl = new JLabel();
            lbl.setIcon((ImageIcon) value);
            lbl.setHorizontalAlignment(JLabel.CENTER);
            return lbl;
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
});   
        
    }

 
    public void filltoTableMonLau() {
    DefaultTableModel model = (DefaultTableModel) tblMonLau.getModel();
            model.setRowCount(0);
            tblMonLau.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {{ setHorizontalAlignment(CENTER); }});

            tblMonLau.setRowHeight(160);
            TableColumnModel columnModel = tblMonLau.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(100); 
            columnModel.getColumn(1).setPreferredWidth(200); 
            columnModel.getColumn(2).setPreferredWidth(100); 
            columnModel.getColumn(3).setPreferredWidth(200);
            MonAn = daor.MonLau();
            MonAn.forEach(item -> {
                 String imagePath = "src/main/resources/img" + item.getHinhAnh();
                  ImageIcon icon = new ImageIcon(imagePath);
                    Image scaledImage = icon.getImage().getScaledInstance(194, 149, Image.SCALE_SMOOTH);
                    ImageIcon scaledIcon = new ImageIcon(scaledImage);
                Object[] rowData = {
                    item.getMaMon(),
                item.getTenMon(),
                item.getDonGia(),
                    scaledIcon,
                    false
                };
                model.addRow(rowData);
            });
            tblMonLau.getColumnModel().getColumn(3).setCellRenderer(new DefaultTableCellRenderer() {
    
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            if(value instanceof ImageIcon) {
                JLabel lbl = new JLabel();
                lbl.setIcon((ImageIcon) value);
                lbl.setHorizontalAlignment(JLabel.CENTER);
                return lbl;
            }
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    });       }


    public void filltoTableMonNuong() {
    DefaultTableModel model = (DefaultTableModel) tblMonNuong.getModel();
                model.setRowCount(0);
                tblMonNuong.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {{ setHorizontalAlignment(CENTER); }});

                tblMonNuong.setRowHeight(160);
                TableColumnModel columnModel = tblMonNuong.getColumnModel();
                columnModel.getColumn(0).setPreferredWidth(100); 
                columnModel.getColumn(1).setPreferredWidth(200); 
                columnModel.getColumn(2).setPreferredWidth(100); 
                columnModel.getColumn(3).setPreferredWidth(200);
                MonAn = daor.MonNuong();
                MonAn.forEach(item -> {
                     String imagePath = "src/main/resources/img" + item.getHinhAnh();
                      ImageIcon icon = new ImageIcon(imagePath);
                        Image scaledImage = icon.getImage().getScaledInstance(194, 149, Image.SCALE_SMOOTH);
                        ImageIcon scaledIcon = new ImageIcon(scaledImage);
                    Object[] rowData = {
                        item.getMaMon(),
                item.getTenMon(),
                item.getDonGia(),
                        scaledIcon,
                        false
                    };
                    model.addRow(rowData);
                });
                tblMonNuong.getColumnModel().getColumn(3).setCellRenderer(new DefaultTableCellRenderer() {

            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                if(value instanceof ImageIcon) {
                    JLabel lbl = new JLabel();
                    lbl.setIcon((ImageIcon) value);
                    lbl.setHorizontalAlignment(JLabel.CENTER);
                    return lbl;
                }
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        }); 
    }


    public void filltoTableMonnhe() {
        DefaultTableModel model = (DefaultTableModel) tblMonNhe.getModel();
                model.setRowCount(0);
                tblMonNhe.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {{ setHorizontalAlignment(CENTER); }});

                tblMonNhe.setRowHeight(160);
                TableColumnModel columnModel = tblMonNhe.getColumnModel();
                columnModel.getColumn(0).setPreferredWidth(100); 
                columnModel.getColumn(1).setPreferredWidth(200); 
                columnModel.getColumn(2).setPreferredWidth(100); 
                columnModel.getColumn(3).setPreferredWidth(200);
                MonAn = daor.MoNhe();
                MonAn.forEach(item -> {
                     String imagePath = "src/main/resources/img" + item.getHinhAnh();
                      ImageIcon icon = new ImageIcon(imagePath);
                        Image scaledImage = icon.getImage().getScaledInstance(194, 149, Image.SCALE_SMOOTH);
                        ImageIcon scaledIcon = new ImageIcon(scaledImage);
                    Object[] rowData = {
                        item.getMaMon(),
                item.getTenMon(),
                item.getDonGia(),
                        scaledIcon,
                        false
                    };
                    model.addRow(rowData);
                });
                tblMonNhe.getColumnModel().getColumn(3).setCellRenderer(new DefaultTableCellRenderer() {

            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                if(value instanceof ImageIcon) {
                    JLabel lbl = new JLabel();
                    lbl.setIcon((ImageIcon) value);
                    lbl.setHorizontalAlignment(JLabel.CENTER);
                    return lbl;
                }
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        }); 
    }




    public void timkiem() {
        try {
            
            String keyword = txtTimkiem.getText().trim();
            if (jtabSP.getTitleAt(jtabSP.getSelectedIndex()).equals("Đồ uống")) {
                List<MonAn> list = daor.timkiemdouong(keyword);

            DefaultTableModel model = (DefaultTableModel) tblDoUong.getModel();
            model.setRowCount(0);
            if(keyword.equals("")){
                filltoTableDoUong();
            }
            if (list.isEmpty()) {
                UDialog.alert("Không tìm thấy đồ uống.");
                return;
            }

            for (MonAn item : list) {
                Object[] row = {
                    item.getMaMon(),
                item.getTenMon(),
                item.getDonGia(),
                    false
                };
                model.addRow(row);
            }
            }
            if (jtabSP.getTitleAt(jtabSP.getSelectedIndex()).equals("Món lẩu")) {
                List<MonAn> list = daor.timkiemdouong(keyword);

            DefaultTableModel model = (DefaultTableModel) tblMonLau.getModel();
            model.setRowCount(0);
            if(keyword.equals("")){
                filltoTableMonLau();
            }
            if (list.isEmpty()) {
                UDialog.alert("Không tìm thấy món ăn.");
                return;
            }

            for (MonAn item : list) {
                Object[] row = {
                    item.getMaMon(),
                item.getTenMon(),
                item.getDonGia(),
                    false
                };
                model.addRow(row);
            }
            }
            if (jtabSP.getTitleAt(jtabSP.getSelectedIndex()).equals("Món nướng")) {
                List<MonAn> list = daor.timkiemdouong(keyword);

            DefaultTableModel model = (DefaultTableModel) tblMonNuong.getModel();
            model.setRowCount(0);
            if(keyword.equals("")){
                filltoTableMonNuong();
            }
            if (list.isEmpty()) {
                UDialog.alert("Không tìm thấy món ăn.");
                return;
            }

            for (MonAn item : list) {
                Object[] row = {
                    item.getTenMon(),
                    item.getTenLoai(),
                    item.getDonGia(),
                    false
                };
                model.addRow(row);
            }
            }
            if (jtabSP.getTitleAt(jtabSP.getSelectedIndex()).equals("Món nhẹ")) {
                List<MonAn> list = daor.timkiemdouong(keyword);

            DefaultTableModel model = (DefaultTableModel) tblMonNhe.getModel();
            model.setRowCount(0);
            if(keyword.equals("")){
                filltoTableMonnhe();
            }
            if (list.isEmpty()) {
                UDialog.alert("Không tìm thấy món ăn.");
                return;
            }

            for (MonAn item : list) {
                Object[] row = {
                    item.getTenMon(),
                    item.getTenLoai(),
                    item.getDonGia(),
                    false
                };
                model.addRow(row);
            }
            }
            
        } catch (Exception e) {}
    }



  




    public void HuyBo() {
        DefaultTableModel model = (DefaultTableModel) tblGoimon.getModel();
        model.setRowCount(0);
    }




public void filltoTableGoiMon(String MaMon, String TenMon, double Gia) {
    DefaultTableModel model = (DefaultTableModel) tblGoimon.getModel();
    boolean found = false;

    for (int i = 0; i < model.getRowCount(); i++) {
        String existingMaMon = model.getValueAt(i, 0).toString();
        if (existingMaMon.equals(MaMon)) { // Ưu tiên so sánh theo MaMon
            int soLuong = Integer.parseInt(model.getValueAt(i, 2).toString());
            soLuong++;
            model.setValueAt(soLuong, i, 2);
            model.setValueAt(Gia * soLuong, i, 3);
            found = true;
            break;
        }
    }

    if (!found) {
        Object[] rowData = { MaMon, TenMon, 1, Gia };
        model.addRow(rowData);
    }

    tinhTongTien();
}




public double tinhTongTien() {
    DefaultTableModel model = (DefaultTableModel) tblGoimon.getModel();
    double tong = 0;

    for (int i = 0; i < model.getRowCount(); i++) {
        Object val = model.getValueAt(i, 3); // Thành tiền

        try {
            double tien = Double.parseDouble(val.toString().replace(",", "").trim());
            tong += tien;
        } catch (Exception e) {
            System.err.println("Lỗi tại dòng " + i + ": " + val);
        }
    }

    lblTongTien.setText(String.format("%,.0f", tong));
    return tong;
}


    public void filltoCombo(){
    cboBanAn.removeAllItems();
    items = daor.CBOBan(); 
    items.forEach(item -> {
        String display = item.getMaBan()+ " - " + item.getSoBan();
        cboBanAn.addItem(display);
    });
    }
}
