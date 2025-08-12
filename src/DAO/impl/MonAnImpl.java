/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DAO.impl;

import DAO.ModelDAO.MonAnDAO;
import Model.MonAn;
import Util.UJdbc;
import Util.UQuery;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Dong Khanh
 */
public class MonAnImpl implements MonAnDAO {

    private static final String sqlInsert = """
        INSERT INTO MonAn (MaMon, TenMon, DonGia, MoTa, HinhAnh, MaLoai)
        VALUES (?, ?, ?, ?, ?, ?);
    """;

    private static final String sqlUpdate = """
        UPDATE MonAn
        SET TenMon = ?,MaLoai = ?, DonGia = ?, MoTa = ?, HinhAnh = ?
        WHERE MaMon = ?;
    """;

    private static final String sqlDelete = """
        DELETE FROM MonAn WHERE MaMon = ?;
    """;

    private static final String sqlFindAll = """
        SELECT * FROM MonAn;
    """;

    private static final String sqlFindById = """
        SELECT MaMon, TenMon, DonGia, MoTa, HinhAnh, MaLoai
        FROM MonAn
        WHERE MaMon = ?;
    """;

    @Override
    public MonAn create(MonAn m) {
        Object[] values = {
            m.getMaMon(),
            m.getTenMon(),
            m.l.getMaLoai(),
            m.getDonGia(),
            m.getMoTa(),
            m.getHinhAnh()
            
        };
        UJdbc.executeUpdate(sqlInsert, values);
        return m;
    }

    @Override
    public void update(MonAn m) {
        Object[] values = {
            m.getTenMon(),
            m.l.getMaLoai(),
            m.getDonGia(),
            m.getMoTa(),
            m.getHinhAnh(),
            
            m.getMaMon()
        };
        UJdbc.executeUpdate(sqlUpdate, values);
    }

    @Override
    public void deleteById(Object id) {
        UJdbc.executeUpdate(sqlDelete, id);
    }

    @Override
    public List<MonAn> findAll() {
        return UQuery.getBeanList(MonAn.class, sqlFindAll);
    }

    @Override
    public MonAn findById(Object id) {
        return UQuery.getSingleBean(MonAn.class, sqlFindById, id);
    }

    public List<MonAn> findByMaLoai(int maLoai) {
        String sql = """
            SELECT MaMon, TenMon, DonGia, MoTa, HinhAnh, MaLoai
            FROM MonAn
            WHERE MaLoai = ?;
        """;
        return UQuery.getBeanList(MonAn.class, sql, maLoai);
    }
    public List<MonAn> findByKeyword(String keyword) {
    String sql = """
        SELECT 
            *
            
        FROM MonAn
        WHERE MaMon LIKE ? 
           OR TenMon LIKE ? 
           OR MoTa LIKE ? 
           OR HinhAnh LIKE ? 
           OR CAST(DonGia AS VARCHAR) LIKE ? 
           OR CAST(MaLoai AS VARCHAR) LIKE ?;
    """;

    String value = "%" + keyword + "%";
    return UQuery.getBeanList(MonAn.class, sql, value, value, value, value, value, value);
}
}
