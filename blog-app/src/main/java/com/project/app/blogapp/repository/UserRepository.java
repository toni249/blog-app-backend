package com.project.app.blogapp.repository;

import com.project.app.blogapp.dao.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser,Long>{

    Optional<AppUser> findByFirstNameAndLastNameAndEmail(String firstName, String lastName, String email);
}
