package br.futurodev.joinville.m1s10.dtos.materials;

import jdk.jshell.Snippet;
import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class MaterialResponseDto {
    private Long id;
    private String name;
    private String description;



}
