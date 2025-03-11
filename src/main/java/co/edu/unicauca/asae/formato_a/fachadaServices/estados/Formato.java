package co.edu.unicauca.asae.formato_a.fachadaServices.estados;

import co.edu.unicauca.asae.formato_a.capaControladores.FormatoController;
import co.edu.unicauca.asae.formato_a.fachadaServices.DTO.FormatoDTORespuesta;
import co.edu.unicauca.asae.formato_a.fachadaServices.services.FormatoServiceImpl;

public class Formato {
    private EstadoInt estado;
    Resultado objResultado;

    public Formato() {
        this.estado = new EstadoFormulado(); // Estado inicial
    }

    public Formato(int id, String nuevoEstado){
        String estadoActual = FormatoServiceImpl.consultarFormato(id).estado;
        EstadoController objFormato = new EstadoController(estadoActual);

        switch(nuevoEstado){
            case "Aprobado":
                objResultado = objFormato.aprobarFormato(this);
                break;
            case "Corecciones":
                objResultado = objFormato.enviarParaEvaluacion(this);
                break;
            case "Evaluaciones":
                objResultado = objFormato.fijarObservacionesFormato(this);
                break;
            case "NoAprabado":
                objResultado = objFormato.noAprobarFormato(this);
                break;
            default:
                break;
        }
    }

    public void setEstado(EstadoInt estado) {
        this.estado = estado;
    }
    
    public EstadoInt getEstado()  {
        return this.estado;
    }
        
    public Resultado enviarParaEvaluacion() {
        return this.estado.enviarParaEvaluacion(this);
    }
    
    public Resultado aprobarFormato() {
        return this.estado.aprobarFormato(this);
    }
    
    public Resultado fijarObservacionesFormato() {
        return this.estado.fijarObservacionesFormato(this);
    }
    
    public Resultado noAprobarFormato() {
        return this.estado.noAprobarFormato(this);
    } 
}
