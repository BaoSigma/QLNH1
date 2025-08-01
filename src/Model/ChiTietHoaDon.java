/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class ChiTietHoaDon {
    private HoaDon hd;
    private MonAn ma;
    private int soLuong;
    private String ghiChu;
    private String trangThai;

   public String getMaHD() {
        return hd.getMaHD();
    }

    public void setMaHD(String maHD) {
        setMaHD(maHD);
    }

    public String getMaMon() {
        return ma.getMaMon();
    }

    public void setMaMon(String maMon) {
        ma.setMaMon(maMon);
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }


}