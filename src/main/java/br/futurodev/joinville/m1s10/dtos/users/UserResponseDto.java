package br.futurodev.joinville.m1s10.dtos.users;

import br.futurodev.joinville.m1s10.enums.UserRole;
import br.futurodev.joinville.m1s10.enums.UserStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDto {
    private Long id;
    private String name;
    private UserStatus status;
    private String username;
    private UserRole role;
}
