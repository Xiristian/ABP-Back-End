package org.example.model;

import java.time.LocalDate;

public class ProcedimentoAtendimento extends ProdutoAtendimento {
    private Procedimento procedimento;
    private LocalDate data;

    public ProcedimentoAtendimento(Long id, Double valor, Double desconto, Procedimento procedimento, LocalDate data) {
        super(id, valor, desconto);
        this.procedimento = procedimento;
        this.data = data;
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
