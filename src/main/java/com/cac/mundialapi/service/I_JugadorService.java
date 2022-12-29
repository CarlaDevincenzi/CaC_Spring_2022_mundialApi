package com.cac.mundialapi.service;

import com.cac.mundialapi.dto.JugadorDtoResp;
import com.cac.mundialapi.dto.UpdateGolesDto;
import com.cac.mundialapi.dto.request.JugadorDtoReq;

import java.util.List;

public interface I_JugadorService {
    JugadorDtoResp addJugador(JugadorDtoReq jugadorDtoReq);
    JugadorDtoResp updateGolesJugador(UpdateGolesDto updateGolesDto, Long id);
}
