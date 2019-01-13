package am.artyshok.dto;

import am.artyshok.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private String name;

    private String surname;

    private String email;

    private UserRole role;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
}
