package DAO.impl;

import Model.ModelChart;
import Model.doanhthu;
import Util.UJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoanhThuImpl {

    public List<ModelChart> getRevenue_byAll_byMonth() {
    List<ModelChart> list = new ArrayList<>();

    String sql = """
        SELECT FORMAT(NgayLap, 'MM/yyyy') AS Thang,
               SUM(TongTien) AS TongThang
        FROM HoaDon
        GROUP BY FORMAT(NgayLap, 'MM/yyyy')
        ORDER BY MIN(NgayLap)
    """;

    String sqlNgay = """
        SELECT FORMAT(NgayLap, 'MM/yyyy') AS Thang,
               SUM(TongTien) AS TongNgay
        FROM HoaDon
        GROUP BY FORMAT(NgayLap, 'MM/yyyy')
    """;

    String sqlNV = """
        SELECT FORMAT(NgayLap, 'MM/yyyy') AS Thang,
               SUM(TongTien) AS TongNV
        FROM HoaDon
        GROUP BY FORMAT(NgayLap, 'MM/yyyy')
    """;

    String sqlKH = """
        
    """;

    try (
        ResultSet rsThang = UJdbc.executeQuery(sql);
        ResultSet rsNgay = UJdbc.executeQuery(sqlNgay);
        ResultSet rsNV   = UJdbc.executeQuery(sqlNV);
        ResultSet rsKH   = UJdbc.executeQuery(sqlKH)
    ) {
        while (rsThang.next()) {
            String thang = rsThang.getString("Thang");
            double doanhThuThang = rsThang.getDouble("TongThang");

            double doanhThuNgay = 0, doanhThuNV = 0, doanhThuKH = 0;

            while (rsNgay.next()) {
                if (thang.equals(rsNgay.getString("Thang"))) {
                    doanhThuNgay = rsNgay.getDouble("TongNgay");
                    break;
                }
            }

            while (rsNV.next()) {
                if (thang.equals(rsNV.getString("Thang"))) {
                    doanhThuNV = rsNV.getDouble("TongNV");
                    break;
                }
            }

            while (rsKH.next()) {
                if (thang.equals(rsKH.getString("Thang"))) {
                    doanhThuKH = rsKH.getDouble("TongKH");
                    break;
                }
            }

            list.add(new ModelChart(
                thang,
                new double[]{doanhThuThang, doanhThuNgay, doanhThuNV, doanhThuKH}
            ));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return list;
}



    public List<doanhthu> getDoanhThuTheoThang() {
        List<doanhthu> list = new ArrayList<>();
        String sql = """
             SELECT
            FORMAT(NgayLap, 'MM/yyyy') AS TheoThang,
            SUM(TongTien) AS TongTien
            FROM HoaDon
            WHERE NgayLap IS NOT NULL
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

    public List<doanhthu> getDoanhThuHomNay() {
    List<doanhthu> list = new ArrayList<>();
    String sql = """
    SELECT FORMAT(NgayLap, 'dd/MM/yyyy') AS TheoNgay, SUM(TongTien) AS TongTien
    FROM HoaDon
    WHERE CAST(NgayLap AS DATE) = CAST(GETDATE() AS DATE)
    GROUP BY FORMAT(NgayLap, 'dd/MM/yyyy')
    """;
    try (ResultSet rs = UJdbc.executeQuery(sql)) {
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

    public List<doanhthu> getDoanhThuTheoNhanVien() {
        List<doanhthu> list = new ArrayList<>();
        String sql = """
            SELECT MaNV, FORMAT(NgayLap, 'MM/yyyy') AS TheoThang, SUM(TongTien) AS TongTien
            FROM HoaDon
            GROUP BY MaNV, FORMAT(NgayLap, 'MM/yyyy')
        """;
        try (ResultSet rs = UJdbc.executeQuery(sql)) {
            while (rs.next()) {
                doanhthu d = new doanhthu();
                d.setMaNhanVien(rs.getString("MaNV"));
                d.setTheoThang(rs.getString("TheoThang"));
                d.setTongTien(rs.getDouble("TongTien"));
                list.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<doanhthu> getDoanhThuTheoKhachHang() {
        List<doanhthu> list = new ArrayList<>();
        String sql = """
            SELECT kh.MaKH, kh.HoTen AS TenKhachHang, FORMAT(hd.NgayLap, 'MM/yyyy') AS TheoThang, SUM(hd.TongTien) AS TongTien
            FROM HoaDon hd
            JOIN KhachHang kh ON kh.MaKH = hd.MaKH
            GROUP BY kh.MaKH, kh.HoTen, FORMAT(hd.NgayLap, 'MM/yyyy')
        """;
        try (ResultSet rs = UJdbc.executeQuery(sql)) {
            while (rs.next()) {
                doanhthu d = new doanhthu();
                d.setMaKhachHang(rs.getString("MaKH"));
                d.setTenKhachHang(rs.getString("TenKhachHang"));
                d.setTheoThang(rs.getString("TheoThang"));
                d.setTongTien(rs.getDouble("TongTien"));
                list.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
