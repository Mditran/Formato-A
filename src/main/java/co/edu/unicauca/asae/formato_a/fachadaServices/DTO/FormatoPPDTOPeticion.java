package co.edu.unicauca.asae.formato_a.fachadaServices.DTO;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonTypeName("PP")
public class FormatoPPDTOPeticion extends FormatoDTOPeticion{
    FormatoPPDTOPeticion(String name){
        super(name);
        this.name = name;
    }
    private String nombreAsesor;
    private String cartaDeAceptacion;
}