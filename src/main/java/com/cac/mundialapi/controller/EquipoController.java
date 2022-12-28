package com.cac.mundialapi.controller;

import com.cac.mundialapi.dto.EquipoDto;
import com.cac.mundialapi.service.I_EquipoService;
import com.cac.mundialapi.service.impl.EquipoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mundial")
public class EquipoController {

    private I_EquipoService equipoService;

    public EquipoController(EquipoServiceImpl equipoService){
        this.equipoService = equipoService;
    }

    @PostMapping("/crearEquipo")
    public ResponseEntity<?> crearEquipo(@RequestBody EquipoDto equipoDto){
        return new ResponseEntity<>(equipoService.addEquipo(equipoDto), HttpStatus.OK);
    }

}
