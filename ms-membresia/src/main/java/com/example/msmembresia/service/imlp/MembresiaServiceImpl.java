package com.example.msmembresia.service.imlp;

import com.example.msmembresia.entity.Membresia;
import com.example.msmembresia.repository.MembresiaRepository;
import com.example.msmembresia.service.MembresiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembresiaServiceImpl implements MembresiaService {
    @Autowired
    private MembresiaRepository membresiaRepository;


    @Override
    public List<Membresia> listar() {
        return membresiaRepository.findAll();
    }

    @Override
    public Membresia guardar(Membresia asistencia) {
        return membresiaRepository.save(asistencia);
    }

    @Override
    public Membresia buscarPorId(Membresia asistencia) {
        return membresiaRepository.save(asistencia);
    }

    @Override
    public Optional<Membresia> editar(Integer id) {
        return membresiaRepository.findById(id);
    }

    @Override
    public void eliminar(Integer id) {
        membresiaRepository.deleteById(id);
    }

}
