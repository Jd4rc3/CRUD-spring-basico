package com.example.crud.controller;

import com.example.crud.domain.Factura;
import com.example.crud.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/factura")
public class FacturaController {

    @Autowired
    FacturaService facturaService;

    @GetMapping("/{id}")
    public Factura findById(@PathVariable("id") Integer id) {
        return facturaService.findById(id);
    }
}
