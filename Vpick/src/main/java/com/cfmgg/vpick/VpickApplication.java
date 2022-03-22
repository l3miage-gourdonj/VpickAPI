package com.cfmgg.vpick;


//import com.cfmgg.vpick.configs.*;
import com.cfmgg.vpick.configs.ClientAboConfig;
import com.cfmgg.vpick.configs.StationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class VpickApplication {

    public static void main(String[] args) {
        SpringApplication.run(new Class[]{VpickApplication.class, ClientAboConfig.class, StationConfig.class}, args);
    }


}
