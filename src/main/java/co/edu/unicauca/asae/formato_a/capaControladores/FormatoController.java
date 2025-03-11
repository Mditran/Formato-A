package co.edu.unicauca.asae.formato_a.capaControladores;

package co.edu.unicauca.asae.formato_a.capaControladores;

import co.edu.unicauca.asae.formato_a.fachadaServices.services.IFormatoServices;
import co.edu.unicauca.asae.formato_a.fachadaServices.DTO.FormatoDTORespuesta;
import co.edu.unicauca.asae.formato_a.fachadaServices.DTO.FormatoDTOPeticion;
import co.edu.unicauca.asae.formato_a.fachadaServices.estados.EstadoInt;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<FormatoDTORespuesta> consultarPropuesta(@PathVariable int id) {
        return ResponseEntity.of(formatoServices.consultarFormato(id));
    }

    @PostMapping
    public ResponseEntity<FormatoDTORespuesta> crearPropuesta(@RequestBody FormatoDTOPeticion formato) {
        return ResponseEntity.ok(formatoServices.crearFormato(formato));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormatoDTORespuesta> actualizarPropuesta(
            @PathVariable int id, @RequestBody FormatoDTOPeticion formato) {
        return ResponseEntity.ok(formatoServices.actualizarFormato(id, formato));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminarPropuesta(@PathVariable int id) {
        return ResponseEntity.ok(formatoServices.eliminarFormato(id));
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<Resultado> cambiarEstado(
            @PathVariable int id, @RequestBody EstadoInt nuevoEstado) {
        return ResponseEntity.ok(formatoServices.cambiarEstadoFormato(id, nuevoEstado));
    }
}