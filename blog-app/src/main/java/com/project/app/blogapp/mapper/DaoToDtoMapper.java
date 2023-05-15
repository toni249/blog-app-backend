package com.project.app.blogapp.mapper;

import com.project.app.blogapp.dao.AppUser;
import com.project.app.blogapp.dao.Posts;
import com.project.app.blogapp.dto.AppUserDTO;
import com.project.app.blogapp.dto.PostDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DaoToDtoMapper {

    AppUserDTO getUserDto(AppUser user);
    AppUser getUserEntity(AppUserDTO userDTO);

    PostDTO getPostDTO(Posts posts);
    Posts getPostEntity(PostDTO postDTO);
}
