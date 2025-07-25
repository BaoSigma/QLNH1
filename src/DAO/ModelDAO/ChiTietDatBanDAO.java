/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO.ModelDAO;

import DAO.CrudDAO;
import Model.ChiTietDatBan;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author micro
 */
public interface ChiTietDatBanDAO extends CrudDAO<ChiTietDatBan, Object> {
    List<ChiTietDatBan> nv = new ArrayList<>();
}
