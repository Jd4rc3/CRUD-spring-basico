package com.example.crud.controller;

import com.example.crud.controller.util.CustomResponse;
import com.example.crud.domain.Factura;
import com.example.crud.service.FacturaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/v1/factura")
public class FacturaController {

    @Autowired
    FacturaService facturaService;

    @Autowired
    CustomResponse customResponse;

    @PostMapping("")
    public ResponseEntity<CustomResponse> create(@RequestBody Factura producto) {
        var mensaje = "Vendedor creado con exito";
        var vendedorGuardado = facturaService.create(producto);

        var respuesta = customResponse.fillFields(false, mensaje, vendedorGuardado,
                                                  HttpStatus.CREATED);

        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Factura findById(@PathVariable("id") Integer id) {
        return facturaService.findById(id);
    }

    @PutMapping("/{id}")
    public Factura update(@RequestBody Factura factura, @PathVariable("id") Integer id) {
        return facturaService.update(factura, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id, @RequestParam("nombre") String nombre) {
        log.error("Nombre {}", nombre);
        facturaService.delete(id);
    }
}