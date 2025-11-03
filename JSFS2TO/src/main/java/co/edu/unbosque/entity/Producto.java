package co.edu.unbosque.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "PRODUCTO")
@Inheritance(strategy = InheritanceType.JOINED)
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo_producto", nullable = false)
    private Long codigoProducto;

    @Column(name = "precio", nullable = false, precision = 15, scale = 2)
    private BigDecimal precio;

    @Column(name = "nombre_producto", nullable = false, length = 20)
    private String nombreProducto;

    @Column(name = "fecha_expedicion", nullable = false)
    private LocalDate fechaExpedicion;

    @Column(name = "lote_expedicion", nullable = false, length = 30)
    private String loteExpedicion;

    @Column(name = "marca", length = 20)
    private String marca;

    @Column(name = "stock", nullable = false)
    private Long stock;
}