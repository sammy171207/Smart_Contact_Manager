package com.scm.scm.forms;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserForm {
    private  String username;
    private String email;
    private String password;
    private String about;
    private String contactNumber;
}
