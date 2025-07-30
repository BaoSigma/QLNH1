package DAO.impl;

import Model.ModelChart;
import Model.doanhthu;
import Util.UJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DoanhThuImpl {

    // Lấy tháng có doanh thu cao nhất
    public List<doanhthu> getDoanhThuTheoThang() {
        List<doanhthu> list = new ArrayList<>();
        String sql = """
            SELECT TOP 1
                FORMAT(NgayLap, 'MM/yyyy') AS TheoThang,
                SUM(TongTien) AS TongTien
            FROM HoaDon
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

    // Lấy ngày có doanh thu cao nhất trong tuần hiện tại
    public List<doanhthu> getNgayCaoNhat() {
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

    // Lấy nhân viên có doanh thu cao nhất
    public List<doanhthu> getDoanhThuTheoNhanVien() {
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

    // Lấy khách hàng có doanh thu cao nhất
    public List<doanhthu> getDoanhThuTheoKhachHang() {
        List<doanhthu> list = new ArrayList<>();
        String sql = """
           SELECT TOP 1
                kh.MaKH,
                kh.HoTen AS TenKhachHang,
                SUM(hd.TongTien) AS TongTien
            FROM HoaDon hd
            JOIN KhachHang kh ON hd.MaKH = kh.MaKH
            GROUP BY kh.MaKH, kh.HoTen
            ORDER BY SUM(hd.TongTien) DESC
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

    // Dữ liệu biểu đồ line: 4 loại doanh thu theo tháng
public List<ModelChart> getRevenue_byAll_byMonth() {
    List<ModelChart> list = new ArrayList<>();

    String sqlThang = """
        SELECT FORMAT(NgayLap, 'MM/yyyy') AS Thang,
               SUM(TongTien) AS TongThang
        FROM HoaDon
        WHERE NgayLap >= DATEADD(MONTH, -5, GETDATE())
        GROUP BY FORMAT(NgayLap, 'MM/yyyy')
        ORDER BY MIN(NgayLap)
    """;

    String sqlNgay = """
        SELECT FORMAT(NgayLap, 'MM/yyyy') AS Thang,
               MAX(TongTien) AS TongNgay
        FROM HoaDon
        WHERE NgayLap >= DATEADD(MONTH, -5, GETDATE())
        GROUP BY FORMAT(NgayLap, 'MM/yyyy')
    """;

    String sqlNV = """
        SELECT FORMAT(NgayLap, 'MM/yyyy') AS Thang,
               MAX(TongTien) AS TongNV
        FROM HoaDon
        WHERE NgayLap >= DATEADD(MONTH, -5, GETDATE())
        GROUP BY FORMAT(NgayLap, 'MM/yyyy')
    """;

    String sqlKH = """
        SELECT FORMAT(NgayLap, 'MM/yyyy') AS Thang,
               MAX(TongTien) AS TongKH
        FROM HoaDon
        WHERE NgayLap >= DATEADD(MONTH, -5, GETDATE())
        GROUP BY FORMAT(NgayLap, 'MM/yyyy')
    """;

    try (
        ResultSet rsThang = UJdbc.executeQuery(sqlThang);
        ResultSet rsNgay  = UJdbc.executeQuery(sqlNgay);
        ResultSet rsNV    = UJdbc.executeQuery(sqlNV);
        ResultSet rsKH    = UJdbc.executeQuery(sqlKH)
    ) {
        Map<String, Double> mapNgay = new HashMap<>();
        Map<String, Double> mapNV   = new HashMap<>();
        Map<String, Double> mapKH   = new HashMap<>();

        while (rsNgay.next()) {
            mapNgay.put(rsNgay.getString("Thang"), rsNgay.getDouble("TongNgay"));
        }
        while (rsNV.next()) {
            mapNV.put(rsNV.getString("Thang"), rsNV.getDouble("TongNV"));
        }
        while (rsKH.next()) {
            mapKH.put(rsKH.getString("Thang"), rsKH.getDouble("TongKH"));
        }

        while (rsThang.next()) {
            String thang = rsThang.getString("Thang");
            double doanhThuThang = rsThang.getDouble("TongThang");
            double doanhThuNgay  = mapNgay.getOrDefault(thang, 0.0);
            double doanhThuNV    = mapNV.getOrDefault(thang, 0.0);
            double doanhThuKH    = mapKH.getOrDefault(thang, 0.0);

            list.add(new ModelChart(thang, new double[]{
                doanhThuThang, doanhThuNgay, doanhThuNV, doanhThuKH
            }));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return list;
}

}
