public class Product {
    String nome;
    Double preco;
    String Categoria;


    public Product(String nome, Double preco, String categoria) {
        this.nome = nome;
        this.preco = preco;
        Categoria = categoria;
    }

    public Product(String nome) {
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
}
