package Presentation;

import MyException.Failed;

import javax.swing.*;
import java.awt.*;

/**
 * fereastra secundara, fereastrea produselor din baza de date
 */
public class ProductView {

    private JFrame frame;

    private JTextField idField;
    private JTextField numeProdField;
    private JTextField cantitateProdField;
    private JTextField pretProdField;
    private JTable table;
    private JButton viewProd;
    private JButton gasesteButton;
    private JButton updateButton;
    private JButton insertButton;
    private JButton deleteButton;
    private JButton backButton;

    public ProductView() {
        initialize();
        frame.setVisible(true);
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(243, 222, 186));
        frame.setBounds(100, 100, 725, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel productsTitle = new JLabel("PRODUCTS MANAGEMENT");
        productsTitle.setHorizontalAlignment(SwingConstants.CENTER);
        productsTitle.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 25));
        productsTitle.setBounds(157, 37, 397, 28);
        frame.getContentPane().add(productsTitle);

        JLabel numeLabel = new JLabel("Nume:");
        numeLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
        numeLabel.setBounds(10, 86, 67, 28);
        frame.getContentPane().add(numeLabel);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
        idLabel.setBounds(10, 449, 42, 18);
        frame.getContentPane().add(idLabel);

        idField = new JTextField();
        idField.setColumns(10);
        idField.setBackground(new Color(171, 196, 170));
        idField.setBounds(47, 451, 79, 21);
        frame.getContentPane().add(idField);


        JLabel cantitateLabel = new JLabel("Cantitate:");
        cantitateLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
        cantitateLabel.setBounds(10, 201, 67, 21);
        frame.getContentPane().add(cantitateLabel);

        JLabel pretLabel = new JLabel("Pret:");
        pretLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
        pretLabel.setBounds(10, 304, 67, 21);
        frame.getContentPane().add(pretLabel);

        numeProdField = new JTextField();
        numeProdField.setBackground(new Color(171, 196, 170));
        numeProdField.setBounds(87, 94, 188, 19);
        frame.getContentPane().add(numeProdField);
        numeProdField.setColumns(10);

        cantitateProdField = new JTextField();
        cantitateProdField.setColumns(10);
        cantitateProdField.setBackground(new Color(171, 196, 170));

        cantitateProdField.setBounds(89, 205, 186, 19);
        frame.getContentPane().add(cantitateProdField);
        pretProdField = new JTextField();
        pretProdField.setColumns(10);
        pretProdField.setBackground(new Color(171, 196, 170));

        pretProdField.setBounds(87, 308, 188, 19);
        frame.getContentPane().add(pretProdField);

        viewProd = new JButton("VIEW PRODUCTS");
        viewProd.setBackground(new Color(169, 144, 126));
        viewProd.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
        viewProd.setBounds(10, 366, 116, 21);
        frame.getContentPane().add(viewProd);

        updateButton = new JButton("UPDATE PROD");
        updateButton.setBackground(new Color(169, 144, 126));
        updateButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
        updateButton.setBounds(159, 366, 116, 21);
        frame.getContentPane().add(updateButton);

        insertButton = new JButton("INSERT PROD");
        insertButton.setBackground(new Color(169, 144, 126));
        insertButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
        insertButton.setBounds(10, 406, 116, 21);
        frame.getContentPane().add(insertButton);

        deleteButton = new JButton("DELETE PROD");
        deleteButton.setBackground(new Color(169, 144, 126));
        deleteButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
        deleteButton.setBounds(159, 406, 116, 21);
        frame.getContentPane().add(deleteButton);

        gasesteButton = new JButton("GASESTE PROD");
        gasesteButton.setBackground(new Color(169, 144, 126));
        gasesteButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
        gasesteButton.setBounds(159, 451, 116, 21);
        frame.getContentPane().add(gasesteButton);

        table = new JTable();
        table.setBounds(307, 96, 394, 390);
        frame.getContentPane().add(table);

        backButton = new JButton("BACK");
        backButton.setBackground(new Color(169, 144, 126));
        backButton.setBounds(616, 492, 85, 21);
        frame.getContentPane().add(backButton);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JTextField getIdField() {
        return idField;
    }

    public void setIdField(JTextField idField) {
        this.idField = idField;
    }

    public JTextField getNumeProdField() {
        return numeProdField;
    }

    public void setNumeProdField(JTextField numeProdField) {
        this.numeProdField = numeProdField;
    }

    public JTextField getCantitateProdField() {
        return cantitateProdField;
    }

    public void setCantitateProdField(JTextField cantitateProdField) {
        this.cantitateProdField = cantitateProdField;
    }

    public JTextField getPretProdField() {
        return pretProdField;
    }

    public void setPretProdField(JTextField pretProdField) {
        this.pretProdField = pretProdField;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public JButton getViewProd() {
        return viewProd;
    }

    public void setViewProd(JButton viewProd) {
        this.viewProd = viewProd;
    }

    public JButton getGasesteButton() {
        return gasesteButton;
    }

    public void setGasesteButton(JButton gasesteButton) {
        this.gasesteButton = gasesteButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public void setUpdateButton(JButton updateButton) {
        this.updateButton = updateButton;
    }

    public JButton getInsertButton() {
        return insertButton;
    }

    public void setInsertButton(JButton insertButton) {
        this.insertButton = insertButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }
    public void displayErrorMessage(Failed exception) {
        if (exception != null) {
            String message = exception.getMessage();
            UIManager UI = new UIManager();
            JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void displayInformationMessage(String s) {
        if (!s.isEmpty()) {
            UIManager UI = new UIManager();
            JOptionPane.showMessageDialog(frame, s, "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void addTable(JTable clientsTable) {
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(307, 96, 394, 390);

        clientsTable.setVisible(true);
        clientsTable.setEnabled(true);
        scrollPane.setViewportView(clientsTable);
        frame.add(scrollPane);
    }

}
