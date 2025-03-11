package co.edu.unicauca.asae.formato_a.fachadaServices.services;

import co.edu.unicauca.asae.formato_a.fachadaServices.estados.*;

import lombok.Getter;

@Getter
public class EstadoService {
    private EstadoInt estado; 

    public EstadoService(String estadoActual){
        switch(estadoActual){
            case "Aprobado":
                this.estado = new EstadoAprobado();
                break;
            case "Correciones":  // Corregido de "Corecciones"
                this.estado = new EstadoPorCorregir();
                break;
            case "Evaluaciones":
                this.estado = new EstadoEnEvaluacion();
                break;
            case "NoAprobado": // Corregido de "NoAprabado"
                this.estado = new EstadoRechazado();
                break;
            default:
                this.estado = new EstadoFormulado(); // Estado por defecto
                break;
        }
    }
}
