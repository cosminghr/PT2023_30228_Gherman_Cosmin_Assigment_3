package BusinessLogic;

import DataAccess.ClientDAO;
import DataModel.Clients;
import MyException.Failed;

import java.util.ArrayList;
/**
 * clasa in care se apeleaza metodele de insert update delete pentru un client
 */
public class ClientBll {
    private ClientDAO client;

    public ClientBll(){

        client = new ClientDAO();
    }

    /**
     * metoda de insert in baza de date a unui client
     * @param c -> cielntul
     * @return clientul inserat
     */
    public Clients insertClient(Clients c){
        ArrayList<Clients> clients = (ArrayList<Clients>) client.findAll();
        return client.insert(c);
    }

    /**
     * cauta clientul dupa id cu findById si ii face update daca il gaseste cu valorile specificate
     * @param c
     * @param id
     */
    public void updateClient(Clients c, int id){
        Clients cExistent = client.findById(id);
        c.setID(id);
        client.update(c);
    }

    /**
     * se cauta dupa id clientul si daca este gasit se va sterge
     * @param id
     */
    public void deleteClient(int id){
        Clients c = client.findById(id);
        client.delete(c);
    }

    public ClientDAO getClientDAO() {
        return client;
    }

    public void setClientDAO(ClientDAO client) {

        this.client = client;
    }

}
