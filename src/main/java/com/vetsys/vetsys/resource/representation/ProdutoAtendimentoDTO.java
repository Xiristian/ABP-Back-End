package com.vetsys.vetsys.resource.representation;

import com.vetsys.vetsys.model.InternacaoAtendimento;
import com.vetsys.vetsys.model.ProcedimentoAtendimento;
import com.vetsys.vetsys.model.ProdutoAtendimento;
import com.vetsys.vetsys.model.ProdutoQuantitavelAtendimento;
import com.vetsys.vetsys.service.ValidationException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ProdutoAtendimentoDTO {
    private ProdutoDTO produto;
    private Double valor;
    private Double desconto;
    private int quantidade;
    private LocalDate dataInternacao;
    private LocalDate dataLiberacao;
    private LocalDate dataProcedimento;

    public ProdutoAtendimentoDTO() {
    }

    public ProdutoDTO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDTO produto) {
        this.produto = produto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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

    public LocalDate getDataProcedimento() {
        return dataProcedimento;
    }

    public void setDataProcedimento(LocalDate dataProcedimento) {
        this.dataProcedimento = dataProcedimento;
    }

    public static ProdutoAtendimentoDTO fromEntity(ProdutoAtendimento produtoAtendimento){
        ProdutoAtendimentoDTO dto = new ProdutoAtendimentoDTO();
        dto.setProduto(ProdutoDTO.fromEntity(produtoAtendimento.getProduto()));
        dto.setValor(produtoAtendimento.getValor());
        dto.setDesconto(produtoAtendimento.getDesconto());
        return dto;
    }

    public ProdutoAtendimento toEntity(){
        ProdutoAtendimento produtoAtendimento = new ProdutoAtendimento();
        produtoAtendimento.setProduto(this.getProduto().toEntity());
        produtoAtendimento.setValor(this.getValor());
        produtoAtendimento.setDesconto(this.getDesconto());
        if (this.getQuantidade() > 0){
            return getProdutoQuantitavelAtendimento(produtoAtendimento);
        }
        if (this.getDataInternacao() != null && this.getDataLiberacao() != null){
            return getInternacaoAtendimento(produtoAtendimento);
        }
        if (this.getDataProcedimento() != null){
            return getProcedimentoAtendimento(produtoAtendimento);
        }
        return produtoAtendimento;
    }

    private ProdutoQuantitavelAtendimento getProdutoQuantitavelAtendimento(ProdutoAtendimento produtoAtendimento) {
        ProdutoQuantitavelAtendimento produtoQuantitavelAtendimento = new ProdutoQuantitavelAtendimento(produtoAtendimento);
        produtoQuantitavelAtendimento.setQuantidade(this.getQuantidade());
        produtoQuantitavelAtendimento.setValorTotal(this.getValor() * this.getQuantidade() - this.getDesconto());
        if (produtoQuantitavelAtendimento.getQuantidade() <= 0){
            throw new ValidationException("Quantidade deve ser maior que zero");
        }
        if (produtoQuantitavelAtendimento.getValorTotal() <= 0){
            throw new ValidationException("Valor total deve ser maior que zero");
        }
        return produtoQuantitavelAtendimento;
    }

    private InternacaoAtendimento getInternacaoAtendimento(ProdutoAtendimento produtoAtendimento) {
        InternacaoAtendimento internacaoAtendimento = new InternacaoAtendimento(produtoAtendimento);
        internacaoAtendimento.setDataInternacao(this.getDataInternacao());
        internacaoAtendimento.setDataLiberacao(this.getDataLiberacao());
        internacaoAtendimento.setQuantidadeDias((double) this.getDataLiberacao().compareTo(this.getDataInternacao()));
        if (internacaoAtendimento.getQuantidadeDias() <= 0){
            throw new ValidationException("Data de liberação deve ser maior que a data de internação");
        }
        internacaoAtendimento.setValorTotal(this.getValor() * internacaoAtendimento.getQuantidadeDias() - this.getDesconto());
        if (internacaoAtendimento.getValorTotal() <= 0){
            throw new ValidationException("Valor total deve ser maior que zero");
        }
        return internacaoAtendimento;
    }

    private ProcedimentoAtendimento getProcedimentoAtendimento(ProdutoAtendimento produtoAtendimento) {
        ProcedimentoAtendimento procedimentoAtendimento = new ProcedimentoAtendimento(produtoAtendimento);
        procedimentoAtendimento.setData(this.getDataProcedimento());
        procedimentoAtendimento.setValorTotal(this.getValor() - this.getDesconto());
        if (procedimentoAtendimento.getValorTotal() <= 0){
            throw new ValidationException("Valor total deve ser maior que zero");
        }
        return procedimentoAtendimento;
    }

    public static List<ProdutoAtendimentoDTO> fromEntity(List<ProdutoAtendimento> produtoAtendimentoList){
        return produtoAtendimentoList.stream().map(ProdutoAtendimentoDTO::fromEntity).collect(Collectors.toList());
    }
}
