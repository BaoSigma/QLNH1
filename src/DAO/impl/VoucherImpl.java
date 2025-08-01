/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.impl;

import DAO.ModelDAO.VoucherDAO;
import Model.voucher;
import Util.UJdbc;
import Util.UQuery;
import View.Voucher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author User
 */
public class VoucherImpl implements VoucherDAO {
    private static final String findall = """
        SELECT 
            MaVoucher,
            TenVoucher,
            GiaTri,
            Loai,
            HanDung,
            MaHD                   
        FROM Voucher;
    """;

    private static final String createsql = """
        EXEC sp_ThemVoucher
            @MaVoucher = ?,
            @TenVoucher = ?,
            @GiaTri = ?,
            @Loai = ?,
            @HanDung=?,
            @MaHD =?;                                                            
    """;

    private static final String updatesql = """
        UPDATE Voucher
        SET 
            MaVoucher = ?,
            TenVoucher = ?,
            GiaTri = ?,
            Loai = ?,
            HanDung=?,
            MaHD =?
        WHERE MaVoucher = ?;
    """;

    private static final String deletesql = "DELETE FROM KhachHang WHERE MaVoucher = ?;";

    private static final String findbyid = """
        SELECT 
           MaVoucher,
           TenVoucher,
           GiaTri,
           Loai,
           HanDung,
           MaHD         
        FROM Voucher
        WHERE Voucher = ?;
    """;
    @Override
    public voucher create(voucher entity) {
        Object[] values = {
            entity.getMaVoucher(),
            entity.getTenVoucher(),
            entity.getGiaTri(),
            entity.getLoai(),
            entity.getHanDung(),
            entity.getMaHD()
        };
        UJdbc.executeUpdate(createsql, values);
        return entity;
    }

    @Override
    public void update(voucher entity) {
         Object[] values = {
            entity.getMaVoucher(),
            entity.getTenVoucher(),
            entity.getGiaTri(),
            entity.getLoai(),
            entity.getHanDung(),
            entity.getMaHD()
        };
          UJdbc.executeUpdate(updatesql, values);
    }

    @Override
    public void deleteById(Object id) {
        UJdbc.executeUpdate(deletesql, id);
    }

    @Override
    public List<voucher> findAll() {
         return UQuery.getBeanList(voucher.class, findall);
    }

    @Override
    public voucher findById(Object id) {
        return UQuery.getSingleBean(voucher.class, findbyid, id);
    }
   public List<voucher> findByKeyword(String keyword) {
        String sql = """
            SELECT 
                 MaVoucher,
                 TenVoucher,
                 GiaTri,
                 Loai,
                 HanDung,
                 MaHD       
            FROM Voucher
            WHERE MaVoucher LIKE ? 
               OR TenVoucher LIKE ?
               OR GiaTri LIKE ?
               OR Loai LIKE ?
               OR HanDung LIKE ?
               OR MaHD LIKE ?;
        """;

        String value = "%" + keyword + "%";
        return UQuery.getBeanList(voucher.class, sql, value, value, value, value, value);
    }

//    public List<voucher> findByKeyword(String keyword) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
}
