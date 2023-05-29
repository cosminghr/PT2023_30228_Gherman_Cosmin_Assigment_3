package BusinessLogic;

import BusinessLogic.ClientController;
import BusinessLogic.OrderController;
import BusinessLogic.ProductController;
import Presentation.StarterView;

/**
 * in aceasta clasa se creaza noi actionListener-uri pentru fiecare fereastra secundara a proiectului
 */
public class MainController {

    private StarterView view;

    public MainController(){
        view = new StarterView();
        initializeListeners();

    }

    public void initializeListeners(){
        view.getClientsTable().addActionListener(e -> new ClientController());
        view.getProductsTable().addActionListener(e -> new ProductController());
        view.getOrdersTable().addActionListener(e -> new OrderController());
    }


}