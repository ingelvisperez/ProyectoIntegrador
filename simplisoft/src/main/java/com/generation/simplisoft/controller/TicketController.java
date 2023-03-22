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

import com.generation.simplisoft.model.Ticket;
import com.generation.simplisoft.service.TicketService;

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

public class TicketController {
    
    public TicketService ticketService;
    
    /*
    * Se inicia el Constructor
    * La anotación @Autowired se puede usar en el constructor
    * para inyectar la instancia de
    * TicketService en la variable de instancia ticketService.
    * 
    * Esto se hace mediante la funcionalidad de la inyección de
    * dependencias de Spring Framework.
    */
    
    public TicketController(@Autowired TicketService ticketService) {
        this.ticketService = ticketService;
    }
    /* --------------------------------- */
    /* Métodos POST / GET / DELETE / PUT */
    /* --------------------------------- */

    // POST: Para ingresar datos a la BD
    @PostMapping("/ticket/save")
    public void saveTicket(@RequestBody Ticket ticket) {
        ticketService.saveTicket(ticket);
    }

    // PUT: Para editar datos en la BD
    @PutMapping("/ticket/Update")
    public void updateTicket(@RequestBody Ticket ticket) {
        ticketService.updateTicket(ticket);
    }

    // DELETE: Eliminar/Borrar datos de BD
    @DeleteMapping("/ticket/Delete/{id}")
    public void deleteTicket(@PathVariable Integer id) {
        ticketService.deleteTicket(id);
    }

    // GET: Para obtener datos de la BD
    @GetMapping("/ticket/FindAll")
    public List<Ticket> getTicket() {
        return ticketService.findAll();
    }  
      
}
