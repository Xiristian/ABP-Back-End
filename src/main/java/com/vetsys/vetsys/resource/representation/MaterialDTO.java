package com.vetsys.vetsys.resource.representation;


import com.vetsys.vetsys.model.Material;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

public class MaterialDTO {

    private Long id;
    private String descricao;
    private String observacao;
    private Double valor;

    public MaterialDTO() {
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

    public static MaterialDTO fromEntity(Material material){
        MaterialDTO dto = new MaterialDTO();
        dto.setId(material.getId());
        dto.setObservacao(material.getObservacao());
        dto.setDescricao(material.getDescricao());
        dto.setValor(material.getValor());
        return dto;
    }

    public Material toEntity(){
        Material material = new Material();
        material.setId(this.getId());
        material.setObservacao(this.getObservacao());
        material.setDescricao(this.getDescricao());
        material.setValor(this.getValor());
        return material;
    }

    public static Page<MaterialDTO> fromEntity(Page<Material> materiais){
        List<MaterialDTO> materiaisFind = materiais.stream().map(MaterialDTO::fromEntity).collect(Collectors.toList());
        return new PageImpl<>(materiaisFind, materiais.getPageable(), materiais.getTotalElements());
    }
}
