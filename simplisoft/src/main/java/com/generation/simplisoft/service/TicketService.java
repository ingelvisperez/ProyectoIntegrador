package com.generation.simplisoft.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.generation.simplisoft.model.Ticket;
import com.generation.simplisoft.repository.TicketRepository;

@Service
@Transactional

public class TicketService {

     /* 
        Necesitamos conectar esta clase con la clase repositorio
        (Lo hacemos declarando una variable de tipo TicketRepository)
        
        Asi ésta clase podrá utilizar 
        los métodos CRUD definidos en la interfaz TicketRepository 
        para interactuar con la base.
    */   

    private TicketRepository ticketRepository;

    /* Se crea el constructor de esta clase, que tiene como parámetro
     * un objeto de tipo TicketRepository.
     * 
     * Esto quiere decir que la instancia TicketService que se crea
     * tendrá acceso a un objeto de TicketRepository y así poder 
     * interactuar con la base de datos
     */
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    /* --------------------------------- */
    /* Inicio de los métodos de la clase */
    /* --------------------------------- */

    // Método SAVE: se hereda de la interfaz JpaRepository
    /*  Este método permite a la esta clase guardar un nuevo objeto ticket
        en la BD usando el objeto TicketRepository que se 
        inyecto en la clase.    
    */ 

    public void saveTicket(Ticket ticket){
        this.ticketRepository.save(ticket);
    }

    // Método ACTUALIZAR/EDITAR/UPDATE
    public void updateTicket(Ticket ticket){
        this.ticketRepository.save(ticket);
    }

    // Método para BORRAR/DELETE
    public void deleteTicket(Integer id){
        ticketRepository.deleteById(id);
    }

    //Método para BUSCAR/ENCONTRAR a TODOS
    public List<Ticket> findAll(){
        return ticketRepository.findAll();
    }


}