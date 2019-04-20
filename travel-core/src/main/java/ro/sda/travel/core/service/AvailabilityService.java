package ro.sda.travel.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.travel.core.entity.Availability;
import ro.sda.travel.core.repository.AvailabilityRepository;
import java.util.Date;
import java.util.List;

@Service("availabilityService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class AvailabilityService {

    @Autowired
    private AvailabilityRepository availabilityRepository;

    public Availability createAvailability(Availability availability) {
        return availabilityRepository.save(availability);
    }

    public Availability getAvailabilityById(int id) {
        return availabilityRepository.findOne(id);
    }

    public List<Availability> getAllAvailability() {
        return availabilityRepository.findAll();
    }

    public Availability updateAvailability(Availability availability) {
        Availability availabilityFromDb = availabilityRepository.findOne(availability.getId());
        return availabilityRepository.save(availabilityFromDb);
    }

    public void deleteAvailability(int id) {
        availabilityRepository.delete(id);
    }

    public List<Availability> findAvailabilitiesByFromDateLessThanEqualAndToDateGreaterThanEqual(Date fromDate, Date toDate) {
        return availabilityRepository.findAvailabilitiesByFromDateLessThanEqualAndToDateGreaterThanEqual(fromDate, toDate);
    }


}
