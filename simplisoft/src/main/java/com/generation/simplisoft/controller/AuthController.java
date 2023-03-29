package com.generation.simplisoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.simplisoft.model.User;
import com.generation.simplisoft.model.UserRegistroDTO;
import com.generation.simplisoft.service.MyUserDetailsService;

@Controller
@CrossOrigin("*")
@RestController
@RequestMapping("/auth")

public class AuthController {
    
    //Clase de spring security que permite encriptar contraseña
    @Autowired
    private PasswordEncoder passwordEncoder;

        //Inyección de dependencia del service donde está el método de crear usuario
        @Autowired
        private MyUserDetailsService myUserDetailsService;

        //Endpoint de registro 
        @PostMapping("/register")
        public ResponseEntity<User> register(@RequestBody UserRegistroDTO userRegistroDTO) {
            
            String encryptedPassword = passwordEncoder.encode(userRegistroDTO.getUserPassword()); // Toma la contraseña y la encripta
            
            userRegistroDTO.setUserPassword(encryptedPassword); // La contraseña encriptada se setea a userRegistroDTO
            
            User usuarioRegistrado = myUserDetailsService.createUser(userRegistroDTO);  // Creamos el usuario llamando a createUser
            
            return new ResponseEntity<>(usuarioRegistrado, HttpStatus.CREATED);
        }

} //Fin de AuthController
