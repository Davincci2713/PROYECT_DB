package co.edu.unbosque.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "HOGAR")
@PrimaryKeyJoinColumn(name = "codigo_producto")
public class Hogar extends Producto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "material", length = 10)
    private String material;
} 