package ro.sda.travel.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ro.sda.travel.core.entity.Client;
import ro.sda.travel.core.service.ClientService;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    public Client createClient(Client client) {
        return clientService.createClient(client);
    }

    public Client getClientById(int id) {
        return clientService.getClientById((id));

    }

    public List<Client> getAllClient() {
        return clientService.getAllClient();
    }

    public Client updateClient(int id, String newName, String newMail, String newTelephone) {
        return clientService.updateClient(id, newName, newMail, newTelephone);
    }

    public void deleteClient(int id) {
        clientService.deleteClient(id);
    }

}
