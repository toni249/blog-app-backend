package com.project.app.blogapp.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.app.blogapp.dto.AppUserDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserPostCreationResponse {
    private String title;
    private String content;
    private LocalDateTime dateOfPublish;
    private LocalDateTime dateOfUpdate;
    private Long likesCount;
    private AppUserDTO userDetails;
}
