package userapi.employer.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import userapi.employer.errors.ErrorResponse;
import userapi.employer.services.MyUserDetailsService;
import userapi.employer.jwts.AuthenticationRequest;
import userapi.employer.jwts.AuthenticationResponse;
import userapi.employer.jwts.JwtUtil;
import userapi.employer.models.User;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {



    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private JwtUtil jwtTokenUtil;

    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)throws Exception {

        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        }catch (BadCredentialsException e) {
            throw new Exception("incorrect username or password",e);

        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final  String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }

    @PostMapping("/register")
    public ResponseEntity<?> saveUser (@RequestBody User user) throws Exception{
        return ResponseEntity.ok(userDetailsService.save(user));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody User user){
         return ResponseEntity.ok(userDetailsService.updateUser(user));

    }

    @GetMapping("/get/{occupation}")
    public ResponseEntity<?> getUserByOccupation(@PathVariable String occupation){

        return ResponseEntity.ok(userDetailsService.findUserByOccupation(occupation));
    }


    @GetMapping("/music/{id}")
    public ResponseEntity<?> getUserByMusicId(@PathVariable long id){
        return ResponseEntity.ok(userDetailsService.findByMusicId(id));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userDetailsService.findAllUser());

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id){
        return ResponseEntity.ok(userDetailsService.findUserById(id));

    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        userDetailsService.deleteUser(id);

    }

//    @GetMapping("/test")
//    public ResponseEntity<?> test() {
//        return ResponseEntity.ok(ErrorResponse.builder()
//                .detail("")
//                .errors(Map.of())
//                .status(200)
//                .build());
//    }

}
