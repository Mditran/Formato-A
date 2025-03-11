package co.edu.unicauca.asae.formato_a.fachadaServices.estados;

public class EstadoRechazado implements EstadoInt{

    @Override
    public Resultado enviarParaEvaluacion(Formato formato) {
        return new Resultado(false, "No se le puede cambiar el estado a un artículo no aprobado");
    }

    @Override
    public Resultado aprobarFormato(Formato formato) {
        return new Resultado(false, "No se le puede cambiar el estado a un artículo no aprobado");
    }

    @Override
    public Resultado fijarObservacionesFormato(Formato formato) {
        return new Resultado(false, "No se le puede cambiar el estado a un artículo no aprobado");
    }

    @Override
    public Resultado noAprobarFormato(Formato formato) {
        return new Resultado(false, "No se le puede cambiar el estado a un artículo no aprobado");
    }
    
    @Override
    public String toString() {
        return "No aprobado";
    }
    
}
