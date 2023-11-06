public class Medicamento extends Product {
      public String tipo;


    public Medicamento(String nome, Double preco, String categoria, String tipo, Fornecedor fornecedor) {
        super(nome, preco, categoria, fornecedor);
        this.tipo = tipo;
    }

    public Medicamento(String nome, String tipo) {
        super(nome);
        this.tipo = tipo;
    }

    public Medicamento(String nome) {
        super(nome);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
