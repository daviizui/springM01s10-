package br.futurodev.joinville.m1s10.controllers;

import br.futurodev.joinville.m1s10.dtos.logins.LoginRequestDto;
import br.futurodev.joinville.m1s10.dtos.logins.LoginResponseDto;
import br.futurodev.joinville.m1s10.servicies.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("login")
public class LoginController {

    private final UserService service;

    @PostMapping
    public LoginResponseDto login(@RequestBody LoginRequestDto dto) {
        return service.authenticate(dto);

    }
}
