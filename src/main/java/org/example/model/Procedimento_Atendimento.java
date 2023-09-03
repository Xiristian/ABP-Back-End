package org.example.model;

import java.time.LocalDate;

public class Procedimento_Atendimento extends Produto_Atendimento{
    private String procedimento;
    private LocalDate data;

    public Procedimento_Atendimento(Long id, Double valor, Double desconto, String procedimento, LocalDate data) {
        super(id, valor, desconto);
        this.procedimento = procedimento;
        this.data = data;
    }

    public String getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(String procedimento) {
        this.procedimento = procedimento;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
