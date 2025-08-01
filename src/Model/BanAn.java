/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Util.UQuery;
import java.util.List;

/**
 *
 * @author Admin
 */
public class BanAn {
    private String maBan;
    private int soBan;
    private String trangThai;
    private String maKV;
    private DatBan db = new DatBan();
    private KhuVuc kv = new KhuVuc();
    public BanAn(String maBan, int soBan, String trangThai, String maKV) {
        this.maBan = maBan;
        this.soBan = soBan;
        this.trangThai = trangThai;
        this.maKV = maKV;
    }

    public BanAn() {
    }
    public String getTenKV() {
        return kv.getTenKV();
    }
    public void setTenKV(String tenKV) {
        kv.setTenKV(tenKV);
    }
    public String getMaBan() {
        return maBan;
    }
    
    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }
    public java.sql.Date getNgayDat() {
        return db.getNgayDat();
    }

    public void setNgayDat(java.sql.Date ngayDat) {
        db.setNgayDat(ngayDat);
    }

    public java.sql.Time getGioDat() {
        return db.getGioDat();
    }

    public void setGioDat(java.sql.Time gioDat) {
        db.setGioDat(gioDat);
    }

    public int getSoBan() {
        return soBan;
    }

    public void setSoBan(int soBan) {
        this.soBan = soBan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaKV() {
        return maKV;
    }

    public void setMaKV(String maKV) {
        this.maKV = maKV;
    }
    public List<BanAn> findByMaBan(String maBan) {
    String sql = """
        SELECT MaBan, SoBan, TrangThai
        FROM BanAn
        WHERE MaBan = ?;
    """;
    return UQuery.getBeanList(BanAn.class, sql, maBan);
}

}
