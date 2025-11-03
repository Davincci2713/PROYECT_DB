package co.edu.unbosque.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "PROVEEDOR")
public class Proveedor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo_proveedor", nullable = false)
    private Long codigoProveedor;

    @Column(name = "nombre", nullable = false, length = 15)
    private String nombre;

    @Column(name = "telefono", nullable = false, length = 20)
    private String telefono;

    @Column(name = "nombre_persona_contacto", length = 15)
    private String nombrePersonaContacto;

    @Column(name = "correo_electronico", nullable = false, length = 80)
    private String correoElectronico;
}