package br.futurodev.joinville.m1s10.dtos.logins;



import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseDto {
    private String type;
    private String token;


}