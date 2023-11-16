package domain;

import entities.Produto;

public interface estoqueInterface {
    void adicionarProduto(Produto produto);
    void mostrarProdutos();
}
