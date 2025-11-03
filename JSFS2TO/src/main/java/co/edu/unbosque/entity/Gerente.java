package co.edu.unbosque.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "GERENTE")
@PrimaryKeyJoinColumn(name = "id_persona")
public class Gerente extends Empleado implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "contrasena", nullable = false, length = 50)
    private String contrasena;
}