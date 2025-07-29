/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author baoha
 */
public class ModelChart {
    private String label;     // Ví dụ: "Tháng 1", "Tháng 2"
    private double value;     // Giá trị doanh thu

    public ModelChart(String label, double value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public double getValue() {
        return value;
    }
}
