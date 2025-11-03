package co.edu.unbosque.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "CAJERO")
@PrimaryKeyJoinColumn(name = "id_persona")
public class Cajero extends Empleado implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "saldo", nullable = false, precision = 15, scale = 2)
    private BigDecimal saldo;
}