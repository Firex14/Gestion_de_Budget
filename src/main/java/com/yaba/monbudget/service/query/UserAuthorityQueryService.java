package com.yaba.monbudget.service.query;

import com.yaba.monbudget.enums.Authority;
import com.yaba.monbudget.model.UserAuthority;

public interface UserAuthorityQueryService {
    UserAuthority findByAuthority(Authority authority);

}
