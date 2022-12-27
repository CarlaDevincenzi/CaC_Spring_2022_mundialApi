package com.cac.mundialapi.service.impl;

import com.cac.mundialapi.repository.I_JugadorRepository;
import com.cac.mundialapi.service.I_JugadorService;
import org.springframework.stereotype.Service;

@Service
public class JugadorServiceImpl implements I_JugadorService {

    private I_JugadorRepository jugadorRepository;

    public JugadorServiceImpl(I_JugadorRepository jugadorRepository){
        this.jugadorRepository = jugadorRepository;
    }
}
