package ro.sda.travel.core.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.travel.core.controller.PropertyController;
import ro.sda.travel.core.entity.Property;

@Service
public class PropertyService {

    @Autowired
    private PropertyController propertyController;

    public Property createProperty(Property property) {
        return propertyController.createProperty(property);
    }
}
