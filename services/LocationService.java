package com.cfmgg.vpick.services;

import com.cfmgg.vpick.models.Location;
import com.cfmgg.vpick.models.Velo;
import com.cfmgg.vpick.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location findLocationById(Long id){
        return locationRepository.findLocationById(id);
    }

    public List<Location> findAllLocation(){
        return locationRepository.findAll();
    }
    public void registerNewLocation(Location location){
        locationRepository.save(location);
    }

    public List<Location> findLocationByClient(Long id){
        return locationRepository.findLocationByClient(id);
    }

    public List<Velo> findVeloLocationById(Long id){
        return locationRepository.findVeloLocationById(id);
    }

    public Boolean checkIfCodeSecretExist(String codeSecret){
        List<Location> locations = locationRepository.checkIfCodeSecretExist();
        System.out.println("locations size:" + locations.size());
        int i=0;
        while(i<locations.size()){
            if(locations.get(i).getCodeSecret().equals(codeSecret))
                return true;
            i++;
        }
        return false;
    }
}
