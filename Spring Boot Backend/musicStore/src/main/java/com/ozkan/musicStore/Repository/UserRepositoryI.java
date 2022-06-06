package com.ozkan.musicStore.Repository;


import com.ozkan.musicStore.Model.Role;
import com.ozkan.musicStore.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepositoryI extends JpaRepository<User, Long>
{
    Optional<User> findByUsername(String username);

    // Update user role
    @Modifying
    @Query("update User set role = :role where username = :username")
    void updateUserRole(@Param("username") String username, @Param("role") Role role);
}
