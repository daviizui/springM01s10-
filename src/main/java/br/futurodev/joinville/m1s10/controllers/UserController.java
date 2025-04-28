package br.futurodev.joinville.m1s10.controllers;

import br.futurodev.joinville.m1s10.dtos.users.UserRequestDto;
import br.futurodev.joinville.m1s10.dtos.users.UserResponseDto;
import br.futurodev.joinville.m1s10.servicies.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {

    private final UserService service;

    @GetMapping
    public List<UserResponseDto> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public UserResponseDto getById(@PathVariable Long id) {
        return service.getById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto create(@RequestBody UserRequestDto dto) {
        return service.create(dto);
    }
    @PutMapping("{id}")
    public UserResponseDto update(@PathVariable Long id, @RequestBody UserRequestDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
