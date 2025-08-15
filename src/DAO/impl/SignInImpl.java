/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.impl;

import DAO.ModelDAO.SignInDAO;
import Model.NhanVien;
import Util.UJdbc;
import Util.UQuery;
import java.util.List;

/**
 *
 * @author baoha
 */
public class SignInImpl implements SignInDAO{
    private static final String createsql = "UPDATE NhanVien\n" +
            "SET \n" +
            "    MatKhau = ?,\n" +
            "    Email = ?,\n" +
            "    NgaySinh = ?\n" +
            "WHERE MaNV = ?";
    private static final String sqlFind = "SELECT * FROM NhanVien";
    private static final String sqlfindid = sqlFind + "Where MaNV = ?";
    @Override
    public NhanVien create(NhanVien entity) {
       return entity;
    }

    @Override
    public void update(NhanVien entity) {
         Object[] values = {
            entity.getMatKhau(),
            entity.getEmail(),
            entity.getNgaySinh(),
            entity.getMaNV()
        };
        UJdbc.executeUpdate(createsql, values);

    }

    @Override
    public void deleteById(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<NhanVien> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public NhanVien findById(Object id) {
        return UQuery.getSingleBean(NhanVien.class, sqlFind);
    }
    
}
