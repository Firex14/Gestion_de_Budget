package com.yaba.monbudget.exchange.request;

import com.yaba.monbudget.utils.validations.PatternValidation;
import com.yaba.monbudget.utils.validations.groups.Create;
import com.yaba.monbudget.utils.validations.groups.Update;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import static com.yaba.monbudget.utils.messages.ErrorMessage.MALFORMED_FIELD;
import static com.yaba.monbudget.utils.messages.ErrorMessage.REQUIRED_FIELD_NAME;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAppCreationRequest {

    @NotNull(message = REQUIRED_FIELD_NAME, groups = { Create.class, Update.class })
    private String firstname;

    @NotNull(message = REQUIRED_FIELD_NAME, groups = { Create.class, Update.class })
    private String lastname;

    @NotNull(message = REQUIRED_FIELD_NAME, groups = { Create.class, Update.class })
    private String gender;

    @NotNull(message = REQUIRED_FIELD_NAME, groups = { Create.class, Update.class })
    @Pattern(regexp = PatternValidation.PHONE_NUMBER_PATTERN, message = MALFORMED_FIELD)
    private String phoneNumber;

    @NotNull(message = REQUIRED_FIELD_NAME, groups = { Create.class, Update.class })
    @Pattern(regexp = PatternValidation.PASSWORD_PATTERN, message = MALFORMED_FIELD, groups = Create.class)
    private String password;

}
