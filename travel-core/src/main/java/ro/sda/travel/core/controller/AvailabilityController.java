package ro.sda.travel.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ro.sda.travel.core.entity.Availability;
import ro.sda.travel.core.service.AvailabilityService;

import java.util.Date;
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

    public Availability updateAvailability(Availability availability) {
        return availabilityService.updateAvailability(availability);
    }

    public void splitAvailability(int id) {
//        availabilityService.splitAvailability(id);
    }

    public void deleteAvailability(int id) {
        availabilityService.deleteAvailability(id);
    }

    public List<Availability> findAvailabilitiesByFromDateLessThanEqualAndToDateGreaterThanEqual(Date fromDate, Date toDate) {
        return availabilityService.findAvailabilitiesByFromDateLessThanEqualAndToDateGreaterThanEqual(fromDate, toDate);
    }

    public void allAvailabilityFromAndToDate(Date fromDate, Date toDate) {
        System.out.println(availabilityService.findAvailabilitiesByFromDateLessThanEqualAndToDateGreaterThanEqual(fromDate, toDate).toString());
    }



}
