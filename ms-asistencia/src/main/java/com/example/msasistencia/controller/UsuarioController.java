package com.example.msasistencia.controller;

import com.example.msasistencia.entity.Usuario;
import com.example.msasistencia.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @GetMapping
    public ResponseEntity<List<Usuario>> listar(){
        return ResponseEntity.ok(usuarioService.listar());
    }

    @PostMapping
    public ResponseEntity<Usuario> guardar(@RequestBody Usuario usuario){
        return  ResponseEntity.ok(usuarioService.guardar(usuario));

    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable(required = true) Integer id){
        return  ResponseEntity.ok(usuarioService.buscarPorId(id));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> editar(@PathVariable(required = true)Integer id,@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.editar(usuario));
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable(required = true) Integer id){
        usuarioService.eliminar(id);
        return "Eliminacion Correcta";

    }
}
