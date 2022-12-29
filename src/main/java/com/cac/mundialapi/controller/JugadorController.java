package com.cac.mundialapi.controller;

import com.cac.mundialapi.dto.UpdateGolesDto;
import com.cac.mundialapi.dto.request.JugadorDtoReq;
import com.cac.mundialapi.service.I_JugadorService;
import com.cac.mundialapi.service.impl.JugadorServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /*
        Suma la cantidad recibida en el body a los goles que ya tenia el jugador
     */
    @PatchMapping("/suma/goles/{id_player}")
    public ResponseEntity<?> updateGolesDeJugador(@RequestBody UpdateGolesDto cant, @PathVariable Long id_player){
        return new ResponseEntity<>(jugadorService.updateGolesJugador(cant, id_player), HttpStatus.OK);
    }



}
