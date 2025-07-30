package DAO.impl;

import Model.ModelChart;
import Model.doanhthu;
import Util.UJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DoanhThuImpl {

    // 1. Doanh thu theo tháng cao nhất
    public List<doanhthu> getDoanhThuTheoThangCaoNhat() {
        List<doanhthu> list = new ArrayList<>();
        String sql = """
            SELECT TOP 1
                FORMAT(NgayLap, 'MM/yyyy') AS TheoThang,
                SUM(TongTien) AS TongTien
            FROM HoaDon
            WHERE NgayLap IS NOT NULL
            GROUP BY FORMAT(NgayLap, 'MM/yyyy')
            ORDER BY SUM(TongTien) DESC
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

    // 2. Doanh thu theo ngày cao nhất trong tuần
    public List<doanhthu> getDoanhThuNgayCaoNhatTrongTuan() {
        List<doanhthu> list = new ArrayList<>();
        String sql = """
            SELECT TOP 1
                FORMAT(NgayLap, 'dd/MM/yyyy') AS TheoNgay,
                SUM(TongTien) AS TongTien
            FROM HoaDon
            WHERE DATEPART(WEEK, NgayLap) = DATEPART(WEEK, GETDATE())
              AND YEAR(NgayLap) = YEAR(GETDATE())
            GROUP BY FORMAT(NgayLap, 'dd/MM/yyyy')
            ORDER BY SUM(TongTien) DESC
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

    // 3. Nhân viên có doanh thu cao nhất
    public List<doanhthu> getNhanVienDoanhThuCaoNhat() {
        List<doanhthu> list = new ArrayList<>();
        String sql = """
            SELECT TOP 1
                nv.MaNV,
                nv.HoTen AS TenNhanVien,
                SUM(hd.TongTien) AS TongTien
            FROM HoaDon hd
            JOIN NhanVien nv ON hd.MaNV = nv.MaNV
            GROUP BY nv.MaNV, nv.HoTen
            ORDER BY SUM(hd.TongTien) DESC
        """;
        try (ResultSet rs = UJdbc.executeQuery(sql)) {
            while (rs.next()) {
                doanhthu d = new doanhthu();
                d.setMaNhanVien(rs.getString("MaNV"));
                d.setTenNhanVien(rs.getString("TenNhanVien"));
                d.setTongTien(rs.getDouble("TongTien"));
                list.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
public ArrayList<ModelChart> getThongTinDoanhThuTuyChinh() {
    ArrayList<ModelChart> list = new ArrayList<>();
    String sql = """
        SELECT 
            FORMAT(NgayLap, 'MM/yyyy') AS Thang,
            SUM(TongTien) AS TongThang,
            (
                SELECT MAX(TongNgay)
                FROM (
                    SELECT SUM(TongTien) AS TongNgay
                    FROM HoaDon hd2
                    WHERE FORMAT(hd2.NgayLap, 'MM/yyyy') = FORMAT(hd.NgayLap, 'MM/yyyy')
                    GROUP BY CAST(hd2.NgayLap AS DATE)
                ) AS Sub
            ) AS DoanhThuNgayCaoNhat,
            (
                SELECT MAX(TongNV)
                FROM (
                    SELECT SUM(TongTien) AS TongNV
                    FROM HoaDon hd3
                    WHERE FORMAT(hd3.NgayLap, 'MM/yyyy') = FORMAT(hd.NgayLap, 'MM/yyyy')
                    GROUP BY MaNV
                ) AS Sub
            ) AS DoanhThuNVCaoNhat
        FROM HoaDon hd
        WHERE NgayLap >= DATEADD(MONTH, -5, GETDATE())
        GROUP BY FORMAT(NgayLap, 'MM/yyyy')
        ORDER BY MIN(CONVERT(DATE, '01/' + FORMAT(NgayLap, 'MM/yyyy'), 103))
    """;

    try (ResultSet rs = UJdbc.executeQuery(sql)) {
        while (rs.next()) {
            String thang = rs.getString("Thang");
            double tongThang = rs.getDouble("TongThang");
            double tongNgay = rs.getDouble("DoanhThuNgayCaoNhat");
            double tongNV = rs.getDouble("DoanhThuNVCaoNhat");
            
            list.add(new ModelChart(thang, new double[]{tongThang, tongNgay, tongNV}));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}




}
