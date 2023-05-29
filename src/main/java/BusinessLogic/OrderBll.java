package BusinessLogic;

import DataAccess.ClientDAO;
import DataAccess.OrderDAO;
import DataAccess.ProductDAO;
import DataModel.Bill;
import DataModel.Clients;
import DataModel.Order;
import DataModel.Product;
import MyException.Failed;

import java.util.ArrayList;

/**
 * Clasa in care se apeleaza metodele delete, update, insert scrise in DAO
 */
public class OrderBll {
    private OrderDAO order;
    private ClientDAO client;
    private ProductDAO product;

    private Bill bill;

    public OrderBll(){
        bill = new Bill();
        order = new OrderDAO();
        client = new ClientDAO();
        product = new ProductDAO();
    }

    /**
     * pentru fiecare comanda se va cunoaste si produsul si clientul care au generat comanda si daca cantiatea ceruta in comanda este mai mica decat stoc ul, se va realiza insert ul.
     * Aici se apeleaza si metoda din clasa Bill pentru generarea unui fisier .txt cu detaliile unei facturi.
     * @param o -> order ul
     * @return order ul
     */
    public Order insertOrder(Order o){
        Product p = (Product) product.findById(o.getIdProdus());
        Clients c = (Clients) client.findById(o.getIdClient());

        if(p.getCantitate() < o.getCantitate() && p.getCantitate() != 0)
            throw new Failed("Nu sunt destule produse disponibile in stoc");
        if(p.getCantitate() == 0){
            throw new Failed("Nu mai sunt produse in stoc!");
        }
        int nouaCantitate = p.getCantitate() - o.getCantitate();
        p.setCantitate(nouaCantitate);
        product.update(p);
        ArrayList<Order> orders = (ArrayList<Order>) order.findAll();
        bill.generateBill(o,p,c);

        return (Order) order.insert(o);
    }

    /**
     * se genereaza metoda de delete dupa un anumit id al unei comenzi care daca va fi gasita, o sa fie stearsa
     * @param id
     */
    public void deleteOrder(int id) {
        Order o = order.findById(id);
        Product p = product.findById(o.getIdProdus());
        if( p != null) {
            int nouaCantitate = p.getCantitate() + o.getCantitate();
            p.setCantitate(nouaCantitate);
            product.update(p);
            order.delete(o);
        }else{
            order.delete(o);
        }
    }

    /**
     * se updateaza order-ul de la id ul cautat, cu valorile din order-ul nou
     * @param o comanda
     * @param id id-ul cautat
     */
    public void updateOrder(Order o, int id){
        Order existentOrder = order.findById(id);
        if (existentOrder == null)
            throw new Failed("Comanda cu id="+id+" nu exista in baza de date.");
        o.setID(id);
        Product p = product.findById(o.getIdProdus());
        if (p.getCantitate() + existentOrder.getCantitate() < o.getCantitate()) {
            throw new Failed("Cantitatea de "+p.getNume()+" ceruta este mai mare decat stocul pe care il avem");
        }
        int nouaCantitate = p.getCantitate() + existentOrder.getCantitate() - o.getCantitate();
        p.setCantitate(nouaCantitate);
        product.update(p);
        order.update(o);
    }

    public OrderDAO getOrder() {
        return order;
    }

    public void setOrder(OrderDAO order) {
        this.order = order;
    }

    public ClientDAO getClient() {
        return client;
    }

    public void setClient(ClientDAO client) {
        this.client = client;
    }

    public ProductDAO getProduct() {
        return product;
    }

    public void setProduct(ProductDAO product) {
        this.product = product;
    }

}
