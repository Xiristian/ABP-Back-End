package com.vetsys.vetsys.resource.representation;

import com.vetsys.vetsys.model.*;

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
    private TipoProduto tipoProduto;

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

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public static ProdutoAtendimentoDTO fromEntity(ProdutoAtendimento produtoAtendimento){
        ProdutoAtendimentoDTO dto = new ProdutoAtendimentoDTO();
        dto.setProduto(ProdutoDTO.fromEntity(produtoAtendimento.getProduto()));
        dto.setValor(produtoAtendimento.getValor());
        dto.setDesconto(produtoAtendimento.getDesconto());
        if (produtoAtendimento instanceof ProdutoQuantitavelAtendimento){
            dto.setProdutoQuantitavelAtendimento((ProdutoQuantitavelAtendimento) produtoAtendimento);
            if (produtoAtendimento.getProduto() instanceof Remedio){
                dto.setTipoProduto(TipoProduto.REMEDIO);
            }
            else if (produtoAtendimento.getProduto() instanceof Material){
                dto.setTipoProduto(TipoProduto.MATERIAL);
            }
        }
        else if (produtoAtendimento instanceof InternacaoAtendimento){
            dto.setInternacaoAtendimento((InternacaoAtendimento) produtoAtendimento);
            dto.setTipoProduto(TipoProduto.INTERNACAO);
        }
        else if (produtoAtendimento instanceof ProcedimentoAtendimento){
            dto.setProcedimentoAtendimento((ProcedimentoAtendimento) produtoAtendimento);
            dto.setTipoProduto(TipoProduto.PROCEDIMENTO);
        }
        return dto;
    }

    public ProdutoAtendimento toEntity(){
        ProdutoAtendimento produtoAtendimento = new ProdutoAtendimento();
        produtoAtendimento.setProduto(this.getProduto().toEntity());
        produtoAtendimento.setValor(this.getValor());
        produtoAtendimento.setDesconto(this.getDesconto());
        if (this.getTipoProduto() == TipoProduto.MATERIAL || this.getTipoProduto() == TipoProduto.REMEDIO){
            return getProdutoQuantitavelAtendimento(produtoAtendimento);
        }
        else if (this.getTipoProduto() == TipoProduto.INTERNACAO){
            return getInternacaoAtendimento(produtoAtendimento);
        }
        else if (this.getTipoProduto() == TipoProduto.PROCEDIMENTO){
            return getProcedimentoAtendimento(produtoAtendimento);
        }
        else {
            return produtoAtendimento;
        }
    }

    private ProdutoQuantitavelAtendimento getProdutoQuantitavelAtendimento(ProdutoAtendimento produtoAtendimento) {
        ProdutoQuantitavelAtendimento produtoQuantitavelAtendimento = new ProdutoQuantitavelAtendimento(produtoAtendimento);
        produtoQuantitavelAtendimento.setQuantidade(this.getQuantidade());
        produtoQuantitavelAtendimento.setValorTotal(this.getValor() * this.getQuantidade() - this.getDesconto());
        return produtoQuantitavelAtendimento;
    }

    private InternacaoAtendimento getInternacaoAtendimento(ProdutoAtendimento produtoAtendimento) {
        InternacaoAtendimento internacaoAtendimento = new InternacaoAtendimento(produtoAtendimento);
        internacaoAtendimento.setDataInternacao(this.getDataInternacao());
        internacaoAtendimento.setDataLiberacao(this.getDataLiberacao());
        internacaoAtendimento.setQuantidadeDias((double) this.getDataLiberacao().compareTo(this.getDataInternacao()));
        internacaoAtendimento.setValorTotal(this.getValor() * internacaoAtendimento.getQuantidadeDias() - this.getDesconto());
        return internacaoAtendimento;
    }

    private ProcedimentoAtendimento getProcedimentoAtendimento(ProdutoAtendimento produtoAtendimento) {
        ProcedimentoAtendimento procedimentoAtendimento = new ProcedimentoAtendimento(produtoAtendimento);
        procedimentoAtendimento.setData(this.getDataProcedimento());
        procedimentoAtendimento.setValorTotal(this.getValor() - this.getDesconto());
        return procedimentoAtendimento;
    }

    private void setProdutoQuantitavelAtendimento(ProdutoQuantitavelAtendimento produtoQuantitavelAtendimento) {
        this.setQuantidade(produtoQuantitavelAtendimento.getQuantidade());
    }

    private void setInternacaoAtendimento(InternacaoAtendimento internacaoAtendimento) {
        this.setDataInternacao(internacaoAtendimento.getDataInternacao());
        this.setDataLiberacao(internacaoAtendimento.getDataLiberacao());
    }

    private void setProcedimentoAtendimento(ProcedimentoAtendimento procedimentoAtendimento) {
        this.setDataProcedimento(procedimentoAtendimento.getData());
    }

    public static List<ProdutoAtendimentoDTO> fromEntity(List<ProdutoAtendimento> produtoAtendimentoList){
        return produtoAtendimentoList.stream().map(ProdutoAtendimentoDTO::fromEntity).collect(Collectors.toList());
    }
}
