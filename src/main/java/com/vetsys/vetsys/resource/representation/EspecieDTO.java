package com.vetsys.vetsys.resource.representation;

import com.vetsys.vetsys.model.Especie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

public class EspecieDTO {
    private Long id;
    private String descricao;

    public EspecieDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static EspecieDTO fromEntity(Especie especie){
        EspecieDTO dto = new EspecieDTO();
        dto.setId(especie.getId());
        dto.setDescricao(especie.getDescricao());
        return dto;
    }

    public Especie toEntity(){
        Especie especie = new Especie();
        especie.setId(this.getId());
        especie.setDescricao(this.getDescricao());
        return especie;
    }

    public static Page<EspecieDTO> fromEntity(Page<Especie> especies){
        List<EspecieDTO> especiesFind = especies.stream().map(EspecieDTO::fromEntity).collect(Collectors.toList());
        return new PageImpl<>(especiesFind, especies.getPageable(), especies.getTotalElements());
    }
}
