package cl.duoc.start_up.controller;

import cl.duoc.start_up.model.Departamento;
import cl.duoc.start_up.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/departamentos")
public class DepartamentoController {
    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public ResponseEntity<List<Departamento>> listarDepartamentos(){
        List<Departamento> departamentos = departamentoService.findAll();
        return ResponseEntity.ok(departamentos);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> buscarDepartamento(@PathVariable String codigo){
        Optional<Departamento> d = departamentoService.findById(codigo);
        if (d.isEmpty()) {
            return ResponseEntity.notFound().build(); //404
        }
        return ResponseEntity.ok(d); //200
    }

    @PostMapping
    public ResponseEntity<?> agregarDepartamento(@RequestBody Departamento d){
        Departamento dNuevo = departamentoService.save(d);
        return new ResponseEntity<>(dNuevo, HttpStatus.CREATED); //201
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<?> actualizarDepartamento(@PathVariable String codigo, @RequestBody Departamento d) {
        Optional<Departamento> departamentoOpt = departamentoService.findById(codigo);
        if (departamentoOpt.isEmpty()) {
            return ResponseEntity.notFound().build(); //404
        }
        Departamento dExistente = departamentoOpt.get();
        dExistente.setNombre(d.getNombre());
        return ResponseEntity.ok(departamentoService.save(dExistente)); //200
    }
}
