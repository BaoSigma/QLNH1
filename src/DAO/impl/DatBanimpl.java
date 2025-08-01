/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.impl;

import DAO.ModelDAO.DatBanDAO;
import Model.DatBan;
import Model.NhanVien;
import Util.UJdbc;
import Util.UQuery;
import java.util.List;

/**
 *
 * @author baoha
 */
public class DatBanimpl implements DatBanDAO{
// Thêm đặt bàn (sử dụng đúng tham số, không dùng dấu nháy đơn)
public static final String datbanam = """
    EXEC sp_ThemDatBan
        @MaKH = ?,
        @MaBan = ?,
        @NgayDat = ?,
        @GioDat = ?,
        @SoNguoi = ?,
        @TrangThai = ?
""";

// Xoá đặt bàn
public static final String xoaDatBan = "DELETE FROM DatBan WHERE MaDat = ?";

// Sửa đặt bàn
public static final String suaDatBan = """
    UPDATE DatBan
    SET 
        MaKH = ?,
        MaBan = ?,
        NgayDat = ?,
        GioDat = ?,
        SoNguoi = ?,
        TrangThai = ?
    WHERE MaDat = ?
""";

// Truy vấn tất cả đặt bàn
public static final String timkietDatBan = """
    SELECT TOP (1000) MaDat, MaKH, MaBan, NgayDat, GioDat, SoNguoi, TrangThai
    FROM DatBan
""";

// Tìm kiếm theo điều kiện (ví dụ theo MaDat)
public static final String timkiemcodieukien = timkietDatBan + " WHERE MaDat = ?";

    @Override
    public DatBan create(DatBan entity) {
         Object[] values = {
            entity.getMaKH(),
           entity.getMaBan(),
           entity.getNgayDat(),
           entity.getGioDat(),
           entity.getSoNguoi(),
           entity.getTrangThai()
        };
        UJdbc.executeUpdate(datbanam, values);
        return entity;
    }

    @Override
    public void update(DatBan entity) {
            Object[] values = {
            entity.getMaKH(),
           entity.getMaBan(),
           entity.getNgayDat(),
           entity.getGioDat(),
           entity.getSoNguoi(),
           entity.getTrangThai(),
            entity.getMaBan()
        };
        UJdbc.executeUpdate(suaDatBan, values);
        }

    @Override
    public void deleteById(Object id) {
        UJdbc.executeUpdate(xoaDatBan, id);
        }

    @Override
    public List<DatBan> findAll() {
        return UQuery.getBeanList(DatBan.class, timkietDatBan);
    }

    @Override
    public DatBan findById(Object id) {
        return UQuery.getSingleBean(DatBan.class, timkiemcodieukien, id);
    }
    
}
