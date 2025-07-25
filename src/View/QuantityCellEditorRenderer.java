package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class QuantityCellEditorRenderer extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {
    private final JPanel panel = new JPanel(new BorderLayout());
    private final JButton btnMinus = new JButton("-");
    private final JButton btnPlus = new JButton("+");
    private final JLabel lblValue = new JLabel("", SwingConstants.CENTER);
    private int row = -1;
    private JTable table;

    public QuantityCellEditorRenderer(JTable table) {
        this.table = table;
    }
    
    public QuantityCellEditorRenderer() {
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(btnMinus);
        buttonPanel.add(btnPlus);
        panel.add(lblValue, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.EAST);

        btnPlus.addActionListener(e -> updateQuantity(1));
        btnMinus.addActionListener(e -> updateQuantity(-1));
    }

    private void updateQuantity(int delta) {
        if (row != -1 && table != null) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            int quantity = Integer.parseInt(model.getValueAt(row, 2).toString());
            quantity = Math.max(1, quantity + delta); // Không cho nhỏ hơn 1
            model.setValueAt(quantity, row, 2);

            // Cập nhật tổng tiền = quantity * đơn giá
            Object priceObj = model.getValueAt(row, 3);
            if (priceObj instanceof Double || priceObj instanceof Integer) {
                double donGia = Double.parseDouble(priceObj.toString()) / (quantity - delta + delta); // tránh lỗi
                model.setValueAt(quantity * donGia, row, 3);
            }

            lblValue.setText(String.valueOf(quantity));
            fireEditingStopped();
        }
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {
        lblValue.setText(value != null ? value.toString() : "1");
        return panel;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,
                                                 int row, int column) {
        this.row = row;
        this.table = table;
        lblValue.setText(value != null ? value.toString() : "1");
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return lblValue.getText();
    }
}
