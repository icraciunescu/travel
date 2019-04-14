package ro.sda.travel.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.travel.core.entity.Host;
import ro.sda.travel.core.repository.HostRepository;

import java.util.List;

@Service
public class HostService {

    @Autowired
    private HostRepository hostRepository;

    public Host createHost(Host host) {
        return hostRepository.save(host);
    }

    public Host getHostById(int id) {
        return hostRepository.findOne(id);
    }

    public List<Host> getAllHost() {
        return hostRepository.findAll();
    }

    public Host updateHost(Host host) {
        Host hostFromDb = hostRepository.findOne(host.getId());
        return hostRepository.save(hostFromDb);
    }

    public void deleteHost(int id) {
        hostRepository.delete(id);
    }

}
