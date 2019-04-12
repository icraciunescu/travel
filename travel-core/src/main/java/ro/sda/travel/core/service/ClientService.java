package ro.sda.travel.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.travel.core.repository.ClientRepository;
import ro.sda.travel.core.entity.Client;

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

    public Client updateClient(int id, String newName, String newMail, String newTelephone) {
        Client clientFromDb = getClientById(id);
        clientFromDb.setName(newName);
        clientFromDb.setEmail(newMail);
        clientFromDb.setTelephone(newTelephone);
        return clientRepository.save(clientFromDb);
    }

    public void deleteClient(int id) {
        clientRepository.delete(id);
    }

    public Iterable<Client> getAllClient() {
        return clientRepository.findAll();
    }
}

