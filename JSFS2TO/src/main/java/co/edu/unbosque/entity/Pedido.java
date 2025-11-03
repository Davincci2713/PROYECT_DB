package co.edu.unbosque.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "PEDIDO")
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo_pedido", nullable = false)
    private Long codigoPedido;

    @Column(name = "estado_pedido", nullable = false)
    private Byte estadoPedido;

    @Column(name = "fecha_pedido", nullable = false)
    private LocalDate fechaPedido;

    @ManyToOne
    @JoinColumn(name = "CLIENTE_id_persona", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "CAJERO_id_persona", nullable = false)
    private Cajero cajero;
}