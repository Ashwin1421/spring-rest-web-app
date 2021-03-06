package aj.vehicletrackingsystem.service;

import aj.vehicletrackingsystem.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> findAll();

    Vehicle findOne(String id);

    Vehicle create(Vehicle newVehicle);

    Vehicle update(String id, Vehicle updatedVehicle);

    void delete(String id);
}
