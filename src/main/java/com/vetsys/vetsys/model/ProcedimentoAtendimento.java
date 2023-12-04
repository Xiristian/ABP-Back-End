package com.vetsys.vetsys.model;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@DiscriminatorValue("procedimento_atendimento")
public class ProcedimentoAtendimento extends ProdutoAtendimento {
    @Column
    private LocalDate data;
    @Column(name = "valor_total")
    private Double valorTotal;

    public ProcedimentoAtendimento(Long id, Produto produto, Double valor, Double desconto, Atendimento atendimento, LocalDate data) {
        super(id, produto, valor, desconto, atendimento);
        this.data = data;
    }

    public ProcedimentoAtendimento() {

    }

    public ProcedimentoAtendimento(ProdutoAtendimento produtoAtendimento) {
        super(produtoAtendimento.getId(), produtoAtendimento.getProduto(), produtoAtendimento.getValor(), produtoAtendimento.getDesconto(), produtoAtendimento.getAtendimento());
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
