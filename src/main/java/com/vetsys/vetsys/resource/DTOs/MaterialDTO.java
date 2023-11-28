package com.vetsys.vetsys.resource.representation;

import com.vetsys.vetsys.model.Material;
import com.vetsys.vetsys.model.Remedio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

public class MaterialDTO {
    private String curativo;
    private String faixa;

    public String getCurativo() {
        return curativo;
    }

    public void setCurativo(String curativo) {
        this.curativo = curativo;
    }

    public String getFaixa() {
        return faixa;
    }

    public void setFaixa(String faixa) {
        this.faixa = faixa;
    }

    public static MaterialDTO fromEntity(Material material){
        MaterialDTO dto = new MaterialDTO();
        dto.setCurativo(material.getCurativo());
        dto.setFaixa(material.getFaixa());
        return dto;
    }
    public Material toEntity(){
        Material material = new Material();
        material.setCurativo(this.getCurativo());
        material.setFaixa(this.getFaixa());
        return material;
    }

    public static Page<MaterialDTO> fromEntity(Page<Material> materialPage){
        List<MaterialDTO> MaterialDTOList = materialPage.getContent().stream()
                .map(MaterialDTO::fromEntity) .collect(Collectors.toList());
        return new PageImpl<>(MaterialDTOList, materialPage.getPageable(), materialPage.getTotalElements());
    }



}
