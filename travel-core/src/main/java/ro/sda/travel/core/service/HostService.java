package ro.sda.travel.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.travel.core.entity.Host;
import ro.sda.travel.core.repository.HostRepository;

@Service
public class HostService {

    @Autowired
    private HostRepository hostRepository;

    public Host createHost(Host host) {
        return hostRepository.save(host);
    }
}
