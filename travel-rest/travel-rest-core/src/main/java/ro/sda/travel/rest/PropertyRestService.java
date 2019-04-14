package ro.sda.travel.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.travel.core.entity.Property;
import ro.sda.travel.core.service.PropertyService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Service
@Path("/property")
public class PropertyRestService {

    @Autowired
    private PropertyService propertyService;

    @Path("/find-all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Property> findAll() {
        return propertyService.getAllProperty();
    }

    @Path("/find/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Property findById(@PathParam("id") int id) {
        return propertyService.getPropertyById(id);
    }

    @Path("/delete")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteProperty(@QueryParam("deleteId") int id) {
        propertyService.deleteProperty(id);
    }

    @Path("/create")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Property createProperty(Property property) {
        return propertyService.createProperty(property);
    }

}
