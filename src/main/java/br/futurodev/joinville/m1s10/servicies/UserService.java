package br.futurodev.joinville.m1s10.servicies;

import br.futurodev.joinville.m1s10.dtos.logins.LoginRequestDto;
import br.futurodev.joinville.m1s10.dtos.logins.LoginResponseDto;
import br.futurodev.joinville.m1s10.dtos.users.UserRequestDto;
import br.futurodev.joinville.m1s10.dtos.users.UserResponseDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<UserResponseDto> getAll();

    UserResponseDto getById(Long id);

    UserResponseDto create(UserRequestDto Dto);

    UserResponseDto update(Long id, UserRequestDto Dto);

    void delete(Long id);

    LoginResponseDto authenticate(LoginRequestDto dto);
}
