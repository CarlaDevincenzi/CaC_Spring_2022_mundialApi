package com.cac.mundialapi.controller;

import com.cac.mundialapi.service.I_JugadorService;
import com.cac.mundialapi.service.impl.JugadorServiceImpl;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JugadorController {

    private I_JugadorService jugadorService;

    public JugadorController(JugadorServiceImpl jugadorService){
        this.jugadorService = jugadorService;
    }


}
