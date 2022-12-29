package com.cac.mundialapi.service.impl;

import com.cac.mundialapi.dto.JugadorDtoResp;
import com.cac.mundialapi.dto.UpdateGolesDto;
import com.cac.mundialapi.dto.request.JugadorDtoReq;
import com.cac.mundialapi.entity.Jugador;
import com.cac.mundialapi.repository.I_JugadorRepository;
import com.cac.mundialapi.service.I_JugadorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class JugadorServiceImpl implements I_JugadorService {

    private I_JugadorRepository jugadorRepository;
    private ModelMapper modelMapper;

    public JugadorServiceImpl(I_JugadorRepository jugadorRepository){
        this.jugadorRepository = jugadorRepository;
        this.modelMapper = new ModelMapper();
    }

    private int calculaEdad(LocalDate fecha) {

        LocalDate hoy = LocalDate.now();
        Period period = fecha.until(hoy);
        return period.getYears();
    }

    @Override
    public JugadorDtoResp addJugador(JugadorDtoReq jugadorDtoReq) {

        Jugador nuevoJugador = modelMapper.map(jugadorDtoReq, Jugador.class);
        nuevoJugador.setAge(calculaEdad(nuevoJugador.getBirthDate()));

        Jugador jugadorSave = jugadorRepository.save(nuevoJugador);

        return modelMapper.map(jugadorSave, JugadorDtoResp.class);

    }

    @Override
    public JugadorDtoResp updateGolesJugador(UpdateGolesDto updateGolesDto, Long id) {
        Optional<Jugador> jugador = jugadorRepository.findById(id);
        JugadorDtoResp jugadorDtoResp = null;

        if(jugador.isPresent()){
            Jugador j = jugador.get();
            j.setGoals(j.getGoals() + updateGolesDto.getGoals()); // le suma a los que ya tenia la cantidad que llega por parametro

            jugadorDtoResp = modelMapper.map(j, JugadorDtoResp.class);

            jugadorRepository.save(j);
        }
        return jugadorDtoResp;
    }


}
