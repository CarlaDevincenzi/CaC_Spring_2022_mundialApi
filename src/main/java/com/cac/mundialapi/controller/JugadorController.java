package com.cac.mundialapi.controller;

import com.cac.mundialapi.dto.JugadorDtoResp;
import com.cac.mundialapi.dto.request.JugadorDtoReq;
import com.cac.mundialapi.service.I_JugadorService;
import com.cac.mundialapi.service.impl.JugadorServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mundial")
public class JugadorController {

    private I_JugadorService jugadorService;

    public JugadorController(JugadorServiceImpl jugadorService){
        this.jugadorService = jugadorService;
    }

    @PostMapping("/crearJugador")
    public ResponseEntity<?> crearJugador(@RequestBody JugadorDtoReq jugadorDtoReq){
        return new ResponseEntity<>(jugadorService.addJugador(jugadorDtoReq), HttpStatus.OK);
    }

}
