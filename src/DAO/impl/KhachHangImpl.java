/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DAO.impl;

import DAO.ModelDAO.KhachHangDAO;
import Model.KhachHang;
import Util.UJdbc;
import Util.UQuery;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Dong Khanh
 */

public class KhachHangImpl implements KhachHangDAO {

    private static final String findall = """
        SELECT 
            MaKH,
            HoTen,
            SDT,
            TongChiTieu,
            HangKhach
        FROM KhachHang;
    """;

    private static final String createsql = """
        EXEC sp_ThemVaTraKhachHang
            @HoTen = ?,
            @SDT = ?,
            @TongChiTieu = ?,
            @HangKhach = ?;
    """;

    private static final String updatesql = """
        UPDATE KhachHang
        SET 
            HoTen = ?,
            SDT = ?,
            TongChiTieu = ?,
            HangKhach = ?
        WHERE MaKH = ?;
    """;

    private static final String deletesql = "DELETE FROM KhachHang WHERE MaKH = ?;";

    private static final String findbyid = """
        SELECT 
            MaKH,
            HoTen,
            SDT,
            TongChiTieu,
            HangKhach
        FROM KhachHang
        WHERE MaKH = ?;
    """;

    @Override
    public KhachHang create(KhachHang entity) {
        Object[] values = {
            entity.getHoTen(),
            entity.getSdt(),
            entity.getTongChiTieu(),
            entity.getHangKhach()
        };
        UJdbc.executeUpdate(createsql, values);
        return entity;
    }

    @Override
    public void update(KhachHang entity) {
        Object[] values = { 
            entity.getHoTen(),
            entity.getSdt(),
            entity.getTongChiTieu(),
            entity.getHangKhach(),
            entity.getMaKH()
        };
        UJdbc.executeUpdate(updatesql, values);
    }

    @Override
    public void deleteById(Object id) {
        UJdbc.executeUpdate(deletesql, id);
    }

    @Override
    public List<KhachHang> findAll() {
        return UQuery.getBeanList(KhachHang.class, findall);
    }

    @Override
    public KhachHang findById(Object id) {
        return UQuery.getSingleBean(KhachHang.class, findbyid, id);
    }

    public List<KhachHang> findByKeyword(String keyword) {
        String sql = """
            SELECT 
                MaKH,
                HoTen,
                SDT,
                TongChiTieu,
                HangKhach
            FROM KhachHang
            WHERE MaKH LIKE ? 
               OR HoTen LIKE ?
               OR SDT LIKE ?
               OR HangKhach LIKE ?
               OR CAST(TongChiTieu AS VARCHAR) LIKE ?;
        """;

        String value = "%" + keyword + "%";
        return UQuery.getBeanList(KhachHang.class, sql, value, value, value, value, value);
    }
}


