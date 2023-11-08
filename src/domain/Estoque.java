package domain;

import entities.Medicamento;
import entities.Produto;
import entities.ProdutoGeral;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    List<Produto> products = new ArrayList<>();


    public void adicionarProduto(Produto product) {
        products.add(product);
    }


    public void removerProduto( String nome) {
        products.removeIf(product -> product.getNome().equals(nome));
    }

    public boolean alterarProduto(String nome, Produto novoProduto) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getNome().equals(nome)) {
                products.set(i, novoProduto);
                return true;
            }
        }
        return false;
    }

    public int excluirProduto(String nome) {
        if(products.removeIf(product -> product.getNome().equals(nome)))
            return 1;
        else{
            return 0;
        }
    }

    public void mostrarProdutos () {
        JFrame frame = new JFrame();
        frame.setSize(700, 400);
        String[] columnNames = {"Nome Produto", "Preço Produto", "Categoria Produto", "Tipo/Marca", "Nome Fornecedor", "Cnpj"};
        String[][] data = new String[products.size()][6];
        for (int i = 0; i < products.size(); i++) {
            Produto produto = products.get(i);
            data[i][0] = produto.getNome();
            data[i][1] = String.valueOf(produto.getPreco());
            data[i][2] = produto.getCategoria();
            if (produto instanceof Medicamento) {
                data[i][3] = ((Medicamento) produto).getTipo();
            } else if (produto instanceof ProdutoGeral) {
                data[i][3] = ((ProdutoGeral) produto).marca;
            }

            data[i][4] = produto.getFornecedor().getNome();
            data[i][5] = produto.getFornecedor().getCnpj();
        }
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
        frame.setVisible(true);
    }

    public List<Produto> getProdutos() {
        return products;
    }
}


