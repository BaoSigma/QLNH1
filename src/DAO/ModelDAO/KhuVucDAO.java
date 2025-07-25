/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.ModelDAO;

import DAO.CrudDAO;
import Model.KhuVuc;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Admin
 */
public interface KhuVucDAO extends CrudDAO<KhuVuc, Object>{
    List<KhuVuc> kv = new ArrayList<>();
            
}
