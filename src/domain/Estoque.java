package domain;

import entities.Medicamento;
import entities.Produto;
import entities.ProdutoGeral;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Estoque implements estoqueInterface {
    List<Produto> products = new ArrayList<>();


    public void adicionarProduto(Produto product) {
        products.add(product);
    }

    /*--metodos de alterar---
     percorre a lista de produtos e Verifa se o nome do produto corresponde
     ao nome fornecido e também se é uma uma instancia do tipo de produto, se for
     o produto será substituido e retornará true;
     */
    public boolean alteraMedicamento (String nome, Produto novoProduto) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getNome().equals(nome)) {
                if(products.get(i) instanceof Medicamento) {
                    products.set(i, novoProduto);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean alteraProdutoG (String nome, Produto novoProduto) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getNome().equals(nome)) {
                if(products.get(i) instanceof ProdutoGeral) {
                    products.set(i, novoProduto);
                    return true;
                }
            }
        }
        return false;
    }

    /*----métodos apagar----
    percorre a lista de produtos e Verifa se o nome do produto corresponde
    ao nome fornecido e também se é uma uma instancia do tipo de produto, se for
    o produto excluido e retornará true;
     */
    public boolean apagarProdutoG(String nome){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getNome().equals(nome)) {
                if(products.get(i) instanceof ProdutoGeral) {
                    products.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean apagarMedicamento(String nome){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getNome().equals(nome)) {
                if(products.get(i) instanceof Medicamento) {
                    products.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public void mostrarProdutos () {
        // Cria uma nova janela JFrame para exibir a lista de produtos.
        JFrame frame = new JFrame();
        frame.setSize(700, 400);
        // Define os nomes das colunas na tabela.
        String[] columnNames = {"Nome Produto", "Preço Produto", "Categoria Produto", "Tipo/Marca", "Nome Fornecedor", "Cnpj"};
        // Cria uma matriz bidimensional para armazenar os dados dos produtos.
        String[][] data = new String[products.size()][6];
        // Preenche a matriz de dados com informações de cada produto.
        for (int i = 0; i < products.size(); i++) {
            Produto produto = products.get(i);
            data[i][0] = produto.getNome();
            data[i][1] = String.valueOf(produto.getPreco());
            data[i][2] = produto.getCategoria();
            // Verifica se o produto é um Medicamento ou ProdutoGeral e atribui o tipo/marca apropriadamente.
            if (produto instanceof Medicamento) {
                data[i][3] = ((Medicamento) produto).getTipo();
            } else if (produto instanceof ProdutoGeral) {
                data[i][3] = ((ProdutoGeral) produto).marca;
            }

            data[i][4] = produto.getFornecedor().getNome();
            data[i][5] = produto.getFornecedor().getCnpj();
        }
        // Cria uma tabela JTable para exibir os dados.
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
        frame.setVisible(true);
    }

    public List<Produto> getProdutos() {
        return products;
    }
}


