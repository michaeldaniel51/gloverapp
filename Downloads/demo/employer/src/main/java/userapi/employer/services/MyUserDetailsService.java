package userapi.employer.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import userapi.employer.exceptions.UserNotFoundException;
import userapi.employer.jwts.JwtUtil;
import userapi.employer.models.Music;
import userapi.employer.models.User;
import userapi.employer.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MyUserDetailsService implements UserDetailsService {



    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private JwtUtil jwtTokenUtil;


    @Autowired
    private  MusicService musicService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
     private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("username not found" + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());

    }

       public User save(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);

    }

    /**
     * find a user by musicId
     * @param id
     * @return
     */

    public List<User> findByMusicId(long id){
        List<User> user = userRepository.findByMusicId(id);
        return  user;

    }

    /**
     * find a user by occupation
     * @param occupation
     * @return
     */

    public List<User> findUserByOccupation(String occupation){

        List<User> user = userRepository.findByOccupation(occupation);
        return user;

    }



    public Optional<User> findUserById(int id){
        Optional<User> user = Optional.ofNullable(userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(" user with this id " + id + " does not exist ")));
        return user;

    }

        public void deleteUser(int id){
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
    }
        else {
            throw new UserNotFoundException("User not found with id " + id + " try another userId ");
        }

    }


    public List<User> findAllUser(){
       return userRepository.findAll()
                .stream().collect(Collectors.toList());
    }


    public User updateUser(User user){
        System.out.println(user);
        User userById = findUserById(user.getId()).orElseThrow();

//        try {
            if (!user.getEmail().equalsIgnoreCase(userById.getEmail())) {
                userById.setEmail(user.getEmail());
            }

//         if(!user.getPassword().equalsIgnoreCase(userById.getPassword())){
//            userById.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//           }
//
//            if (!user.getDateOfBirth().equals(userById.getDateOfBirth())) {
//                userById.setDateOfBirth(user.getDateOfBirth());
//            }
//
//            if (!user.getEmail().equalsIgnoreCase(userById.getEmail())) {
//                userById.setEmail(user.getEmail());
//            }
//            if (!user.getLgaOfResidence().equalsIgnoreCase(userById.getLgaOfResidence())) {
//                userById.setLgaOfResidence(user.getLgaOfResidence());
//            }
//
//            if (!user.getGender().equals(userById.getGender())) {
//                userById.setGender(user.getGender());
//            }
//
//            if (!user.getMaritalStatus().equals(userById.getMaritalStatus())) {
//                userById.setMaritalStatus(user.getMaritalStatus());
//            }
//
//            if (!user.getOccupation().equalsIgnoreCase(userById.getOccupation())) {
//                userById.setOccupation(user.getOccupation());
//            }
//
//            if (!user.getPhoneNumber().equalsIgnoreCase(userById.getPhoneNumber())) {
//                userById.setPhoneNumber(user.getPhoneNumber());
//            }
//
//            if (!user.getStateOfOrigin().equalsIgnoreCase(userById.getStateOfOrigin())) {
//                userById.setStateOfOrigin(user.getStateOfResidence());
//            }
//
//            if (!user.getStateOfResidence().equalsIgnoreCase(userById.getStateOfResidence())) {
//                userById.setStateOfResidence(user.getStateOfResidence());
//            }
//        } catch (NullPointerException ex) {
//            System.out.println(ex.getMessage());
//        }

        return userRepository.save(userById);

    }





}