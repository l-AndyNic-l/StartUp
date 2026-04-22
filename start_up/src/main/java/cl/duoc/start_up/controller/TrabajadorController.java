package cl.duoc.start_up.controller;

import cl.duoc.start_up.dto.TrabajadorDTO;
import cl.duoc.start_up.model.Departamento;
import cl.duoc.start_up.model.Trabajador;
import cl.duoc.start_up.service.TrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/trabajadores")
public class TrabajadorController {

    @Autowired
    private TrabajadorService trabajadorService;

    @GetMapping
    public ResponseEntity<List<TrabajadorDTO>> listarTrabajadores(){
        List<TrabajadorDTO> Trabajadores = trabajadorService.findAll();
        return ResponseEntity.ok(Trabajadores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarTrabajador(@PathVariable Long id){
        TrabajadorDTO trabajadorTemp = trabajadorService.findOne(id);
        if (trabajadorTemp == null) {
            return ResponseEntity.notFound().build(); //404
        }
        return ResponseEntity.ok(trabajadorTemp); //200
    }

    @PostMapping
    public ResponseEntity<?> agregarTrabajador(@RequestBody Trabajador t){
        Trabajador tNuevo = trabajadorService.save(t);
        return new ResponseEntity<>(tNuevo, HttpStatus.CREATED); //201
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTrabajador(@RequestBody Trabajador t) {
        TrabajadorDTO trabajadorTemp = trabajadorService.findOne(t.getId());
        if (trabajadorTemp == null) {
            return ResponseEntity.notFound().build(); //404
        }
        trabajadorService.delete(trabajadorTemp.getId());
        return ResponseEntity.noContent().build(); //204
    }

    @GetMapping("/buscar-por-email/{e}")
    public ResponseEntity<?> buscarTrabajadorEmail (@PathVariable String e ) {
        TrabajadorDTO trabajadorTemp = trabajadorService.findByEmail( e );
        if (trabajadorTemp == null) {
            return ResponseEntity.notFound().build(); //404
        }
        return ResponseEntity.ok(trabajadorTemp); //200
    }

    @GetMapping("/listar-por-especialidad/{e}")
    public ResponseEntity<?> listarTrabajadoresEspecialidad (@PathVariable String e ) {
        List<TrabajadorDTO> trabajadoresTemp = trabajadorService.findAllByEspecialidad( e );
        if (trabajadoresTemp == null) {
            return ResponseEntity.noContent().build(); //204
        }
        return ResponseEntity.ok(trabajadoresTemp); //200
    }

    @GetMapping("/listar-por-departamento/{cod}")
    public ResponseEntity<?> listarTrabajadoresDepartamento (@PathVariable String cod ) {
        List<TrabajadorDTO> trabajadoresTemp = trabajadorService.findAllByDepartamento_Codigo( cod );
        if (trabajadoresTemp == null) {
            return ResponseEntity.noContent().build(); //204
        }
        return ResponseEntity.ok(trabajadoresTemp); //200
    }

    @GetMapping("/listar-por-sueldo-mayor/{sld}")
    public ResponseEntity<?> listarTrabajadoresSueldoMayor (@PathVariable int sld ) {
        List<TrabajadorDTO> trabajadoresTemp = trabajadorService.findSueldoMayor( sld );
        if (trabajadoresTemp == null) {
            return ResponseEntity.noContent().build(); //204
        }
        return ResponseEntity.ok(trabajadoresTemp); //200
    }

    @GetMapping("/listar-por-sueldo-menor/{sld}")
    public ResponseEntity<?> listarTrabajadoresSueldoMenor (@PathVariable int sld ) {
        List<TrabajadorDTO> trabajadoresTemp = trabajadorService.findSueldoMenor( sld );
        if (trabajadoresTemp == null) {
            return ResponseEntity.noContent().build(); //204
        }
        return ResponseEntity.ok(trabajadoresTemp); //200
    }

    @GetMapping("/listar-por-sueldo-entre/{sld_a/{sld_b}}")
    public ResponseEntity<?> listarTrabajadoresSueldoEntre (@PathVariable int sld_a, @PathVariable int sld_b ) {
        List<TrabajadorDTO> trabajadoresTemp = trabajadorService.findSueldoEntre( sld_a, sld_b );
        if (trabajadoresTemp == null) {
            return ResponseEntity.noContent().build(); //204
        }
        return ResponseEntity.ok(trabajadoresTemp); //200
    }

    @GetMapping("/listar-por-experiencia/{e}")
    public ResponseEntity<?> listarTrabajadoresExperiencia (@PathVariable int e ) {
        List<TrabajadorDTO> trabajadoresTemp = trabajadorService.findAllExperiencia( e );
        if (trabajadoresTemp == null) {
            return ResponseEntity.noContent().build(); //204
        }
        return ResponseEntity.ok(trabajadoresTemp); //200
    }

    @GetMapping("/sueldo-total-departamento/{cod}")
    public ResponseEntity<?> sueldoTotalDepartamento (@PathVariable String cod ) {
        int sueldoTotalDepartamento = trabajadorService.findSueldoDepartamento( cod );
        if (sueldoTotalDepartamento == 0) {
            return ResponseEntity.noContent().build(); //204
        }
        return ResponseEntity.ok(sueldoTotalDepartamento); //200
    }

}
