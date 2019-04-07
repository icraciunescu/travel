package ro.sda.travel.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.travel.core.entity.Availability;
import ro.sda.travel.core.repository.AvailabilityRepository;

@Service
public class AvailabilityService {

    @Autowired
    private AvailabilityRepository availabilityRepository;

    public Availability createAvailability(Availability availability) {
        return availabilityRepository.save(availability);
    }
}
