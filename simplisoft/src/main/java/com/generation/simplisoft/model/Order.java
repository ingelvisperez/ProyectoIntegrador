package com.generation.simplisoft.model;

import javax.persistence.Entity;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Orders") // Se usa para comunicarnos con la tabla que queremos, en este caso "Roles"

// Anotaciones para el uso de Lombok
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Order {
        /* ------- Esto para indicarle a la tabla que ID es autoincrementable ------ */
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        /* ----------------------------------------------------------------------------- */
        /*----- El atributo ID debe venir justo después de las sentencias de arriba ---- */
        /* ---------- Los atributos coinciden con las columnas de la tabla ------------- */
        /* ----------------------------------------------------------------------------- */
        private Integer id_order_service;
        private String comment_initial;     // Comentario inicial al ingresar un equipo a Servicio Técnico
        private String comment_technical;   // Informe Técnico
        private String comment_client;      // Informe para el cliente
        private String status_order;        // Reparado, en reparación, ingresado, sin revisar....
        private Integer fk_id_device;       // 
        private Integer fk_id_ticket;       // 
        
        // Preguntar files que es BLOB
        private String files;               // Archivos pdf, fotos, imagen, etc
        // Preguntar DATATIME que son las fecha
        private String order_creation_date;
        private String order_close_date; 
       
       
       
}
