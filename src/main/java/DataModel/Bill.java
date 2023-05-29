package DataModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * se implementeaza clasa in care se va crea metoda de generare a facturii
 */
public class Bill {
    /**
     * metoda care se ocupa cu generarea unui fisier .txt in care se vor trece detaliile unui order
     * @param order -> factura
     * @param product -> produsul comandat
     * @param client -> clientul care comanda produsele
     */
    public void generateBill(Order order, Product product, Clients client){
    try{
        File myFile = new File("bill.txt");
        FileWriter myWriter = new FileWriter("bill.txt");
        float totalPrice = product.getPret() * order.getCantitate();
        myWriter.write(" CLIENT NAME: "+client.getNume() + "\n CLIENT ADDRESS: "+ client.getAdresa()+ "\n TELEFON: "+ client.getTelefon() + "\n PRODUCT NAME: "+ product.getNume()+ "\n NUMAR DE PRODUSE: " + order.getCantitate()  + "\n PRET TOTAL: " + totalPrice);
        myWriter.close();
        if (myFile.createNewFile()) {
            System.out.println("File created: " + myFile.getName());
        }
        else {
            System.out.println("Factura a fost creata cu succes");
        }
    } catch (IOException e) {
        System.out.println("An error occurred while processing the bill!");
        e.printStackTrace();
    }
}
}
