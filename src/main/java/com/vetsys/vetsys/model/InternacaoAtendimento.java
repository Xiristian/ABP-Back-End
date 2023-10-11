package com.vetsys.vetsys.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("internacao_atendimento")
public class InternacaoAtendimento extends ProdutoAtendimento {
    @ManyToOne
    @JoinColumn(name = "internacao_id")
    private Internacao internacao;
    @Column(nullable = false, name = "data_internacao")
    private LocalDate dataInternacao;
    @Column(nullable = false, name = "data_liberacao")
    private LocalDate dataLiberacao;
    @Column(nullable = false, name = "quantidade_dias")
    private Double quantidadeDias;
    @Column(nullable = false, name = "valor_total")
    private Double valorTotal;

    public InternacaoAtendimento(Long id, Double valor, Double desconto, Internacao internacao, LocalDate dataInternacao, LocalDate dataLiberacao, Double quantidadeDias, Double valorTotal) {
        super(id, valor, desconto);
        this.internacao = internacao;
        this.dataInternacao = dataInternacao;
        this.dataLiberacao = dataLiberacao;
        this.quantidadeDias = quantidadeDias;
        this.valorTotal = valorTotal;
    }

    public InternacaoAtendimento() {

    }

    public Internacao getInternacao() {
        return internacao;
    }

    public void setInternacao(Internacao internacao) {
        this.internacao = internacao;
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
