package com.scm.scm.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {
    private  String username;
    private String  email;
    private String password;
    private String about;
    private String phoneNumber;
}
