package com.ashwin.repository;

import com.ashwin.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle, String> {
}
