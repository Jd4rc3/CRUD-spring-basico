package com.example.crud.service;

import com.example.crud.domain.Factura;
import com.example.crud.domain.Producto;
import com.example.crud.repository.FacturaRepository;
import com.example.crud.service.interfaces.ICRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaService implements ICRUD<Factura> {
    @Autowired
    FacturaRepository facturaRepository;

    @Override
    public Factura create(Factura factura) {
        return facturaRepository.save(factura);
    }

    @Override
    public Factura findById(Integer id) {
        return facturaRepository.findById(id).orElse(null);
    }

    @Override
    public Factura update(Factura facturaNueva, Integer id) {
        var facturaAntigua = facturaRepository.findById(id).orElse(null);

       /* if (facturaAntigua != null) {
            if (facturaNueva.() != null) {
                facturaAntigua.setNombre(facturaNueva.getNombre());
            }
            if (facturaNueva.getValor() != null) {
                facturaAntigua.setValor(facturaNueva.getValor());
            }

            productoRepository.save(facturaAntigua);
        }*/

        return facturaAntigua;
    }

    @Override
    public void delete(Integer id) {
        facturaRepository.deleteById(id);
    }
}
