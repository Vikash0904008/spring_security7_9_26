package com.vikash.green.Repository;

import com.vikash.green.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByusername(String username);
}
