package br.futurodev.joinville.m1s10.servicies;

import br.futurodev.joinville.m1s10.dtos.materials.MaterialRequestDto;
import br.futurodev.joinville.m1s10.dtos.materials.MaterialResponseDto;

import java.util.List;

public interface MaterialService {

    List<MaterialResponseDto> getAll();

    MaterialResponseDto getById(Long id);

    MaterialResponseDto create(MaterialRequestDto Dto);

    MaterialResponseDto update(Long id, MaterialRequestDto Dto);

    void delete(Long id);
}
