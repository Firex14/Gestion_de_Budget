package com.yaba.monbudget.model;

import com.yaba.monbudget.enums.Authority;
import com.yaba.monbudget.utils.validations.groups.Create;
import com.yaba.monbudget.utils.validations.groups.Update;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.UUID;

import static com.yaba.monbudget.utils.messages.ErrorMessage.REQUIRED_FIELD_NAME;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAuthority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    private UUID id;

    @NotNull(message = REQUIRED_FIELD_NAME, groups = { Create.class, Update.class })
    @Column(nullable = false, unique = true)
    @Setter
    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Override
    public String getAuthority() {
        return authority.name();
    }

}
