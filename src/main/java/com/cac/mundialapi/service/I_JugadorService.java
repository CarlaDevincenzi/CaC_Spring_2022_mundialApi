package com.cac.mundialapi.service;

import com.cac.mundialapi.dto.JugadorDtoResp;
import com.cac.mundialapi.dto.request.JugadorDtoReq;

public interface I_JugadorService {
    JugadorDtoResp addJugador(JugadorDtoReq jugadorDtoReq);
}
