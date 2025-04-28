package br.futurodev.joinville.m1s10.servicies;

import br.futurodev.joinville.m1s10.dtos.logins.LoginRequestDto;
import br.futurodev.joinville.m1s10.dtos.logins.LoginResponseDto;
import br.futurodev.joinville.m1s10.dtos.users.UserRequestDto;
import br.futurodev.joinville.m1s10.dtos.users.UserResponseDto;
import br.futurodev.joinville.m1s10.entities.User;
import br.futurodev.joinville.m1s10.mappers.UserMapper;
import br.futurodev.joinville.m1s10.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public List<UserResponseDto> getAll() {
        List<User> users = repository.findAll();
        return UserMapper.toDtos(users);
    }

    @Override
    public UserResponseDto getById(Long id) {
        return UserMapper.toDto(findEntityById(id));
    }

    @Override
    public UserResponseDto create(UserRequestDto dto) {
        User user = new User();
        UserMapper.toEntity(user, dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user = repository.save(user);
        return UserMapper.toDto(user);
    }

    @Override
    public UserResponseDto update(Long id, UserRequestDto dto) {
        User user = findEntityById(id);
        UserMapper.toEntity(user, dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user = repository.save(user);
        return UserMapper.toDto(user);
    }

    @Override
    public void delete(Long id) {
        User user = findEntityById(id);
        repository.delete(user);

    }

    @Override
    public LoginResponseDto authenticate(LoginRequestDto dto) {
        User user = repository.findByUsername(dto.getUsername()).orElseThrow();
        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid username or password");
        }
        String token = Base64.getEncoder().encodeToString(
                (user.getUsername() + ":" + dto.getPassword()).getBytes()
        );
        return LoginResponseDto.builder().type("Basic").token(token).build();

    }

    private User findEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException(username));
    }
}
