/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO.ModelDAO;

import DAO.CrudDAO;
import Model.BanAn;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author micro
 */
public interface BanAnDAO extends CrudDAO<BanAn, Object> {
    List<BanAn> nv = new ArrayList<>();
}
