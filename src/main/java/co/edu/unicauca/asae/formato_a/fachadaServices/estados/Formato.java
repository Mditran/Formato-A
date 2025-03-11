package co.edu.unicauca.asae.formato_a.fachadaServices.estados;

import co.edu.unicauca.asae.formato_a.fachadaServices.services.EstadoService;

public class Formato {
    private EstadoInt estado;
    private Resultado objResultado;

    public Formato() {
        this.estado = new EstadoFormulado(); // Estado inicial
    }

    public Formato(Long id, String nuevoEstado, String estadoActual){
        EstadoService objFormato = new EstadoService(estadoActual);

        switch(nuevoEstado){
            case "Aprobado":
                objResultado = objFormato.getEstado().aprobarFormato(this);
                break;
            case "Correciones":  // Corregido de "Corecciones"
                objResultado = objFormato.getEstado().enviarParaEvaluacion(this);
                break;
            case "Evaluaciones":
                objResultado = objFormato.getEstado().fijarObservacionesFormato(this);
                break;
            case "NoAprobado": // Corregido de "NoAprabado"
                objResultado = objFormato.getEstado().noAprobarFormato(this);
                break;
            default:
                break;
        }
    }

    public void setEstado(EstadoInt estado) {
        this.estado = estado;
    }

    public EstadoInt getEstado() {
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
