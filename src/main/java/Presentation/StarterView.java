package Presentation;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

/**
 * fereastra principala a proiectului
 */
public class StarterView {

    private JFrame frame;
    private JButton productsTable;
    private JButton clientsTable;
    private JButton ordersTable;

    public StarterView() {
        initialize();
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JButton getProductsTable() {
        return productsTable;
    }

    public void setProductsTable(JButton productsTable) {
        this.productsTable = productsTable;
    }

    public JButton getClientsTable() {
        return clientsTable;
    }

    public void setClientsTable(JButton clientsTable) {
        this.clientsTable = clientsTable;
    }

    public JButton getOrdersTable() {
        return ordersTable;
    }

    public void setOrdersTable(JButton ordersTable) {
        this.ordersTable = ordersTable;
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(243, 222, 186));
        frame.setBounds(100, 100, 725, 551);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("ORDER MANAGEMENT");
        lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(138, 23, 397, 28);
        frame.getContentPane().add(lblNewLabel);

        clientsTable = new JButton("CLIENTS");
        clientsTable.setBackground(new Color(169, 144, 126));
        clientsTable.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
        clientsTable.setBounds(136, 123, 397, 64);
        frame.getContentPane().add(clientsTable);

        productsTable = new JButton("PRODUCTS");
        productsTable.setBackground(new Color(169, 144, 126));
        productsTable.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
        productsTable.setBounds(138, 254, 397, 64);
        frame.getContentPane().add(productsTable);

        ordersTable = new JButton("ORDERS");
        ordersTable.setBackground(new Color(169, 144, 126));
        ordersTable.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
        ordersTable.setBounds(138, 380, 397, 64);
        frame.getContentPane().add(ordersTable);


    }


}
