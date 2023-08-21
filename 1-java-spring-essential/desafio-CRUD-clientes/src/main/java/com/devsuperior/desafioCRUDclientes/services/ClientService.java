package com.devsuperior.desafioCRUDclientes.services;

import com.devsuperior.desafioCRUDclientes.dto.ClientDTO;
import com.devsuperior.desafioCRUDclientes.entities.Client;
import com.devsuperior.desafioCRUDclientes.repositories.ClientRepository;
import com.devsuperior.desafioCRUDclientes.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID não encontrado"));
        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> result = clientRepository.findAll(pageable);
        return result.map(x -> new ClientDTO(x));
    }

    @Transactional
    public ClientDTO insert(ClientDTO clientDTO) {
        Client client = new Client();
        copyDtoToEntity(clientDTO, client);
        client = clientRepository.save(client);
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO clientDTO) {
        Client client = clientRepository.getReferenceById(id);
        copyDtoToEntity(clientDTO, client);
        client = clientRepository.save(client);
        return new ClientDTO(client);
    }
    @Transactional
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
    private void copyDtoToEntity(ClientDTO clientDTO, Client client) {
        client.setName(clientDTO.getName());
        client.setCpf(clientDTO.getCpf());
        client.setIncome(clientDTO.getIncome());
        client.setBirthDate(clientDTO.getBirthDate());
        client.setChildren(clientDTO.getChildren());
    }
}
