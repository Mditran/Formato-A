package co.edu.unicauca.asae.formato_a.capaAccesoADatos.models;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonTypeName("PP")
public class FormatoPPEntity extends FormatoEntity{
    FormatoPPEntity(String name){
        super(name);
        this.name = name;
    }
    private String nombreAsesor;
    private String cartaDeAceptacion;
}
