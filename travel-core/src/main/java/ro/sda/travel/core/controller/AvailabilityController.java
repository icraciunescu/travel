package ro.sda.travel.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ro.sda.travel.core.entity.Availability;
import ro.sda.travel.core.service.AvailabilityService;

import java.util.List;

@RestController
public class AvailabilityController {

    @Autowired
    private AvailabilityService availabilityService;

    public Availability createAvailability(Availability availability) {
        return availabilityService.createAvailability(availability);
    }

    public Availability getAvailabilityById(int id) {
        return availabilityService.getAvailabilityById(id);
    }

    public List<Availability> getAllAvailability() {
        return availabilityService.getAllAvailability();
    }


    public void deleteAvailability(int id) {
        availabilityService.deleteAvailability(id);
    }
}
