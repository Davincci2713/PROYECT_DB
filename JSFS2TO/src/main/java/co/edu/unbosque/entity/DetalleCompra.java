package co.edu.unbosque.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "DETALLE_COMPRA")
@IdClass(DetalleCompraId.class)  // ¡IMPORTANTE!
public class DetalleCompra implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @ManyToOne
    @JoinColumn(name = "COMPRA_codigo_compra", nullable = false)
    private Compra compra;

    @Id
    @ManyToOne
    @JoinColumn(name = "PRODUCTO_codigo_producto", nullable = false)
    private Producto producto;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "valor_unidad", precision = 12, scale = 2)
    private BigDecimal valorUnidad;
}