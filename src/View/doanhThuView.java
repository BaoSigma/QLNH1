/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import DAO.impl.DoanhThuImpl;
import Model.ModelCard;
import Model.ModelChart;
import Model.doanhthu;
import RTDRestaurant.View.Swing.Chart.LineChart;
import java.awt.Color;
import java.lang.System.Logger;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author baoha
 */
public class doanhThuView extends javax.swing.JPanel {

    private DoanhThuImpl doanhThuDao;
   
   private DecimalFormat df = new DecimalFormat("##,###,###");


    public doanhThuView() {
        initComponents();
        doanhThuDao = new DoanhThuImpl();
        initCard("Tháng");
        initChart();
        df = new DecimalFormat("##,###,###");
    }
// Hàm load icon từ đường dẫn
    private ImageIcon loadIcon(String path) {
    java.net.URL location = getClass().getResource(path);
    if (location == null) {
        System.err.println("Không tìm thấy ảnh: " + path);
        return new ImageIcon(); // hoặc return null;
    }
    return new ImageIcon(location);
}


    public void initCard(String filter) {
        try {
            DoanhThuImpl doanhThuDao = new DoanhThuImpl();
            DecimalFormat df = new DecimalFormat("##,###,###");

            double total = 0;
            String title = "";
            String iconPath = "";

            if ("Tháng".equals(filter)) {
                List<doanhthu> list = doanhThuDao.getDoanhThuTheoThang();
                for (doanhthu d : list) {
                    total += d.getTongTien();
                }
                title = "Doanh Thu theo Tháng";
                iconPath = "/img/revenue.png";
                Thang.setData(new ModelCard(loadIcon(iconPath), title, df.format(total) + "đ", ". . ."));
            } else if ("Ngày".equals(filter)) {
                List<doanhthu> list = doanhThuDao.getDoanhThuHomNay();
                for (doanhthu d : list) {
                    total += d.getTongTien();
                }
                title = "Doanh Thu theo Ngày";
                iconPath = "/img/expenses.png";
                Ngay.setData(new ModelCard(loadIcon(iconPath), title, df.format(total) + "đ", ". . ."));
            } else if ("Nhân viên".equals(filter)) {
                List<doanhthu> list = doanhThuDao.getDoanhThuTheoNhanVien();
                for (doanhthu d : list) {
                    total += d.getTongTien();
                }
                title = "Doanh Thu theo Nhân Viên";
                iconPath = "/img/profit.png";
                NhanVien.setData(new ModelCard(loadIcon(iconPath), title, df.format(total) + "đ", ". . ."));
            } else if ("Khách hàng".equals(filter)) {
                List<doanhthu> list = doanhThuDao.getDoanhThuTheoKhachHang();
                for (doanhthu d : list) {
                    total += d.getTongTien();
                }
                title = "Doanh Thu theo Khách Hàng";
                iconPath = "/img/customer.png";
                KhachHang.setData(new ModelCard(loadIcon(iconPath), title, df.format(total) + "đ", ". . ."));
            } else {
                System.out.println("Không hợp lệ: " + filter);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

public void initChart() {
    DoanhThuImpl doanhThuDao = new DoanhThuImpl();

    // Add legend
    lineChart.addLegend("Doanh Thu theo Tháng", new Color(101, 78, 163), new Color(101, 78, 163));
    lineChart.addLegend("Doanh Thu theo Ngày", new Color(109, 222, 202), new Color(109, 222, 202));
    lineChart.addLegend("Doanh Thu theo Nhân Viên", new Color(35, 49, 64), new Color(35, 49, 64));
    lineChart.addLegend("Doanh Thu theo Khách Hàng", new Color(255, 235, 205), new Color(240, 220, 180));

    try {
        List<doanhthu> thangList = doanhThuDao.getDoanhThuTheoThang();
        List<doanhthu> ngayList = doanhThuDao.getDoanhThuHomNay();
        List<doanhthu> nhanVienList = doanhThuDao.getDoanhThuTheoNhanVien();
        List<doanhthu> khachHangList = doanhThuDao.getDoanhThuTheoKhachHang();

        DateTimeFormatter fmtThang = DateTimeFormatter.ofPattern("MM/yyyy");
        DateTimeFormatter fmtNgay = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (doanhthu d : thangList) {
            String thang = d.getTheoThang();
            if (thang == null || thang.isEmpty()) continue;

            double doanhThuThang = d.getTongTien();
            YearMonth ymThang;
            try {
                ymThang = YearMonth.parse(thang, fmtThang);
            } catch (Exception e) {
                continue; // Skip format lỗi
            }

            // 1. Doanh thu theo Ngày (gom các ngày nằm trong cùng tháng)
            double doanhThuNgay = 0;
            for (doanhthu ngay : ngayList) {
                String ngayStr = ngay.getTheoNgay();
                if (ngayStr != null && !ngayStr.isBlank()) {
                    try {
                        LocalDate date = LocalDate.parse(ngayStr, fmtNgay);
                        if (YearMonth.from(date).equals(ymThang)) {
                            doanhThuNgay += ngay.getTongTien();
                        }
                    } catch (DateTimeParseException e) {
                        // Format lỗi → bỏ qua
                    }
                }
            }

            // 2. Doanh thu theo Nhân Viên (cùng tháng)
            double doanhThuNV = 0;
            for (doanhthu nv : nhanVienList) {
                if (thang.equals(nv.getTheoThang())) {
                    doanhThuNV += nv.getTongTien();
                }
            }

            // 3. Doanh thu theo Khách Hàng (cùng tháng)
            double doanhThuKH = 0;
            for (doanhthu kh : khachHangList) {
                if (thang.equals(kh.getTheoThang())) {
                    doanhThuKH += kh.getTongTien();
                }
            }

            // 4. Add vào biểu đồ
            lineChart.addData(new ModelChart(
                thang,
                new double[]{doanhThuThang, doanhThuNgay, doanhThuNV, doanhThuKH}
            ));
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    lineChart.start();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lineChart = new RTDRestaurant.View.Swing.Chart.LineChart();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        NhanVien = new View.Card();
        Thang = new View.Card();
        Ngay = new View.Card();
        KhachHang = new View.Card();
        filter = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(173, 139, 115));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Doanh Thu");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 876, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/expenses.png"))); // NOI18N
        jLabel2.setText("THỐNG KÊ DOANH THU");

        Thang.setColor1(new java.awt.Color(227, 127, 20));
        Thang.setColor2(new java.awt.Color(240, 222, 132));

        Ngay.setColor1(new java.awt.Color(79, 172, 254));
        Ngay.setColor2(new java.awt.Color(0, 242, 254));

        KhachHang.setColor1(new java.awt.Color(36, 243, 68));

        jLayeredPane1.setLayer(NhanVien, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Thang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Ngay, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(KhachHang, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Thang, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Ngay, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jLayeredPane1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {KhachHang, Ngay, NhanVien, Thang});

        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Thang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {KhachHang, Ngay, NhanVien, Thang});

        filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tháng", "Ngày", "Nhân viên", "Khách hàng" }));
        filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lineChart, javax.swing.GroupLayout.PREFERRED_SIZE, 1418, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lineChart, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterActionPerformed
        // TODO add your handling code here:
        initCard(filter.getSelectedItem().toString());
    }//GEN-LAST:event_filterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.Card KhachHang;
    private View.Card Ngay;
    private View.Card NhanVien;
    private View.Card Thang;
    private javax.swing.JComboBox<String> filter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private RTDRestaurant.View.Swing.Chart.LineChart lineChart;
    // End of variables declaration//GEN-END:variables
}
