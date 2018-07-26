package com.ashwin.service;

import com.ashwin.entity.Vehicle;
import com.ashwin.exception.BadRequestException;
import com.ashwin.exception.ResourceNotFoundException;
import com.ashwin.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Vehicle> findAll() {
        return (List<Vehicle>) vehicleRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Vehicle findOne(String id) {
        Optional<Vehicle> v = vehicleRepository.findById(id);
        if(!v.isPresent()){
            throw new ResourceNotFoundException("Vehicle with VIN="+id+" does not exist.");
        }
        return v.get();
    }

    @Override
    @Transactional
    public Vehicle create(Vehicle newVehicle) {
        Optional<Vehicle> existingVehicle = vehicleRepository.findById(newVehicle.getVin());
        if(existingVehicle.isPresent()){
            throw new BadRequestException("Vehicle with VIN="+existingVehicle.get().getVin()+" already exists.");
        }
        return vehicleRepository.save(newVehicle);
    }

    @Override
    @Transactional
    public Vehicle update(String id, Vehicle updatedVehicle) {
        Optional<Vehicle> existingVehicle = vehicleRepository.findById(id);
        if(!existingVehicle.isPresent()){
            throw new ResourceNotFoundException("Vehicle with VIN="+id+" does not exist.");
        }
        return vehicleRepository.save(updatedVehicle);
    }

    @Override
    @Transactional
    public void delete(String id) {
        Optional<Vehicle> existingVehicle = vehicleRepository.findById(id);
        if(!existingVehicle.isPresent()){
            throw new ResourceNotFoundException("Vehicle with VIN="+id+" does not exist.");
        }
        vehicleRepository.delete(existingVehicle.get());
    }
}
