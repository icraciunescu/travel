package ro.sda.travel.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ro.sda.travel.core.entity.Client;
import ro.sda.travel.core.service.ClientService;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    public Client createClient(Client client) {
        return clientService.createClient(client);
    }

//    public Client getClientById(int id) {
//        return clientService.getClientById(client.getId());
//
//    }

}
