package BusinessLogic;

import BusinessLogic.Validators.EmailValidator;
import BusinessLogic.Validators.TelephoneValidator;
import DataModel.Clients;
import Presentation.ClientView;
import MyException.Failed;

import javax.swing.*;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * in aceasta clasa pentru fiecare buton al clasei ClientView se va genera un actionListener care va realiza toate interogarile cerute
 */
public class ClientController {
    private ClientView view;
    private ClientBll client;

    public ClientController() {
        view = new ClientView();
        client = new ClientBll();
        initializeListeners();
    }

    private void initializeListeners() {

        view.getInsertButton().addActionListener(e -> {
            try {
                EmailValidator emailValidator = new EmailValidator();
                TelephoneValidator telephoneValidator = new TelephoneValidator();
                int telefon = Integer.parseInt(view.getTelefonField().getText());
                Clients c = new Clients(view.getNumeField().getText(), view.getAdresaField().getText(), view.getEmailField().getText(), telefon);
                emailValidator.validateForInsert(c);
                telephoneValidator.validateForInsert(c);

                client.insertClient(c);
                view.displayInformationMessage("S-a realizat cu succes adaugarea clientului");
            } catch (Failed message) {
                view.displayErrorMessage(message);
            } catch (NumberFormatException ex) {
                view.displayInformationMessage("Numarul de telefon nu trebuie sa contina litere sau alte caractere!");
            } catch (SQLIntegrityConstraintViolationException ex) {
                throw new Failed(ex.getMessage());
            }

        });

        view.getUpdateButton().addActionListener((e -> {
            int id = Integer.parseInt(view.getIdField().getText());
            try {
                EmailValidator emailValidator = new EmailValidator();
                TelephoneValidator telephoneValidator = new TelephoneValidator();
                int telefon = Integer.parseInt(view.getTelefonField().getText());
                Clients c = new Clients(view.getNumeField().getText(), view.getAdresaField().getText(), view.getEmailField().getText(), telefon);
                try {
                    emailValidator.validateForUpdate(c);
                    telephoneValidator.validateForUpdate(c);
                    client.updateClient(c, id);
                    view.displayInformationMessage("S-au schimbat datele clientului.");
                } catch (Failed message) {
                    view.displayErrorMessage(message);
                }
            } catch (IndexOutOfBoundsException exception) {
                view.displayErrorMessage(new Failed("Nu mai exista in baza de date clientul cu id-ul " + id));
            } catch (NumberFormatException ex) {
                view.displayInformationMessage("Id-ul trebuie sa fie un numar!");
            }
        }));

        view.getViewButton().addActionListener(e -> {
            List<Clients> clients = client.getClientDAO().findAll();
            JTable clientsTable = client.getClientDAO().createTable(clients);
            view.addTable(clientsTable);
        });


        view.getDeleteButton().addActionListener(e -> {
            int id = Integer.parseInt(view.getIdField().getText());
            try {
                client.deleteClient(id);
                view.displayInformationMessage("Clientul a fost sters din baza de date.");
            } catch (NumberFormatException ex) {
                view.displayInformationMessage("Id-ul trebuie sa fie un numar!");
            } catch (IndexOutOfBoundsException exception) {
                view.displayErrorMessage(new Failed("Nu mai exista in baza de date clientul cu id-ul " + id));
            }
        });

        view.getFindButton().addActionListener(e -> {
            int id = Integer.parseInt(view.getIdField().getText());
            try {
                List<Clients> clients = new ArrayList<>();
                Clients c = client.getClientDAO().findById(id);
                clients.add(c);
                JTable clientsTable = client.getClientDAO().createTable(clients);
                view.addTable(clientsTable);
            } catch (IndexOutOfBoundsException exception) {
                view.displayErrorMessage(new Failed("Nu mai exista in baza de date clientul cu id-ul " + id));
            }
        });

        view.getBackButton().addActionListener(e -> {

            view.getFrame().dispose();
        });
    }


}