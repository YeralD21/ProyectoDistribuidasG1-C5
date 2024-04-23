package com.example.msmembresia.controller;

import com.example.msmembresia.entity.Membresia;
import com.example.msmembresia.service.MembresiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/membresia")

public class MembresiaController {
    @Autowired
    private MembresiaService  membresiaService;


    @GetMapping()
    public ResponseEntity<List<Membresia>> listar() {
        return ResponseEntity.ok().body(membresiaService.listar());
    }
    @PostMapping()
    public ResponseEntity<Membresia> guardar(@RequestBody Membresia membresia){
        return ResponseEntity.ok(membresiaService.guardar(membresia));
    }
    @PutMapping()
    public ResponseEntity<Membresia> buscarPorId(@RequestBody Membresia membresia){
        return ResponseEntity.ok(membresiaService.buscarPorId(membresia));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Membresia> editar(@PathVariable(required = true) Integer id){
        return ResponseEntity.ok().body(membresiaService.editar(id).get());
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id){
        membresiaService.eliminar(id);
        return "Eliminacion Correcta";
    }
}
