/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalTime;

/**
 *
 * @author baoha
 */
public class DatBanINFOR {
    
    public String tenKH ;
    public BanAn ba = new BanAn();
    public NhanVien nv = new NhanVien();
    public ChiTietDatBan ctdb = new ChiTietDatBan();
    public MonAn ma = new MonAn();
    public HoaDon hd = new HoaDon();
    public DatBan db = new DatBan();
    public ChiTietHoaDon cthd = new ChiTietHoaDon();



public String getMaBan() {
    return ba.getMaBan();
}

public java.util.Date getNgayDat() {
    return db.getNgayDat();
}

public LocalTime getGioDat() {
    return db.getGioDat();
}

public int getSoNguoi() {
    return db.getSoNguoi();
}

public String getMaNV() {
    return nv.getMaNV();
}

public String getHTTT() {
    return hd.getHinhThucTT();
}

public String getMaMon() {
    return ma.getMaMon();
}

public int getSoLuong() {
    return cthd.getSoLuong();
}

public String getGhiChu() {
    return ctdb.getGhiChu();
}

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }


    public DatBanINFOR(String tenKH, String maBan, java.util.Date ngayDat, LocalTime gioDat,
                      int soNguoi, String maNV, String HTTT, String maMon, int soLuong, String ghiChu) {
        this.tenKH=tenKH;
        ba.setMaBan(maBan);
        db.setNgayDat(ngayDat);
        db.setGioDat(gioDat);
        db.setSoNguoi(soNguoi);
        nv.setMaNV(maNV);
        hd.setHinhThucTT(HTTT);
        ma.setMaMon(maMon);
        cthd.setSoLuong(soLuong);
        ctdb.setGhiChu(ghiChu);
    }
}
