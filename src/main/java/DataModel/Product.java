package DataModel;

public class Product {
    private int ID;
    private String nume;
    private int cantitate;
    private float pret;

    public Product(){

    }

    public Product(int id, String nume, int cantitate, float pret) {
        this.ID= id;
        this.nume = nume;
        this.cantitate = cantitate;
        this.pret = pret;
    }
    public Product(String nume, int cantitate, float pret) {
        this.nume = nume;
        this.cantitate = cantitate;
        this.pret = pret;
    }

    public int getID() {
        return ID;
    }

    public void setID(int id) {
        this.ID = id;
    }


    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

}