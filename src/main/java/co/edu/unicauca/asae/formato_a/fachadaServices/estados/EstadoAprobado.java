package co.edu.unicauca.asae.formato_a.fachadaServices.estados;

public class EstadoAprobado implements EstadoInt{

    @Override
    public Resultado enviarParaEvaluacion(Formato formato) {
        return new Resultado(false, "Un artículo aprobado no se puede enviar a evaluar");
    }

    @Override
    public Resultado aprobarFormato(Formato formato) {
        return new Resultado(false, "Un artículo aprobado no se puede volver a aprobar");
    }

    @Override
    public Resultado fijarObservacionesFormato(Formato formato) {
        return new Resultado(false, "Un artículo aprobado no  puede volver a tener observaciones");
    }

    @Override
    public Resultado noAprobarFormato(Formato formato) {
        return new Resultado(false, "Un artículo aprobado no puede no aprobarse");
    }

    @Override
    public String toString() {
        return "Aprobado";
    }
    
}
