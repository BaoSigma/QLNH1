/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.impl;
import DAO.ModelDAO.KhuVucDAO;
import Model.BanAn;
import Model.ChiTietDatBan;
import Model.KhuVuc;
import Model.NhanVien;

import Util.UJdbc;
import Util.UQuery;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;
import java.time.LocalTime;
/**
 *
 * @author Admin
 */
public class KhuVucImp implements KhuVucDAO{
    private static final String findAll = """
        SELECT 
            kv.maKV,
            kv.tenKV
        FROM KhuVuc kv
    """;
    private static final String  createsql= "EXEC sp_ThemVaTraKhuVuc\n" +
"    kv.maKV,\n" +
"    kv.tenKV,\n" ;
    private static final String updateSql = """
        UPDATE KhuVuc
        SET tenKV = ?
        WHERE maKV = ?
    """;
     private static final String deleteSql = """
        DELETE FROM KhuVuc WHERE maKV = ?
    """;

    private static final String findById = """
        SELECT 
            kv.maKV, kv.tenKV
        FROM KhuVuc kv
        WHERE kv.maKV = ?
    """;

    private static final String findByKeywordSql = """
        SELECT 
            kv.maKV,
            kv.tenKV
        FROM KhuVuc kv
        WHERE kv.maKV LIKE ? OR kv.tenKV LIKE ?
    """;

    @Override
    public KhuVuc create(KhuVuc entity) {
        Object[] values = {
            entity.getMaKV(),
            entity.getTenKV()
        };
        UJdbc.executeUpdate(createsql, values);
        return entity;
    }

    @Override
    public void update(KhuVuc entity) {
        Object[] values = {
            entity.getTenKV(),
            entity.getMaKV()
        };
        UJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(Object id) {
        UJdbc.executeUpdate(deleteSql, id);
    }

    @Override
    public List<KhuVuc> findAll() {
        return UQuery.getBeanList(KhuVuc.class, findAll);
    }

    @Override
    public KhuVuc findById(Object id) {
        return UQuery.getSingleBean(KhuVuc.class, findById, id);
    }
    public String getMaDatChuaThanhToan(String maBan) {
        String sql = "SELECT MaDat FROM DatBan WHERE MaBan = ? AND TrangThai = N'Chưa thanh toán'";
        try (ResultSet rs = UJdbc.executeQuery(sql, maBan)) {
            if (rs.next()) {
                return rs.getString("MaDat");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ChiTietDatBan> getChiTietTheoMaDat(String maDat) {
        List<ChiTietDatBan> list = new ArrayList<>();
        String sql = """
            SELECT c.MaMon, d.TenMon, c.SoLuong, c.GhiChu
            FROM ChiTietDatBan c
            JOIN DoUong d ON c.MaMon = d.MaMon
            WHERE c.MaDat = ?
        """;

        try (ResultSet rs = UJdbc.executeQuery(sql, maDat)) {
            while (rs.next()) {
                ChiTietDatBan ct = new ChiTietDatBan();
                ct.setMaMon(rs.getString("TenMon")); // dùng tên món thay vì mã
                ct.setSoLuong(rs.getInt("SoLuong"));
                ct.setGhiChu(rs.getString("GhiChu"));
                list.add(ct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
public ArrayList<BanAn> MenuTable(String tenKV) {
    ArrayList<BanAn> list = new ArrayList<>();
    String sql = "SELECT b.MaBan, b.SoBan, b.TrangThai, b.MaKV, d.GioDat, d.NgayDat " +
                 "FROM BanAn b " +
                 "JOIN KhuVuc k ON b.MaKV = k.MaKV " +
                 "LEFT JOIN DatBan d ON b.MaBan = d.MaBan AND d.TrangThai = 'Đang đặt' " +
                 "WHERE k.TenKV = ?";

    try (ResultSet r = UJdbc.executeQuery(sql, tenKV)) {
        while (r.next()) {
            String maBan = r.getString("MaBan");
            String soBan = r.getString("SoBan");
            String trangThai = r.getString("TrangThai");
            String maKV = r.getString("MaKV");
            Time gioDatSql = r.getTime("GioDat"); // java.sql.Time
            Date ngayDat = r.getDate("NgayDat");  // java.sql.Date

            BanAn ban = new BanAn();
            ban.setMaBan(maBan);
            ban.setSoBan(Integer.parseInt(soBan));
            ban.setTrangThai(trangThai);
            ban.setMaKV(maKV);

            if (gioDatSql != null) {
                ban.setGioDat(gioDatSql.toLocalTime()); // chuyển sang LocalTime
            }
            ban.setNgayDat(ngayDat); // vẫn là java.sql.Date hoặc LocalDate nếu bạn convert

            list.add(ban);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}



    public List<KhuVuc> findByKeyword(String keyword) {
        String value = "%" + keyword + "%";
        return UQuery.getBeanList(KhuVuc.class, findByKeywordSql, value, value);
    }
}