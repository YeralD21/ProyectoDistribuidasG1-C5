package com.example.msclientegym.controller;

import com.example.msclientegym.entity.ClienteGym;
import com.example.msclientegym.service.ClienteGymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class ClienteGymController {
    @Autowired
    private ClienteGymService clienteGymService; // Utiliza ClienteService en lugar de CategoriaService

    @GetMapping()
    public ResponseEntity<List<ClienteGym>> listar() {
        return ResponseEntity.ok().body(clienteGymService.listar());
    }
    @PostMapping()
    public ResponseEntity<ClienteGym> guardar(@RequestBody ClienteGym clienteGym){
        return ResponseEntity.ok(clienteGymService.guardar(clienteGym));
    }
    @PutMapping()
    public ResponseEntity<ClienteGym> buscarPorId(@RequestBody ClienteGym clienteGym){
        return ResponseEntity.ok(clienteGymService.buscarPorId(clienteGym));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClienteGym> editar(@PathVariable(required = true) Integer id){
        return ResponseEntity.ok().body(clienteGymService.editar(id).get());
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id){
        clienteGymService.eliminar(id);
        return "Eliminacion Correcta";
    }
}
