package com.vetsys.vetsys.resource.representation;

import com.vetsys.vetsys.model.Material;
import com.vetsys.vetsys.model.Produto;
import com.vetsys.vetsys.model.ProdutoQuantitavel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutoQuantitavelDTO {

    private Produto produtoQuantitavel;
    private int quantidade;

    private Double valorTotal;

    public Produto getProdutoQuantitavel() {
        return produtoQuantitavel;
    }

    public void setProdutoQuantitavel(Produto produtoQuantitavel) {
        this.produtoQuantitavel = produtoQuantitavel;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public static ProdutoQuantitavelDTO fromEntity(ProdutoQuantitavel produtoquantitavel){
        ProdutoQuantitavelDTO dto = new ProdutoQuantitavelDTO();
        dto.setProdutoQuantitavel(produtoquantitavel.getProdutoQuantitavel());
        dto.setQuantidade(produtoquantitavel.getQuantidade());
        dto.setValorTotal(produtoquantitavel.getValorTotal());
        return dto;
    }
    public ProdutoQuantitavel toEntity(){
        ProdutoQuantitavel produtoquantitavel = new Material();
        produtoquantitavel.setProdutoQuantitavel(this.getProdutoQuantitavel());
        produtoquantitavel.setQuantidade(this.getQuantidade());
        produtoquantitavel.setValorTotal(this.getValorTotal());
        return produtoquantitavel;
    }

    public static Page<ProdutoQuantitavelDTO> fromEntity(Page<ProdutoQuantitavel> produtoQuantitavelpage){
        List<ProdutoQuantitavelDTO> ProdutoQuantitavelDTOList = produtoQuantitavelpage.getContent().stream()
                .map(ProdutoQuantitavelDTO::fromEntity) .collect(Collectors.toList());
        return new PageImpl<>(ProdutoQuantitavelDTOList, produtoQuantitavelpage.getPageable(), produtoQuantitavelpage.getTotalElements());
    }




}
