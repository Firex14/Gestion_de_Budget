package com.yaba.monbudget.mapper;

import com.yaba.monbudget.enums.Gender;
import com.yaba.monbudget.exchange.request.UserAppCreationRequest;
import com.yaba.monbudget.model.UserApp;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-29T13:49:23+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class UserAppMapperImpl implements UserAppMapper {

    @Override
    public UserApp toUserApp(UserAppCreationRequest userAppCreationRequest) {
        if ( userAppCreationRequest == null ) {
            return null;
        }

        UserApp userApp = new UserApp();

        userApp.setFirstname( userAppCreationRequest.getFirstname() );
        userApp.setLastname( userAppCreationRequest.getLastname() );
        userApp.setPhoneNumber( userAppCreationRequest.getPhoneNumber() );
        if ( userAppCreationRequest.getGender() != null ) {
            userApp.setGender( Enum.valueOf( Gender.class, userAppCreationRequest.getGender() ) );
        }

        return userApp;
    }
}
