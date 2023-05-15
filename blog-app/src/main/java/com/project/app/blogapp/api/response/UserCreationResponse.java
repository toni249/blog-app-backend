package com.project.app.blogapp.api.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserCreationResponse {
    private String remark;
}
