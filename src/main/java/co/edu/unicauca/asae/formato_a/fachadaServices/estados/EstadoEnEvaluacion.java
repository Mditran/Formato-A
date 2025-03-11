package co.edu.unicauca.asae.formato_a.fachadaServices.estados;

public class EstadoEnEvaluacion implements EstadoInt{
    @Override
    public Resultado enviarParaEvaluacion(Formato formato) {
        return new Resultado(false, "Un formato en evaluación, no se puede enviar a evaluación");
    }

    @Override
    public Resultado aprobarFormato(Formato formato) {
        EstadoAprobado objEstado= new EstadoAprobado();
        formato.setEstado(objEstado);
        return new Resultado(true,"Estado cambiado a aprobado de manera exitosa");
    }

    @Override
    public Resultado fijarObservacionesFormato(Formato formato) {
        EstadoPorCorregir objEstado= new EstadoPorCorregir();
        formato.setEstado(objEstado);
        return new Resultado(true, "Estado cambiado a formulado con observaciones de manera exitosa");
    }

    @Override
    public Resultado noAprobarFormato(Formato formato) {
        EstadoRechazado objEstado= new EstadoRechazado();
        formato.setEstado(objEstado);
        return new Resultado(true, "Estado cambiado a no aprobado");
    }
    
    @Override
    public String toString() {
        return "En evaluación";
    }
    
}
