package DataModel;


public class Clients {
    private int ID;
    private String nume;
    private String adresa;
    private String email;

    private int telefon;

    public Clients(){

    }

    public Clients(int id, String nume, String adresa, String email, int nrPhone) {
        this.ID = id;
        this.nume = nume;
        this.adresa = adresa;
        this.email = email;
        this.telefon = nrPhone;
    }
    public Clients(String nume, String adresa, String email, int nrPhone) {
        this.nume = nume;
        this.adresa = adresa;
        this.email = email;
        this.telefon = nrPhone;
    }


    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }



}