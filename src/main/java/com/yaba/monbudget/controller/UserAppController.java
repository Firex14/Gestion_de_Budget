package com.yaba.monbudget.controller;

import com.yaba.monbudget.dto.UserAppDto;
import com.yaba.monbudget.model.UserApp;
import com.yaba.monbudget.service.UserAppService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.yaba.monbudget.constant.Constant.BASE_URL;

@RestController
@Tag(name = "Api des utilisateurs de l'Application")
@RequestMapping(BASE_URL + "/users")
public class UserAppController {
    @Autowired
    private  UserAppService userAppService;

    @Operation(summary = "Endpoint pour lister tous les utilisateurs")
    @GetMapping
    public List<UserApp> getAllUsers(){
        return userAppService.getAllUsers();
    }
    @Operation(summary = "Endpoint de création d'un utilisateur")
    @PostMapping
    public UserApp saveUser(@RequestBody UserAppDto userAppDto){
        return userAppService.create(userAppDto);
    }
    @Operation(summary = "Endpoint pour lister un utilisateur par son id")
    @GetMapping(path = "/{id}")
    public UserApp getUserById(@PathVariable Long id ){
        return userAppService.getUserById(id);
    }

    @Operation(summary = "Endpoint pour changer le solde d'un utilisateur")
    @PatchMapping(path = "/{id}")
    public UserApp setBalance(@PathVariable Long id,@RequestBody double balance){
        return userAppService.setBalance(id, balance);
    }


}
