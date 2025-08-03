/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.impl;

import Model.BanAn;
import Model.ChiTietHoaDon;
import Model.HoaDon;
import Model.MonAn;
import Util.UJdbc;
import Util.UQuery;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
/**
 *
 * @author baoha
 */
public class OrderImpl {
    public static final String goiDoUong = "SELECT M.MaMon, M.* FROM MonAn M\n" +
"JOIN LoaiMon L ON M.MaLoai = L.MaLoai\n" +
"WHERE L.MaLoai = 1";
    public static final String goiMonLau = "SELECT M.MaMon, M.* FROM MonAn M\n" +
"JOIN LoaiMon L ON M.MaLoai = L.MaLoai\n" +
"WHERE L.MaLoai = 2";
    public static final String goiMonNuong = "SELECT M.MaMon, M.* FROM MonAn M\n" +
"JOIN LoaiMon L ON M.MaLoai = L.MaLoai\n" +
"WHERE L.MaLoai = 3";
    public static final String goiMoNhe = "SELECT M.MaMon, M.* FROM MonAn M\n" +
"JOIN LoaiMon L ON M.MaLoai = L.MaLoai\n" +
"WHERE L.MaLoai = 4";
    public static final String sqlBanAn = "SELECT MaBan, SoBan, TrangThai\n" +
"FROM BanAn";
    public static final String sqlHoaDon = "EXEC sp_ThemHoaDon \n" +
"    @MaBan = ? ,\n" +
"    @MaNV = ?,\n" +
"    @NgayLap = ?,\n" +
"    @TongTien = ?,\n" +
"    @HinhThucTT = ?;";

    public static final String timkiemall = "SELECT L.TenLoai AS LoaiMon, M.TenMon, M.DonGia, M.HinhAnh\n" +
"FROM MonAn M\n" +
"JOIN LoaiMon L ON M.MaLoai = L.MaLoai\n";
    public HoaDon create(HoaDon entity) {
    try (Connection con = UJdbc.openConnection();
         CallableStatement cs = con.prepareCall("{call sp_ThemHoaDon(?, ?, ?, ?, ?)}")) {

        cs.setString(1, entity.getMaBan());
        cs.setString(2, entity.getMaNV());
        cs.setTimestamp(3, new java.sql.Timestamp(System.currentTimeMillis())); // Ngày lập
        cs.setDouble(4, 0); // Tổng tiền ban đầu
        cs.setString(5, entity.getHinhThucTT());
        boolean hasResult = cs.execute();

        if (hasResult) {
            try (ResultSet rs = cs.getResultSet()) {
                if (rs.next()) {
                    String newMaHD = rs.getString("MaHD");
                    entity.setMaHD(newMaHD);
                    System.out.println(" Mã hóa đơn mới tạo: " + newMaHD); // Debug
                } else {
                    System.err.println(" Không nhận được MaHD từ sp_ThemHoaDon");
                }
            }
        } else {
            System.err.println(" sp_ThemHoaDon không trả về kết quả");
        }

        return entity;

    } catch (SQLException e) {
        throw new RuntimeException("Lỗi khi tạo hóa đơn: " + e.getMessage(), e);
    }
}
    public HoaDon createDB(HoaDon entity) {
    try (Connection con = UJdbc.openConnection();
         CallableStatement cs = con.prepareCall("{call sp_ThemHoaDon(?, ?, ?, ?, ?, ?)}")) {

        cs.setString(1, entity.getMaBan());
        cs.setString(2, entity.getMaNV());
        cs.setTimestamp(3, new java.sql.Timestamp(System.currentTimeMillis())); // Ngày lập
        cs.setDouble(4, 0); // Tổng tiền ban đầu
        cs.setString(5, entity.getHinhThucTT());
        cs.setString(6, entity.getMaHD());
        boolean hasResult = cs.execute();

        if (hasResult) {
            try (ResultSet rs = cs.getResultSet()) {
                if (rs.next()) {
                    String newMaHD = rs.getString("MaHD");
                    entity.setMaHD(newMaHD);
                    System.out.println(" Mã hóa đơn mới tạo: " + newMaHD); // Debug
                } else {
                    System.err.println(" Không nhận được MaHD từ sp_ThemHoaDon");
                }
            }
        } else {
            System.err.println(" sp_ThemHoaDon không trả về kết quả");
        }

        return entity;

    } catch (SQLException e) {
        throw new RuntimeException("Lỗi khi tạo hóa đơn: " + e.getMessage(), e);
    }
}
    public void goiMonTheoBan(String maBan, String maMon, int soLuong, String ghiChu) {
    if (maBan == null || maBan.trim().isEmpty()) {
    throw new IllegalArgumentException("Mã bàn (MaBan) không được null hoặc rỗng.");
    }
    if (maMon == null || maMon.trim().isEmpty()) {
    throw new IllegalArgumentException("Mã món (MaMon) không được null hoặc rỗng.");
    }
    if (soLuong <= 0) {
    throw new IllegalArgumentException("Số lượng phải lớn hơn 0.");
    }
    String sql = "{CALL sp_GoiMonTuBan  (?, ?, ?, ?)}";

    try (Connection con = UJdbc.openConnection();
         CallableStatement cs = con.prepareCall(sql)) {

        cs.setString(1, maBan);
        cs.setString(2, maMon);
        cs.setInt(3, soLuong);
        cs.setString(4, (ghiChu == null || ghiChu.trim().isEmpty()) ? null : ghiChu.trim());

        cs.executeUpdate();

    } catch (SQLException e) {
        throw new RuntimeException("Lỗi khi gọi món theo bàn: " + e.getMessage(), e);
    }
    }


        public List<MonAn> timkiemdouong(String keyword) {
    String sql = timkiemall
        + " WHERE L.TenLoai = N'Đồ uống' AND M.TenMon LIKE ? OR M.DonGia LIKE ? ";

    String value = "%" + keyword + "%";
    return UQuery.getBeanList(MonAn.class, sql,value, value);
}
        public List<MonAn> timkiemmonlau(String keyword) {
    String sql = timkiemall
        + " WHERE L.TenLoai = N'Món lẩu' OR M.TenMon LIKE ? OR M.DonGia LIKE ? ";

    String value = "%" + keyword + "%";
    return UQuery.getBeanList(MonAn.class, sql, value, value);
}
        public List<MonAn> timkiemmonnuong(String keyword) {
    String sql = timkiemall
        + " WHERE L.TenLoai = N'Món nướng' OR M.TenMon LIKE ? OR M.DonGia LIKE ? ";

    String value = "%" + keyword + "%";
    return UQuery.getBeanList(MonAn.class, sql, value, value);
}
        public List<MonAn> timkiemmonnhe(String keyword) {
    String sql = timkiemall
        + " WHERE L.TenLoai = N'Món nhẹ' OR M.TenMon LIKE ? OR M.DonGia LIKE ? ";

    String value = "%" + keyword + "%";
    return UQuery.getBeanList(MonAn.class, sql, value, value);
}
    
    public List<MonAn> DoUong() {
        return UQuery.getBeanList(MonAn.class, goiDoUong);
    }
    public List<MonAn> MonLau() {
        return UQuery.getBeanList(MonAn.class, goiMonLau);
    }
    public List<MonAn> MonNuong() {
        return UQuery.getBeanList(MonAn.class, goiMonNuong);
    }
    public List<MonAn> MoNhe() {
        return UQuery.getBeanList(MonAn.class, goiMoNhe);
    }
    public List<BanAn> CBOBan() {
        return UQuery.getBeanList(BanAn.class, sqlBanAn);
    }
}
