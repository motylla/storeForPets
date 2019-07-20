package pl.sda.storeforpets.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactMe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDateTime dateAdded = LocalDateTime.now();
    @NotBlank(message = "To pole nie może być puste")
    private String name;
    @NotBlank(message = "To pole nie może być puste")
    @Email
    private String email;
    @NotBlank(message = "To pole nie może być puste")
    private String subject;
    @NotBlank(message = "To pole nie może być puste")
    @Type(type="text")
    private String message;

    public ContactMe(String name, String email, String subject, String message) {
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }
}
