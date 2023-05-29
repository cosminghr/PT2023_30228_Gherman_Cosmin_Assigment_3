package BusinessLogic;

import DataModel.Product;
import Presentation.ProductView;
import MyException.Failed;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * in aceasta clasa pentru fiecare buton al clasei ProductView se va genera un actionListener care va realiza toate interogarile cerute
 */
public class ProductController {
    private ProductView view;
    private ProductBll product;

    public ProductController() {
        view = new ProductView();
        product = new ProductBll();
        initializeListeners();
    }

    private void initializeListeners() {

        view.getInsertButton().addActionListener(e -> {
            try {
                int cantitate = Integer.parseInt(view.getCantitateProdField().getText());
                float pret = Float.parseFloat(view.getPretProdField().getText());
                Product p = new Product(view.getNumeProdField().getText(), cantitate, pret);
                List<Product> products = product.findAll();
                product.insertProduct(p);
                view.displayInformationMessage("Produsul a fost adaugat in baza de date.");
            } catch (Failed message) {
                view.displayErrorMessage(message);
            }
        });

        view.getUpdateButton().addActionListener((e -> {
            int id = Integer.parseInt(view.getIdField().getText());
            try {
                Product p = new Product(view.getNumeProdField().getText(), Integer.parseInt(view.getCantitateProdField().getText()), Float.parseFloat(view.getPretProdField().getText()));
                product.updateProduct(p, id);
                view.displayInformationMessage("Datele despre produs au fost schimbate");
            } catch (IndexOutOfBoundsException exception) {
                view.displayErrorMessage(new Failed("Nu mai exista in baza de date produsul cu id-ul " + id));
            } catch (NumberFormatException exception) {
                view.displayInformationMessage("Cantitatea trebuie sa fie un numar!!");
            }
        }));

        view.getViewProd().addActionListener(e -> {
            List<Product> products = product.getProduct().findAll();
            System.out.println(products);
            JTable productsTable = product.getProduct().createTable(products);
            view.addTable(productsTable);
        });

        view.getDeleteButton().addActionListener(e -> {
            int id = Integer.parseInt(view.getIdField().getText());
            try {
                product.deleteProduct(id);
                view.displayInformationMessage("Produsul a fost sters din baza de date");
            } catch (IndexOutOfBoundsException exception) {
                view.displayErrorMessage(new Failed("Nu mai exista in baza de date produsul cu id-ul " + id));
            } catch (NumberFormatException exception) {
                view.displayInformationMessage("ID trebuie sa fie un numar!!");
            }
        });

        view.getGasesteButton().addActionListener(e -> {
            int id = Integer.parseInt(view.getIdField().getText());
            try {
                List<Product> products = new ArrayList<>();
                Product p = product.getProduct().findById(id);
                products.add(p);
                JTable productsTable = product.getProduct().createTable(products);
                view.addTable(productsTable);
            } catch (IndexOutOfBoundsException exception) {
                view.displayErrorMessage(new Failed("Nu mai exista in baza de date produsul cu id-ul " + id));
            }
        });

        view.getBackButton().addActionListener(e -> {
            view.getFrame().dispose();
        });
    }
}