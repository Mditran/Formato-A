package co.edu.unicauca.asae.formato_a.fachadaServices.services;

import co.edu.unicauca.asae.formato_a.DTO.FormatoDTORespuesta;
import co.edu.unicauca.asae.formato_a.propuesta.dto.FormatoDTOPeticion;
import co.edu.unicauca.asae.formato_a.propuesta.model.Resultado;
import co.edu.unicauca.asae.formato_a.propuesta.state.EstadoInt;

import java.util.List;
import java.util.Optional;

public interface IFormatoServices {

    List<FormatoDTORespuesta> listarFormatos();
    
    Optional<FormatoDTORespuesta> consultarFormato(int id);

    FormatoDTORespuesta crearFormato(FormatoDTOPeticion formato);

    FormatoDTORespuesta actualizarFormato(int id, FormatoDTOPeticion formato);

    boolean eliminarFormato(int id);

    Resultado cambiarEstadoFormato(int id, String nuevoEstado);
}