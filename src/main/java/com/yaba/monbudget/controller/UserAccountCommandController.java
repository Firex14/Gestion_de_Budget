package com.yaba.monbudget.controller;

import com.yaba.monbudget.exchange.request.UserAppCreationRequest;
import com.yaba.monbudget.model.UserAccount;
import com.yaba.monbudget.service.cmd.UserAccountCommandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.yaba.monbudget.constant.Constant.BASE_URL;

@RestController
@Tag(name = "Api des Comptes utilisateurs de l'Application")
@RequestMapping(BASE_URL + "/cmd/account")
@RequiredArgsConstructor
public class UserAccountCommandController {

    private final UserAccountCommandService commandService;

    @Operation(summary = "Endpoint de création d'un utilisateur")
    @PostMapping
    public UserAccount saveUser(@RequestBody UserAppCreationRequest request){
        return commandService.create(request);
    }
}
