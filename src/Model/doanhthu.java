package Model;

public class doanhthu {
    private HoaDon hd;
    private NhanVien nv;
    private String theoNgay;  
    private String theoThang; 
    private double tongNgay;
private double tongNhanVien;

public double getTongNgay() { return tongNgay; }
public void setTongNgay(double tongNgay) { this.tongNgay = tongNgay; }

public double getTongNhanVien() { return tongNhanVien; }
public void setTongNhanVien(double tongNhanVien) { this.tongNhanVien = tongNhanVien; }

    public doanhthu() {
        this.hd = new HoaDon();
        this.nv = new NhanVien();
    }

    // Mã hóa đơn
    public String getMaHoaDon() {
        return hd != null ? hd.getMaHD() : null;
    }

    public void setMaHoaDon(String maHoaDon) {
        if (hd == null) hd = new HoaDon();
        hd.setMaHD(maHoaDon);
    }


    // Tên nhân viên
    public String getTenNhanVien() {
        return nv != null ? nv.getHoTen() : null;
    }

    public void setTenNhanVien(String tenNhanVien) {
        if (nv == null) nv = new NhanVien();
        nv.setHoTen(tenNhanVien);
    }

    // Ngày lập hóa đơn
    public java.util.Date getNgayLap() {
        return hd != null ? hd.getNgayLap() : null;
    }

    public void setNgayLap(java.util.Date ngayLap) {
        if (hd == null) hd = new HoaDon();
        hd.setNgayLap(ngayLap);
    }

    // Tổng tiền
    public double getTongTien() {
        return hd != null ? hd.getTongTien() : 0.0;
    }

    public void setTongTien(double tongTien) {
        if (hd == null) hd = new HoaDon();
        hd.setTongTien(tongTien);
    }

    // Theo ngày
    public String getTheoNgay() {
        return theoNgay;
    }

    public void setTheoNgay(String theoNgay) {
        this.theoNgay = theoNgay;
    }

    // Theo tháng
    public String getTheoThang() {
        return theoThang;
    }

    public void setTheoThang(String theoThang) {
        this.theoThang = theoThang;
    }


    // Mã NV
    public String getMaNhanVien() {
        return nv.getMaNV();
    }

    public void setMaNhanVien(String maNhanVien) {
        nv.setMaNV(maNhanVien);
    }
}
