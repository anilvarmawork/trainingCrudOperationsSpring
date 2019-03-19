package com.cognizant.training.CrudDemo.Controller;

import com.cognizant.training.CrudDemo.Model.User;
import java.util.List;
import java.util.Optional;
import com.cognizant.training.CrudDemo.Service.UserServiceImpl;
import com.sun.net.httpserver.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userCtrl/")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("users")
    public List<User> getUsers(){
        return userServiceImpl.findAllService();
    }

    @PostMapping(path = "saveUser", consumes = "application/json", produces = "application/json")
    public void saveUser(@RequestBody User user){
        System.out.println(user.getFirstName());
        userServiceImpl.saveService(user);
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable long id){
        userServiceImpl.deleteService(id);
    }

    @GetMapping("userById/{id}")
    public Optional<User> findById(@PathVariable long id){
        return userServiceImpl.findByIdService(id);
    }
}