/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.impl;

import DAO.ModelDAO.VoucherDAO;
import Util.UJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author User
 */
public class VoucherImpl implements VoucherDAO {
    public void capNhatTongChiTieu(String maKH, double tongTien) {
        String sql = "UPDATE KhachHang SET TongChiTieu = TongChiTieu + ? WHERE MaKH = ?";

        try (Connection conn = UJdbc.openConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, tongTien);
            stmt.setString(2, maKH);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println(" Đã cập nhật tổng chi tiêu cho khách hàng: " + maKH);
            } else {
                System.out.println("️ Không tìm thấy khách hàng có mã: " + maKH);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(" Lỗi khi cập nhật tổng chi tiêu.");
        }
    }
    public double layTongChiTieu(String maKH) {
    String sql = "SELECT TongChiTieu FROM KhachHang WHERE MaKH = ?";
    try (Connection conn = UJdbc.openConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, maKH);
        var rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getDouble("TongChiTieu");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return 0;
}
    
}
