package com.vetsys.vetsys.model;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@DiscriminatorValue("procedimento_atendimento")
public class ProcedimentoAtendimento extends ProdutoAtendimento {
    @ManyToOne
    @JoinColumn(name = "procedimento_id")
    private Procedimento procedimento;
    @Column(nullable = false)
    private LocalDate data;

    public ProcedimentoAtendimento(Long id, Double valor, Double desconto, Procedimento procedimento, LocalDate data) {
        super(id, valor, desconto);
        this.procedimento = procedimento;
        this.data = data;
    }

    public ProcedimentoAtendimento() {

    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
