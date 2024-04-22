package com.example.msasistencia.controller;

import com.example.msasistencia.entity.Asistencia;
import com.example.msasistencia.service.AsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asistencia")
public class AsistenciaController {
    @Autowired
    private AsistenciaService asistenciaService;
    @GetMapping
    public ResponseEntity<List<Asistencia>> listar(){
        return ResponseEntity.ok(asistenciaService.listar());
    }

    @PostMapping
    public ResponseEntity<Asistencia> guardar(@RequestBody Asistencia asistencia){
        return  ResponseEntity.ok(asistenciaService.guardar(asistencia));

    }
    @GetMapping("/{id}")
    public ResponseEntity<Asistencia> buscarPorId(@PathVariable(required = true) Integer id){
        return  ResponseEntity.ok(asistenciaService.buscarPorId(id));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Asistencia> editar(@PathVariable(required = true)Integer id,@RequestBody Asistencia asistencia){
        return ResponseEntity.ok(asistenciaService.editar(asistencia));
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable(required = true) Integer id){
        asistenciaService.eliminar(id);
        return "Eliminacion Correcta";

    }
}
