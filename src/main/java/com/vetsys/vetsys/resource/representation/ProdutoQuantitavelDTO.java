package com.vetsys.vetsys.resource.representation;

import com.vetsys.vetsys.model.ProdutoQuantitavel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutoQuantitavelDTO {

    private Long id;
    private String descricao;
    private String observacao;
    private Double valor;

    public ProdutoQuantitavelDTO() {
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

    public static ProdutoQuantitavelDTO fromEntity(ProdutoQuantitavel produtoQuantitavel){
        ProdutoQuantitavelDTO dto = new ProdutoQuantitavelDTO();
        dto.setId(produtoQuantitavel.getId());
        dto.setObservacao(produtoQuantitavel.getObservacao());
        dto.setDescricao(produtoQuantitavel.getDescricao());
        dto.setValor(produtoQuantitavel.getValor());
        return dto;
    }

    public ProdutoQuantitavel toEntity(){
        ProdutoQuantitavel produtoQuantitavel = new ProdutoQuantitavel();
        produtoQuantitavel.setId(this.getId());
        produtoQuantitavel.setObservacao(this.getObservacao());
        produtoQuantitavel.setDescricao(this.getDescricao());
        produtoQuantitavel.setValor(this.getValor());
        return produtoQuantitavel;
    }

    public static Page<ProdutoQuantitavelDTO> fromEntity(Page<ProdutoQuantitavel> produtosQuantitaveis){
        List<ProdutoQuantitavelDTO> produtosQuantitaveisFind = produtosQuantitaveis.stream().map(ProdutoQuantitavelDTO::fromEntity).collect(Collectors.toList());
        return new PageImpl<>(produtosQuantitaveisFind, produtosQuantitaveis.getPageable(), produtosQuantitaveis.getTotalElements());
    }
}
