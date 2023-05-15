package com.project.app.blogapp.service;

import com.project.app.blogapp.dao.AppUser;
import com.project.app.blogapp.dto.AppUserDTO;
import com.project.app.blogapp.dto.PostDTO;

public interface AppUserService {
    public Boolean isUserExit(AppUser appUser);
    AppUser saveUser(AppUser user);
    PostDTO savePost(PostDTO post);
}
