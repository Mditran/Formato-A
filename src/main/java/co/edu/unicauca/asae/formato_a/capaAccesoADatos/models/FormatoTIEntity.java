package co.edu.unicauca.asae.formato_a.capaAccesoADatos.models;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonTypeName("TI")
public class FormatoTIEntity extends FormatoEntity{
    FormatoTIEntity(String name){
        super(name);
        this.name = name;
    }
    private String nombreEstudiante2;
    private String codigoEstudiante2;
}
