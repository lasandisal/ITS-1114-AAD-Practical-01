package lk.ijse.aad.dto;

import lk.ijse.aad.enums.UserStatus;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor @AllArgsConstructor
public class UserDTO {
    private Long id;

    private String firstName;
    private String lastName;
    private Date dob;
    private UserStatus status;
}
