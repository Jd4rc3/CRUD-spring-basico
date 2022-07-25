package com.example.crud.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@JsonIgnoreProperties(value = {"vendedor",
                               "cliente",
                               "descuentoGeneral"}, allowGetters = true, allowSetters = false,
        ignoreUnknown = true)
@Table(name = "factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fac_id", nullable = false)
    private Integer id;

    @Column(name = "ven_id_vendedor", nullable = false)
    private Integer vendedorId;

    @Column(name = "cli_id_cliente", nullable = false)
    private Integer clienteId;

    @ManyToOne(targetEntity = Vendedor.class)
    @JoinColumn(name = "ven_id_vendedor", insertable = false, updatable = false)
    private Vendedor vendedor;

    @JoinColumn(name = "cli_id_cliente", nullable = false, insertable = false, updatable = false)
    @ManyToOne(targetEntity = Cliente.class)
    private Cliente cliente;

    @Column(name = "fac_descuento_general")
    private Integer descuentoGeneral = 0;

    @JsonManagedReference(value = "factura-detalle")
    @OneToMany(mappedBy = "factura")
    private List<Detalle> detalles = new ArrayList<>();
}