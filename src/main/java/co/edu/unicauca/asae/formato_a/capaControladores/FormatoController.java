package co.edu.unicauca.asae.formato_a.capaControladores;

import co.edu.unicauca.asae.formato_a.fachadaServices.services.IFormatoServices;
import co.edu.unicauca.asae.formato_a.fachadaServices.DTO.FormatoDTORespuesta;
import co.edu.unicauca.asae.formato_a.fachadaServices.DTO.FormatoDTOPeticion;
import co.edu.unicauca.asae.formato_a.fachadaServices.estados.Resultado;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/propuestas")
public class FormatoController {

    private final IFormatoServices formatoServices;

    public FormatoController(IFormatoServices formatoServices) {
        this.formatoServices = formatoServices;
    }

    @GetMapping
    public List<FormatoDTORespuesta> listarPropuestas() {
        return formatoServices.listarFormatos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormatoDTORespuesta> consultarPropuesta(@PathVariable Long id) {
        return ResponseEntity.of(Optional.ofNullable(formatoServices.consultarFormato(id)));
    }

    @PostMapping
    public ResponseEntity<FormatoDTORespuesta> crearPropuesta(@RequestBody FormatoDTOPeticion formato) {
        return ResponseEntity.ok(formatoServices.crearFormato(formato));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormatoDTORespuesta> actualizarPropuesta(
            @PathVariable Long id, @RequestBody FormatoDTOPeticion formato) {
        return ResponseEntity.ok(formatoServices.actualizarFormato(id, formato));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminarPropuesta(@PathVariable Long id) {
        return ResponseEntity.ok(formatoServices.eliminarFormato(id));
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<Resultado> cambiarEstado(
            @PathVariable Long id, @RequestBody String nuevoEstado) {
        return ResponseEntity.ok(formatoServices.cambiarEstadoFormato(id, nuevoEstado));
    }
}
