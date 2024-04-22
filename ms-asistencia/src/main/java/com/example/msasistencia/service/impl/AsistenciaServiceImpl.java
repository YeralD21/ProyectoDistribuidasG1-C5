package com.example.msasistencia.service.impl;

import com.example.msasistencia.entity.Asistencia;
import com.example.msasistencia.entity.Usuario;
import com.example.msasistencia.repository.AsistenciaRepository;
import com.example.msasistencia.repository.UsuarioRepository;
import com.example.msasistencia.service.AsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AsistenciaServiceImpl implements AsistenciaService {
    @Autowired
    private AsistenciaRepository asistenciaRepository;
    @Override
    public List<Asistencia> listar() {
        return asistenciaRepository.findAll();
    }

    @Override
    public Asistencia guardar(Asistencia asistencia) {
        return asistenciaRepository.save(asistencia);
    }

    @Override
    public Asistencia actualizar(Asistencia asistencia) {
        return asistenciaRepository.save(asistencia);
    }

    @Override
    public Optional<Asistencia> listarPorId(Integer id) {
        return asistenciaRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        asistenciaRepository.deleteById(id);
    }
}

