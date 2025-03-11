package co.edu.unicauca.asae.formato_a.fachadaServices.services;

import co.edu.unicauca.asae.formato_a.fachadaServices.estados.EstadoAprobado;
import co.edu.unicauca.asae.formato_a.fachadaServices.estados.EstadoEnEvaluacion;
import co.edu.unicauca.asae.formato_a.fachadaServices.estados.EstadoFormulado;
import co.edu.unicauca.asae.formato_a.fachadaServices.estados.EstadoInt;
import co.edu.unicauca.asae.formato_a.fachadaServices.estados.EstadoPorCorregir;
import co.edu.unicauca.asae.formato_a.fachadaServices.estados.EstadoRechazado;
import lombok.Getter;
@Getter
public class EstadoController {
    private EstadoInt estado = new EstadoFormulado();; 

    public EstadoController(String estadoActual){
        switch(estadoActual){
            case "Aprobado":
                this.estado = new EstadoAprobado();
                break;
            case "Corecciones":
            this.estado = new EstadoPorCorregir();
                break;
            case "Evaluaciones":
            this.estado = new EstadoEnEvaluacion();
                break;
            case "NoAprabado":
            this.estado = new EstadoRechazado();
                break;
            default:
                break;
        }
    }
}
