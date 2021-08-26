package com.example.Springbootservices.restfulwebservices.models;

import com.example.Springbootservices.restfulwebservices.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @PostMapping("/authenticate")
    public ResponseEntity createAuthToken(@RequestBody AuthenticateRequest authenticateRequest) throws Exception {
        try {
            //getting the standard token and getting to authenticate
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticateRequest.getUsername(),
                            authenticateRequest.getPassword()));
        } catch (BadCredentialsException e){
                throw new Exception("Incorrect Username or password",e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticateRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticateResponse(jwt));
    }

}
