package com.udacity.bootstrap.service;

import com.udacity.bootstrap.entity.Location;
import com.udacity.bootstrap.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImp implements LocationService {
    @Autowired
    LocationRepository locationRepository;

    @Override
    public List<Location> retrieveLocations() {
        return (List<Location>) locationRepository.findAll();
    }

    public Location retrieveLocation(long id) {
        Optional<Location> optionalLocation = locationRepository.findById(id);

        if (optionalLocation.isPresent())
            return optionalLocation.get();
        else
            throw new RuntimeException();
    }

}
