package BusinessLogic.Validators;

import BusinessLogic.ClientBll;
import DataModel.Clients;
import MyException.Failed;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.regex.Pattern;

/**
 * clasa in care se implementeaza validatorul pentru numarul de telefon
 */
public class TelephoneValidator {
    private ClientBll client = new ClientBll();
    private static final String EMAIL_PATTERN = "^7[0-9]{8}$";

    /**
     * prima metoda verifica daca numarul de telefon mai este cumva la alta persoana asociat si daca este valid din punct de vedere al sintaxei
     * @param t clientul
     * @throws SQLIntegrityConstraintViolationException in cazul in care este un client cu acelasi numar de telefon in baza de date, se va arunca aceasta exceptie
     */
    public void validateForInsert(Clients t) throws SQLIntegrityConstraintViolationException {
        String telefon = String.valueOf(t.getTelefon());
        List<Clients> clients = client.getClientDAO().findAll();
        int telefonFound = 1;
        for (Clients c : clients) {
            if (c.getTelefon() == t.getTelefon()) {
                telefonFound = 0;
                break;
            }
        }
        if (telefonFound == 0) {
            throw new Failed("Acelasi numar de telefon!");

        }
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        if (!pattern.matcher((telefon)).matches()) {
            throw new Failed("Numarul de telefon nu este valid!");
        }
    }

    /**
     *  verifica sintaxa numarului de telefon
     * @param t clientul
     */
        public void validateForUpdate(Clients t){
            String telefon = String.valueOf(t.getTelefon()); Pattern pattern = Pattern.compile(EMAIL_PATTERN);
            if (!pattern.matcher((telefon)).matches()) {
                throw new Failed("Numarul de telefon nu este valid!");
            }


        }
    }

