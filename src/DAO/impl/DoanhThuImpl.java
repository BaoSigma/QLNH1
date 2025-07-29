package DAO.impl;

import Model.doanhthu;
import Util.UJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoanhThuImpl {

    public List<doanhthu> findDoanhThuTheoThang() {
        List<doanhthu> list = new ArrayList<>();
        String sql = """
            SELECT FORMAT(NgayLap, 'MM/yyyy') AS TheoThang, SUM(TongTien) AS TongTien
            FROM HoaDon
            GROUP BY FORMAT(NgayLap, 'MM/yyyy')
            ORDER BY MIN(NgayLap)
        """;
        try (ResultSet rs = UJdbc.executeQuery(sql)) {
            while (rs.next()) {
                doanhthu d = new doanhthu();
                d.setTheoThang(rs.getString("TheoThang"));
                d.setTongTien(rs.getDouble("TongTien"));
                list.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<doanhthu> findDoanhThuTheoNgay(String tuNgay, String denNgay) {
        List<doanhthu> list = new ArrayList<>();
        String sql = """
            SELECT FORMAT(NgayLap, 'dd/MM/yyyy') AS TheoNgay, SUM(TongTien) AS TongTien
            FROM HoaDon
            WHERE NgayLap BETWEEN ? AND ?
            GROUP BY FORMAT(NgayLap, 'dd/MM/yyyy')
            ORDER BY MIN(NgayLap)
        """;
        try (ResultSet rs = UJdbc.executeQuery(sql, tuNgay, denNgay)) {
            while (rs.next()) {
                doanhthu d = new doanhthu();
                d.setTheoNgay(rs.getString("TheoNgay"));
                d.setTongTien(rs.getDouble("TongTien"));
                list.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<doanhthu> findDoanhThuTheoNhanVien() {
        List<doanhthu> list = new ArrayList<>();
        String sql = """
            SELECT MaNV, SUM(TongTien) AS TongTien
            FROM HoaDon
            GROUP BY MaNV
        """;
        try (ResultSet rs = UJdbc.executeQuery(sql)) {
            while (rs.next()) {
                doanhthu d = new doanhthu();
                d.setMaNhanVien(rs.getString("MaNV"));
                d.setTongTien(rs.getDouble("TongTien"));
                list.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<doanhthu> findDoanhThuTheoKhachHang() {
        List<doanhthu> list = new ArrayList<>();
        String sql = """
            SELECT kh.MaKH, kh.HoTen AS TenKhachHang, SUM(hd.TongTien) AS TongTien
            FROM HoaDon hd
            JOIN KhachHang kh ON kh.MaKH = hd.MaKH
            GROUP BY kh.MaKH, kh.HoTen
        """;
        try (ResultSet rs = UJdbc.executeQuery(sql)) {
            while (rs.next()) {
                doanhthu d = new doanhthu();
                d.setMaKhachHang(rs.getString("MaKH"));
                d.setTenKhachHang(rs.getString("TenKhachHang"));
                d.setTongTien(rs.getDouble("TongTien"));
                list.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<doanhthu> getDoanhThuTheoNgay(String tuNgay, String denNgay) {
        return findDoanhThuTheoNgay(tuNgay, denNgay);
    }

    public List<doanhthu> getDoanhThuTheoThang(String thang) {
        List<doanhthu> list = new ArrayList<>();
        String sql = """
            SELECT FORMAT(hd.NgayLap, 'MM/yyyy') AS TheoThang, SUM(hd.TongTien) AS TongTien
            FROM HoaDon hd
            WHERE FORMAT(hd.NgayLap, 'MM/yyyy') = ?
            GROUP BY FORMAT(hd.NgayLap, 'MM/yyyy')
        """;
        try (ResultSet rs = UJdbc.executeQuery(sql, thang)) {
            while (rs.next()) {
                doanhthu d = new doanhthu();
                d.setTheoThang(rs.getString("TheoThang"));
                d.setTongTien(rs.getDouble("TongTien"));
                list.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<doanhthu> getDoanhThuTheoThang() {
        return findDoanhThuTheoThang();
    }

    public List<doanhthu> getDoanhThuTheoNhanVien() {
        return findDoanhThuTheoNhanVien();
    }

    public List<doanhthu> getDoanhThuTheoNhanVien(String maNV) {
        List<doanhthu> list = new ArrayList<>();
        String sql = """
            SELECT nv.MaNV, SUM(hd.TongTien) AS TongTien
            FROM HoaDon hd
            JOIN NhanVien nv ON nv.MaNV = hd.MaNV
            WHERE nv.MaNV = ?
            GROUP BY nv.MaNV
        """;
        try (ResultSet rs = UJdbc.executeQuery(sql, maNV)) {
            while (rs.next()) {
                doanhthu d = new doanhthu();
                d.setMaNhanVien(rs.getString("MaNV"));
                d.setTongTien(rs.getDouble("TongTien"));
                list.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<doanhthu> getDoanhThuTheoKhachHang(String maKH) {
        List<doanhthu> list = new ArrayList<>();
        String sql = """
            SELECT kh.MaKH, kh.HoTen AS TenKhachHang, SUM(hd.TongTien) AS TongTien
            FROM HoaDon hd
            JOIN KhachHang kh ON kh.MaKH = hd.MaKH
            WHERE kh.MaKH = ?
            GROUP BY kh.MaKH, kh.HoTen
        """;
        try (ResultSet rs = UJdbc.executeQuery(sql, maKH)) {
            while (rs.next()) {
                doanhthu d = new doanhthu();
                d.setMaKhachHang(rs.getString("MaKH"));
                d.setTenKhachHang(rs.getString("TenKhachHang"));
                d.setTongTien(rs.getDouble("TongTien"));
                list.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<doanhthu> getDoanhThuTheoKhachHang() {
        return findDoanhThuTheoKhachHang();
    }
}
