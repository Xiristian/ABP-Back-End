package com.vetsys.vetsys.resource.representation;

import com.vetsys.vetsys.model.Remedio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

public class RemedioDTO {
    private String contraIndicacoes;


    public String getContraIndicacoes() {
        return contraIndicacoes;
    }

    public void setContraIndicacoes(String contraIndicacoes) {
        this.contraIndicacoes = contraIndicacoes;
    }

    public static RemedioDTO fromEntity(Remedio remedio){
        RemedioDTO dto = new RemedioDTO();
        dto.setContraIndicacoes(remedio.getContraIndicacoes());

        return dto;
    }
    public Remedio toEntity(){
        Remedio remedio = new Remedio();
        remedio.setContraIndicacoes(this.getContraIndicacoes());
        return remedio;
    }

    public static Page<RemedioDTO> fromEntity(Page<Remedio> remedioPage){
        List<RemedioDTO> RemedioDTOList = remedioPage.getContent().stream()
                .map(RemedioDTO::fromEntity) .collect(Collectors.toList());
        return new PageImpl<>(RemedioDTOList, remedioPage.getPageable(), remedioPage.getTotalElements());
    }


}
