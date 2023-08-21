package com.devsuperior.desafioCRUDclientes.repositories;

import com.devsuperior.desafioCRUDclientes.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {


}
