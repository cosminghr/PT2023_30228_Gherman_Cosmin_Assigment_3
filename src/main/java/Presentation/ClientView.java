package Presentation;

import MyException.Failed;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * fereastra secundara, fereastrea clientilor din baza de date
 */
public class ClientView extends Component {

    private JTextField idField;
    private JButton viewButton;
    private JButton deleteButton;
    private JButton findButton;
    private JButton updateButton;
    private JButton insertButton;
    private JButton backButton;
    private DefaultTableModel tableModel;
    private JFrame frame;
    private JTextField numeField;
    private JTextField adresaField;
    private JTextField emailField;
    private JTextField telefonField;
    private JTable table;
    private JScrollPane scrollPane;

    public ClientView() {
        initialize();
        frame.setVisible(true);
    }


    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(243, 222, 186));
        frame.setBounds(100, 100, 724, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel clientsTitle = new JLabel("CLIENTS MANAGEMENT");
        clientsTitle.setHorizontalAlignment(SwingConstants.CENTER);
        clientsTitle.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 25));
        clientsTitle.setBounds(143, 22, 397, 28);
        frame.getContentPane().add(clientsTitle);

        JLabel numeLabel = new JLabel("Nume:");
        numeLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
        numeLabel.setBounds(10, 77, 51, 28);
        frame.getContentPane().add(numeLabel);

        JLabel adresaLabel = new JLabel("Adresa:");
        adresaLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
        adresaLabel.setBounds(10, 154, 51, 21);
        frame.getContentPane().add(adresaLabel);

        JLabel telefonLabel = new JLabel("Telefon:");
        telefonLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
        telefonLabel.setBounds(10, 309, 60, 21);
        frame.getContentPane().add(telefonLabel);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
        emailLabel.setBounds(10, 235, 42, 21);
        frame.getContentPane().add(emailLabel);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
        idLabel.setBounds(10, 450, 42, 21);
        frame.getContentPane().add(idLabel);

        numeField = new JTextField();
        numeField.setBounds(69, 85, 193, 19);
        numeField.setBackground(new Color(171, 196, 170));
        frame.getContentPane().add(numeField);
        numeField.setColumns(10);

        adresaField = new JTextField();
        adresaField.setColumns(10);
        adresaField.setBackground(new Color(171, 196, 170));
        adresaField.setBounds(69, 158, 193, 19);
        frame.getContentPane().add(adresaField);

        emailField = new JTextField();
        emailField.setColumns(10);
        emailField.setBackground(new Color(171, 196, 170));
        emailField.setBounds(69, 239, 193, 19);
        frame.getContentPane().add(emailField);

        telefonField = new JTextField();
        telefonField.setColumns(10);
        telefonField.setBackground(new Color(171, 196, 170));
        telefonField.setBounds(69, 313, 193, 19);
        frame.getContentPane().add(telefonField);

        idField = new JTextField();
        idField.setColumns(10);
        idField.setBackground(new Color(171, 196, 170));
        idField.setBounds(45, 453, 84, 21);
        frame.getContentPane().add(idField);

        viewButton = new JButton("VIEW CLIENTS");
        viewButton.setBackground(new Color(169, 144, 126));
        viewButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
        viewButton.setBounds(10, 362, 119, 21);
        frame.getContentPane().add(viewButton);


        deleteButton = new JButton("DELETE CLIENT");
        deleteButton.setBackground(new Color(169, 144, 126));
        deleteButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
        deleteButton.setBounds(143, 401, 119, 21);
        frame.getContentPane().add(deleteButton);

        findButton = new JButton("GASESTE CLIENT");
        findButton.setBackground(new Color(169, 144, 126));
        findButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 10));
        findButton.setBounds(143, 453, 119, 21);
        frame.getContentPane().add(findButton);



        table = new JTable();
        table.setBounds(278, 72, 422, 417);
        frame.getContentPane().add(table);

        updateButton = new JButton("UPDATE CLIENT");
        updateButton.setBackground(new Color(169, 144, 126));
        updateButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
        updateButton.setBounds(143, 362, 119, 21);
        frame.getContentPane().add(updateButton);

        insertButton = new JButton("INSERT CLIENT");
        insertButton.setBackground(new Color(169, 144, 126));
        insertButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
        insertButton.setBounds(10, 401, 119, 21);
        frame.getContentPane().add(insertButton);


        backButton = new JButton("BACK");
        backButton.setBackground(new Color(169, 144, 126));
        backButton.setBounds(615, 492, 85, 21);
        frame.getContentPane().add(backButton);
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public JTextField getIdField() {
        return idField;
    }

    public void setIdField(JTextField idField) {
        this.idField = idField;
    }

    public JButton getViewButton() {
        return viewButton;
    }


    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JTextField getNumeField() {
        return numeField;
    }

    public void setNumeField(JTextField numeField) {
        this.numeField = numeField;
    }

    public JTextField getAdresaField() {
        return adresaField;
    }

    public void setAdresaField(JTextField adresaField) {
        this.adresaField = adresaField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public void setEmailField(JTextField emailField) {
        this.emailField = emailField;
    }

    public JTextField getTelefonField() {
        return telefonField;
    }

    public void setTelefonField(JTextField telefonField) {
        this.telefonField = telefonField;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }

    public JButton getFindButton() {
        return findButton;
    }

    public void setFindButton(JButton findButton) {
        this.findButton = findButton;
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


    public void addTable(JTable clientsTable) {
        scrollPane = new JScrollPane(table);
        table.setModel(clientsTable.getModel());
        scrollPane.setBounds(278, 72, 422, 417);;
        table.setGridColor(new Color(171, 196, 170));

        scrollPane.setViewportView(table);
        frame.add(scrollPane);
    }

    public void displayErrorMessage(Failed exception) {
        if (exception != null) {
            String message = exception.getMessage();
            JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void displayInformationMessage(String s) {
        if (!s.isEmpty()) {
            JOptionPane.showMessageDialog(this, s, "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
