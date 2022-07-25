package com.example.crud.service;

import com.example.crud.domain.Vendedor;
import com.example.crud.repository.VendedorRepository;
import com.example.crud.service.interfaces.ICRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendedorService implements ICRUD<Vendedor> {

    @Autowired
    VendedorRepository vendedorRepository;


    @Override
    public Vendedor create(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    @Override
    public Vendedor findById(Integer id) {
        return vendedorRepository.findById(id).orElse(new Vendedor());
    }

    @Override
    public Vendedor update(Vendedor vendedorNuevo, Integer id) {
        var vendedorAntiguo = vendedorRepository.findById(id).orElse(null);

        if (vendedorAntiguo != null) {
            if (vendedorNuevo.getNombre() != null) {
                vendedorAntiguo.setNombre(vendedorNuevo.getNombre());
            }
            if (vendedorNuevo.getCorreo() != null) {
                vendedorAntiguo.setCorreo(vendedorNuevo.getCorreo());
            }

            vendedorRepository.save(vendedorAntiguo);
        }
        return vendedorAntiguo;
    }

    @Override
    public void delete(Integer id) {
        vendedorRepository.deleteById(id);
    }
}
