package com.vetsys.vetsys.resource.representation;

import com.vetsys.vetsys.model.Remedio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

public class RemedioDTO {
    private Long id;
    private String descricao;
    private String observacao;
    private Double valor;
    private String contraIndicacoes;

    public RemedioDTO() {
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getContraIndicacoes() {
        return contraIndicacoes;
    }

    public void setContraIndicacoes(String contraIndicacoes) {
        this.contraIndicacoes = contraIndicacoes;
    }

    public static RemedioDTO fromEntity(Remedio remedio){
        RemedioDTO dto = new RemedioDTO();
        dto.setId(remedio.getId());
        dto.setDescricao(remedio.getDescricao());
        dto.setObservacao(remedio.getObservacao());
        dto.setValor(remedio.getValor());
        dto.setContraIndicacoes(remedio.getContraIndicacoes());

        return dto;
    }
    public Remedio toEntity(){
        Remedio remedio = new Remedio();
        remedio.setId(this.getId());
        remedio.setDescricao(this.getDescricao());
        remedio.setObservacao(this.getObservacao());
        remedio.setValor(this.getValor());
        remedio.setContraIndicacoes(this.getContraIndicacoes());
        return remedio;
    }

    public static Page<RemedioDTO> fromEntity(Page<Remedio> remedioPage){
        List<RemedioDTO> RemedioDTOList = remedioPage.getContent().stream()
                .map(RemedioDTO::fromEntity) .collect(Collectors.toList());
        return new PageImpl<>(RemedioDTOList, remedioPage.getPageable(), remedioPage.getTotalElements());
    }


}
