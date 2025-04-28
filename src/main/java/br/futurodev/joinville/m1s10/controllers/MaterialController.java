package br.futurodev.joinville.m1s10.controllers;

import br.futurodev.joinville.m1s10.dtos.materials.MaterialRequestDto;
import br.futurodev.joinville.m1s10.dtos.materials.MaterialResponseDto;
import br.futurodev.joinville.m1s10.servicies.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("materials")
public class MaterialController {

    private final MaterialService service;

    @GetMapping
    public List<MaterialResponseDto> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public MaterialResponseDto getById(@PathVariable Long id) {
        return service.getById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MaterialResponseDto create(@RequestBody MaterialRequestDto dto) {
        return service.create(dto);
    }
    @PutMapping("{id}")
    public MaterialResponseDto update(@PathVariable Long id, @RequestBody MaterialRequestDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
