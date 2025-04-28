package br.futurodev.joinville.m1s10.dtos.materials;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MaterialRequestDto {
    private String name;
    private String description;

}
