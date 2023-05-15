package com.project.app.blogapp.service.impl;

import com.project.app.blogapp.dao.AppUser;
import com.project.app.blogapp.dao.Posts;
import com.project.app.blogapp.dto.AppUserDTO;
import com.project.app.blogapp.dto.PostDTO;
import com.project.app.blogapp.mapper.DaoToDtoMapper;
import com.project.app.blogapp.repository.PostRepository;
import com.project.app.blogapp.repository.UserRepository;
import com.project.app.blogapp.service.AppUserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserService {

    private UserRepository appUserRepository;
    private PostRepository userPostRepository;
    private DaoToDtoMapper daoToDtoMapperService;
    public AppUserServiceImpl(UserRepository userRepository, PostRepository postRepository,
                                DaoToDtoMapper daoToDtoMapper){
        appUserRepository = userRepository;
        userPostRepository = postRepository;
        daoToDtoMapperService = daoToDtoMapper;
    }
    @Override
    public Boolean isUserExit(AppUser appUser) {
        Optional<AppUser> existingUser = appUserRepository.findByFirstNameAndLastNameAndEmail(appUser.getFirstName(), appUser.getLastName(), appUser.getEmail());
        return existingUser.isPresent();
    }

    @Override
    public AppUser saveUser(AppUser user) {
        return appUserRepository.save(user);
    }

    @Override
    public PostDTO savePost(PostDTO post) {
        Posts newPost = daoToDtoMapperService.getPostEntity(post);
        Optional<AppUser>appUser = appUserRepository.findByFirstNameAndLastNameAndEmail(post.getUserDetails().getFirstName(), post.getUserDetails().getLastName(), post.getUserDetails().getEmailId());
        newPost.setUserDetails(appUser.get());
        newPost.setLikesCount(0L);
        return daoToDtoMapperService.getPostDTO(userPostRepository.save(newPost));
    }
}
