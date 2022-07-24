package com.example.crud.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "vendedor")
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ven_id", nullable = false)
    private Integer id;

    @Column(name = "ven_nombre", nullable = false, length = 100)
    private String venNombre;

    @Column(name = "ven_correo", nullable = false, length = 100)
    private String venCorreo;
}