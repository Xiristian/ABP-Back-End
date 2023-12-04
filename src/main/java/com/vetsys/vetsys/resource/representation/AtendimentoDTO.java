package com.vetsys.vetsys.resource.representation;

import com.vetsys.vetsys.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class AtendimentoDTO {
    private Long id;
    private AnimalDTO animal;
    private TutorDTO tutor;
    private EmpregadoDTO empregado;
    private LocalDate dataAtendimento;
    private List<ProdutoAtendimentoDTO> produtoAtendimento;
    private Boolean houveInternacao;
    private Double valorTotal;

    public AtendimentoDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AnimalDTO getAnimal() {
        return animal;
    }

    public void setAnimal(AnimalDTO animal) {
        this.animal = animal;
    }

    public TutorDTO getTutor() {
        return tutor;
    }

    public void setTutor(TutorDTO tutor) {
        this.tutor = tutor;
    }

    public EmpregadoDTO getEmpregado() {
        return empregado;
    }

    public void setEmpregado(EmpregadoDTO empregado) {
        this.empregado = empregado;
    }

    public LocalDate getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(LocalDate dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public List<ProdutoAtendimentoDTO> getProdutoAtendimento() {
        return produtoAtendimento;
    }

    public void setProdutoAtendimento(List<ProdutoAtendimentoDTO> produtoAtendimento) {
        this.produtoAtendimento = produtoAtendimento;
    }

    public Boolean getHouveInternacao() {
        return houveInternacao;
    }

    public void setHouveInternacao(Boolean houveInternacao) {
        this.houveInternacao = houveInternacao;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public static AtendimentoDTO fromEntity(Atendimento atendimento){
        AtendimentoDTO dto = new AtendimentoDTO();
        dto.setId(atendimento.getId());
        dto.setAnimal(AnimalDTO.fromEntity(atendimento.getAnimal()));
        dto.setTutor(TutorDTO.fromEntity(atendimento.getTutor()));
        dto.setEmpregado(EmpregadoDTO.fromEntity(atendimento.getEmpregado()));
        dto.setDataAtendimento(atendimento.getDataAtendimento());
        dto.setProdutoAtendimento(atendimento.getProdutoAtendimento().stream()
                .map(ProdutoAtendimentoDTO::fromEntity).collect(Collectors.toList()));
        dto.setHouveInternacao(atendimento.getHouveInternacao());
        dto.setValorTotal(atendimento.getValorTotal());
        return dto;
    }

    public Atendimento toEntity(){
        Atendimento atendimento = new Atendimento();
        atendimento.setId(this.getId());
        atendimento.setAnimal(this.getAnimal().toEntity());
        atendimento.setTutor(this.getTutor().toEntity());
        atendimento.setEmpregado(this.getEmpregado().toEntity());
        atendimento.setDataAtendimento(this.getDataAtendimento());
        atendimento.setProdutoAtendimento(this.getProdutoAtendimento().stream()
                .map(ProdutoAtendimentoDTO::toEntity).collect(Collectors.toList()));
        atendimento.setHouveInternacao(this.getHouveInternacao());
        atendimento.setValorTotal(this.getValorTotal());
        return atendimento;
    }

    public static Page<AtendimentoDTO> fromEntity(Page<Atendimento> atendimentoPage){
        List<AtendimentoDTO> atendimentoDTOList = atendimentoPage.getContent().stream()
                .map(AtendimentoDTO::fromEntity).collect(Collectors.toList());
        return new PageImpl<>(atendimentoDTOList, atendimentoPage.getPageable(), atendimentoPage.getTotalElements());
    }
}
