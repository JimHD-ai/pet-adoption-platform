package com.petadoption.service;

import com.petadoption.model.AppUser;

public interface UserService {
    AppUser findByUsername(String username);
    AppUser findById(Long id);
}
