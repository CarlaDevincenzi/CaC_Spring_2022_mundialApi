package com.cac.mundialapi.service.impl;

import com.cac.mundialapi.dto.EquipoDto;
import com.cac.mundialapi.entity.Equipo;
import com.cac.mundialapi.repository.I_EquipoRepository;
import com.cac.mundialapi.service.I_EquipoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EquipoServiceImpl implements I_EquipoService {

    private I_EquipoRepository equipoRepository;
    private ModelMapper modelMapper;

    public EquipoServiceImpl(I_EquipoRepository equipoRepository){
        this.equipoRepository = equipoRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public EquipoDto addEquipo(EquipoDto equipoDto) {
        Equipo nuevoEquipo = modelMapper.map(equipoDto, Equipo.class);
        Equipo equipoSave = equipoRepository.save(nuevoEquipo);

        return modelMapper.map(equipoSave, EquipoDto.class);
    }
}
