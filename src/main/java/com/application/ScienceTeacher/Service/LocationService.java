package com.application.ScienceTeacher.Service;

import com.application.ScienceTeacher.Entity.Location;
import com.application.ScienceTeacher.Exception.ResourceNotFoundException;
import com.application.ScienceTeacher.Repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocationService {

    @Autowired
    public LocationRepository locationRepository;
    public Location addLocation(Location location){
        return this.locationRepository.save(location);
    }
    public List<Location> getAllLocation(){
        return this.locationRepository.findAll();

    }
    public Location getById(Integer location_id){
        return (Location) this.locationRepository.findById(location_id).orElseThrow(()->
                new ResourceNotFoundException("ThatId"+location_id+"NotFound"));
    }
    public void deleteLocationById(Integer location_id){
        this.locationRepository.deleteById(location_id);
    }
    public Location updateLocation(Location location){
        Location location1 = this.locationRepository.findById(location.getLocation_id()).orElseThrow(null);
        location1.setLocation_name(location.getLocation_name());
        return this.locationRepository.save(location1);


    }
}
