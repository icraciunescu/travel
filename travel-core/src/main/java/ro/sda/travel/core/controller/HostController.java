package ro.sda.travel.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ro.sda.travel.core.entity.Host;
import ro.sda.travel.core.service.HostService;

@RestController
public class HostController {

    @Autowired
    private HostService hostService;

    public Host createHost(Host host) {
        return hostService.createHost(host);
    }
}
