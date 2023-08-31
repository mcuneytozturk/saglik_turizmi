package com.mcuneytozturk.saglikturizmi.controller;

import com.mcuneytozturk.saglikturizmi.database.entity.AdminEntity;
import com.mcuneytozturk.saglikturizmi.database.entity.PatientEntity;
import com.mcuneytozturk.saglikturizmi.database.entity.UserEntity;
import com.mcuneytozturk.saglikturizmi.model.RequestDTO.LoginRequestDTO;
import com.mcuneytozturk.saglikturizmi.services.AdminService;
import com.mcuneytozturk.saglikturizmi.services.PatientService;
import com.mcuneytozturk.saglikturizmi.services.UserService;
import com.mcuneytozturk.saglikturizmi.util.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("auth")
public class AuthorizationController {


    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    UserService userService;
    @Autowired
    PatientService patientService;
    @Autowired
    AdminService adminService;


    @PostMapping("login")
    public Map<String, Object> loginHandler(@RequestBody LoginRequestDTO body) {
        UsernamePasswordAuthenticationToken authInputToken =
                new UsernamePasswordAuthenticationToken(body.getEmail(), body.getPassword());

        authManager.authenticate(authInputToken);

        String token = jwtUtil.generateToken(body.getEmail());

        Map<String, Object> authorizationMap = new HashMap<>();
        authorizationMap.put("jwt-token", token);
        //authorizationMap.put("gender", user.getGenderEnum() != null ? user.getGenderEnum().name() : "");
        //Collections.singletonMap("jwt-token", token);

        return authorizationMap;
    }


    @PostMapping("user-register")
    public ResponseEntity<Boolean> loginHandler(@RequestBody UserEntity body) {
        userService.saveUserByRole(body);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

    @PostMapping("admin-register")
    public ResponseEntity<Boolean> loginHandler(@RequestBody AdminEntity body) {
        adminService.saveAdminByRole(body);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

    @PostMapping("patient-register")
    public ResponseEntity<Boolean> loginHandler(@RequestBody PatientEntity body) {
        patientService.savePatientByRole(body);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }


}
