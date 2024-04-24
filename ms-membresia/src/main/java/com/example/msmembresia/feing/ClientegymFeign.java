package com.example.msmembresia.feing;

import com.example.msmembresia.dto.ClientegymDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-clientegym-service", path = "/clientegym")
public interface ClientegymFeign {
    @GetMapping("/{id}")
    public ResponseEntity<ClientegymDto> editar(@PathVariable(required = true) Integer id);
}
