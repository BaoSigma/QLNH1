package DAO.impl;

import DAO.ModelDAO.KhachHangDAO;
import Model.KhachHang;
import Util.UJdbc;
import Util.UQuery;
import java.util.List;

public class KhachHangImpl implements KhachHangDAO {

    private static final String findall = """
        SELECT 
            MaKH,
            HoTen,
            TongChiTieu,
            HangKhach,
            MatKhau,
            Anh,
            Email,
            maVaiTro
        FROM KhachHang;
    """;

    private static final String createsql = """
        EXEC sp_ThemVaTraKhachHang
            @HoTen = ?,
            @TongChiTieu = ?,
            @HangKhach = ?,
            @MatKhau = ?,
            @Anh = ?,
            @Email = ?,
            @maVaiTro = ?;
    """;

    private static final String updatesql = """
        UPDATE KhachHang
        SET 
            HoTen = ?,
            TongChiTieu = ?,
            HangKhach = ?,
            MatKhau = ?,
            Anh = ?,
            Email = ?,
            maVaiTro = ?
        WHERE MaKH = ?;
    """;

    private static final String updateHangKhachSql = """
        UPDATE KhachHang
        SET HangKhach = 
            CASE 
                WHEN TongChiTieu >= 60000000 THEN N'Kim Cương'
                WHEN TongChiTieu >= 45000000 THEN N'Vàng'
                WHEN TongChiTieu >= 30000000 THEN N'Bạc'
                WHEN TongChiTieu >= 15000000 THEN N'Thanh toán nhiều'
                ELSE N'Thường'
            END;
    """;

    private static final String deletesql = "DELETE FROM KhachHang WHERE MaKH = ?;";

    private static final String findbyid = """
        SELECT 
            MaKH,
            HoTen,
            TongChiTieu,
            HangKhach,
            MatKhau,
            Anh,
            Email,
            maVaiTro
        FROM KhachHang
        WHERE MaKH = ?;
    """;

    @Override
    public KhachHang create(KhachHang entity) {
        Object[] values = {
            entity.getHoTen(),
            entity.getTongChiTieu(),
            entity.getHangKhach(),
            entity.getMatKhau(),
            entity.getAnh(),
            entity.getEmail(),
            entity.getMaVaiTro()
        };
        UJdbc.executeUpdate(createsql, values);
        UJdbc.executeUpdate(updateHangKhachSql);
        return entity;
    }

    @Override
    public void update(KhachHang entity) {
        Object[] values = {
            entity.getHoTen(),
            entity.getTongChiTieu(),
            entity.getHangKhach(),
            entity.getMatKhau(),
            entity.getAnh(),
            entity.getEmail(),
            entity.getMaVaiTro(),
            entity.getMaKH()
        };
        UJdbc.executeUpdate(updatesql, values);
        UJdbc.executeUpdate(updateHangKhachSql);
    }

    @Override
    public void deleteById(Object id) {
        UJdbc.executeUpdate(deletesql, id);
    }

    @Override
    public List<KhachHang> findAll() {
        return UQuery.getBeanList(KhachHang.class, findall);
    }

    @Override
    public KhachHang findById(Object id) {
        return UQuery.getSingleBean(KhachHang.class, findbyid, id);
    }

    public List<KhachHang> findByKeyword(String keyword) {
        String sql = """
            SELECT 
                MaKH,
                HoTen,
                TongChiTieu,
                HangKhach,
                MatKhau,
                Anh,
                Email,
                maVaiTro
            FROM KhachHang
            WHERE MaKH LIKE ? 
               OR HoTen LIKE ?
               OR HangKhach LIKE ?
               OR MatKhau LIKE ?
               OR Email LIKE ?
               OR CAST(TongChiTieu AS VARCHAR) LIKE ?;
        """;
        String value = "%" + keyword + "%";
        return UQuery.getBeanList(KhachHang.class, sql, value, value, value, value, value, value);
    }
}
