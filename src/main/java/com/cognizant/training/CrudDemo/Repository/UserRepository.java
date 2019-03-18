package com.cognizant.training.CrudDemo.Repository;

import org.springframework.data.repository.CrudRepository;
import com.cognizant.training.CrudDemo.Model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll ();

    void save(List<User> user);

    Optional<User> findById(long id);

    void deleteById(long id);

}
