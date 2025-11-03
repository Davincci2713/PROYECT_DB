package co.edu.unbosque.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "FACTURA")
public class Factura implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_factura", nullable = false)
    private Long idFactura;

    @Column(name = "valor_impuestos", nullable = false, precision = 12, scale = 2)
    private BigDecimal valorImpuestos;

    @Column(name = "valor_propina", precision = 12, scale = 2)
    private BigDecimal valorPropina;

    @Column(name = "precio_total", nullable = false, precision = 12, scale = 2)
    private BigDecimal precioTotal;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDate fechaEmision;

    @OneToOne
    @JoinColumn(name = "PEDIDO_codigo_pedido", nullable = false, unique = true)
    private Pedido pedido;
}