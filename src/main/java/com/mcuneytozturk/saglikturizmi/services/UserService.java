package com.mcuneytozturk.saglikturizmi.services;

import com.mcuneytozturk.saglikturizmi.database.entity.UserRoleEntity;
import com.mcuneytozturk.saglikturizmi.database.entity.UserEntity;
import com.mcuneytozturk.saglikturizmi.database.repository.UserRoleRepository;
import com.mcuneytozturk.saglikturizmi.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;


    @Autowired
    PasswordEncoder passwordEncoder;

    public void saveUserByRole(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<UserRoleEntity> roles = new HashSet<>();
        roles.add(userRoleRepository.findByName("user").get());
        user.setRoles(roles);
        userRepository.save(user);
    }

}
