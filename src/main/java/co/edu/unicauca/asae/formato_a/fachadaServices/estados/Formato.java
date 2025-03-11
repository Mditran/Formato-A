package co.edu.unicauca.asae.formato_a.fachadaServices.estados;

import co.edu.unicauca.asae.formato_a.capaControladores.FormatoController;

public class Formato {
    private EstadoInt estado;
    Resultado objResultado;

    public Formato() {
        this.estado = new EstadoFormulado(); // Estado inicial
    }
    public Formato(int id, String nuevoEstado){
        switch(nuevoEstado){
            case "Aprobado":
                objResultado = this.estado.aprobarFormato(this);
                break;
            case "Corecciones":
                objResultado = this.estado.enviarParaEvaluacion(this);
                break;
            case "Evaluaciones":
                objResultado = this.estado.fijarObservacionesFormato(this);
                break;
            case "NoAprabado":
                objResultado = this.estado.noAprobarFormato(this);
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
