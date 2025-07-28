/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO.ModelDAO;

import DAO.CrudDAO;
import Model.LoaiMon;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author micro
 */
public interface LoaiMonDAO extends CrudDAO<LoaiMon, Object>{
    List<LoaiMon> ma = new ArrayList<>();
            
}