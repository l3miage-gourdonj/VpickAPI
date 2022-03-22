package com.cfmgg.vpick;


import com.cfmgg.vpick.configs.ClientAboConfig;
import com.cfmgg.vpick.configs.ModeleConfig;
import com.cfmgg.vpick.configs.StationConfig;
import com.cfmgg.vpick.configs.VeloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class VpickApplication {

    public static void main(String[] args) {
        SpringApplication.run(new Class[]{VpickApplication.class, ClientAboConfig.class, StationConfig.class, ModeleConfig.class, VeloConfig.class}, args);
    }


}
