package aj.vehicletrackingsystem.repository;

import aj.vehicletrackingsystem.entity.VehicleUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<VehicleUser, String> {
}
