package br.futurodev.joinville.m1s10.dtos.users;

import br.futurodev.joinville.m1s10.enums.UserRole;
import br.futurodev.joinville.m1s10.enums.UserStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequestDto {
    private String name;
    private String username;
    private String password;
    private UserRole role;
}
