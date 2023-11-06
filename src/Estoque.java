import java.util.ArrayList;
import java.util.List;

public class Estoque {
    List<Product> products = new ArrayList<>();


    public void adicionarProduto(Product product) {
        products.add(product);
    }


    public void removerProduto( String nome) {
        products.removeIf(product -> product.getNome().equals(nome));
    }

    public void alterarProduto(String nomeAntigo, String nomeNovo) {
        for (Product produto : products) {
            if (produto.getNome().equals(nomeAntigo)) {
                produto.setNome(nomeNovo);
                break;
            }
        }
    }

    public List<Product> getProdutos() {
        return products;
    }
}


