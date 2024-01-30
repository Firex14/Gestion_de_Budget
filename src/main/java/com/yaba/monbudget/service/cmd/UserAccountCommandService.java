package com.yaba.monbudget.service.cmd;

import com.yaba.monbudget.exchange.request.UserAppCreationRequest;
import com.yaba.monbudget.model.UserAccount;

public interface UserAccountCommandService {

    UserAccount create(UserAppCreationRequest request);


}
