package co.edu.unbosque.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "COMPRA")
public class Compra implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo_compra", nullable = false)
    private Long codigoCompra;

    @Column(name = "fecha_compra")
    private LocalDate fechaCompra;

    @ManyToOne
    @JoinColumn(name = "GERENTE_id_persona", nullable = false)
    private Gerente gerente;

    @ManyToOne
    @JoinColumn(name = "PROVEEDOR_codigo_proveedor", nullable = false)
    private Proveedor proveedor;
}