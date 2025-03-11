package co.edu.unicauca.asae.formato_a.fachadaServices.DTO;

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
    @JsonSubTypes.Type(value = FormatoPPDTOPeticion.class, name = "PP"),
    @JsonSubTypes.Type(value = FormatoTIDTOPeticion.class, name = "TI")
})
public class FormatoDTOPeticion {
    FormatoDTOPeticion(String name){
        this.name = name;
    }
    public String name;
    private Long id;
    private String titulo;
    private String nombreDirector;
    private String nombreEstudiante;
    private String codigoEstudiante;
}