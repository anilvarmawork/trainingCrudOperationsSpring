package com.cognizant.training.CrudDemo.Service;

import com.cognizant.training.CrudDemo.Model.User;
import com.cognizant.training.CrudDemo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAllService() {
        return userRepository.findAll();
    }

    @Override
    public void saveService(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> findByIdService(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteService(long id) {
         userRepository.deleteById(id);
    }
}
