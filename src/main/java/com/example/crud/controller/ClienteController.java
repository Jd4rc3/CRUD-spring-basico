package com.example.crud.controller;

import com.example.crud.controller.util.CustomResponse;
import com.example.crud.domain.Cliente;
import com.example.crud.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @Autowired
    CustomResponse customResponse;

    @PostMapping("/new")
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.createCliente(cliente));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cliente>> getAllClients() {
        var clientes = clienteService.getAllClients();
        return new ResponseEntity<>(clientes, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<CustomResponse> findByNombre(@PathVariable("nombre") String nombre) {
        List<Cliente> clientesEncontrados = clienteService.findByNombre(nombre);

        if (clientesEncontrados.isEmpty()) {
            var message = String.format("No se encontro clientes con el nombre %s", nombre);
            var respuesta = customResponse.fillFields(true, message, new String[]{},
                                                      HttpStatus.NOT_FOUND);

            return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
        }

        var message = String.format("Se encontro %d cliente(s) con el nombre %s",
                                    clientesEncontrados.size(), nombre);

        return ResponseEntity.ok(
                customResponse.fillFields(false, message, clientesEncontrados, HttpStatus.OK));
    }
}