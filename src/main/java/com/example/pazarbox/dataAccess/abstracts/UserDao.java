package com.example.pazarbox.dataAccess.abstracts;

import com.example.pazarbox.entity.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserDao  extends JpaRepository<User,Long> {
    @Query("SELECT s FROM User s WHERE s.email=?1")
    Optional<User> findUserByEmail(String email);
    @Transactional
    @Modifying
    @Query("UPDATE User a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableAppUser(String email);
    @Transactional
    @Modifying
    @Query("UPDATE User a " +
            "SET a.password = ?1 WHERE a.email = ?2")
    int updatePassword(String password,String email);
}

