package ro.sda.travel.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ro.sda.travel.core.entity.Host;
import ro.sda.travel.core.service.HostService;

import java.util.List;

@RestController
public class HostController {

    @Autowired
    private HostService hostService;

    public Host createHost(Host host) {
        return hostService.createHost(host);
    }

    public Host getHostById(int id) {
        return hostService.getHostById(id);
    }

    public List<Host> getAllHost() {
        return hostService.getAllHost();
    }

    public void deleteHost(int id) {
        hostService.deleteHost(id);
    }
}
