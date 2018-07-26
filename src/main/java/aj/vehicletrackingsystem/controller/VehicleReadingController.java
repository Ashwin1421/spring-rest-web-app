package aj.vehicletrackingsystem.controller;

import aj.vehicletrackingsystem.entity.VehicleReading;
import aj.vehicletrackingsystem.service.VehicleReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sun.text.normalizer.VersionInfo;

import java.util.List;

@RestController
@RequestMapping(value = "/readings")
public class VehicleReadingController {

    @Autowired
    VehicleReadingService vehicleReadingService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public List<VehicleReading> findAll() {
        return vehicleReadingService.findAll();
    }


    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public VehicleReading findByVin(@PathVariable("id") String vin){
        return vehicleReadingService.findById(vin);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public VehicleReading create(@RequestBody VehicleReading newVehicleReading){
        return vehicleReadingService.create(newVehicleReading);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            value = "/{id}"
    )
    public VehicleReading update(@PathVariable("id") String vin,@RequestBody VehicleReading vehicleReading){
        return vehicleReadingService.update(vin, vehicleReading);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            value = "/{id}"
    )
    public void delete(@PathVariable("id") String vin){
        vehicleReadingService.delete(vin);
    }
}
