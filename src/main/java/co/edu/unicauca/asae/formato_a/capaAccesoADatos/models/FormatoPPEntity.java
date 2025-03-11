package co.edu.unicauca.asae.formato_a.capaAccesoADatos.models;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormatoPPEntity extends FormatoEntity{
    private String nombreAsesor;
    private String cartaDeAceptacion;
    public FormatoPPEntity(){
    }
}
