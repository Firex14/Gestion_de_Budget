package com.yaba.monbudget.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yaba.monbudget.enums.Gender;
import com.yaba.monbudget.enums.UserStatus;
import com.yaba.monbudget.utils.validations.PatternValidation;
import com.yaba.monbudget.utils.validations.groups.Create;
import com.yaba.monbudget.utils.validations.groups.Update;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

import static com.yaba.monbudget.utils.messages.ErrorMessage.MALFORMED_FIELD;
import static com.yaba.monbudget.utils.messages.ErrorMessage.REQUIRED_FIELD_NAME;
import static com.yaba.monbudget.utils.validations.PatternValidation.DATE_PATTERN;

@Data
@NoArgsConstructor
@Entity
public class UserApp implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull(message = REQUIRED_FIELD_NAME, groups = { Create.class, Update.class })
    @Column(nullable = false)
    private String firstname;

    @NotNull(message = REQUIRED_FIELD_NAME, groups = { Create.class, Update.class })
    @Column(nullable = false)
    private String lastname;

    @NotNull(message = REQUIRED_FIELD_NAME, groups = { Create.class })
    @Column(nullable = false)
    @Pattern(regexp = PatternValidation.PHONE_NUMBER_PATTERN, message = MALFORMED_FIELD)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    private double balance;

    @NotNull(message = REQUIRED_FIELD_NAME, groups = {Create.class, Update.class})
    @JsonFormat(pattern = DATE_PATTERN)
    @Column(nullable = false)
    private ZonedDateTime createdAt;

    @NotNull(message = REQUIRED_FIELD_NAME, groups = {Create.class, Update.class})
    @JsonFormat(pattern = DATE_PATTERN)
    @Column(nullable = false)
    private ZonedDateTime updatedAt;

    public void loadNewUser(){
        createdAt = ZonedDateTime.now();
        updatedAt = ZonedDateTime.now();
        balance = 0;
    }

}
