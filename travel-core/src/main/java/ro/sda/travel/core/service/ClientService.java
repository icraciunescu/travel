package ro.sda.travel.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.travel.core.repository.ClientRepository;
import ro.sda.travel.core.entity.Client;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client getClientById(int id) {
        return clientRepository.findOne(id);
    }

    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    public Client updateClient(Client client) {
        Client clientFromDb = clientRepository.findOne(client.getId());
        return clientRepository.save(clientFromDb);
    }

    public void deleteClient(int id) {
        clientRepository.delete(id);
    }


}

