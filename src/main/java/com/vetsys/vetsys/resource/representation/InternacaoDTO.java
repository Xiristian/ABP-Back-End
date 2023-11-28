package com.vetsys.vetsys.resource.representation;

import com.vetsys.vetsys.model.Internacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

public class InternacaoDTO {
    private Long id;
    private String observacao;
    private String descricao;

    private Double valor;

    public InternacaoDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getValor() {
        return valor;
    }

    public static InternacaoDTO fromEntity(Internacao internacao){
        InternacaoDTO dto = new InternacaoDTO();
        dto.setId(internacao.getId());
        dto.setObservacao(internacao.getObservacao());
        dto.setDescricao(internacao.getDescricao());
        return dto;
    }

    public Internacao toEntity(){
        Internacao internacao = new Internacao();
        internacao.setId(this.getId());
        internacao.setObservacao(this.getObservacao());
        internacao.setDescricao(this.getDescricao());
        internacao.setValor(this.getValor());
        return internacao;
    }

    public static Page<InternacaoDTO> fromEntity(Page<Internacao> internacaos){
        List<InternacaoDTO> internacaosFind = internacaos.stream().map(internacao -> fromEntity(internacao)).collect(Collectors.toList());
        return new PageImpl<>(internacaosFind, internacaos.getPageable(), internacaos.getTotalElements());
    }
}
