package com.scm.scm.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserForm {
    @NotBlank(message = "username is required")
    @Size(min=3,message = "Min 3 charchater is required")
    private  String username;
    @Email(message = "Invalid Email Address")
    private String email;
    @NotBlank(message = "password is required")
    private String password;
    @NotBlank(message = "About is required")
    @Size(min = 10,message = "write minimum 20 word")
    private String about;
    @Size(min = 8, max = 12,message = "Invalid Format")
    private String contactNumber;
}
