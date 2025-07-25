/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.impl;
import DAO.ModelDAO.KhuVucDAO;
import Model.KhuVuc;
import Model.NhanVien;

import Util.UJdbc;
import Util.UQuery;
import java.util.List;
import java.sql.ResultSet;
/**
 *
 * @author Admin
 */
public class KhuVucImp implements KhuVucDAO{
private static final String findall = "SELECT \n" +
"    kv.maKV,\n" +
"    kv.tenKV,\n" +
"FROM KhuVuc kv\n";
    private static final String  createsql= "EXEC sp_ThemVaTraKhuVuc\n" +
"    kv.maKV,\n" +
"    kv.tenKV,\n" ;
    private static final String updatesql = "UPDATE KhuVuc\n" +
"SET\n" +
"    kv.maKV,\n" +
"    kv.tenKV,\n" +
"WHERE maKV = ?;";
    private static final String deletesql = 
    "DELETE FROM KhuVuc WHERE maKV = ?;";

    private static final String findbyid = 
    "SELECT kv.maKV, kv.tenKV" +
    "FROM KhuVuc kv" +
    "WHERE kv.maKV = ?;";    

    @Override
    public KhuVuc create(KhuVuc entity) {
         Object[] values = {
            entity.getMaKV(),
           entity.getTenKV(),
        };
        UJdbc.executeUpdate(createsql, values);
        return entity;
    }

    @Override
    public void update(KhuVuc entity) {
         Object[] values = {
            entity.getMaKV(),
           entity.getTenKV(),
        };
          UJdbc.executeUpdate(updatesql, values);
    }

    @Override
    public void deleteById(Object id) {
        UJdbc.executeUpdate(deletesql, id);    
    }

    @Override
    public List<KhuVuc> findAll() {
          return UQuery.getBeanList(KhuVuc.class, findall);
    }

    @Override
    public KhuVuc findById(Object id) {
       return UQuery.getSingleBean(KhuVuc.class, findbyid, id);
    }
     public List<KhuVuc> findByKeyword(String keyword) {
    String sql = """
        SELECT 
            "    kv.maKV,\n" +
        "    kv.tenKV,\n" +
        "FROM KhuVuc kv\n";
        JOIN VaiTro vt ON nv.MaVaiTro = vt.MaVaiTro
        WHERE kv.maKV LIKE ? 
            OR kv.tenKV LIKE ? 
    """;

    String value = "%" + keyword + "%";
    return UQuery.getBeanList(KhuVuc.class, sql, value, value, value, value, value);
}
}