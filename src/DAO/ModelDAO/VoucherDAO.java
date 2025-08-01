/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO.ModelDAO;

import DAO.CrudDAO;
import Model.voucher;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public interface VoucherDAO extends CrudDAO<voucher, Object>{
    List<voucher> vc = new ArrayList<>();           
}
