package com.example.inventory;

import com.example.inventory.model.Product;
import com.example.inventory.repository.InMemoryProductRepository;
import com.example.inventory.service.ProductService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class InventoryUI {

    private ProductService service;
    private DefaultTableModel tableModel;

    public InventoryUI() {
        service = new ProductService(new InMemoryProductRepository());
        createUI();
    }

    private void createUI() {
        JFrame frame = new JFrame("Inventory Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Table to display products
        String[] columns = {"ID", "Name", "Quantity", "Price"};
        tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        // Panel for adding products
        JPanel inputPanel = new JPanel();
        JTextField nameField = new JTextField(10);
        JTextField qtyField = new JTextField(5);
        JTextField priceField = new JTextField(5);
        JButton addButton = new JButton("Add Product");

        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Qty:"));
        inputPanel.add(qtyField);
        inputPanel.add(new JLabel("Price:"));
        inputPanel.add(priceField);
        inputPanel.add(addButton);

        frame.add(inputPanel, BorderLayout.NORTH);

        // Add product button action
        addButton.addActionListener((ActionEvent e) -> {
            try {
                String name = nameField.getText();
                int qty = Integer.parseInt(qtyField.getText());
                double price = Double.parseDouble(priceField.getText());
                Product p = service.addProduct(name, qty, price);
                updateTable();
                nameField.setText("");
                qtyField.setText("");
                priceField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid number format", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.setVisible(true);
    }

    private void updateTable() {
        tableModel.setRowCount(0); // clear table
        List<Product> products = service.getAll();
        for (Product p : products) {
            tableModel.addRow(new Object[]{p.getId(), p.getName(), p.getQuantity(), p.getPrice()});
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InventoryUI::new);
    }
}
