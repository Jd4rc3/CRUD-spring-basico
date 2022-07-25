package com.example.crud.service;

import com.example.crud.domain.Producto;
import com.example.crud.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository productoRepository;

    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto getProducto(Integer producto) {
        return productoRepository.findById(producto).orElse(null);
    }
}
