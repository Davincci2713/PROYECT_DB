package co.edu.unbosque.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "DETALLE_FACTURA")
@IdClass(DetalleFacturaId.class)
public class DetalleFactura implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @ManyToOne
    @JoinColumn(name = "FACTURA_id_factura", nullable = false)
    private Factura factura;

    @Id
    @ManyToOne
    @JoinColumn(name = "PRODUCTO_codigo_producto", nullable = false)
    private Producto producto;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "valor_unidad", precision = 12, scale = 2)
    private BigDecimal valorUnidad;
}