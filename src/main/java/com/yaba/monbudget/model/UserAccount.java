package com.yaba.monbudget.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yaba.monbudget.utils.validations.PatternValidation;
import com.yaba.monbudget.utils.validations.groups.Create;
import com.yaba.monbudget.utils.validations.groups.Update;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.ZonedDateTime;
import java.util.*;

import static com.yaba.monbudget.utils.messages.ErrorMessage.MALFORMED_FIELD;
import static com.yaba.monbudget.utils.messages.ErrorMessage.REQUIRED_FIELD_NAME;
import static com.yaba.monbudget.utils.validations.PatternValidation.DATE_PATTERN;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class UserAccount implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull(message = REQUIRED_FIELD_NAME, groups = {Create.class, Update.class})
    @Column(nullable = false, unique = true)
    @Pattern(regexp = PatternValidation.PHONE_NUMBER_PATTERN, message = MALFORMED_FIELD)
    private String username;

    @JsonIgnore
    @NotNull(message = REQUIRED_FIELD_NAME, groups = {Create.class, Update.class})
    @Column(nullable = false)
    private String password;

    @NotNull(message = REQUIRED_FIELD_NAME, groups = {Create.class, Update.class})
    @Column(nullable = false)
    private boolean accountNonExpired;

    @NotNull(message = REQUIRED_FIELD_NAME, groups = {Create.class, Update.class})
    @Column(nullable = false)
    private boolean accountNonLocked;

    @NotNull(message = REQUIRED_FIELD_NAME, groups = {Create.class, Update.class})
    @Column(nullable = false)
    private boolean credentialsNonExpired;

    @NotNull(message = REQUIRED_FIELD_NAME, groups = {Create.class, Update.class})
    @Column(nullable = false)
    private boolean enabled;

    @NotNull(message = REQUIRED_FIELD_NAME, groups = {Create.class, Update.class})
    @OneToOne(optional = false)
    private UserApp owner;

    @ManyToMany
    @NotNull(message = REQUIRED_FIELD_NAME, groups = { Create.class, Update.class })
    @JoinTable(name = "user_account_authority",
            joinColumns = @JoinColumn(name = "user_account_id"),
            inverseJoinColumns = @JoinColumn(name = "user_authority_id")
    )
    private Set<UserAuthority> authorities;

    @NotNull(message = REQUIRED_FIELD_NAME, groups = {Create.class, Update.class})
    @JsonFormat(pattern = DATE_PATTERN)
    @Column(nullable = false)
    private ZonedDateTime createdAt;

    @NotNull(message = REQUIRED_FIELD_NAME, groups = {Create.class, Update.class})
    @JsonFormat(pattern = DATE_PATTERN)
    @Column(nullable = false)
    private ZonedDateTime updatedAt;
    public void addAuthority(UserAuthority authority){
        if(Objects.isNull(authorities) || authorities.isEmpty()){
            authorities = new HashSet<>();
        }

        authorities.add(authority);
    }

    public void shutDown(){
        enabled = false;
        accountNonExpired = false;
        credentialsNonExpired = false;
        accountNonLocked = false;
        updatedAt = ZonedDateTime.now();
    }

    public void setUp(){
        enabled = true;
        accountNonExpired = true;
        credentialsNonExpired = true;
        accountNonLocked = true;
        updatedAt = ZonedDateTime.now();
    }
    public boolean isValid(){
        return accountNonExpired && accountNonLocked && credentialsNonExpired && enabled;
    }
}
