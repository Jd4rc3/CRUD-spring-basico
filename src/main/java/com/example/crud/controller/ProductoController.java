package com.example.crud.controller;

import com.example.crud.controller.util.CustomResponse;
import com.example.crud.domain.Producto;
import com.example.crud.domain.Vendedor;
import com.example.crud.service.ProductoService;
import com.example.crud.service.VendedorService;
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

@RequestMapping("/api/v1/producto")
@RestController
@Slf4j
public class ProductoController {
    @Autowired
    ProductoService productoService;
    @Autowired
    CustomResponse customResponse;

    @PostMapping("")
    public ResponseEntity<CustomResponse> create(@RequestBody Producto producto) {
        var mensaje = "Vendedor creado con exito";
        var vendedorGuardado = productoService.create(producto);

        var respuesta = customResponse.fillFields(false, mensaje, vendedorGuardado,
                                                  HttpStatus.CREATED);

        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Producto findById(@PathVariable("id") Integer id) {
        return productoService.findById(id);
    }

    @PutMapping("/{id}")
    public Producto update(@RequestBody Producto factura, @PathVariable("id") Integer id) {
        return productoService.update(factura, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id, @RequestParam("nombre") String nombre) {
        log.error("Nombre {}", nombre);
        productoService.delete(id);
    }
}
