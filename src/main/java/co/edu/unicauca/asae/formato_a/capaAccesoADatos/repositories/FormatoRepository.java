package co.edu.unicauca.asae.formato_a.capaAccesoADatos.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;


import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.formato_a.capaAccesoADatos.models.FormatoEntity;

@Repository("IDFormatoRepository")
public class FormatoRepository {
    private Map<Long, FormatoEntity> mapaFormatos;
    private AtomicLong contadorId;

    public FormatoRepository(){
        this.mapaFormatos = new HashMap<>();
        this.contadorId = new AtomicLong(1);
    }

    public Optional<Collection<FormatoEntity>> listarFormatos() {
        System.out.println("Invocando a listar Formatos");
        return this.mapaFormatos.isEmpty() ? Optional.empty() : Optional.of(mapaFormatos.values());
    }

    public Optional<FormatoEntity> crearFormato(FormatoEntity formato){
        formato.setId(contadorId.getAndIncrement());
        this.mapaFormatos.put(formato.getId(), formato);
        return this.consultarFormato(formato.getId());
    }

    public Optional<FormatoEntity> consultarFormato(Long id){
        System.out.println("Invocando a Consultar un Formato");
        return Optional.ofNullable(this.mapaFormatos.get(id));
    }

    public Optional<FormatoEntity> actualizarFormato(Long id, FormatoEntity formato) {
        Optional<FormatoEntity> respuesta;
		System.out.println("Invocando a actualizar un Formato");
        if (this.mapaFormatos.containsKey(id)) {
            this.mapaFormatos.put(id, formato);
            respuesta= Optional.of(formato);
        }
        else{
            respuesta= Optional.empty();
        }
		return respuesta;
    }

    public boolean elimintarFormato(Long id) {
        Boolean respuesta;
        System.out.println("Invocando a eliminar un Formato");
        respuesta = this.mapaFormatos.remove(id) != null;
        return respuesta;
    }
    public String consultarEstado(Long id){
        String estado= "";
        System.out.println("Invocando a Consultar un Formato");
        Optional<FormatoEntity> respuesta = Optional.ofNullable(this.mapaFormatos.get(id));
        if(respuesta.isPresent()){
            estado = respuesta.get().getEstado();
        }
        return estado;
    }
}
