package co.edu.unbosque.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "LIMPIEZA")
@PrimaryKeyJoinColumn(name = "codigo_producto")
public class Limpieza extends Producto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "toxicidad", nullable = false)
    private Byte toxicidad;

    @Column(name = "presentacion", length = 10)
    private String presentacion;
}