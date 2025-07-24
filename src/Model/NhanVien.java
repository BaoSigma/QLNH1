package Model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor // Lombok constructor đầy đủ
public class NhanVien {
    private String MaNV;
    private String HoTen;
    private String MatKhau;
    private String Email;
    private double LuongCoBan;
    private Date NgaySinh;
    private String Anh;
    private VaiTro vt = new VaiTro();

    // ✅ Constructor không tham số thủ công (để tránh lỗi khi Lombok không hoạt động)
    public NhanVien() {
    }

    // ✅ Constructor đầy đủ 7 tham số (đã có sẵn)
    public NhanVien(String MaNV, String HoTen, String MatKhau, String Email, double LuongCoBan, Date NgaySinh, String Anh) {
        this.MaNV = MaNV;
        this.HoTen = HoTen;
        this.MatKhau = MatKhau;
        this.Email = Email;
        this.LuongCoBan = LuongCoBan;
        this.NgaySinh = NgaySinh;
        this.Anh = Anh;
    }

    // Vai trò
    public String getTenVaiTro() {
        return vt.getTenVaiTro();
    }

    public void setTenVaiTro(String TenVaiTro) {
        vt.setTenVaiTro(TenVaiTro);
    }

    public int getMaVaiTro() {
        return vt.getMaVaiTro();
    }

    public void setMaVaiTro(int MaVaiTro) {
        vt.setMaVaiTro(MaVaiTro);
    }

    // Getters & setters
    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public double getLuongCoBan() {
        return LuongCoBan;
    }

    public void setLuongCoBan(double LuongCoBan) {
        this.LuongCoBan = LuongCoBan;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getAnh() {
        return Anh;
    }

    public void setAnh(String Anh) {
        this.Anh = Anh;
    }
}
