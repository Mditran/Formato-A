package co.edu.unicauca.asae.formato_a.capaAccesoADatos.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
    include = As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = FormatoPPEntity.class, name = "PP"),
    @JsonSubTypes.Type(value = FormatoTIEntity.class, name = "TI")
})
public class FormatoEntity {
    public String name;
    private Long id;
    private String titulo;
    private String nombreDirector;
    private String nombreEstudiante;
    private String codigoEstudiante;
    private Date fechaDeCreacion;
    private String estado;

    public FormatoEntity(String name){
        this.name = name;
    }

}
