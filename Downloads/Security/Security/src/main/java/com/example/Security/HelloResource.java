package com.example.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloResource {


    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private JwtUtil jwtTokenUtil;


    @GetMapping("/hello")
    public String hello(){
        return "Hello world";
    }


    @PostMapping("/authenticate")
    public ResponseEntity<?> createAutheticationToken(@RequestBody AuhenticationRequest auhenticationRequest)throws Exception {

        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(auhenticationRequest.getUsername(), auhenticationRequest.getPassword()));
        }catch (BadCredentialsException e) {
            throw new Exception("incorrect username or password",e);

        }

         final UserDetails userDetails = userDetailsService.loadUserByUsername(auhenticationRequest.getUsername());

        final  String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }

}
