package ro.sda.travel.core.repository;

import org.springframework.data.repository.CrudRepository;
import ro.sda.travel.core.entity.Host;

public interface HostRepository extends CrudRepository<Host, Integer> {
}
