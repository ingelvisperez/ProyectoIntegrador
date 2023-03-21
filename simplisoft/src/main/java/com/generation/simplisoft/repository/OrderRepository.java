package com.generation.simplisoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.simplisoft.model.Order;

/*  
    Esta sentencia define una interfaz de repositorio para la entidad Order utilizando Spring Data JPA. 
    La interfaz extiende la interfaz JpaRepository que proporciona métodos para realizar operaciones 
    CRUD (Crear, Leer, Actualizar, Eliminar) en la base de datos.
*/

public interface OrderRepository extends JpaRepository<Order, Integer>{
    //NOTA: Aqui van las consultas personalizadas

    
}
