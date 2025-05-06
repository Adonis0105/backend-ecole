package com.tonapp.tonapp.service;



import com.tonapp.tonapp.dto.RegisterRequest;
import com.tonapp.tonapp.model.User;
import com.tonapp.tonapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public void register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.email)) {
            throw new RuntimeException("Email déjà utilisé");
        }
        User user = new User();
        user.setName(request.name);
        user.setEmail(request.email);
        user.setPassword(request.password); // À chiffrer en vrai
        userRepository.save(user);
    }
}
