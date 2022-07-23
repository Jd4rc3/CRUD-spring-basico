package com.example.crud.service;

import com.example.crud.domain.Cliente;
import com.example.crud.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClients() {
        return clienteRepository.findAll();
    }

    public List<Cliente> findByNombre(String nombre) {
        return clienteRepository.findByNombre(nombre);
    }
}
