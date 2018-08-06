package aj.vehicletrackingsystem.service;

import aj.vehicletrackingsystem.entity.WeatherSensor;

import java.util.List;

public interface WeatherSensorService {

    List<WeatherSensor> findAll();

    WeatherSensor findById(String id);

    WeatherSensor create(WeatherSensor newWeatherSensor);

    WeatherSensor update(String id, WeatherSensor updatedWeatherSensor);

    void delete(String id);
}
