package ro.sda.travel.core.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.travel.core.entity.Property;
import ro.sda.travel.core.repository.PropertyRepository;

import java.util.List;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    public Property createProperty(Property property) {
        return propertyRepository.save(property);
    }

    public Property getPropertyById(int id) {
        return propertyRepository.findOne(id);
    }

    public List<Property> getAllProperty() {
        return propertyRepository.findAll();
    }

    public Property updateProperty(Property property) {
        Property propertyFromDb = propertyRepository.findOne(property.getId());
        return propertyRepository.save(propertyFromDb);
    }

    public void deleteProperty(int id) {
        propertyRepository.delete(id);
    }

}
