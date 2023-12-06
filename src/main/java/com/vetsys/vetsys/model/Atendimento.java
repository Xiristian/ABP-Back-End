package com.vetsys.vetsys.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Atendimento extends EntitiyId{
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "animal_id")
    private Animal animal;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "empregado_id")
    private Empregado empregado;
    @Column(nullable = false)
    private LocalDate dataAtendimento;
    @OneToMany(mappedBy = "atendimento", cascade = CascadeType.ALL)
    private List<ProdutoAtendimento> produtoAtendimento;
    @Column(nullable = false)
    private Boolean houveInternacao;
    @Column(nullable = false)
    private Double valorTotal;


    public Atendimento(Animal animal, Tutor tutor, Empregado empregado, LocalDate dataAtendimento, List<ProdutoAtendimento> produtoAtendimento, Boolean houveInternacao, Double valorTotal) {
        this.animal = animal;
        this.tutor = tutor;
        this.empregado = empregado;
        this.dataAtendimento = dataAtendimento;
        this.produtoAtendimento = produtoAtendimento;
        this.houveInternacao = houveInternacao;
        this.valorTotal = valorTotal;
    }

    public Atendimento() {
    }

    public Animal getAnimal() {
        return this.animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Tutor getTutor() {
        return this.tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Empregado getEmpregado() {
        return this.empregado;
    }

    public void setEmpregado(Empregado empregado) {
        this.empregado = empregado;
    }

    public LocalDate getDataAtendimento() {
        return this.dataAtendimento;
    }

    public void setDataAtendimento(LocalDate dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public List<ProdutoAtendimento> getProdutoAtendimento() {
        return this.produtoAtendimento;
    }

    public void setProdutoAtendimento(List<ProdutoAtendimento> produtoAtendimento) {
        this.produtoAtendimento = produtoAtendimento;
    }

    public void addProdutoAtendimento(ProdutoAtendimento produtoAtendimento){
        this.produtoAtendimento.add(produtoAtendimento);
    }

    public void delProdutoAtendimento(ProdutoAtendimento produtoAtendimento){
        this.produtoAtendimento.remove(produtoAtendimento);
    }

    public Boolean getHouveInternacao() {
        return this.houveInternacao;
    }

    public void setHouveInternacao(Boolean houveInternacao) {
        this.houveInternacao = houveInternacao;
    }

    public Double getValorTotal() {
        return this.valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    
}
