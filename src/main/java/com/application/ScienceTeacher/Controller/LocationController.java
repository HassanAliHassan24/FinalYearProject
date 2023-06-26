package com.application.ScienceTeacher.Controller;

import com.application.ScienceTeacher.Entity.Location;
import com.application.ScienceTeacher.Repository.LocationRepository;
import com.application.ScienceTeacher.Repository.TeacherRepository;
import com.application.ScienceTeacher.Service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Location")
public class LocationController {

    @Autowired
    public LocationService locationService;

    @Autowired
    public LocationRepository locationRepository;

    @Autowired
    TeacherRepository teacherRepository;
    @PostMapping("/add")
    public Location addLocation(@RequestBody Location location){
        return this.locationService.addLocation(location);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Location>> getAllLocation(){
        List<Location> locations = this.locationService.getAllLocation();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }
    @GetMapping("/getById/{location_id}")
    public  ResponseEntity<Location> getLocationById(@PathVariable("location_id")Integer location_id){
        Location location = this.locationService.getById(location_id);
        return new ResponseEntity<>(location,HttpStatus.OK);
    }
    @Transactional
    @DeleteMapping("/deleteLocation/{location_id}")
    public void deleteLocationById(@PathVariable Integer location_id){
        this.locationService.deleteLocationById(location_id);
    }
    @PutMapping("/updateLocation/{location_id}")
    public Location updateLocation(@RequestBody Location location){
        return this.locationService.updateLocation(location);
    }

}
