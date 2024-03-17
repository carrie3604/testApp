package com.example.login;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<UserEntity, Integer>
{
    @Query("SELECT u FROM UserEntity u WHERE u.email = :email") // :parameter and @Param("")should be the same
    UserEntity findbyEmail(@Param("email") String email);

    @Query("SELECT u FROM UserEntity u WHERE u.password = :password")
    UserEntity findbyPassword(@Param("password") String password);

}
