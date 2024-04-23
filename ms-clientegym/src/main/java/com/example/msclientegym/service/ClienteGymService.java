package com.example.msclientegym.service;

import com.example.msclientegym.entity.ClienteGym;
import com.example.msclientegym.repository.ClienteGymRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteGymService {
    public List<ClienteGym> listar();
    public ClienteGym guardar(ClienteGym clienteGym);
    public ClienteGym buscarPorId(ClienteGym clienteGym);
    public Optional<ClienteGym> editar(Integer id);
    public void eliminar(Integer id);
}
