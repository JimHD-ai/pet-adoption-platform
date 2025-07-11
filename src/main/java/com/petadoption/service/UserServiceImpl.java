package com.petadoption.service;

import com.petadoption.model.AppUser;
import com.petadoption.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public AppUser findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public AppUser findById(Long id) {
        Optional<AppUser> user = userRepository.findById(id);
        return user.orElse(null);
    }
}
