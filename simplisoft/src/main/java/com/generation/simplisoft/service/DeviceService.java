package com.generation.simplisoft.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.generation.simplisoft.model.Device;
import com.generation.simplisoft.repository.DeviceRepository;

@Service
@Transactional

public class DeviceService {

     /* 
        Necesitamos conectar esta clase con la clase repositorio
        (Lo hacemos declarando una variable de tipo DeviceRepository)
        
        Asi ésta clase podrá utilizar 
        los métodos CRUD definidos en la interfaz DeviceRepository 
        para interactuar con la base.
    */   

    private DeviceRepository deviceRepository;

    /* Se crea el constructor de esta clase, que tiene como parámetro
     * un objeto de tipo DeviceRepository.
     * 
     * Esto quiere decir que la instancia DeviceService que se crea
     * tendrá acceso a un objeto de DeviceRepository y así poder 
     * interactuar con la base de datos
     */
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    /* --------------------------------- */
    /* Inicio de los métodos de la clase */
    /* --------------------------------- */

    // Método SAVE: se hereda de la interfaz JpaRepository
    /*  Este método permite a la esta clase guardar un nuevo objeto device
        en la BD usando el objeto DeviceRepository que se 
        inyecto en la clase.    
    */ 

    public void saveDevice(Device device){
        this.deviceRepository.save(device);
    }

    // Método ACTUALIZAR/EDITAR/UPDATE
    public void updateDevice(Device device){
        this.deviceRepository.save(device);
    }

    // Método para BORRAR/DELETE
    public void deleteDevice(Integer id){
        deviceRepository.deleteById(id);
    }

    //Método para BUSCAR/ENCONTRAR a TODOS
    public List<Device> findAll(){
        return deviceRepository.findAll();
    }


}
