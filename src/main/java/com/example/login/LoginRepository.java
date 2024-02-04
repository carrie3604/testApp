package com.example.login;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface LoginRepository extends CrudRepository<LoginEntity, Integer>
{
    @Query("SELECT user FROM LoginEntity user WHERE user.email = :email") // :parameter and @Param("")should be the same
    LoginEntity findUserbyEmail(@Param("email") String email);

}
