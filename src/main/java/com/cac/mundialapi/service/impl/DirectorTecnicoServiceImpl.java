package com.cac.mundialapi.service.impl;

import com.cac.mundialapi.dto.DirectorTecnicoDto;
import com.cac.mundialapi.entity.DirectorTecnico;
import com.cac.mundialapi.repository.I_DirectorTecnicoRepository;
import com.cac.mundialapi.service.I_DirectorTecnicoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class DirectorTecnicoServiceImpl implements I_DirectorTecnicoService {

    private I_DirectorTecnicoRepository directorTecnicoRepository;
    private ModelMapper modelMapper;

    public DirectorTecnicoServiceImpl(I_DirectorTecnicoRepository directorTecnicoRepository){
        this.directorTecnicoRepository = directorTecnicoRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public DirectorTecnicoDto addDirectorTecnico(DirectorTecnicoDto directorTecnicoDto) {
        DirectorTecnico nuevoDt = modelMapper.map(directorTecnicoDto, DirectorTecnico.class);
        DirectorTecnico dtSave = directorTecnicoRepository.save(nuevoDt);

        return modelMapper.map(dtSave, DirectorTecnicoDto.class);
    }
}
