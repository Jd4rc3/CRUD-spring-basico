package com.example.crud.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
import javax.persistence.Table;

@Entity
@Data
@Table(name = "detalle")
public class Detalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "det_id", nullable = false)
    private Integer id;

    @Column(name = "det_cantidad", nullable = false)
    private Integer detCantidad;

    @Column(name = "det_iva", nullable = false)
    private Integer detIva;

    @Column(name = "det_descuento", nullable = false)
    private Integer detDescuento;

    @JsonBackReference(value = "factura-detalle")
    @JoinColumn(name = "fac_id_factura", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Factura factura;


    @ManyToOne(targetEntity = Producto.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "prod_id_producto", insertable = false, updatable = false)
    private Producto producto;
}