package black.auth.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String matchingPassword;
    private String role;
}
