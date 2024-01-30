package com.yaba.monbudget.init;

import com.yaba.monbudget.enums.Authority;
import com.yaba.monbudget.model.UserAuthority;
import com.yaba.monbudget.repository.UserAuthorityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static java.util.List.of;

@Log4j2
@Component
@RequiredArgsConstructor
public class DataInit {

    protected static void createAuthorities(UserAuthorityRepository authorityRepository){

        if (authorityRepository.count() > 0) {
            return;
        }

        log.info("***   CREATE AUTHORITIES   ***");

        authorityRepository.saveAll(of(
                UserAuthority.builder().authority(Authority.USER).build(),
                UserAuthority.builder().authority(Authority.ADMIN).build()
        )).forEach(log::info);
    }

    @Bean
    public CommandLineRunner initData(UserAuthorityRepository authorityRepository){
        return args -> {
            createAuthorities(authorityRepository);
        };
    }
}