package Presentation;

import DataAccess.ClientDAO;
import DataAccess.ProductDAO;
import DataModel.Clients;
import DataModel.Product;
import MyException.Failed;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * fereastra secundara, fereastrea comenzilor din baza de date
 */
public class OrderView {

    private ClientDAO clientDAO = new ClientDAO();
    private ProductDAO productDAO = new ProductDAO();
    private JFrame frame;
    private JComboBox idClientBox;
    private JComboBox idProdusBox;
    private JTextField cantitateField;

    private JTextField idField;
    private JTable table;
    private JButton viewOrderButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton insertButton;
    private JButton gasesteButton;
    private JButton backButton;

    public OrderView() {
        initialize();
        frame.setVisible(true);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(243, 222, 186));
        frame.setBounds(100, 100, 725, 551);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel orderTitle = new JLabel("ORDERS MANAGEMENT");
        orderTitle.setHorizontalAlignment(SwingConstants.CENTER);
        orderTitle.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 25));
        orderTitle.setBounds(147, 26, 397, 28);
        frame.getContentPane().add(orderTitle);

        JLabel cantitateLabel = new JLabel("Cantitate:");
        cantitateLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
        cantitateLabel.setBounds(10, 284, 67, 21);
        frame.getContentPane().add(cantitateLabel);

        JLabel idProdusLabel = new JLabel("IdProdus:");
        idProdusLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
        idProdusLabel.setBounds(10, 190, 67, 28);
        frame.getContentPane().add(idProdusLabel);

        JLabel idClientLabel = new JLabel("IdClient:");
        idClientLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
        idClientLabel.setBounds(10, 91, 58, 28);
        frame.getContentPane().add(idClientLabel);

        List<Clients> clients = clientDAO.findAll();;
        idClientBox = new JComboBox();
        idClientBox.setBackground(new Color(171, 196, 170));
        idClientBox.setBounds(84, 99, 174, 19);
        for(Clients c: clients){
            idClientBox.addItem(c.getID());
        }
        frame.getContentPane().add(idClientBox);

        List<Product> products = productDAO.findAll();
        idProdusBox = new JComboBox();
        idProdusBox.setBackground(new Color(171, 196, 170));
        idProdusBox.setBounds(84, 198, 174, 19);
        for(Product p : products){
            idProdusBox.addItem(p.getID());
        }
        frame.getContentPane().add(idProdusBox);

        cantitateField = new JTextField();
        cantitateField.setColumns(10);
        cantitateField.setBackground(new Color(171, 196, 170));
        cantitateField.setBounds(84, 288, 174, 19);
        frame.getContentPane().add(cantitateField);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
        idLabel.setBounds(10, 462, 42, 21);
        frame.getContentPane().add(idLabel);

        viewOrderButton = new JButton("VIEW ORDER");
        viewOrderButton.setBackground(new Color(169, 144, 126));
        viewOrderButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
        viewOrderButton.setBounds(10, 350, 119, 21);
        frame.getContentPane().add(viewOrderButton);

        updateButton = new JButton("UPDATE ORDER");
        updateButton.setBackground(new Color(169, 144, 126));
        updateButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
        updateButton.setBounds(147, 350, 119, 21);
        frame.getContentPane().add(updateButton);

        insertButton = new JButton("INSERT ORDER");
        insertButton.setBackground(new Color(169, 144, 126));
        insertButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
        insertButton.setBounds(10, 398, 119, 21);
        frame.getContentPane().add(insertButton);

        deleteButton = new JButton("DELETE ORDER");
        deleteButton.setBackground(new Color(169, 144, 126));
        deleteButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
        deleteButton.setBounds(147, 398, 119, 21);
        frame.getContentPane().add(deleteButton);

        gasesteButton = new JButton("GASESTE ORDER");
        gasesteButton.setBackground(new Color(169, 144, 126));
        gasesteButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
        gasesteButton.setBounds(139, 465, 119, 21);
        frame.getContentPane().add(gasesteButton);

        idField = new JTextField();
        idField.setColumns(10);
        idField.setBackground(new Color(171, 196, 170));
        idField.setBounds(40, 465, 76, 21);
        frame.getContentPane().add(idField);

        table = new JTable();
        table.setBounds(276, 91, 425, 395);
        frame.getContentPane().add(table);

        backButton = new JButton("BACK");
        backButton.setBackground(new Color(169, 144, 126));
        backButton.setBounds(616, 496, 85, 21);
        frame.getContentPane().add(backButton);
    }

    public ClientDAO getClientDAO() {
        return clientDAO;
    }

    public void setClientDAO(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JComboBox getIdClientBox() {
        return idClientBox;
    }

    public void setIdClientBox(JComboBox idClientBox) {
        this.idClientBox = idClientBox;
    }

    public JComboBox getIdProdusBox() {
        return idProdusBox;
    }

    public void setIdProdusBox(JComboBox idProdusBox) {
        this.idProdusBox = idProdusBox;
    }

    public JTextField getCantitateField() {
        return cantitateField;
    }

    public void setCantitateField(JTextField cantitateField) {
        this.cantitateField = cantitateField;
    }

    public JTextField getIdField() {
        return idField;
    }

    public void setIdField(JTextField idField) {
        this.idField = idField;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public JButton getViewOrderButton() {
        return viewOrderButton;
    }

    public void setViewOrderButton(JButton viewOrderButton) {
        this.viewOrderButton = viewOrderButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public void setUpdateButton(JButton updateButton) {
        this.updateButton = updateButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }

    public JButton getInsertButton() {
        return insertButton;
    }

    public void setInsertButton(JButton insertButton) {
        this.insertButton = insertButton;
    }

    public JButton getGasesteButton() {
        return gasesteButton;
    }

    public void setGasesteButton(JButton gasesteButton) {
        this.gasesteButton = gasesteButton;
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
            JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void displayInformationMessage(String s) {
        if (!s.isEmpty()) {
            JOptionPane.showMessageDialog(frame, s, "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void addTable(JTable clientsTable) {
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(276, 91, 425, 395);

        clientsTable.setVisible(true);
        clientsTable.setEnabled(true);
        scrollPane.setViewportView(clientsTable);
        frame.add(scrollPane);
    }

}
