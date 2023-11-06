public class ProdutoGeral extends Product {
    String marca;

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
