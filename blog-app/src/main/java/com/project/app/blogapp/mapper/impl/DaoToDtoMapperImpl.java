package com.project.app.blogapp.mapper.impl;

import com.project.app.blogapp.dao.AppUser;
import com.project.app.blogapp.dao.Posts;
import com.project.app.blogapp.dto.AppUserDTO;
import com.project.app.blogapp.dto.PostDTO;
import com.project.app.blogapp.mapper.DaoToDtoMapper;
import org.springframework.stereotype.Service;

@Service
public class DaoToDtoMapperImpl implements DaoToDtoMapper {
    @Override
    public AppUserDTO getUserDto(AppUser user) {
        AppUserDTO userDTO = new AppUserDTO();
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmailId(user.getEmail());
        return userDTO;
    }

    @Override
    public AppUser getUserEntity(AppUserDTO userDTO) {
        AppUser appUser = new AppUser();
        appUser.setEmail(userDTO.getEmailId());
        appUser.setFirstName(userDTO.getFirstName());
        appUser.setLastName(userDTO.getLastName());
        return appUser;
    }

    @Override
    public PostDTO getPostDTO(Posts posts) {
        PostDTO postDTO = new PostDTO();
        postDTO.setContent(posts.getContent());
        postDTO.setTitle(posts.getTitle());
        postDTO.setUserDetails(getUserDto(posts.getUserDetails()));
        postDTO.setDateOfPublish(posts.getDateOfPublish());
        postDTO.setDateOfUpdate(posts.getDateOfUpdate());
        postDTO.setLikesCount(posts.getLikesCount());
        postDTO.setUserDetails(getUserDto(posts.getUserDetails()));
        return postDTO;
    }

    @Override
    public Posts getPostEntity(PostDTO postDTO) {
        Posts posts = new Posts();
        posts.setContent(postDTO.getContent());
        posts.setTitle(postDTO.getTitle());
        posts.setUserDetails(getUserEntity(postDTO.getUserDetails()));
        posts.setDateOfPublish(postDTO.getDateOfPublish());
        posts.setDateOfUpdate(postDTO.getDateOfUpdate());
        posts.setLikesCount(postDTO.getLikesCount());
        return posts;
    }
}
