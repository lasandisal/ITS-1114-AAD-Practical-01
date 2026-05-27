package lk.ijse.aad.entity;

import jakarta.persistence.*;
import lk.ijse.aad.enums.UserStatus;
import lombok.*;

import java.util.Date;

 @Data // = Getter + Setter + toString + .equal
//@Getter @Setter // Industry Standard
@AllArgsConstructor @NoArgsConstructor
@Entity
public class User {

    @Id
    // Auto Increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private Date dob;

    // Search and Save this enum as a String
    @Enumerated(EnumType.STRING)
    private UserStatus status;

}
