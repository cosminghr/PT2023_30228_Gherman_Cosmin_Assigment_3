package BusinessLogic;

import DataModel.Order;
import Presentation.OrderView;
import MyException.Failed;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * in aceasta clasa pentru fiecare buton al clasei OrderView se va genera un actionListener care va realiza toate interogarile cerute
 */
public class OrderController {
    private OrderView view;
    private OrderBll order;

    public OrderController() {
        view = new OrderView();
        order = new OrderBll();
        initializeListeners();
    }

    private void initializeListeners() {

        view.getViewOrderButton().addActionListener(e -> {
            List<Order> orders = order.getOrder().findAll();
            JTable ordersTable = order.getOrder().createTable(orders);
            view.addTable(ordersTable);
        });

        view.getInsertButton().addActionListener(e -> {
            try {
                int cantitate = Integer.parseInt(view.getCantitateField().getText());
                Order o = new Order(Integer.parseInt(view.getIdClientBox().getSelectedItem().toString()),
                        Integer.parseInt(view.getIdProdusBox().getSelectedItem().toString()),
                        cantitate);
                order.insertOrder(o);
                view.displayInformationMessage("Comanda a fost creata");
            } catch (NumberFormatException exp) {
                view.displayInformationMessage("Cantitatea trebuie sa fie un numar");
            } catch (Failed exception) {
                view.displayErrorMessage(exception);
            }
        });

        view.getUpdateButton().addActionListener(e -> {
            int id = Integer.parseInt(view.getIdField().getText());
            try {
                int cantitate = Integer.parseInt(view.getCantitateField().getText());
                Order o = new Order(Integer.parseInt(view.getIdClientBox().getSelectedItem().toString()), Integer.parseInt(view.getIdProdusBox().getSelectedItem().toString()), cantitate);
                order.updateOrder(o, id);
                view.displayInformationMessage("Comanda a fost schimbata");
            } catch (NumberFormatException ex) {
                view.displayInformationMessage("Cantitatea trebuie sa fie un numar.");
            } catch (IndexOutOfBoundsException exception) {
                view.displayErrorMessage(new Failed("Nu mai exista in baza de date order-ul cu id-ul " + id));
            }
        });
        view.getDeleteButton().addActionListener(e -> {
            int id = Integer.parseInt(view.getIdField().getText());
            try {
                order.deleteOrder(id);
                view.displayInformationMessage("Comanda a fost stearsa");
            } catch (NumberFormatException exp) {
                view.displayInformationMessage("ID trebuie sa fie un numar");
            }catch (IndexOutOfBoundsException exception) {
                view.displayErrorMessage(new Failed("Nu mai exista in baza de date order-ul cu id-ul " + id));
            }
        });

        view.getGasesteButton().addActionListener(e -> {
            int id = Integer.parseInt(view.getIdField().getText());
            try {
                List<Order> orders = new ArrayList<>();
                Order o = order.getOrder().findById(id);
                orders.add(o);
                JTable clientsTable = order.getOrder().createTable(orders);
                view.addTable(clientsTable);
            } catch (NumberFormatException exp) {
                view.displayInformationMessage("ID trebuie sa fie un numar");
            } catch (IndexOutOfBoundsException exception) {
                view.displayErrorMessage(new Failed("Nu mai exista in baza de date order-ul cu id-ul " + id));
            }
        });

        view.getBackButton().addActionListener(e -> {
            view.getFrame().dispose();
        });
    }
}