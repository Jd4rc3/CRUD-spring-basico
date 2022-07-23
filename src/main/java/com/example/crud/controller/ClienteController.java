package com.example.crud.controller;

import com.example.crud.domain.Cliente;
import com.example.crud.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping("/all")
    public ResponseEntity<List<Cliente>> getAllClients() {
        var clientes = clienteService.getAllClients();
        return new ResponseEntity<>(clientes, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<List<Cliente>> findByNombre(@PathVariable("nombre") String apellido) {
        var clientes = clienteService.findByNombre(apellido);
        return new ResponseEntity<>(clientes, HttpStatus.NOT_FOUND);
    }
}