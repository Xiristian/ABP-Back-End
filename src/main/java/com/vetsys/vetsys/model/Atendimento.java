package com.vetsys.vetsys.model;

import java.time.LocalDate;
import java.util.List;

public class Atendimento extends EntitiyId{
    private Animal animal;
    private Tutor tutor;
    private LocalDate dataAtendimento;
    private List<ProdutoAtendimento> produtoAtendimento;
    private List<ProdutoQuantitavelAtendimento> produtoQuantitavelAtendimento;
    private Boolean houveInternacao;
    private Double valorTotal;


    public Atendimento(Animal animal, Tutor tutor, LocalDate dataAtendimento, List<ProdutoAtendimento> produtoAtendimento, List<ProdutoQuantitavelAtendimento> produtoQuantitavelAtendimento, Boolean houveInternacao, Double valorTotal) {
        this.animal = animal;
        this.tutor = tutor;
        this.dataAtendimento = dataAtendimento;
        this.produtoAtendimento = produtoAtendimento;
        this.produtoQuantitavelAtendimento = produtoQuantitavelAtendimento;
        this.houveInternacao = houveInternacao;
        this.valorTotal = valorTotal;
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

    public List<ProdutoQuantitavelAtendimento> getProdutoQuantitavelAtendimento() {
        return this.produtoQuantitavelAtendimento;
    }

    public void setProdutoQuantitavelAtendimento(List<ProdutoQuantitavelAtendimento> produtoQuantitavelAtendimento) {
        this.produtoQuantitavelAtendimento = produtoQuantitavelAtendimento;
    }

    public void addProdutoQuantitavelAtendimento(ProdutoQuantitavelAtendimento produtoQuantitavelAtendimento){
        this.produtoQuantitavelAtendimento.add(produtoQuantitavelAtendimento);
    }

    public void delProdutoQuantitavelAtendimento(ProdutoQuantitavelAtendimento produtoQuantitavelAtendimento){
        this.produtoQuantitavelAtendimento.remove(produtoQuantitavelAtendimento);
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
