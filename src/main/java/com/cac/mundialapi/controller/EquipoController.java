package com.cac.mundialapi.controller;

import com.cac.mundialapi.dto.request.EquipoDtoReq;
import com.cac.mundialapi.service.I_EquipoService;
import com.cac.mundialapi.service.impl.EquipoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mundial")
public class EquipoController {

    private I_EquipoService equipoService;

    public EquipoController(EquipoServiceImpl equipoService){
        this.equipoService = equipoService;
    }

    @PostMapping("/crearEquipo")
    public ResponseEntity<?> crearEquipo(@RequestBody EquipoDtoReq equipoDto){
        return new ResponseEntity<>(equipoService.addEquipo(equipoDto), HttpStatus.OK);
    }

    @GetMapping("/listarEquipos")
    public ResponseEntity<?> listarEquipos(){
        return new ResponseEntity<>(equipoService.listarEquipos(), HttpStatus.OK);
    }

    @GetMapping("/listar/equipo/{id_team}")
    public ResponseEntity<?> listarUnEquipo(@PathVariable Long id_team){
        return new ResponseEntity<>(equipoService.listarUnEquipo(id_team), HttpStatus.OK);
    }

    @GetMapping("/jugadores/equipo/{id_team}")
    public ResponseEntity<?> listarJugadoresDeUnEquipo(@PathVariable Long id_team){
        return new ResponseEntity<>(equipoService.listarJugadoresDeUnEquipo(id_team), HttpStatus.OK);
    }

    /*
        Muestra cada goleador, ordenado alfabeticamente por pais
     */
    @GetMapping("/goleadores/equipo/alf")
    public ResponseEntity<?> goleadoresPorEquipoAlfabeticamente(){
        return new ResponseEntity<>(equipoService.goleadoresPorEquipoAlfabeticamente(), HttpStatus.OK);
    }

    /*
        Elimina al equipo junto a los jugadores y el Dt
     */
    @DeleteMapping("/delete/equipo/{id_team}")
    public ResponseEntity<?> deleteEquipo(@PathVariable Long id_team){
        return new ResponseEntity<>(equipoService.deleteEquipo(id_team), HttpStatus.OK);
    }


}
