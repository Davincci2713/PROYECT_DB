package co.edu.unbosque.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "ALIMENTO")
@PrimaryKeyJoinColumn(name = "codigo_producto")
public class Alimento extends Producto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "fecha_vencimiento", nullable = false)
    private LocalDate fechaVencimiento;
}	