package DAO.impl;

import Model.ModelChart;
import Model.doanhthu;
import Util.UJdbc;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DoanhThuImpl {

    /**
     * Lấy tổng doanh thu của 1 tháng bất kỳ
     * @param thangNam Chuỗi định dạng "MM/yyyy" (ví dụ: "08/2025")
     * @return Tổng doanh thu (double)
     */
    public double getTongDoanhThuTheoThang(String thangNam) {
        String sql = """
            SELECT SUM(TongTien) AS TongTien
            FROM HoaDon
            WHERE FORMAT(NgayLap, 'MM/yyyy') = ?
        """;

        try (ResultSet rs = UJdbc.executeQuery(sql, thangNam)) {
            if (rs.next()) {
                return rs.getDouble("TongTien");
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi lấy tổng doanh thu theo tháng: " + e.getMessage());
        }
        return 0;
    }

    /**
     * Trả về danh sách các tháng có hóa đơn, dùng cho ComboBox
     * @return List<String> danh sách tháng dạng "MM/yyyy"
     */
    public List<String> getDanhSachThang() {
        List<String> list = new ArrayList<>();
        String sql = """
            SELECT FORMAT(NgayLap, 'MM/yyyy') AS Thang
            FROM HoaDon
            WHERE NgayLap IS NOT NULL
            GROUP BY FORMAT(NgayLap, 'MM/yyyy')
            ORDER BY MIN(NgayLap)
        """;

        try (ResultSet rs = UJdbc.executeQuery(sql)) {
            while (rs.next()) {
                list.add(rs.getString("Thang"));
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi lấy danh sách tháng: " + e.getMessage());
        }
        return list;
    }
}
