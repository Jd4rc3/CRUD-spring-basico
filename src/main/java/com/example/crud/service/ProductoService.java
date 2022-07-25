package com.example.crud.service;

import com.example.crud.domain.Producto;
import com.example.crud.repository.ProductoRepository;
import com.example.crud.service.interfaces.ICRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements ICRUD<Producto> {
    @Autowired
    ProductoRepository productoRepository;
    @Override
    public Producto create(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto findById(Integer id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public Producto update(Producto productoNuevo, Integer id) {
        var productoAntiguo = productoRepository.findById(id).orElse(null);

        if (productoAntiguo != null) {
            if (productoNuevo.getNombre() != null) {
                productoAntiguo.setNombre(productoNuevo.getNombre());
            }
            if (productoNuevo.getValor() != null) {
                productoAntiguo.setValor(productoNuevo.getValor());
            }

            productoRepository.save(productoAntiguo);
        }
        return productoAntiguo;
    }

    @Override
    public void delete(Integer id) {
        productoRepository.deleteById(id);
    }
}
