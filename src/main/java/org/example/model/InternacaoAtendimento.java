package org.example.model;

import java.time.LocalDate;

public class InternacaoAtendimento extends ProdutoAtendimento {
    private Internacao internacao;
    private LocalDate dataInternacao;
    private LocalDate dataLiberacao;
    private Double quantidadeDias;
    private Double valorTotal;

    public InternacaoAtendimento(Long id, Double valor, Double desconto, LocalDate dataInternacao, LocalDate dataLiberacao, Double quantidadeDias, Double valorTotal) {
        super(id, valor, desconto);
        this.dataInternacao = dataInternacao;
        this.dataLiberacao = dataLiberacao;
        this.quantidadeDias = quantidadeDias;
        this.valorTotal = valorTotal;
    }

    public LocalDate getDataInternacao() {
        return dataInternacao;
    }

    public void setDataInternacao(LocalDate dataInternacao) {
        this.dataInternacao = dataInternacao;
    }

    public LocalDate getDataLiberacao() {
        return dataLiberacao;
    }

    public void setDataLiberacao(LocalDate dataLiberacao) {
        this.dataLiberacao = dataLiberacao;
    }

    public Double getQuantidadeDias() {
        return quantidadeDias;
    }

    public void setQuantidadeDias(Double quantidadeDias) {
        this.quantidadeDias = quantidadeDias;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
