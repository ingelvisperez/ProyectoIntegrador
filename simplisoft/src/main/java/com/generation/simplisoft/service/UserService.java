package com.generation.simplisoft.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.simplisoft.model.User;
import com.generation.simplisoft.repository.UserRepository;

@Service
@Transactional

public class UserService {

    /*
     * Necesitamos conectar esta clase con la clase repositorio
     * (Lo hacemos declarando una variable de tipo UserRepository)
     * 
     * Asi ésta clase podrá utilizar
     * los métodos CRUD definidos en la interfaz UserRepository
     * para interactuar con la base.
     */

    private UserRepository userRepository;

    /*
     * Se crea el constructor de esta clase, que tiene como parámetro
     * un objeto de tipo UserRepository.
     * 
     * Esto quiere decir que la instancia UserService que se crea
     * tendrá acceso a un objeto de UserRepository y así poder
     * interactuar con la base de datos
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /* --------------------------------- */
    /* Inicio de los métodos de la clase */
    /* --------------------------------- */

    // Método SAVE: se hereda de la interfaz JpaRepository
    /*
     * Este método permite a la esta clase guardar un nuevo objeto user
     * en la BD usando el objeto UserRepository que se
     * inyecto en la clase.
     */

    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    // Método ACTUALIZAR/EDITAR/UPDATE
    public void updateUser(User user) {
        this.userRepository.save(user);
    }

    // Método para BORRAR/DELETE
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    // Método para BUSCAR/ENCONTRAR a TODOS
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // Método para BUSCAR/ENCONTRAR a TODOS
    public List<User> findUserById(Integer id_user){
        return userRepository.findUserByID(id_user);
    }

}