package co.edu.unicauca.asae.formato_a.fachadaServices.estados;

public interface EstadoInt {
    Resultado enviarParaEvaluacion(Formato formato);
    Resultado aprobarFormato(Formato formato);
    Resultado fijarObservacionesFormato(Formato formato);
    Resultado noAprobarFormato(Formato formato);
}
