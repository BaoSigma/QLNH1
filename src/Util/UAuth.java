package Util;

import DAO.ModelDAO.NhanVienDAO;
import DAO.impl.NhanVienImpl;
import Model.NhanVien;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UAuth {
    public static NhanVien user = null;
    private static final String FILE_PATH = "auth.dat";

    public static boolean isLogin() {
        return user != null;
    }

    public static boolean QuanLy() {
    return isLogin() && user.getVt().getMaVaiTro() == 3;
}

public static boolean NhanVien() {
    return isLogin() && user.getVt().getMaVaiTro() == 2;
}

public static boolean KhachHang () {
    return isLogin() && user.getVt().getMaVaiTro() == 1;
}


    public static void save(NhanVien nv) {
        try (PrintWriter pw = new PrintWriter(FILE_PATH)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            pw.println(safe(nv.getMaNV()));
            pw.println(safe(nv.getMatKhau())); // thường là đã mã hóa
            pw.println(safe(nv.getHoTen()));
            pw.println(safe(nv.getEmail()));
            pw.println(safe(nv.getTenVaiTro()));
            pw.println(nv.getNgaySinh() != null ? sdf.format(nv.getNgaySinh()) : "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void load() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String maNV = br.readLine();
            String matKhau = br.readLine();
            String hoTen = br.readLine();
            String email = br.readLine();
            String tenVaiTro = br.readLine();
            String namSinhStr = br.readLine();

            if (safe(maNV).isEmpty() || safe(matKhau).isEmpty()) return;

            NhanVienDAO dao = new NhanVienImpl();
            NhanVien nv = dao.findById(maNV);

            if (nv != null && matKhau.equals(nv.getMatKhau())) {
                nv.setHoTen(hoTen);
                nv.setEmail(email);
                nv.setTenVaiTro(tenVaiTro);

                if (namSinhStr != null && !namSinhStr.isEmpty()) {
                    try {
                        Date ns = new SimpleDateFormat("yyyy-MM-dd").parse(namSinhStr);
                        nv.setNgaySinh(ns);
                    } catch (Exception ignored) {}
                }

                user = nv;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clear() {
        File file = new File(FILE_PATH);
        if (file.exists() && !file.delete()) {
            System.err.println("Không thể xóa file đăng nhập.");
        }
        user = null;
    }

    private static String safe(String s) {
        return s == null ? "" : s.trim();
    }
}
