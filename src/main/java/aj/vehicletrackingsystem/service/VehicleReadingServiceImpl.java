package aj.vehicletrackingsystem.service;

import aj.vehicletrackingsystem.entity.VehicleReading;
import aj.vehicletrackingsystem.exception.BadRequestException;
import aj.vehicletrackingsystem.exception.ResourceNotFoundException;
import aj.vehicletrackingsystem.repository.VehicleReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public class VehicleReadingServiceImpl implements VehicleReadingService {
    @Autowired
    VehicleReadingRepository vehicleReadingRepository;

    @Override
    @Transactional
    public List<VehicleReading> findAll() {
        return (List<VehicleReading>) vehicleReadingRepository.findAll();
    }

    @Override
    public VehicleReading findById(String vin) {
        Optional<VehicleReading> existing = vehicleReadingRepository.findById(vin);
        if(!existing.isPresent()){
            throw new ResourceNotFoundException("Vehicle reading for vin="+vin+" does not exist.");
        }
        return existing.get();
    }

    @Override
    public VehicleReading create(VehicleReading newVehicleReading) {
        Optional<VehicleReading> existing = vehicleReadingRepository.findById(newVehicleReading.getVin());
        if(existing.isPresent()){
            throw new BadRequestException("Vehicle reading for vin="+existing.get().getVin()+" already exists.");
        }
        return vehicleReadingRepository.save(newVehicleReading);
    }

    @Override
    public VehicleReading update(String vin, VehicleReading vehicleReading) {
        Optional<VehicleReading> existing = vehicleReadingRepository.findById(vin);
        if(!existing.isPresent()){
            throw new ResourceNotFoundException("Vehicle reading for vin="+vin+" does not exist.");
        }
        return vehicleReadingRepository.save(vehicleReading);
    }

    @Override
    public void delete(String vin) {
        Optional<VehicleReading> existing = vehicleReadingRepository.findById(vin);
        if(!existing.isPresent()){
            throw new BadRequestException("Vehicle reading for vin="+vin+" does not exist.");
        }
        vehicleReadingRepository.delete(existing.get());
    }
}
