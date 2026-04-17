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
        TrabajadorDTO t = trabajadorService.findOne(id);
        if (t == null) {
            return ResponseEntity.notFound().build(); //404
        }
        return ResponseEntity.ok(t); //200
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
}
