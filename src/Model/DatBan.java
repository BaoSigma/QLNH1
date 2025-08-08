package Model;

import java.time.LocalTime;

public class DatBan {
    private String maDat;
    private String tenKH;
    private BanAn b; // ❌ KHÔNG khởi tạo new BanAn()
    private java.util.Date ngayDat;
    private LocalTime gioDat;
    private int soNguoi;
    private String trangThai;

    public DatBan(String maDat, java.util.Date ngayDat, LocalTime gioDat, int soNguoi, String trangThai) {
        this.maDat = maDat;
        this.ngayDat = ngayDat;
        this.gioDat = gioDat;
        this.soNguoi = soNguoi;
        this.trangThai = trangThai;
    }

    public DatBan() {}

    public String getMaDat() { return maDat; }
    public void setMaDat(String maDat) { this.maDat = maDat; }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenK) {
        this.tenKH = tenK;
    }

    public String getMaBan() { return b != null ? b.getMaBan() : null; }
    public void setMaBan(String maBan) {
        if (b == null) b = new BanAn();
        b.setMaBan(maBan);
    }

    public java.util.Date getNgayDat() { return ngayDat; }
    public void setNgayDat(java.util.Date ngayDat) { this.ngayDat = ngayDat; }

    public LocalTime getGioDat() { return gioDat; }
    public void setGioDat(LocalTime gioDat) { this.gioDat = gioDat; }

    public int getSoNguoi() { return soNguoi; }
    public void setSoNguoi(int soNguoi) { this.soNguoi = soNguoi; }

    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }
}
