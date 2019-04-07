package ro.sda.travel.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.travel.core.dao.ClientDao;
import ro.sda.travel.core.entity.Client;

@Service
public class ClientService {

    @Autowired
    private ClientDao clientDao;

    public Client createClient(Client client) {
        return clientDao.save(client);
    }

//    public Client getClientById(Client client) {
//        return clientDao.getClitntById(client.getId());
//    }
}
