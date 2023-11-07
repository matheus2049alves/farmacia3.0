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

    public boolean alterarProduto(String nome,Product novoProduto) {
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

    public List<Product> getProdutos() {
        return products;
    }
}


