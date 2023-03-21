package com.generation.simplisoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.simplisoft.model.Device;

/*  
    Esta sentencia define una interfaz de repositorio para la entidad Device utilizando Spring Data JPA. 
    La interfaz extiende la interfaz JpaRepository que proporciona métodos para realizar operaciones 
    CRUD (Crear, Leer, Actualizar, Eliminar) en la base de datos.
*/

public interface DeviceRepository extends JpaRepository<Device, Integer>{
    //NOTA: Aqui van las consultas personalizadas

    
}
