package co.edu.unicauca.asae.formato_a.capaAccesoADatos.models;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor // 🔹 Constructor con todos los atributos

public class FormatoEntity {
    private Long id;
    private String titulo;
    private String nombreDirector;
    private String nombreEstudiante;
    private String codigoEstudiante;
    private Date fechaDeCreacion;
    private String estado;

    public FormatoEntity() {
    }
}
