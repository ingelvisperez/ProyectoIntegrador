package com.generation.simplisoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.generation.simplisoft.model.User;

/*  
    Esta sentencia define una interfaz de repositorio para la entidad User utilizando Spring Data JPA. 
    La interfaz extiende la interfaz JpaRepository que proporciona métodos para realizar operaciones 
    CRUD (Crear, Leer, Actualizar, Eliminar) en la base de datos.
*/

public interface UserRepository extends JpaRepository<User, Integer>{
     //NOTA: Aqui van las consultas personalizadas

     @Query(value = "SELECT * FROM Users WHERE id_user = ?1", nativeQuery = true)
     List <User> findUserByID(Integer id_user);

     @Query(value= "SELECT * FROM Users WHERE rut LIKE ?1", nativeQuery = true)
     List<User> findUserByRut(String rut);







}//Fin de interface
