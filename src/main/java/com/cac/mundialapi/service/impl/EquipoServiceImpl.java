package com.cac.mundialapi.service.impl;

import com.cac.mundialapi.dto.GoleadoresPorPaisDto;
import com.cac.mundialapi.dto.SuccessDto;
import com.cac.mundialapi.dto.request.EquipoDtoReq;
import com.cac.mundialapi.dto.EquipoDtoResp;
import com.cac.mundialapi.dto.JugadorDtoResp;
import com.cac.mundialapi.entity.Equipo;
import com.cac.mundialapi.entity.Jugador;
import com.cac.mundialapi.exception.NotFoundException;
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
            List<Jugador> jugadores = equipo.get().getTeamPlayers();
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
    public SuccessDto deleteEquipo(Long id_team) {
        if(equipoRepository.existsById(id_team)){
            equipoRepository.deleteById(id_team);
            return new SuccessDto("Equipo eliminado satisfactoriamente");
        }
        throw new NotFoundException("No se hallaba el equipo buscado");
    }

    private Jugador maxGoleador(List<Jugador> jugadores){
        Jugador max = null;
        int maxGoals;

        if(jugadores != null && !jugadores.isEmpty()){
            max = jugadores.get(0);
            maxGoals = max.getGoals();
            for(Jugador j: jugadores){
                if(j.getGoals() > maxGoals){
                    max = j;
                    maxGoals = j.getGoals();
                }
            }
        }

        return max;
    }

    @Override
    public List<GoleadoresPorPaisDto> goleadoresPorEquipoAlfabeticamente() {
        List<Equipo> equipos = equipoRepository.findAllByOrderByCountryAsc();
        List<GoleadoresPorPaisDto> equiposDto = new ArrayList<>();

        for(Equipo e: equipos){
            Jugador maxGol = maxGoleador(e.getTeamPlayers());
            if(maxGol != null) {
                equiposDto.add(new GoleadoresPorPaisDto(e.getCountry(),
                        maxGol.getLastName() + " " + maxGol.getName(), maxGol.getGoals()));
            }
        }

        return equiposDto;
    }

}
