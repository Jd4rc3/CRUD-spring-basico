package com.example.crud.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fac_id", nullable = false)
    private Integer id;

    @Column(name = "fac_descuento_general", nullable = false)
    private Integer facDescuentoGeneral;

    @Column(name = "ven_id_vendedor", nullable = false)
    private Integer vendedorId;

    @JsonManagedReference(value = "factura-detalle")
    @OneToMany(mappedBy = "factura")
    private List<Detalle> detalles = new ArrayList<>();

    @JoinColumn(name = "cli_id_cliente", nullable = false)
    @ManyToOne(targetEntity = Cliente.class)
    @JsonManagedReference(value = "cliente-factura")
    private Cliente cliente;


}