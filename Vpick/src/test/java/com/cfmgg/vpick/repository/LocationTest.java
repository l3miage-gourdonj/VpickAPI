package com.cfmgg.vpick.repository;

import com.cfmgg.vpick.models.Location;
import com.cfmgg.vpick.services.LocationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class LocationTest {
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private LocationService locationService;
    @Test
    public void shouldExist(){
        try{
            Thread.sleep(1000);
            List<Location> locations = locationRepository.checkIfCodeSecretExist();
            System.out.println("nombre de location en cours : "+locations.size());
            System.out.println("exist : "+locationService.checkIfCodeSecretExist("2354"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}