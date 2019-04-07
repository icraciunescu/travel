package ro.sda.travel.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.travel.core.controller.HostController;
import ro.sda.travel.core.entity.Host;

@Service
public class HostService {

    @Autowired
    private HostController hostController;

    public Host createHost(Host host) {
        return hostController.createHost(host);
    }
}
