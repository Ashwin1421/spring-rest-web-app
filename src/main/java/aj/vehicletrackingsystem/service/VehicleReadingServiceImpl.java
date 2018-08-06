package aj.vehicletrackingsystem.service;

import aj.vehicletrackingsystem.entity.VehicleReading;
import aj.vehicletrackingsystem.exception.BadRequestException;
import aj.vehicletrackingsystem.exception.ResourceNotFoundException;
import aj.vehicletrackingsystem.repository.VehicleReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleReadingServiceImpl implements VehicleReadingService {
    @Autowired
    VehicleReadingRepository vehicleReadingRepository;

    @Override
    @Transactional(readOnly = true)
    public List<VehicleReading> findAll() {
        return (List<VehicleReading>) vehicleReadingRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public VehicleReading findById(String vin) {
        Optional<VehicleReading> existing = vehicleReadingRepository.findById(vin);
        if(!existing.isPresent()){
            throw new ResourceNotFoundException("Vehicle reading for vin="+vin+" does not exist.");
        }
        return existing.get();
    }

    @Override
    @Transactional
    public VehicleReading create(VehicleReading newVehicleReading) {
        Optional<VehicleReading> existing = vehicleReadingRepository.findById(newVehicleReading.getId());
        if(existing.isPresent()){
            throw new BadRequestException("Vehicle reading for vehicle="+existing.get().getVehicle()+" already exists.");
        }
        return vehicleReadingRepository.save(newVehicleReading);
    }

    @Override
    @Transactional
    public VehicleReading update(String vin, VehicleReading vehicleReading) {
        Optional<VehicleReading> existing = vehicleReadingRepository.findById(vin);
        if(!existing.isPresent()){
            throw new ResourceNotFoundException("Vehicle reading for vin="+vin+" does not exist.");
        }
        return vehicleReadingRepository.save(vehicleReading);
    }

    @Override
    @Transactional
    public void delete(String vin) {
        Optional<VehicleReading> existing = vehicleReadingRepository.findById(vin);
        if(!existing.isPresent()){
            throw new BadRequestException("Vehicle reading for vin="+vin+" does not exist.");
        }
        vehicleReadingRepository.delete(existing.get());
    }
}
