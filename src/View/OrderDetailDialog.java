/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.HoaDon;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.text.SimpleDateFormat;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class OrderDetailDialog extends JDialog {
    public OrderDetailDialog(Frame parent, HoaDon hd) {
        super(parent, "Chi tiết hóa đơn", true); // true = modal (chặn form chính)

        // Format ngày lập
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String ngayLapFormatted = hd.getNgayLap() != null 
                ? sdf.format(hd.getNgayLap()) : "Chưa có";

        JTextArea txtDetail = new JTextArea();
        txtDetail.setEditable(false);
        txtDetail.setText(
            "Chi tiết hóa đơn:\n" +
            "- Mã HĐ: " + hd.getMaHD() +
            "\n- Mã Bàn: " + hd.getMaBan() +
            "\n- Ngày lập: " + ngayLapFormatted +
            "\n- Tổng tiền: " + hd.getTongTien()
        );

        add(new JScrollPane(txtDetail), BorderLayout.CENTER);

        setSize(300, 200);
        setLocationRelativeTo(parent); // canh giữa
    }
}
