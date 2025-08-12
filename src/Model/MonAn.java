/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class MonAn  {
    private String maMon;
    private String tenMon;
    private double donGia;
    private String moTa;
    private String HinhAnh;
    public LoaiMon l = new LoaiMon();
    public MonAn(String maMon, String tenMon, double donGia, String moTa, String HinhAnh, int maLoai, String tenLoai, String tenMua) {
       
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.donGia = donGia;
        this.moTa = moTa;
        this.HinhAnh = HinhAnh;
    }
    public String getTenLoai(){
        return l.getTenLoai();
    }
    public void setTenLoai(String TenLoai){
        l.setTenLoai(TenLoai);
    }
    public int getMaLoai(){
        return l.getMaLoai();
    }
    public void setMaLoai(int MaLoai){
        l.setMaLoai(MaLoai);
    }
    public MonAn() {
    }
    public String getMaMon() {
        return maMon;
    }
    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }
    public String getTenMon() {
        return tenMon;
    }
    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }
    public double getDonGia() {
        return donGia;
    }
    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    public String getMoTa() {
        return moTa;
    }
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }



}