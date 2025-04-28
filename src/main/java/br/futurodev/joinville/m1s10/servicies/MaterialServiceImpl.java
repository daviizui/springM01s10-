package br.futurodev.joinville.m1s10.servicies;

import br.futurodev.joinville.m1s10.dtos.materials.MaterialRequestDto;
import br.futurodev.joinville.m1s10.dtos.materials.MaterialResponseDto;
import br.futurodev.joinville.m1s10.entities.Material;
import br.futurodev.joinville.m1s10.mappers.MaterialMapper;
import br.futurodev.joinville.m1s10.repositories.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MaterialServiceImpl implements MaterialService{

    private final MaterialRepository repository;


    @Override
    public List<MaterialResponseDto> getAll() {
        List<Material> materials = repository.findAll();
        return MaterialMapper.toDtos(materials);
    }

    @Override
    public MaterialResponseDto getById(Long id) {
        return MaterialMapper.toDto(findEntityById(id));
    }

    @Override
    public MaterialResponseDto create(MaterialRequestDto dto) {
        Material material = new Material();
        MaterialMapper.toEntity(material, dto);

        material = repository.save(material);
        return MaterialMapper.toDto(material);
    }

    @Override
    public MaterialResponseDto update(Long id, MaterialRequestDto dto) {
        Material material = findEntityById(id);
        MaterialMapper.toEntity(material, dto);
        material = repository.save(material);
        return MaterialMapper.toDto(material);
    }

    @Override
    public void delete(Long id) {
        Material material = findEntityById(id);
        repository.delete(material);

    }

    private Material findEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Material not found"));
    }


}
