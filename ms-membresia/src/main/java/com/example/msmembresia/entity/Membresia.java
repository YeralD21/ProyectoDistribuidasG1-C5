package com.example.msmembresia.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Membresia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fechainicio;
    private String fechafin;
    private String tipomembresia;
    private String costo;

}
