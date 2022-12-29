package com.cac.mundialapi.service;

import com.cac.mundialapi.dto.request.EquipoDtoReq;
import com.cac.mundialapi.dto.EquipoDtoResp;
import com.cac.mundialapi.dto.JugadorDtoResp;


import java.util.List;

public interface I_EquipoService {
    EquipoDtoReq addEquipo(EquipoDtoReq equipoDto);
    List<EquipoDtoResp> listarEquipos();
    List<JugadorDtoResp> listarJugadoresDeUnEquipo(Long id_team);
    EquipoDtoResp listarUnEquipo(Long id_team);
    String deleteEquipo(Long id_team); //FIXME: Revisar tipo de respuesta

}
