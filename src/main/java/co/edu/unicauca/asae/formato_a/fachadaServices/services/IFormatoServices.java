package co.edu.unicauca.asae.formato_a.fachadaServices.services;

import co.edu.unicauca.asae.formato_a.fachadaServices.DTO.FormatoDTORespuesta;
import co.edu.unicauca.asae.formato_a.fachadaServices.DTO.FormatoDTOPeticion;
import co.edu.unicauca.asae.formato_a.fachadaServices.estados.Resultado;
import co.edu.unicauca.asae.formato_a.fachadaServices.estados.EstadoInt;

import java.util.List;
import java.util.Optional;

public interface IFormatoServices {

    public List<FormatoDTORespuesta> listarFormatos();
    
    public FormatoDTORespuesta consultarFormato(Long id);

    public FormatoDTORespuesta crearFormato(FormatoDTOPeticion formato);

    public FormatoDTORespuesta actualizarFormato(Long id, FormatoDTOPeticion formato);

    public boolean eliminarFormato(Long id);

    public Resultado cambiarEstadoFormato(Long id, String nuevoEstado);
}