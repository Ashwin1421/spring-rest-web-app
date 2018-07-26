package aj.vehicletrackingsystem.service;

import aj.vehicletrackingsystem.entity.VehicleUser;

import java.util.List;

public interface UserService {

    List<VehicleUser> findAll();

    VehicleUser findById(String id);

    VehicleUser create(VehicleUser newUser);

    VehicleUser update(String id, VehicleUser updatedUser);

    void delete(String id);
}
