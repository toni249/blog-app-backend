package com.project.app.blogapp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppUserDTO {

    private String firstName;
    private String lastName;
    private String emailId;
    private List<PostDTO> posts;
}
