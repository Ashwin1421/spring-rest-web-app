package aj.vehicletrackingsystem.service;

import aj.vehicletrackingsystem.entity.VehicleReading;

import java.util.List;

public interface VehicleReadingService {
    List<VehicleReading> findAll();
    VehicleReading findById(String vin);
    VehicleReading create(VehicleReading newVehicleReading);
    VehicleReading update(String vin, VehicleReading vehicleReading);
    void delete(String vin);
}
