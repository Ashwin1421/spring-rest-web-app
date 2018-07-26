package aj.vehicletrackingsystem.service;

import aj.vehicletrackingsystem.exception.BadRequestException;
import aj.vehicletrackingsystem.exception.ResourceNotFoundException;
import aj.vehicletrackingsystem.entity.WeatherSensor;
import aj.vehicletrackingsystem.repository.WeatherSensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class WeatherSensorServiceImpl implements WeatherSensorService {

    @Autowired
    WeatherSensorRepository weatherSensorRepository;

    @Override
    @Transactional
    public List<WeatherSensor> findAll() {
        return (List<WeatherSensor>) weatherSensorRepository.findAll();
    }

    @Override
    @Transactional
    public WeatherSensor findById(String id) {
        Optional<WeatherSensor> existingWeatherSensor = weatherSensorRepository.findById(id);
        if(!existingWeatherSensor.isPresent()){
            throw new ResourceNotFoundException("Weather sensor data with id="+id+" does not exist.");
        }
        return existingWeatherSensor.get();
    }

    @Override
    @Transactional
    public WeatherSensor create(WeatherSensor newWeatherSensor) {
        Optional<WeatherSensor> existingWeatherSensor = weatherSensorRepository.findById(newWeatherSensor.getId());
        if(existingWeatherSensor.isPresent()){
            throw new BadRequestException("Weather sensor with id="+existingWeatherSensor.get().getId()+"already exists.");
        }
        return weatherSensorRepository.save(newWeatherSensor);
    }

    @Override
    @Transactional
    public WeatherSensor update(String id, WeatherSensor updatedWeatherSensor) {
        Optional<WeatherSensor> existingWeatherSensor = weatherSensorRepository.findById(id);
        if(!existingWeatherSensor.isPresent()){
            throw new ResourceNotFoundException("Weather sensor with id="+id+" does not exist.");
        }
        return weatherSensorRepository.save(updatedWeatherSensor);
    }

    @Override
    @Transactional
    public void delete(String id) {
        Optional<WeatherSensor> existingWeatherSensor = weatherSensorRepository.findById(id);
        if(!existingWeatherSensor.isPresent()){
            throw new BadRequestException("Weather sensor with id="+id+" does not exist");
        }
        weatherSensorRepository.delete(existingWeatherSensor.get());
    }
}
