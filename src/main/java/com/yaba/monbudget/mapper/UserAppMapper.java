package com.yaba.monbudget.mapper;

import com.yaba.monbudget.exchange.request.UserAppCreationRequest;
import com.yaba.monbudget.model.UserApp;
import org.mapstruct.Mapper;

@Mapper
public interface UserAppMapper {

    UserApp toUserApp(UserAppCreationRequest userAppCreationRequest);
}
