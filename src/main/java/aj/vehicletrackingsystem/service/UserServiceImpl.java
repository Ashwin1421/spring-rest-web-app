package aj.vehicletrackingsystem.service;

import aj.vehicletrackingsystem.entity.VehicleUser;
import aj.vehicletrackingsystem.exception.BadRequestException;
import aj.vehicletrackingsystem.exception.ResourceNotFoundException;
import aj.vehicletrackingsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<VehicleUser> findAll() {
        return (List<VehicleUser>) userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public VehicleUser findById(String id) {
        Optional<VehicleUser> existingUser = userRepository.findById(id);
        if(!existingUser.isPresent()){
            throw new ResourceNotFoundException("User with id="+id+" does not exist.");
        }
        return existingUser.get();
    }

    @Override
    @Transactional
    public VehicleUser create(VehicleUser newUser) {
        Optional<VehicleUser> existingUser = userRepository.findById(newUser.getId());
        if(existingUser.isPresent()){
            throw new BadRequestException("User with id="+existingUser.get().getId()+" already exists.");
        }
        return userRepository.save(newUser);
    }

    @Override
    @Transactional
    public VehicleUser update(String id, VehicleUser updatedUser) {
        Optional<VehicleUser> existingUser = userRepository.findById(id);
        if(!existingUser.isPresent()){
            throw new ResourceNotFoundException("User with id="+id+" does not exist.");
        }
        return userRepository.save(updatedUser);
    }

    @Override
    @Transactional
    public void delete(String id) {
        Optional<VehicleUser> existingUser = userRepository.findById(id);
        if(!existingUser.isPresent()){
            throw new BadRequestException("User with id="+id+" does not exist.");
        }
        userRepository.delete(existingUser.get());
    }
}
