package com.generation.simplisoft.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.generation.simplisoft.model.User;
import com.generation.simplisoft.model.UserRegistroDTO;
import com.generation.simplisoft.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

    //Inyección de dependencias que hacemos para poder acceder a los métodos del repository desde esta clase
    @Autowired
    private UserRepository userRepository;

    //Método para buscar el usuario por username, haciendo el llamdo al repositorio    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
        
    }

    //Metodo para crear/registrar un usuario 

    public User createUser(UserRegistroDTO userRegistroDTO) {
        User userCreation = new User();
        userCreation.setRut(userRegistroDTO.getRut());
        userCreation.setUsername(userRegistroDTO.getUsername());
        userCreation.setUserPassword(userRegistroDTO.getUserPassword());
        userCreation.setEmail(userRegistroDTO.getEmail());
        userCreation.setAddress(userRegistroDTO.getAddress());
        userCreation.setPhone(userRegistroDTO.getPhone());

        return userRepository.save(userCreation);
    }    
    
}
