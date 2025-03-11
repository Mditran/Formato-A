package co.edu.unicauca.asae.formato_a.fachadaServices.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
    Optional<FormatoDTORespuesta> consultarFormato(int id){
        FormatoDTORespuesta formatoRetornar = null;
        Optional<FormatoEntity> optionalFormato = this.servicioAccesoBaseDeDatos.consultarFormato(id);
        if(optionalFormato)
    }
}
