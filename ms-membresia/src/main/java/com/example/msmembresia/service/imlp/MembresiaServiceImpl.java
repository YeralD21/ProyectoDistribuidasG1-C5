package com.example.msmembresia.service.imlp;

import com.example.msmembresia.dto.ClientegymDto;
import com.example.msmembresia.entity.Membresia;
import com.example.msmembresia.entity.MembresiaDetalle;
import com.example.msmembresia.feing.ClientegymFeign;
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

    @Autowired
    private ClientegymFeign clientegymFeign;

    @Override
    public List<Membresia> listar() {
        return membresiaRepository.findAll();
    }

    @Override
    public  Membresia guardar(Membresia membresia) {
        return membresiaRepository.save(membresia);
    }

    @Override
    public Membresia buscarPorId(Integer id)  {
        Membresia membresia = membresiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Membresia no encontrada"));

        // Suponiendo que tienes un campo en Membresia que almacena el ID del cliente.
        Integer clientegymId = membresia.getClientegymDto().getId();

        // Si hay un ID del cliente, obtenemos toda la información del cliente.
        if (clientegymId != null) {
            ClientegymDto clientegymDto = clientegymFeign.buscarPorId(clientegymId).getBody();
            membresia.setClientegymDto(clientegymDto);
        }

        return membresia;

    }
    @Override
    public Membresia editar(Membresia membresia) {return membresiaRepository.save(membresia);
    }

    @Override
    public void eliminar(Integer id) {
        membresiaRepository.deleteById(id);
    }

}
