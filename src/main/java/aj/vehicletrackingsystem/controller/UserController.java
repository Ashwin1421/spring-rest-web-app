package aj.vehicletrackingsystem.controller;

import aj.vehicletrackingsystem.entity.VehicleUser;
import aj.vehicletrackingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public List<VehicleUser> findAll(){
        return userService.findAll();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public VehicleUser findById(@PathVariable("id") String id){

        return userService.findById(id);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public VehicleUser create(@RequestBody VehicleUser newUser){
        return userService.create(newUser);
    }


    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public VehicleUser update(@PathVariable("id") String id,@RequestBody VehicleUser updatedUser){
        return userService.update(id, updatedUser);
    }


    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{id}"
    )
    public void delete(@PathVariable("id") String id){
        userService.delete(id);
    }
}
