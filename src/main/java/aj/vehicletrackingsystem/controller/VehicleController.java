package aj.vehicletrackingsystem.controller;

import aj.vehicletrackingsystem.entity.Vehicle;
import aj.vehicletrackingsystem.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080/api/vehicles" )
@RequestMapping(value = "/vehicles")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public List<Vehicle> findAll(){
        return vehicleService.findAll();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public Vehicle findById(@PathVariable("id") String id){
        return vehicleService.findOne(id);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public Vehicle create(@RequestBody Vehicle newVehicle){
        return vehicleService.create(newVehicle);
    }


    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public Vehicle update(@PathVariable("id") String id,@RequestBody Vehicle updatedVehicle){
        return vehicleService.update(id, updatedVehicle);
    }


    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{id}"
    )
    public void delete(@PathVariable("id") String id){
        vehicleService.delete(id);
    }
}
