package ro.sda.travel.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.travel.core.entity.Host;

public interface HostRepository extends JpaRepository<Host, Integer> {
}
