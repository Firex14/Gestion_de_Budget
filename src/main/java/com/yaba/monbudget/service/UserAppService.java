package com.yaba.monbudget.service;

import com.yaba.monbudget.dto.PasswordRequest;
import com.yaba.monbudget.dto.UserAppDto;
import com.yaba.monbudget.model.UserApp;
import com.yaba.monbudget.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAppService {
    @Autowired
    public UserRepository repository;

    public UserApp create (UserAppDto userApp){
        UserApp user = new UserApp();
        if(existByUsername(userApp.getUsername()))
            throw new RuntimeException("already exist");
        user.setUsername(userApp.getUsername());
        user.setPassword(userApp.getPassword());
        return repository.save(user);
    }
    public List<UserApp> getAllUsers(){
        return repository.findAll();
    }

    public UserApp getUserById(Long id){
        return repository.findById(id).orElseThrow(()-> new RuntimeException("user not found"));
    }
    public UserApp setBalance(Long id , double balance){
        UserApp user= repository.findById(id).orElseThrow(()-> new RuntimeException("not present"));
        user.setBalance(balance);
        return repository.save(user);
    }

    public boolean existByUsername(String username){
        return repository.existsByUsername(username);
    }
}
