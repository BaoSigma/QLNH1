/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO.ModelDAO;

import DAO.CrudDAO;
import Model.ChiTietHoaDon;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author micro
 */
public interface ChiTietHoaDonDAO extends CrudDAO<ChiTietHoaDon, Object> {
    List<ChiTietHoaDon> nv = new ArrayList<>();
}
