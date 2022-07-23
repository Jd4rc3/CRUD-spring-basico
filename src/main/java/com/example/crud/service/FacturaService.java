package com.example.crud.service;

import com.example.crud.domain.Factura;
import com.example.crud.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaService {
    @Autowired
    FacturaRepository facturaRepository;

    public Factura findById(Integer id) {
        return facturaRepository.findById(id).orElse(null);
    }
}
