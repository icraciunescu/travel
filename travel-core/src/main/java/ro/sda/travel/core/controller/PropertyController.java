package ro.sda.travel.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ro.sda.travel.core.entity.Property;
import ro.sda.travel.core.service.PropertyService;

import java.util.List;

@RestController
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    public Property createProperty(Property property) {
        return propertyService.createProperty(property);
    }

    public Property getPropertyById(int id) {
        return propertyService.getPropertyById(id);
    }

    public List<Property> getAllProperty() {
        return propertyService.getAllProperty();
    }

    public void deleteProperty(int id) {
        propertyService.deleteProperty(id);
    }
}
