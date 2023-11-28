package com.vetsys.vetsys.resource.representation;

import com.vetsys.vetsys.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutoDTO {
    private Long id;
    private String observacao;
    private String descricao;

    private Double valor;

    public ProdutoDTO() {
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

    public static ProdutoDTO fromEntity(Produto produto){
        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(produto.getId());
        dto.setObservacao(produto.getObservacao());
        dto.setDescricao(produto.getDescricao());
        return dto;
    }

    public Produto toEntity(){
        Produto produto = new Produto();
        produto.setId(this.getId());
        produto.setObservacao(this.getObservacao());
        produto.setDescricao(this.getDescricao());
        produto.setValor(this.getValor());
        return produto;
    }

    public static Page<ProdutoDTO> fromEntity(Page<Produto> produtos){
        List<ProdutoDTO> produtosFind = produtos.stream().map(ProdutoDTO::fromEntity).collect(Collectors.toList());
        return new PageImpl<>(produtosFind, produtos.getPageable(), produtos.getTotalElements());
    }
}
