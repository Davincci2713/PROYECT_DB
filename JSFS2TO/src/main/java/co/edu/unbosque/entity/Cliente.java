package co.edu.unbosque.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "CLIENTE")
@PrimaryKeyJoinColumn(name = "id_persona")
public class Cliente extends Persona implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "correo_electronico", length = 80)
    private String correoElectronico;
}