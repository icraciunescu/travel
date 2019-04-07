package ro.sda.travel.core.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.sda.travel.core.entity.Client;

@Repository
public interface ClientDao extends CrudRepository<Client,Integer> {

}
