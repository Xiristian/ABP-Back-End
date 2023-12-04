package com.vetsys.vetsys.resource.representation;

import com.vetsys.vetsys.model.ProdutoAtendimento;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutoAtendimentoDTO {
    private ProdutoDTO produto;
    private Double valor;
    private Double desconto;

    public ProdutoAtendimentoDTO() {
    }

    public ProdutoDTO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDTO produto) {
        this.produto = produto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public static ProdutoAtendimentoDTO fromEntity(ProdutoAtendimento produtoAtendimento){
        ProdutoAtendimentoDTO dto = new ProdutoAtendimentoDTO();
        dto.setProduto(ProdutoDTO.fromEntity(produtoAtendimento.getProduto()));
        dto.setValor(produtoAtendimento.getValor());
        dto.setDesconto(produtoAtendimento.getDesconto());
        return dto;
    }

    public ProdutoAtendimento toEntity(){
        ProdutoAtendimento produtoAtendimento = new ProdutoAtendimento();
        produtoAtendimento.setProduto(this.getProduto().toEntity());
        produtoAtendimento.setValor(this.getValor());
        produtoAtendimento.setDesconto(this.getDesconto());
        return produtoAtendimento;
    }

    public static List<ProdutoAtendimentoDTO> fromEntity(List<ProdutoAtendimento> produtoAtendimentoList){
        return produtoAtendimentoList.stream().map(ProdutoAtendimentoDTO::fromEntity).collect(Collectors.toList());
    }
}
