package co.edu.unbosque.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "PERSONA")
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_persona", nullable = false)
    private Long id;

    @Column(name = "nombre1", length = 15)
    private String nombre1;

    @Column(name = "nombre2", length = 15)
    private String nombre2;

    @Column(name = "apellido1", length = 15)
    private String apellido1;

    @Column(name = "apellido2", length = 15)
    private String apellido2;
}