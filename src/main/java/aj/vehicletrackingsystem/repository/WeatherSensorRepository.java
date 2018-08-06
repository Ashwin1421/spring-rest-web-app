package aj.vehicletrackingsystem.repository;

import aj.vehicletrackingsystem.entity.WeatherSensor;
import org.springframework.data.repository.CrudRepository;

public interface WeatherSensorRepository extends CrudRepository<WeatherSensor, String> {
}
