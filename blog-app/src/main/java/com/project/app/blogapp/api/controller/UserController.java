package com.project.app.blogapp.api.controller;

import com.project.app.blogapp.api.request.UserCreationRequest;
import com.project.app.blogapp.api.request.UserPostCreationRequest;
import com.project.app.blogapp.api.response.UserCreationResponse;
import com.project.app.blogapp.dao.AppUser;
import com.project.app.blogapp.dto.AppUserDTO;
import com.project.app.blogapp.dto.PostDTO;
import com.project.app.blogapp.service.AppUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/v1")
@Slf4j
public class UserController {

    private AppUserService appUserService;


    public UserController(AppUserService userService){
        appUserService = userService;
    }

    @GetMapping(value = "/health-check",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getSubmit(){
        return "running..";
    }

    @PostMapping(value="/save-user", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserCreationResponse> createUser(
            @RequestBody UserCreationRequest userCreationRequest){
        try {
            AppUser newAppUser = new AppUser();
            newAppUser.setFirstName(userCreationRequest.getFirstName());
            newAppUser.setLastName(userCreationRequest.getLastName());
            newAppUser.setDob(userCreationRequest.getDob());
            newAppUser.setEmail(userCreationRequest.getMail());
            newAppUser.setPassword(userCreationRequest.getPassword());
            if(appUserService.isUserExit(newAppUser)){
                return new ResponseEntity<>(UserCreationResponse.builder().remark("User already exits.").build() , HttpStatus.BAD_REQUEST);
            }else {
                appUserService.saveUser(newAppUser);
                return new ResponseEntity<>(UserCreationResponse.builder().remark("User is created").build(),HttpStatus.CREATED);
            }
        }catch (Exception e){
            log.info("exceptions: {}", e.getMessage());
            return new ResponseEntity<>(UserCreationResponse.builder().remark("User is not created. Exception is "+ e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/create-post", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostDTO> createPost(@RequestBody UserPostCreationRequest userPostCreationRequest,
                        @RequestParam("UserMailId") String userMailId, @RequestParam("UserName") String userName){
        PostDTO newPost = new PostDTO();
        newPost.setContent(userPostCreationRequest.getContent());
        newPost.setTitle(userPostCreationRequest.getTitle());
        newPost.setDateOfPublish(LocalDateTime.now());
        newPost.setLikesCount(0L);
        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setEmailId(userMailId);
        String[] userData = userName.split("\\.");
        appUserDTO.setFirstName(userData[0]);
        appUserDTO.setLastName(userData[1]);
        newPost.setUserDetails(appUserDTO);
        newPost = appUserService.savePost(newPost);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }

}
