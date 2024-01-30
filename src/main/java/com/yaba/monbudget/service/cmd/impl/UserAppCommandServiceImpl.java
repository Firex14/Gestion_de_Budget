package com.yaba.monbudget.service.cmd.impl;


import com.yaba.monbudget.enums.UserStatus;
import com.yaba.monbudget.exceptions.AlreadyExistException;
import com.yaba.monbudget.exchange.request.UserAppCreationRequest;
import com.yaba.monbudget.mapper.UserAppMapper;
import com.yaba.monbudget.model.UserApp;
import com.yaba.monbudget.repository.UserAppRepository;
import com.yaba.monbudget.service.cmd.UserAppCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAppCommandServiceImpl implements UserAppCommandService {

    private final UserAppRepository repository;
    private final UserAppMapper mapper;

    @Override
    public UserApp create(UserAppCreationRequest request) {

        if (repository.existsByPhoneNumber(request.getPhoneNumber())) {
            throw new AlreadyExistException("User already exists");
        }

        UserApp user = mapper.toUserApp(request);

        user.setStatus(UserStatus.ACTIVE);

        user.loadNewUser();

        return repository.save(user);
    }
}
