package com.yaba.monbudget.service.query.impl;

import com.yaba.monbudget.enums.Authority;
import com.yaba.monbudget.exceptions.NotFoundException;
import com.yaba.monbudget.model.UserAuthority;
import com.yaba.monbudget.repository.UserAuthorityRepository;
import com.yaba.monbudget.service.query.UserAuthorityQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserAuthorityQueryServiceImpl implements UserAuthorityQueryService {


    private final UserAuthorityRepository repository;
    @Override
    public UserAuthority findByAuthority(Authority authority) {
        return repository.findByAuthority(authority).orElseThrow(
                () -> new NotFoundException("authority not found"));
    }
}
