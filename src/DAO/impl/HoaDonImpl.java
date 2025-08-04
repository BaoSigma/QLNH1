/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.impl;

import DAO.ModelDAO.HoaDonDAO;
import Model.HoaDon;
import Util.UJdbc;
import Util.UQuery;
import java.util.List;

/**
 *
 * @author User
 */
public class HoaDonImpl implements HoaDonDAO{
    private static final String sqlInsert = """
        INSERT INTO HoaDon (MaHD, MaBan, MaNV, NgayLap, TongTien, HinhThucTT)
        VALUES (?, ?, ?, ?, ?, ?);
    """;

    private static final String sqlUpdate = """
        UPDATE HoaDon
        SET MaBan = ?, MaNV = ?, NgayLap = ?, TongTien = ?, HinhThucTT = ?
        WHERE MaHD = ?;
    """;

    private static final String sqlDelete = "DELETE FROM HoaDon WHERE MaHD = ?";

    private static final String sqlSelectAll = "SELECT * FROM HoaDon";

    private static final String sqlSelectById = "SELECT * FROM HoaDon WHERE MaHD = ?";

    @Override
    public HoaDon create(HoaDon entity) {
        Object[] values = {
            entity.getMaHD(),
            entity.getMaBan(),
            entity.getMaNV(),
            entity.getNgayLap(),
            entity.getTongTien(),
            entity.getHinhThucTT()
        };
        UJdbc.executeUpdate(sqlInsert, values);
        return entity;
    }

    // Update
    @Override
    public void update(HoaDon entity) {
        Object[] values = {
            entity.getMaBan(),
            entity.getMaNV(),
            entity.getNgayLap(),
            entity.getTongTien(),
            entity.getHinhThucTT(),
            entity.getMaHD()
        };
        UJdbc.executeUpdate(sqlUpdate, values);
    }

    // Delete
    @Override
    public void deleteById(Object id) {
        UJdbc.executeUpdate(sqlDelete, id);
    }

    // Find all
    @Override
    public List<HoaDon> findAll() {
        return UQuery.getBeanList(HoaDon.class, sqlSelectAll);
    }

    // Find by ID
    @Override
    public HoaDon findById(Object id) {
        return UQuery.getSingleBean(HoaDon.class, sqlSelectById, id);
    }
    public List<HoaDon> findByKeyword(String keyword) {
    String sql = """
        SELECT 
            MaHD,
            MaBan,
            MaNV,
            NgayLap,
            TongTien,
            HinhThucTT
        FROM HoaDon
        WHERE MaHD LIKE ?
            OR MaBan LIKE ?
            OR MaNV LIKE ?
            OR HinhThucTT LIKE ?
            
    """;

    String value = "%" + keyword + "%";
    return UQuery.getBeanList(HoaDon.class, sql, value, value, value, value);
}
}
