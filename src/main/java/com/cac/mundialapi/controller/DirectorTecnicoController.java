package com.cac.mundialapi.controller;

import com.cac.mundialapi.dto.DirectorTecnicoDto;
import com.cac.mundialapi.service.I_DirectorTecnicoService;
import com.cac.mundialapi.service.impl.DirectorTecnicoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mundial")
public class DirectorTecnicoController {

    private I_DirectorTecnicoService directorTecnicoService;

    public DirectorTecnicoController(DirectorTecnicoServiceImpl directorTecnicoService){
        this.directorTecnicoService = directorTecnicoService;
    }

    @PostMapping("/crearDT")
    public ResponseEntity<?> crearDirectorTecnico(@RequestBody DirectorTecnicoDto directorTecnicoDto){
        return new ResponseEntity<>(directorTecnicoService.addDirectorTecnico(directorTecnicoDto), HttpStatus.OK);
    }


}
