package Util;

import DAO.ModelDAO.NhanVienDAO;
import Model.NhanVien;

import DAO.impl.NhanVienImpl;
import java.io.*;

public class UAuth {
    public static NhanVien user = null;
    private static final String FILE_PATH = "auth.dat";

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

    public static void save(NhanVien nv) {
        try (PrintWriter pw = new PrintWriter(FILE_PATH)) {
            pw.println(nv.getMaNV());
            pw.println(nv.getMatKhau()); // đã mã hóa sẵn từ DB
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void load() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) return;

            BufferedReader br = new BufferedReader(new FileReader(file));
            String maNV = br.readLine();
            String encryptedPass = br.readLine();
            br.close();

            if (maNV != null && encryptedPass != null) {
                NhanVienDAO dao = new NhanVienImpl();
                NhanVien nv = dao.findById(maNV);
                if (nv != null && encryptedPass.equals(nv.getMatKhau())) {
                    user = nv;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clear() {
        File file = new File(FILE_PATH);
        if (file.exists()) file.delete();
    }
}
