package com.vikash.green.Configuration;

import com.vikash.green.Entity.Users;
import com.vikash.green.Repository.UserDetailsRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataSeeder {

    @Bean
    public ApplicationRunner seedDefaultUser(UserDetailsRepository userDetailsRepository,
            PasswordEncoder passwordEncoder) {
        return (ApplicationArguments args) -> {
            userDetailsRepository.findByusername("vikas").orElseGet(() -> {
                Users user = new Users();
                user.setUsername("vikas");
                user.setPassword(passwordEncoder.encode("pass123"));
                user.setRoll("ROLE_USER");
                return userDetailsRepository.save(user);
            });
        };
    }
}
