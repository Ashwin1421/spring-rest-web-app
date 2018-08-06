package aj.vehicletrackingsystem.controller;

import aj.vehicletrackingsystem.entity.WeatherSensor;
import aj.vehicletrackingsystem.service.WeatherSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/weather")
public class WeatherSensorController {

    @Autowired
    WeatherSensorService weatherSensorService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public List<WeatherSensor> findAll(){
        return weatherSensorService.findAll();
    }


    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public WeatherSensor findById(@PathVariable("id") String id){
        return weatherSensorService.findById(id);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public WeatherSensor create(@RequestBody WeatherSensor newWeatherSensor){
        return weatherSensorService.create(newWeatherSensor);
    }


    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public WeatherSensor update(@PathVariable("id") String id,@RequestBody WeatherSensor updatedWeatherSensor){
        return weatherSensorService.update(id, updatedWeatherSensor);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public void delete(@PathVariable("id") String id){
        weatherSensorService.delete(id);
    }
}
