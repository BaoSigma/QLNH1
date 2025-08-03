/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;
import java.sql.Time;
import java.time.LocalTime;

/**
 *
 * @author Admin
 */
public class DatBan {
    private String maDat;
    private KhachHang kh = new KhachHang();
    private BanAn b = new BanAn();
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

    public DatBan() {
    }

    public String getMaDat() {
        return maDat;
    }

    public void setMaDat(String maDat) {
        this.maDat = maDat;
    }

    public String getMaKH() {
        return kh.getMaKH();
    }

    public void setMaKH(String maKH) {
        kh.setMaKH(maKH);
    }

    public String getMaBan() {
        return b.getMaBan();
    }

    public void setMaBan(String maBan) {
        b.setMaBan(maBan);
    }

    public java.util.Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(java.util.Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public LocalTime getGioDat() {
        return gioDat;
    }

    public void setGioDat(LocalTime gioDat) {
        this.gioDat = gioDat;
    }

    public int getSoNguoi() {
        return soNguoi;
    }

    public void setSoNguoi(int soNguoi) {
        this.soNguoi = soNguoi;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

}