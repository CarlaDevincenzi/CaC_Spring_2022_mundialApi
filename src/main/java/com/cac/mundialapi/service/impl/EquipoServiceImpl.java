package com.cac.mundialapi.service.impl;

import com.cac.mundialapi.dto.request.EquipoDtoReq;
import com.cac.mundialapi.dto.EquipoDtoResp;
import com.cac.mundialapi.dto.JugadorDtoResp;
import com.cac.mundialapi.entity.Equipo;
import com.cac.mundialapi.entity.Jugador;
import com.cac.mundialapi.repository.I_EquipoRepository;
import com.cac.mundialapi.service.I_EquipoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EquipoServiceImpl implements I_EquipoService {

    private I_EquipoRepository equipoRepository;
    private ModelMapper modelMapper;

    public EquipoServiceImpl(I_EquipoRepository equipoRepository){
        this.equipoRepository = equipoRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public EquipoDtoReq addEquipo(EquipoDtoReq equipoDto) {
        Equipo nuevoEquipo = modelMapper.map(equipoDto, Equipo.class);
        Equipo equipoSave = equipoRepository.save(nuevoEquipo);

        return modelMapper.map(equipoSave, EquipoDtoReq.class);
    }

    @Override
    public List<EquipoDtoResp> listarEquipos() {
        List<Equipo> equipos = equipoRepository.findAll();
        List<EquipoDtoResp> equiposDto = new ArrayList<>();

         equipos.stream()
                .forEach(e -> equiposDto.add(modelMapper.map(e, EquipoDtoResp.class)));

        return equiposDto;
    }

    @Override
    public List<JugadorDtoResp> listarJugadoresDeUnEquipo(Long id_team) {
        Optional<Equipo> equipo = equipoRepository.findById(id_team);
        List<JugadorDtoResp> jugadoresDto = new ArrayList<>();

        if(equipo.isPresent()){
            Set<Jugador> jugadores = equipo.get().getTeamPlayers();
            jugadores.stream()
                    .forEach(j -> jugadoresDto.add(modelMapper.map(j, JugadorDtoResp.class)));
        }

       return jugadoresDto;
    }

    @Override
    public EquipoDtoResp listarUnEquipo(Long id_team) {
        Optional<Equipo> equipo = equipoRepository.findById(id_team);
        EquipoDtoResp equipoResp = null;

        if(equipo.isPresent()){
            equipoResp = modelMapper.map(equipo.get(), EquipoDtoResp.class);
        }
        return equipoResp;
    }

    @Override
    public String deleteEquipo(Long id_team) {
        if(equipoRepository.existsById(id_team)){
            equipoRepository.deleteById(id_team);
        }else{
            return "No se hallaba el equipo buscado";
        }

        return "Equipo eliminado satisfactoriamente";
    }


}
