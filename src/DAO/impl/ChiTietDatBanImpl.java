/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DAO.impl;

import DAO.ModelDAO.ChiTietDatBanDAO;
import Model.ChiTietDatBan;
import Util.UJdbc;
import Util.UQuery;
import java.util.List;

/**
 *
 * @author Dong Khanh
 */

public class ChiTietDatBanImpl implements ChiTietDatBanDAO {
    private static final String sqlInsert = """
        EXEC sp_ThemChiTietDatBan ?, ?, ?, ?;
    """;

    private static final String sqlUpdate = """
        UPDATE ChiTietDatBan
        SET SoLuong = ?, GhiChu = ?
        WHERE MaDat = ? AND MaMon = ?;
    """;

    private static final String sqlDelete = """
        DELETE FROM ChiTietDatBan
        WHERE MaDat = ? AND MaMon = ?;
    """;

    private static final String sqlFindAll = """
        SELECT MaDat, MaMon, SoLuong, GhiChu FROM ChiTietDatBan;
    """;

    private static final String sqlFindById = """
        SELECT MaDat, MaMon, SoLuong, GhiChu
        FROM ChiTietDatBan
        WHERE MaDat = ? AND MaMon = ?;
    """;

    @Override
    public ChiTietDatBan create(ChiTietDatBan ct) {
        Object[] values = {
            ct.getMaDat(),
            ct.getMaMon(),
            ct.getSoLuong(),
            ct.getGhiChu()
        };
        UJdbc.executeUpdate(sqlInsert, values);
        return ct;
    }

    @Override
    public void update(ChiTietDatBan ct) {
        Object[] values = {
            ct.getSoLuong(),
            ct.getGhiChu(),
            ct.getMaDat(),
            ct.getMaMon()
        };
        UJdbc.executeUpdate(sqlUpdate, values);
    }

    @Override
    public void deleteById(Object id) {
        if (id instanceof String[] ids && ids.length == 2) {
            UJdbc.executeUpdate(sqlDelete, ids[0], ids[1]);
        } else {
            throw new IllegalArgumentException("ID phải là String[2] gồm MaDat và MaMon");
        }
    }

    @Override
    public List<ChiTietDatBan> findAll() {
        return UQuery.getBeanList(ChiTietDatBan.class, sqlFindAll);
    }

    @Override
    public ChiTietDatBan findById(Object id) {
        if (id instanceof String[] ids && ids.length == 2) {
            return UQuery.getSingleBean(ChiTietDatBan.class, sqlFindById, ids[0], ids[1]);
        }
        return null;
    }

    public List<ChiTietDatBan> findByMaDat(String maDat) {
        String sql = """
            SELECT MaDat, MaMon, SoLuong, GhiChu
            FROM ChiTietDatBan
            WHERE MaDat = ?;
        """;
        return UQuery.getBeanList(ChiTietDatBan.class, sql, maDat);
    }
}



