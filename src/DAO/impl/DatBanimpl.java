/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.impl;

import DAO.ModelDAO.DatBanDAO;
import Model.BanAn;
import Model.DatBan;
import Model.NhanVien;
import Util.UJdbc;
import Util.UQuery;
import java.util.List;
import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
/**
 *
 * @author baoha
 */
public class DatBanimpl implements DatBanDAO{
    private final Connection con = null;
// Thêm đặt bàn (sử dụng đúng tham số, không dùng dấu nháy đơn)
        public static final String datbanam = """
    
            DECLARE @MaDatMoi VARCHAR(10);
            EXEC sp_ThemDatBan_TuSinhMa 
                @tenKH = ?,
                @MaBan = ?,
                @NgayDat = ?,
                @GioDat = ?,
                @SoNguoi = ?,
                @TrangThai = N'Đã đặt',
                @MaMon = ?,
                @SoLuong = ?,
                @MaDat = @MaDatMoi OUTPUT;
            
            SELECT @MaDatMoi AS MaDatDuocSinh;

""";

// Xoá đặt bàn
public static final String xoaDatBan = "DELETE FROM DatBan WHERE MaDat = ?";
public static final String capnhatTrangThai = "UPDATE BanAn SET TrangThai = N'Đã đặt'Where MaBan = ?";
// Sửa đặt bàn


// Truy vấn tất cả đặt bàn
public static final String timkietDatBan = """
        SELECT  MaDat,TenKH, MaBan, NgayDat, GioDat, SoNguoi, TrangThai
              FROM DatBan WHERE TrangThai = N'Trống'
""";
public static final String timkietDatBancoTang = """
    SELECT 
              b.MaBan,
              b.SoBan,
              b.TrangThai,
              b.MaKV
          FROM BanAn b
          WHERE b.MaKV = ? AND b.TrangThai = N'Trống'
""";

// Tìm kiếm theo điều kiện (ví dụ theo MaDat)
public static final String timkiemcodieukien = timkietDatBan + " WHERE MaDat = ?";
public static String datbantruocgoimon = "EXEC sp_DatBanVaTaoHoaDon_GoiMon_MaTuyChinh \n" +
"    @TenKH = ?,\n" +
"    @MaBan = ?,\n" +
"    @NgayDat = ?,\n" +
"    @GioDat = ?,\n" +
"    @SoNguoi = ?,\n" +
"    @MaNV = ?,\n" +
"    @HinhThucTT = N'?',\n" +
"    @MaMon = ?,\n" +
"    @SoLuong = ?,\n" +
"    @GhiChu = ?;";

    @Override   
public DatBan create(DatBan entity) {
    Object[] values = {
        entity.getTenKH(),
        entity.getMaBan(),
        entity.getNgayDat(),
        entity.getGioDat(),
        entity.getSoNguoi(),
        entity.getTrangThai(),
        entity.getMaDat() // cần truyền thêm MaDat ở cuối
    };
    UJdbc.executeUpdate(capnhatTrangThai, values); // gọi đúng câu UPDATE
    return entity;
}
   public static void executeProcedureDatBan(
    String TenKH, String MaBan, java.sql.Date NgayDat, Time GioDat,
    int soNguoi, String maNV, String HTTT, String maMon, int SoLuong, String ghiChu) {

    String call =datbantruocgoimon;
    
    try (Connection con = UJdbc.openConnection(); 
         CallableStatement cs = con.prepareCall(call)) {

        cs.setString(1, TenKH);
        cs.setString(2, MaBan);
        cs.setDate(3, NgayDat);
        cs.setTime(4, GioDat);
        cs.setInt(5, soNguoi);
        cs.setString(6, maNV);
        cs.setString(7, HTTT);
        cs.setString(8, maMon);
        cs.setInt(9, SoLuong);
        cs.setString(10, ghiChu);

        cs.execute();

    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Lỗi gọi thủ tục sp_DatBanVaGoiMon: " + e.getMessage());
    }
}





    public List<BanAn> DatBanCoTang(String tang) throws SQLException {
    List<BanAn> list = new ArrayList<>();
    String sql = timkietDatBancoTang;
    PreparedStatement p = UJdbc.openConnection().prepareStatement(sql);
    p.setString(1, tang);
    ResultSet r = p.executeQuery();
    while (r.next()) {
        BanAn ba = new BanAn();
        ba.setMaBan(r.getString("MaBan"));
        ba.setSoBan(r.getInt("SoBan"));
        ba.setTrangThai(r.getString("TrangThai"));
        ba.setMaKV(r.getString("MaKV"));
        list.add(ba);
    }
    r.close();
    p.close();
    return list;
}

    @Override
    public void update(DatBan entity) {
            Object[] values = {
            entity.getTenKH(),
           entity.getMaBan(),
           entity.getNgayDat(),
           entity.getGioDat(),
           entity.getSoNguoi(),
           entity.getTrangThai(),
            entity.getMaBan()
        };
        UJdbc.executeUpdate(capnhatTrangThai, values);
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
