package ro.sda.travel.core.repository;

import org.springframework.data.repository.CrudRepository;
import ro.sda.travel.core.entity.Client;

public interface ClientRepository extends CrudRepository<Client,Integer> {

}