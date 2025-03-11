package co.edu.unicauca.asae.formato_a.fachadaServices.estados;

public class EstadoPorCorregir implements EstadoInt{

    @Override
    public Resultado enviarParaEvaluacion(Formato formato) {
        EstadoEnEvaluacion objEstado= new EstadoEnEvaluacion();
        formato.setEstado(objEstado);
        return new Resultado(true, "Estado cambiado a evaluación de manera exitosa");
    }

    @Override
    public Resultado aprobarFormato(Formato formato) {         
        return new Resultado(false, "Un artículo formulado con observaciones, no puede directamente aprobarse");
    }

    @Override
    public Resultado fijarObservacionesFormato(Formato formato) {
        return new Resultado(false, "A un artículo formulado con observaciones, no se le pueden fijar observaciones,"
                + "solo se pueden plantear observaciones si esta en evaluación");  
    }

    @Override
    public Resultado noAprobarFormato(Formato formato) {
        return new Resultado(false, "Un artículo formulado con observaciones, no puede directamente no aprobarse");
    }
    
    @Override
    public String toString() {
        return "Formulado con observaciones";
    }    
}
