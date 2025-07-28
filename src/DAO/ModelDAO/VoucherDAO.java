/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO.ModelDAO;

/**
 *
 * @author User
 */
public interface VoucherDAO {
    void capNhatTongChiTieu(String maKH, double tongTien);
    double layTongChiTieu(String maKH);
}
