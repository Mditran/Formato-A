package co.edu.unicauca.asae.formato_a.fachadaServices.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Date;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.formato_a.capaAccesoADatos.models.FormatoEntity;
import co.edu.unicauca.asae.formato_a.capaAccesoADatos.repositories.FormatoRepository;
import co.edu.unicauca.asae.formato_a.fachadaServices.DTO.FormatoDTOPeticion;
import co.edu.unicauca.asae.formato_a.fachadaServices.DTO.FormatoDTORespuesta;
import co.edu.unicauca.asae.formato_a.fachadaServices.estados.Resultado;

@Service("IDFachadaFormatoServices")
public class FormatoServiceImpl implements IFormatoServices{

    @Qualifier("IDFormatoRepository")
    private FormatoRepository servicioAccesoBaseDeDatos;
    private ModelMapper modelMapper; 

    public FormatoServiceImpl(FormatoRepository servicioAccesoBaseDeDatos, ModelMapper modelMapper){
        this.servicioAccesoBaseDeDatos = servicioAccesoBaseDeDatos;
        this.modelMapper = modelMapper;
    }

    @Override
	public List<FormatoDTORespuesta> listarFormatos() {
		List<FormatoDTORespuesta> listaRetornar;
		Optional<Collection<FormatoEntity>> formatoEntityOpt = this.servicioAccesoBaseDeDatos.listarFormatos();
		
		// Si el Optional está vacío, devolvemos una lista vacía
		if (formatoEntityOpt.isEmpty()) {
			listaRetornar=List.of(); // Retorna una lista inmutable vacía
		}
	
		// Convertimos la colección a una lista y la mapeamos a FormatoDTORespuesta
		Collection<FormatoEntity> clientesEntity = formatoEntityOpt.get();
		listaRetornar= this.modelMapper.map(clientesEntity, new TypeToken<List<FormatoDTORespuesta>>() {}.getType());
		return listaRetornar;
	}

    @Override
    public FormatoDTORespuesta consultarFormato(Long id){
        FormatoDTORespuesta formatoRetornar = null;
        Optional<FormatoEntity> optionalFormato = this.servicioAccesoBaseDeDatos.consultarFormato(id);
        if(optionalFormato.isPresent())
        {
            FormatoEntity formatoEntity=optionalFormato.get();
            formatoRetornar = this.modelMapper.map(formatoEntity, FormatoDTORespuesta.class);
        }
        return formatoRetornar;
    }

    public FormatoDTORespuesta crearFormato(FormatoDTOPeticion formato){
        FormatoDTORespuesta formatoRetornar = null;
        FormatoEntity nuevoFormato = modelMapper.map(formato, FormatoEntity.class);
        nuevoFormato.setEstado("Formulado");
        nuevoFormato.setFechaDeCreacion(new Date());
        Optional<FormatoEntity> optionalFormato = this.servicioAccesoBaseDeDatos.crearFormato(nuevoFormato);
        if(optionalFormato.isPresent())
        {
            FormatoEntity formatoEntity=optionalFormato.get();
            formatoRetornar = this.modelMapper.map(formatoEntity, FormatoDTORespuesta.class);
        }
        return modelMapper.map(formatoRetornar, FormatoDTORespuesta.class);
    }

    public FormatoDTORespuesta actualizarFormato(Long id, FormatoDTOPeticion formato){
        FormatoDTORespuesta formatoRetornar = null;
        Optional<FormatoEntity> formatoConsultar = this.servicioAccesoBaseDeDatos.consultarFormato(id);
        
        if(formatoConsultar.isPresent())
        {
            FormatoEntity nuevoFormato = modelMapper.map(formato, FormatoEntity.class);
            FormatoEntity formatoEntity=formatoConsultar.get();
            formatoEntity.setNombreEstudiante(formato.getNombreEstudiante());

            Optional<FormatoEntity> optionalFormato = this.servicioAccesoBaseDeDatos.actualizarFormato(id, nuevoFormato);
            formatoRetornar = this.modelMapper.map(optionalFormato, FormatoDTORespuesta.class);
        }
        return formatoRetornar;
    }
    public boolean eliminarFormato(Long id){
        return this.servicioAccesoBaseDeDatos.elimintarFormato(id);
    }
    public Resultado cambiarEstadoFormato(Long id, String nuevoEstado) {
        return this.servicioAccesoBaseDeDatos.consultarFormato(id)
            .map(formato -> {
                formato.setEstado(nuevoEstado);
                this.servicioAccesoBaseDeDatos.actualizarFormato(id, formato);
                return new Resultado(true, "Estado cambiado exitosamente");
            })
            .orElse(new Resultado(false, "Formato no encontrado"));
    }

}
