package com.project.app.blogapp.api.request;

import jakarta.annotation.PostConstruct;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserPostCreationRequest {
    private String title;
    private String content;
    private LocalDateTime dateOfPublish;
    private LocalDateTime dateOfUpdate;
    private Long likesCount;

    @PostConstruct
    public void init(){
        this.dateOfPublish = LocalDateTime.now();
        this.dateOfUpdate = LocalDateTime.now();
        this.likesCount = 0L;
    }
}
