/**** Update: Tables *****/
DROP DATABASE IF EXISTS restaurante;

CREATE DATABASE restaurante DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

use restaurante;

/******* Add Table: cliente *********/

/* Build Table Structure */
CREATE TABLE cliente
(
    cli_id INTEGER UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    cli_nombre VARCHAR(100) NOT NULL,
    cli_telefono VARCHAR(50) NULL,
    cli_correo VARCHAR(100) NOT NULL
) ENGINE=InnoDB;


/******* Add Table: detalle *********/

/* Build Table Structure */
CREATE TABLE detalle
(
    det_id INTEGER UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    fac_id_factura INTEGER UNSIGNED NOT NULL,
    prod_id_producto INTEGER UNSIGNED NOT NULL,
    det_cantidad INTEGER UNSIGNED NOT NULL,
    det_iva INTEGER UNSIGNED NOT NULL,
    det_descuento INTEGER UNSIGNED DEFAULT 0 NOT NULL
) ENGINE=InnoDB;


/******* Add Table: factura *********/

/* Build Table Structure */
CREATE TABLE factura
(
    fac_id INTEGER UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    ven_id_vendedor INTEGER UNSIGNED NOT NULL,
    cli_id_cliente INTEGER UNSIGNED NOT NULL,
    fac_descuento_general INTEGER UNSIGNED DEFAULT 0 NOT NULL
) ENGINE=InnoDB;


/******* Add Table: producto *********/

/* Build Table Structure */
CREATE TABLE producto
(
    prod_id INTEGER UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    prod_nombre VARCHAR(100) NOT NULL,
    prod_valor INTEGER NOT NULL
) ENGINE=InnoDB;


/******* Add Table: vendedor *********/

/* Build Table Structure */
CREATE TABLE vendedor
(
    ven_id INTEGER UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    ven_nombre VARCHAR(100) NOT NULL,
    ven_correo VARCHAR(100) NOT NULL
) ENGINE=InnoDB;





/**** Add Foreign Keys *****/

/* Add Foreign Key: fk_detalle_factura */
ALTER TABLE detalle ADD CONSTRAINT fk_detalle_factura
    FOREIGN KEY (fac_id_factura) REFERENCES factura (fac_id)
        ON UPDATE RESTRICT ON DELETE RESTRICT;

/* Add Foreign Key: fk_detalle_producto */
ALTER TABLE detalle ADD CONSTRAINT fk_detalle_producto
    FOREIGN KEY (prod_id_producto) REFERENCES producto (prod_id)
        ON UPDATE RESTRICT ON DELETE RESTRICT;

/* Add Foreign Key: fk_factura_cliente */
ALTER TABLE factura ADD CONSTRAINT fk_factura_cliente
    FOREIGN KEY (cli_id_cliente) REFERENCES cliente (cli_id)
        ON UPDATE RESTRICT ON DELETE RESTRICT;

/* Add Foreign Key: fk_factura_vendedor */
ALTER TABLE factura ADD CONSTRAINT fk_factura_vendedor
    FOREIGN KEY (ven_id_vendedor) REFERENCES vendedor (ven_id)
        ON UPDATE RESTRICT ON DELETE RESTRICT;