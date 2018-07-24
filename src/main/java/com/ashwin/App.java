package com.ashwin;

import com.ashwin.entity.Vehicle;
import com.ashwin.repository.VehicleRepository;
import com.ashwin.service.VehicleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App
{
    public static void main( String[] args ){
        SpringApplication app = new SpringApplication(App.class);
        app.run();
    }
}
