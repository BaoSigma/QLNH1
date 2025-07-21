package Util;

import Model.NhanVien;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UAuth {
    public static NhanVien user = null;
    private static final String FILE_PATH = "login.txt";

    public static void clear() {
        user = null;
        File file = new File(FILE_PATH);
        if (file.exists()) file.delete();
    }

    public static boolean isLogin() {
        return user != null;
    }

    public static boolean is1() {
        return user != null && "Quản lý".equalsIgnoreCase(user.getTenVaiTro());
    }

    public static boolean is2() {
        return user != null && "Nhân viên".equalsIgnoreCase(user.getTenVaiTro());
    }

    public static boolean is3() {
        return user != null && "Phục vụ".equalsIgnoreCase(user.getTenVaiTro());
    }

    public static boolean is4() {
        return user != null && "Bảo vệ".equalsIgnoreCase(user.getTenVaiTro());
    }

    public static void save() {
        if (user == null) return;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(user.getMaNV() != null ? user.getMaNV() : ""); writer.newLine();
            writer.write(user.getHoTen() != null ? user.getHoTen() : ""); writer.newLine();
            writer.write(user.getMatKhau() != null ? user.getMatKhau() : ""); writer.newLine();
            writer.write(user.getEmail() != null ? user.getEmail() : ""); writer.newLine();
            writer.write(Double.toString(user.getLuongCoBan())); writer.newLine();
            writer.write(user.getTenVaiTro() != null ? user.getTenVaiTro() : ""); writer.newLine();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dateStr = (user.getNgaySinh() != null) ? sdf.format(user.getNgaySinh()) : "";
            writer.write(dateStr); writer.newLine();

            writer.write(user.getAnh() != null ? user.getAnh() : ""); writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void load() {
    File file = new File(FILE_PATH);
    if (!file.exists()) {
        user = null;
        return;
    }

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String maNV = reader.readLine();
        String hoTen = reader.readLine();
        String matKhau = reader.readLine();
        String email = reader.readLine();
        String luongStr = reader.readLine();
        double luongCoBan = 0;
        try {
            luongCoBan = Double.parseDouble(luongStr);
        } catch (NumberFormatException e) {
            luongCoBan = 0;
        }

        String tenVaiTro = reader.readLine(); // Đọc đúng dòng vai trò
        String ngaySinhStr = reader.readLine();
        String anh = reader.readLine();

        Date ngaySinh = null;
        try {
            if (ngaySinhStr != null && !ngaySinhStr.isBlank()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                ngaySinh = sdf.parse(ngaySinhStr);
            } else {
                ngaySinh = new Date(); // fallback nếu rỗng
            }
        } catch (ParseException e) {
            ngaySinh = new Date(); // fallback nếu sai định dạng
        }

        // Dùng builder tạo đối tượng NhanVien
        user = NhanVien.builder()
                .MaNV(maNV)
                .HoTen(hoTen)
                .MatKhau(matKhau)
                .Email(email)
                .LuongCoBan(luongCoBan)
                .NgaySinh(ngaySinh)
                .Anh(anh)
                .build();

        // Nếu class VaiTro có setTenVaiTro(), ta gọi lại sau khi build
        if (tenVaiTro != null && !tenVaiTro.isBlank()) {
            user.setTenVaiTro(tenVaiTro);
        }

    } catch (IOException e) {
        e.printStackTrace();
        user = null;
    }
}

}

