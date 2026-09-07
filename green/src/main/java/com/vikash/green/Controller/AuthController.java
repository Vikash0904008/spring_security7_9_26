package com.vikash.green.Controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vikash.green.Entity.AuthRequest;
import com.vikash.green.Util.Util;

@RestController
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final Util util;

    AuthController(AuthenticationManager authenticationManager, Util util) {
        this.authenticationManager = authenticationManager;
        this.util = util;
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authrequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authrequest.getUsername(), authrequest.getPassword()));
            return util.generateToken(authrequest.getUsername());
        } catch (Exception e) {
            throw e;
        }

    }
}
