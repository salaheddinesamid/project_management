package com.projecmanagement.service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.User;

@Data
@Getter
@Setter
public class UserDTO {

    Integer userID;
    String firstName;
    String lastName;
    String email;
    String role;
    public UserDTO(
            Integer userID,
            String firstName,
            String lastName,
            String email,
            String role
    ){
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
    }
}
