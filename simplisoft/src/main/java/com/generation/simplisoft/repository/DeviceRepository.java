package com.generation.simplisoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.generation.simplisoft.model.Device;

/*  
    Esta sentencia define una interfaz de repositorio para la entidad Device utilizando Spring Data JPA. 
    La interfaz extiende la interfaz JpaRepository que proporciona métodos para realizar operaciones 
    CRUD (Crear, Leer, Actualizar, Eliminar) en la base de datos.
*/

public interface DeviceRepository extends JpaRepository<Device, Integer> {

    // @Query(Value = "", nativeQuery = true)

    // Query para buscar los equipos asociados a un username
    @Query(value = "SELECT devices.id_device, devices.device_type, devices.device_brand, devices.device_model, devices.serial_number, devices.fk_id_user FROM devices INNER JOIN Users ON Users.id_user = devices.fk_id_user WHERE Users.user_name LIKE ?1", nativeQuery = true)
    List<Device> findAllDevicesByUsername(String username);

    // Query para saber la cantidad de equipos totales
    @Query(value = "SELECT COUNT(*) FROM devices", nativeQuery = true)
    Integer numberOfDevices();

}// fin
