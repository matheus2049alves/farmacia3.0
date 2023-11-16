package entities;

import entities.Produto;
import entities.Fornecedor;

public class ProdutoGeral extends Produto {
    public String marca;

    public ProdutoGeral(String nome, Double preco, String categoria, String marca, Fornecedor fornecedor) {
        super(nome, preco, categoria, fornecedor);
        this.marca = marca;
    }

    public ProdutoGeral(String nome, String marca) {
        super(nome);
        this.marca = marca;
    }

    public ProdutoGeral(String nome) {
        super(nome);
    }
}
