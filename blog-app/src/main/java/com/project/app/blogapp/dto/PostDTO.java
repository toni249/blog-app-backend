package com.project.app.blogapp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private String title;
    private String content;
    private LocalDateTime dateOfPublish;
    private LocalDateTime dateOfUpdate;
    private Long likesCount;
    private AppUserDTO userDetails;
}
