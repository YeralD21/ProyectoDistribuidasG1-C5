package com.example.msmembresia.service;

import com.example.msmembresia.entity.Membresia;

import java.util.List;
import java.util.Optional;

public interface MembresiaService {
    public List<Membresia> listar();
    public Membresia guardar(Membresia membresia);
    public Membresia buscarPorId(Membresia membresia);
    public Optional<Membresia> editar(Integer id);
    public void eliminar(Integer id);
}
