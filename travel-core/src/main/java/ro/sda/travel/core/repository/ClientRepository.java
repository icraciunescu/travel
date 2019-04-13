package ro.sda.travel.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.travel.core.entity.Client;

public interface ClientRepository extends JpaRepository<Client,Integer> {

}