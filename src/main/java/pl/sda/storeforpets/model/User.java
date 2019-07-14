package pl.sda.storeforpets.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Email(message = "Invalid email address")
    @NotBlank(message = "This field cannot be empty")
    private String email;
    @NotBlank(message = "This field cannot be empty")
    @Size(min = 6, message = "Password must contain at least six characters")
    private String password;
    private LocalDateTime registered = LocalDateTime.now();
    private boolean activityFlag = false;
    @Transient //pamięć podręczna bez wpisywania do bazy danych
    @NotBlank(message = "This field cannot be empty")
    @Size(min = 6, message = "Password must contain at least six characters")
    private String password_confirm;


    public User(String email, String password) {
        this.email = email;
        this.password = password;

    }
}
