package userapi.employer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import userapi.employer.models.User;
import userapi.employer.repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class SecurityService {

    private final UserRepository userRepository;

    public User authenticatedUser() {
        String sub = SecurityContextHolder.getContext().getAuthentication().getName();

        return userRepository.findByUsername(sub);
    }
}
