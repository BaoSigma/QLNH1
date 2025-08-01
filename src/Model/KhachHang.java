package Model;

public class KhachHang {
    private String maKH;
    private String hoTen;
    private double tongChiTieu;
    private String matKhau;
    private String anh;
    private String email;
    private int maVaiTro;
    private String HangKhach;
    
    // Constructor không tham số
    public KhachHang() {}

    // Constructor đầy đủ

    public KhachHang(String maKH, String hoTen, double tongChiTieu, String matKhau, String anh, String email, int maVaiTro, String HangKhach) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.tongChiTieu = tongChiTieu;
        this.matKhau = matKhau;
        this.anh = anh;
        this.email = email;
        this.maVaiTro = maVaiTro;
        this.HangKhach = HangKhach;
    }
    public void setHangKhach(String hangKhach) {
    this.HangKhach = hangKhach;
}

    // Getter & Setter
    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public double getTongChiTieu() {
        return tongChiTieu;
    }

    public void setTongChiTieu(double tongChiTieu) {
        this.tongChiTieu = tongChiTieu;
    }

    // HangKhach được tính tự động theo TongChiTieu
    public String getHangKhach() {
        if (tongChiTieu >= 60000000) {
            return "Kim Cương";
        } else if (tongChiTieu >= 45000000) {
            return "Vàng";
        } else if (tongChiTieu >= 30000000) {
            return "Bạc";
        } else if (tongChiTieu >= 15000000) {
            return "Thanh toán nhiều";
        } else {
            return "Thường";
        }
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMaVaiTro() {
        return maVaiTro;
    }

    public void setMaVaiTro(int maVaiTro) {
        this.maVaiTro = maVaiTro;
    }
}
