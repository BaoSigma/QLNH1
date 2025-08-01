/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DAO.impl;

import DAO.ModelDAO.BanAnDAO;
import Model.BanAn;
import Util.UJdbc;
import Util.UQuery;
import java.util.List;

/**
 *
 * @author Dong Khanh
 */
public class BanAnImpl implements BanAnDAO {
    private static final String sqlInsert = """
        INSERT INTO BanAn (MaBan, SoBan, TrangThai, MaKV)
        VALUES (?, ?, ?, ?);
    """;

    private static final String sqlUpdate = """
        UPDATE BanAn
        SET SoBan = ?, TrangThai = ?, MaKV = ?
        WHERE MaBan = ?;
    """;

    private static final String sqlDelete = """
        DELETE FROM BanAn
        WHERE MaBan = ?;
    """;

    private static final String sqlFindAll = """
        SELECT MaBan, SoBan, TrangThai, MaKV FROM BanAn;
    """;

    private static final String sqlFindById = """
        SELECT MaBan, SoBan, TrangThai, MaKV
        FROM BanAn
        WHERE MaBan = ?;
    """;

    @Override
    public BanAn create(BanAn ba) {
        Object[] values = {
            ba.getMaBan(),
            ba.getSoBan(),
            ba.getTrangThai(),
            ba.getMaKV()
        };
        UJdbc.executeUpdate(sqlInsert, values);
        return ba;
    }

    @Override
    public void update(BanAn ba) {
        Object[] values = {
            ba.getSoBan(),
            ba.getTrangThai(),
            ba.getMaKV(),
            ba.getMaBan()
        };
        UJdbc.executeUpdate(sqlUpdate, values);
    }

    @Override
    public void deleteById(Object id) {
        UJdbc.executeUpdate(sqlDelete, id);
    }

    @Override
    public List<BanAn> findAll() {
        return UQuery.getBeanList(BanAn.class, sqlFindAll);
    }

    @Override
    public BanAn findById(Object id) {
        return UQuery.getSingleBean(BanAn.class, sqlFindById, id);
    }

    public List<BanAn> findByKeyword(String keyword) {
        String sql = """
            SELECT MaBan, SoBan, TrangThai, MaKV
            FROM BanAn
            WHERE MaBan LIKE ? OR MaKV LIKE ?;
        """;
        String search = "%" + keyword + "%";
        return UQuery.getBeanList(BanAn.class, sql, search, search);
    }
}

