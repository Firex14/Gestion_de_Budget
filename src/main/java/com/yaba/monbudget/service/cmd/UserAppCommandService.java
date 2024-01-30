package com.yaba.monbudget.service.cmd;

import com.yaba.monbudget.exchange.request.UserAppCreationRequest;
import com.yaba.monbudget.model.UserAccount;
import com.yaba.monbudget.model.UserApp;

public interface UserAppCommandService {

    UserApp create(UserAppCreationRequest request);
    //UserAccount update(UserAccount userAccount);
    //UserAccount updatePassword(UserAccount userAccount);

    //UserAccount delete(UserAccount userAccount);
}
