package com.yaba.monbudget.service.cmd.impl;

import com.yaba.monbudget.enums.Authority;
import com.yaba.monbudget.exchange.request.UserAppCreationRequest;
import com.yaba.monbudget.model.UserAccount;
import com.yaba.monbudget.model.UserApp;
import com.yaba.monbudget.model.UserAuthority;
import com.yaba.monbudget.repository.UserAccountRepository;
import com.yaba.monbudget.service.cmd.UserAccountCommandService;
import com.yaba.monbudget.service.cmd.UserAppCommandService;
import com.yaba.monbudget.service.query.UserAuthorityQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class UserAccountCommandServiceImpl implements UserAccountCommandService {

    private final UserAccountRepository repository;
    private final UserAppCommandService commandService;
    private final PasswordEncoder passwordEncoder;
    private final UserAuthorityQueryService authorityQueryService;

    @Override
    public UserAccount create(UserAppCreationRequest request) {

        UserApp userApp = commandService.create(request);

        UserAccount account = UserAccount.builder()
                .username(request.getPhoneNumber())
                .password(passwordEncoder.encode(request.getPassword()))
                .createdAt(ZonedDateTime.now())
                .build();

        account.setOwner(userApp);
        account.setUp();

        UserAuthority authority = authorityQueryService.findByAuthority(Authority.USER);
        account.addAuthority(authority);

        return repository.save(account);
    }
}
