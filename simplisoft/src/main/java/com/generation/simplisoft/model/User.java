package com.generation.simplisoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Users") // Se usa para comunicarnos con la tabla que queremos, en este caso "Roles"

// Anotaciones para el uso de Lombok
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class User {
        
    /* ------- Esto para indicarle a la tabla que ID es autoincrementable ------ */
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        /* ----------------------------------------------------------------------------- */
        /*----- El atributo ID debe venir justo después de las sentencias de arriba ---- */
        /* ---------- Los atributos coinciden con las columnas de la tabla ------------- */
        /* ----------------------------------------------------------------------------- */
        @Column(name = "id_user")        
        private Integer idUser;
               
        private String rut;
<<<<<<< HEAD
        @Column(name = "user_name")                
=======
        
        @Column(name = "user_name")
>>>>>>> 30419626f5a5527e957c2755ca06651e197c4fd1
        private String userName;
        
        @Column(name = "user_password")               
        private String userPassword;
               
        private String email;
                
        private String address;
        
        @Column(name = "user_status")               
        private Boolean userStatus; // Usuario Activo(1) o  Inactivo (0)
               
        private String phone;
        
        @Column(name = "fk_id_role")                      
        private Integer fkIdRole;
}
