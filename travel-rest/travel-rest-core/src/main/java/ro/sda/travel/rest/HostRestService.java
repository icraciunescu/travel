package ro.sda.travel.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.travel.core.entity.Host;
import ro.sda.travel.core.service.HostService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Service
@Path("/host")
public class HostRestService {

    @Autowired
    private HostService hostService;

    @Path("/find-all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Host> findAll() {
        return hostService.getAllHost();
    }

    @Path("/find/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Host findById(@PathParam("id") int id) {
        return hostService.getHostById(id);
    }

    @Path("/delete")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteHost(@QueryParam("hostId") int id) {
        hostService.deleteHost(id);
    }

    @Path("/create")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Host createHost(Host host) {
        return hostService.createHost(host);
    }
}
