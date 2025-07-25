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
    public static final String datbanam = "EXEC sp_ThemDatBan ?, ?, ?, ?, ?, ?";
    public static final String xoaDatBanAn = "Delete form DatBan where MaDat = ?";
    public static final String suaDatBan = "UPDATE DatBan\n" +
"SET \n" +
"    MaKH = ?,\n" +
"    MaBan = ?,\n" +
"    NgayDat = ?,\n" +
"    GioDat = ?,\n" +
"    SoNguoi = ?,\n" +
"    TrangThai = ?\n" +
"WHERE MaDat = ?';";
       
    public static final String timkietDatBan = "SELECT TOP (1000) [MaDat]\n" +
"      ,[MaKH]\n" +
"      ,[MaBan]\n" +
"      ,[NgayDat]\n" +
"      ,[GioDat]\n" +
"      ,[SoNguoi]\n" +
"      ,[TrangThai]\n" +
"  FROM [QuanLyNhaHang].[dbo].[DatBan]";
    public static final String timkiemcodieukien = timkietDatBan + "Where MaDat = ?";
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
        UJdbc.executeUpdate(xoaDatBanAn, id);
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
