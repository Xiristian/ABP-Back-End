package com.vetsys.vetsys.resource.representation;

import com.vetsys.vetsys.model.Procedimento;
import com.vetsys.vetsys.model.Tipo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

public class ProcedimentoDTO {
    private Long id;
    private String observacao;
    private String descricao;
    private Double valor;

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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    private Tipo tipo;

    public ProcedimentoDTO() {
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    public static ProcedimentoDTO fromEntity(Procedimento procedimento){
        ProcedimentoDTO dto = new ProcedimentoDTO();
        dto.setId(procedimento.getId());
        dto.setObservacao(procedimento.getObservacao());
        dto.setDescricao(procedimento.getDescricao());
        dto.setValor(procedimento.getValor());
        dto.setTipo(procedimento.getTipo());
        return dto;
    }
    public Procedimento toEntity(){
        Procedimento procedimento = new Procedimento();
        procedimento.setId(this.getId());
        procedimento.setObservacao(this.getObservacao());
        procedimento.setDescricao(this.getDescricao());
        procedimento.setValor(this.getValor());
        procedimento.setTipo((this.getTipo()));
        return procedimento;
    }
    public static Page<ProcedimentoDTO> fromEntity(Page<Procedimento> procedimentos){
        List<ProcedimentoDTO> procedimentosFind = procedimentos.stream().map(procedimento -> fromEntity(procedimento)).collect(Collectors.toList());
        return new PageImpl<>(procedimentosFind, procedimentos.getPageable(), procedimentos.getTotalElements());
    }
}
