package co.edu.unicauca.asae.formato_a.fachadaServices.DTO;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonTypeName("TI")
public class FormatoTIDTOPeticion extends FormatoDTOPeticion {
    FormatoTIDTOPeticion(String name){
        super(name);
        this.name = name;
    }
    private String nombreEstudiante2;
    private String codigoEstdiante2;
}