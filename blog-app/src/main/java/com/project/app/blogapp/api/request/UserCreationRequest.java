package com.project.app.blogapp.api.request;

import lombok.Data;

@Data
public class UserCreationRequest {
    private String firstName;
    private String lastName;
    private String mail;
    private String dob;
    private String password;
}
