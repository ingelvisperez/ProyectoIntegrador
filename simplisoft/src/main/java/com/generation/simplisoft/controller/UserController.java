package com.generation.simplisoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.simplisoft.model.User;
import com.generation.simplisoft.service.UserService;

//se debe especificar que es una clase de tipo controlador
/*
Es una anotación utilizada para marcar una clase que se encargará 
de manejar solicitudes HTTP y enviar respuestas en forma de objetos
Java serializados en formato JSON o XML.

*/
@Controller
// se debe especificar el origen de las peticiones, en este caso pueden
// venir de cualquier lado!
@CrossOrigin("*")
/*
 * Un controlador de REST, marcado con la anotación @RestController,
 * funciona como una combinación de las anotaciones @Controller y
 * 
 * @ResponseBody
 */
@RestController

public class UserController {

    public UserService userService;

    /*
     * Se inicia el Constructor
     * La anotación @Autowired se puede usar en el constructor
     * para inyectar la instancia de
     * UserService en la variable de instancia userService.
     * 
     * Esto se hace mediante la funcionalidad de la inyección de
     * dependencias de Spring Framework.
     */

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }
    /* --------------------------------- */
    /* Métodos POST / GET / DELETE / PUT */
    /* --------------------------------- */

    // POST: Para ingresar datos a la BD
    @PostMapping("/user/save")
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    // PUT: Para editar datos en la BD
    @PutMapping("/user/Update")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    // DELETE: Eliminar/Borrar datos de BD
    @DeleteMapping("/user/Delete/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

    // GET: Para obtener datos de la BD
    @GetMapping("/user/FindAll")
    public List<User> getUser() {
        return userService.findAll();
    }

    // GET: Para obtener los datos de un usuario usando el ID
    @GetMapping("/user/FindUserById/{id_user}")
    public List<User> getUserById(@PathVariable Integer id_user) {
        return userService.findUserById(id_user);
    }

    // GET: Para obtener los datos de un usuario usando el Rut
    @GetMapping("/user/FindUserByRut/{rut}")
    public List<User> getUserByRut(@PathVariable String rut) {
        return userService.findUserByRut(rut);
    }





}
