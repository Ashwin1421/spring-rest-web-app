package aj.vehicletrackingsystem.repository;

import aj.vehicletrackingsystem.entity.VehicleReading;
import org.springframework.data.repository.CrudRepository;

public interface VehicleReadingRepository extends CrudRepository<VehicleReading, String> {
}
