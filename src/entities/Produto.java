package entities;

import entities.Fornecedor;

public class Produto {
  private String nome;
  private  Double preco;
  private  String Categoria;

  private Fornecedor fornecedor;


    public Produto(String nome, Double preco, String categoria, Fornecedor fornecedor) {
        this.nome = nome;
        this.preco = preco;
        Categoria = categoria;
        this.fornecedor = fornecedor;
    }

    public Produto(String nome) {
        this.nome = nome;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
