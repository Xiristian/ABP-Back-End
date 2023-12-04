package com.vetsys.vetsys.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("internacao_atendimento")
public class InternacaoAtendimento extends ProdutoAtendimento {
    @Column(name = "data_internacao")
    private LocalDate dataInternacao;
    @Column(name = "data_liberacao")
    private LocalDate dataLiberacao;
    @Column(name = "quantidade_dias")
    private Double quantidadeDias;
    @Column(name = "valor_total")
    private Double valorTotal;

    public InternacaoAtendimento(Long id, Produto produto, Double valor, Double desconto, Atendimento atendimento, LocalDate dataInternacao, LocalDate dataLiberacao, Double quantidadeDias, Double valorTotal) {
        super(id, produto, valor, desconto, atendimento);
        this.dataInternacao = dataInternacao;
        this.dataLiberacao = dataLiberacao;
        this.quantidadeDias = quantidadeDias;
        this.valorTotal = valorTotal;
    }

    public InternacaoAtendimento() {

    }

    public InternacaoAtendimento(ProdutoAtendimento produtoAtendimento) {
        super(produtoAtendimento.getId(), produtoAtendimento.getProduto(), produtoAtendimento.getValor(), produtoAtendimento.getDesconto(), produtoAtendimento.getAtendimento());
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
