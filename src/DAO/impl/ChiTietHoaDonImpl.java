/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.impl;

import DAO.ModelDAO.ChiTietHoaDonDAO;
import Model.ChiTietHoaDon;
import Util.UJdbc;
import Util.UQuery;
import java.util.List;

/**
 *
 * @author baoha
 */

public class ChiTietHoaDonImpl implements ChiTietHoaDonDAO {

    private static final String sqlInsert = """
        EXEC sp_ThemChiTietHoaDon ?, ?, ?, ?, ?;
    """;
    private static final String sqlDelete = """
    DELETE FROM ChiTietHoaDon
    WHERE MaCTHD = ?;
""";
    private static final String sqlFindAll = """
    SELECT MaCTHD, MaHD, MaMon, SoLuong, GhiChu, TrangThai
    FROM ChiTietHoaDon;
""";
    private static final String sqlFindById = """
    SELECT MaCTHD, MaHD, MaMon, SoLuong, GhiChu, TrangThai
    FROM ChiTietHoaDon
    WHERE MaCTHD = ?;
""";
private static final String sqlUpdate = """
    UPDATE ChiTietHoaDon
    SET SoLuong = ?, GhiChu = ?, TrangThai = ?
    WHERE MaCTHD = ?;
""";

    

    @Override
    public ChiTietHoaDon create(ChiTietHoaDon ct) {
        Object[] values = {
            ct.getMaHD(),
            ct.getMaMon(),
            ct.getSoLuong(),
            ct.getGhiChu(),
            ct.getTrangThai()
        };
        UJdbc.executeUpdate(sqlInsert, values);
        return ct;
    }

    @Override
    public void update(ChiTietHoaDon ct) {
        Object[] values = {
            ct.getSoLuong(),
            ct.getGhiChu(),
            ct.getTrangThai(),
            ct.getMaHD(),
            ct.getMaMon()
        };
        UJdbc.executeUpdate(sqlUpdate, values);
    }

    @Override
    public void deleteById(Object id) {
        if (id instanceof String[] ids && ids.length == 2) {
            UJdbc.executeUpdate(sqlDelete, ids[0], ids[1]);
        } else {
            throw new IllegalArgumentException("ID phải là String[2] gồm MaHD và MaMon");
        }
    }

    @Override
    public List<ChiTietHoaDon> findAll() {
        return UQuery.getBeanList(ChiTietHoaDon.class, sqlFindAll);
    }

    @Override
    public ChiTietHoaDon findById(Object id) {  
    return UQuery.getSingleBean(ChiTietHoaDon.class, sqlFindById);
    }

    public List<ChiTietHoaDon> findByKeyword(String keyword) {
    String sql = """
        SELECT 
            MaCTHD,
            MaHD,
            MaMon,
            SoLuong,
            GhiChu,
            TrangThai
        FROM ChiTietHoaDon
        WHERE MaCTHD LIKE ? 
           OR MaHD LIKE ? 
           OR MaMon LIKE ? 
           OR GhiChu LIKE ? 
           OR TrangThai LIKE ? 
           OR CAST(SoLuong AS VARCHAR) LIKE ?
    """;

    String value = "%" + keyword + "%";
    return UQuery.getBeanList(ChiTietHoaDon.class, sql, value, value, value, value, value, value);
}

}


