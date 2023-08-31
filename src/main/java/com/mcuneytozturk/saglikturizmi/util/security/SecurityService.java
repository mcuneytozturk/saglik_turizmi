package com.mcuneytozturk.saglikturizmi.util.security;

import com.mcuneytozturk.saglikturizmi.database.entity.AdminEntity;
import com.mcuneytozturk.saglikturizmi.database.entity.PatientEntity;
import com.mcuneytozturk.saglikturizmi.database.entity.UserEntity;
import com.mcuneytozturk.saglikturizmi.database.repository.AdminRepository;
import com.mcuneytozturk.saglikturizmi.database.repository.PatientRepository;
import com.mcuneytozturk.saglikturizmi.database.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SecurityService implements UserDetailsService {

    private final UserRepository userRepository;

    private final AdminRepository adminRepository;

    private final PatientRepository patientRepository;

    public SecurityService(UserRepository userRepository, AdminRepository adminRepository, PatientRepository patientRepository) {
        this.userRepository = userRepository;
        this.adminRepository = adminRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.findByEmail(email);
        Optional<PatientEntity> patient = patientRepository.findByEmail(email);
        Optional<AdminEntity> admin = adminRepository.findByEmail(email);

        if (user.isEmpty() && patient.isEmpty() && admin.isEmpty()){
            throw new UsernameNotFoundException("Could not find user with email: " + email);
        }

        Set<SimpleGrantedAuthority> authorities = new HashSet<>();

        if (user.isPresent()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            return new User(email, user.get().getPassword(), authorities);
        }

        if (patient.isPresent()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_PATIENT"));
            return new User(email, patient.get().getPassword(), authorities);
        }

        if (admin.isPresent()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            return new User(email, admin.get().getPassword(), authorities);
        }

        throw new UsernameNotFoundException("Could not find user with email: " + email);

    }
}
