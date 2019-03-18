package com.cognizant.training.CrudDemo.Service;

import com.cognizant.training.CrudDemo.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAllService();

    void saveService(User user);

    Optional<User> findByIdService(long id);

    void deleteService(long id);
}