package com.cfmgg.vpick;


//import com.cfmgg.vpick.configs.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class VpickApplication {

    public static void main(String[] args) {
        SpringApplication.run(new Class[]{VpickApplication.class/*, StationConfig.class,ClientConfig.class, ModeleConfig.class,BornetteConfig.class,  VeloConfig.class, LocationConfig.class*/}, args);
    }
    //SpringApplication.run(new Class[]{VpickApplication.class,},args);
    //SpringApplication.run(VpickApplication.class,args);


}
