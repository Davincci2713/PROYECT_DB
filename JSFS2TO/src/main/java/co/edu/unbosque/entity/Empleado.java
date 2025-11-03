package co.edu.unbosque.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "EMPLEADO")
@PrimaryKeyJoinColumn(name = "id_persona")
public class Empleado extends Persona implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "sueldo", nullable = false, precision = 15, scale = 2)
    private BigDecimal sueldo;
}