/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DAO.impl;

import DAO.ModelDAO.LoaiMonDAO;
import Model.LoaiMon;
import Model.MonAn;
import Util.UJdbc;
import Util.UQuery;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Dong Khanh
 */
public class LoaiMonImpl implements LoaiMonDAO {

    private static final String sqlInsert = """
        INSERT INTO LoaiMon (MaLoai, TenLoai)
        VALUES (?, ?);
    """;

    private static final String sqlUpdate = """
        UPDATE LoaiMon
        SET TenLoai = ?
        WHERE MaLoai = ?;
    """;

    private static final String sqlDelete = """
        DELETE FROM LoaiMon WHERE MaLoai = ?;
    """;

    private static final String sqlFindAll = """
        SELECT MaLoai, TenLoai FROM LoaiMon;
    """;

    private static final String sqlFindById = """
        SELECT MaLoai, TenLoai FROM LoaiMon WHERE MaLoai = ?;
    """;

    @Override
    public LoaiMon create(LoaiMon l) {
        Object[] values = {
            l.getMaLoai(),
            l.getTenLoai()
        };
        UJdbc.executeUpdate(sqlInsert, values);
        return l;
    }

    @Override
    public void update(LoaiMon l) {
        Object[] values = {
            l.getTenLoai(),
            l.getMaLoai()
        };
        UJdbc.executeUpdate(sqlUpdate, values);
    }

    @Override
    public void deleteById(Object id) {
        UJdbc.executeUpdate(sqlDelete, id);
    }

    @Override
    public List<LoaiMon> findAll() {
        return UQuery.getBeanList(LoaiMon.class, sqlFindAll);
    }

    @Override
    public LoaiMon findById(Object id) {
        return UQuery.getSingleBean(LoaiMon.class, sqlFindById, id);
    }

    public LoaiMon findByTenLoai(String tenLoai) {
        String sql = """
            SELECT MaLoai, TenLoai
            FROM LoaiMon
            WHERE TenLoai = ?;
        """;
        return UQuery.getSingleBean(LoaiMon.class, sql, tenLoai);
    }
    public List<LoaiMon> findByKeyword(String keyword) {
    String sql = """
        SELECT 
            MaMon,
            TenMon,
            DonGia,
            MoTa,
            HinhAnh,
            MaLoai
        FROM MonAn
        WHERE MaMon LIKE ? 
           OR TenMon LIKE ? 
           OR MoTa LIKE ? 
           OR HinhAnh LIKE ? 
           OR CAST(DonGia AS VARCHAR) LIKE ? 
           OR CAST(MaLoai AS VARCHAR) LIKE ?;
    """;

    String value = "%" + keyword + "%";
    return UQuery.getBeanList(LoaiMon.class, sql, value, value, value, value, value, value);
}
}

