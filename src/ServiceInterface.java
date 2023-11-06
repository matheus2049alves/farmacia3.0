
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServiceInterface extends JFrame implements ActionListener {
    Estoque estoque = new Estoque();
    JTextArea textArea = new JTextArea();

    public  ServiceInterface () {
        setTitle("Farmácia Art3mis");
        String[] opcoesProdutos = {"Medicamento", "Produtos Gerais"};
        JComboBox<String> tipoBox = new JComboBox<>(opcoesProdutos);
        // Criando botão de diálogo para usuário adicionar um produto
        JButton addProductButton = new JButton("Adicionar Produto");
        addProductButton.addActionListener(e -> {
            JTextField nomeField = new JTextField();
            JTextField precoField = new JTextField();
            JTextField categoriaField = new JTextField();
            JTextField tipoField = new JTextField();
            JTextField marcaField = new JTextField();
            JTextField nomeForneField = new JTextField();
            JTextField cnpjForneField = new JTextField();



            tipoBox.addActionListener(event -> {
                if (tipoBox.getSelectedItem().equals("Medicamento")) {
                    tipoField.setVisible(true);
                    marcaField.setVisible(false);
                } else {
                    tipoField.setVisible(false);
                    marcaField.setVisible(true);
                }
            });
            Object[] message = {
                    "Nome:", nomeField,
                    "Preço:", precoField,
                    "Categoria:", categoriaField,
                    "Tipo:", tipoField,
                    "Marca", marcaField,
                    "Nome fornecedor:", nomeForneField,
                    "Cnpj Fornecedor:", cnpjForneField
            };

            int option = JOptionPane.showConfirmDialog(null, message, "Adicionar Produto", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                String nome = nomeField.getText();
                Double preco = Double.parseDouble(precoField.getText());
                String categoria = categoriaField.getText();
                String nomeFornecedor = nomeForneField.getText();
                String cnpj = cnpjForneField.getText();

                if (tipoBox.getSelectedItem().equals("Medicamento")) {
                    String tipo = tipoField.getText();
                    estoque.adicionarProduto(new Medicamento(nome, preco, categoria, tipo, new Fornecedor(nomeFornecedor, cnpj)));
                } else {
                    String marca = marcaField.getText();
                    estoque.adicionarProduto(new ProdutoGeral(nome, preco, categoria, marca, new Fornecedor(nomeFornecedor, cnpj)));
                }
            }

        });

        // Criando botão de diálogo para imprimir todos os produtos
        JButton showProductsButton = new JButton("Mostrar Produtos");
        showProductsButton.addActionListener(e -> mostrarProdutos());

        setLayout(new FlowLayout());
        setSize(400, 500);
        add(addProductButton);
        add(showProductsButton);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(tipoBox);


         //Método para mostrar os produtos em uma nova janela

        }

    public void mostrarProdutos () {
        JFrame frame = new JFrame("Produtos");
        String[] columnNames = {"Nome do Produto", "Preço", "Categoria", "Tipo", "Nome Fornecedor", "CNPJ"};
        String[][] data = new String[estoque.getProdutos().size()][6];
        for (int i = 0; i < estoque.getProdutos().size(); i++) {
            Product produto = estoque.getProdutos().get(i);
            data[i][0] = produto.getNome();
            data[i][1] = String.valueOf(produto.getPreco());
            data[i][2] = produto.getCategoria();
            if (produto instanceof Medicamento) {
                data[i][3] = ((Medicamento) produto).getTipo();
            } else if (produto instanceof  ProdutoGeral) {
                data[i][3]= ((ProdutoGeral) produto).marca;
            }

            data[i][4] = produto.getFornecedor().getNome();
            data[i][5] = produto.getFornecedor().getCnpj();
        }
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
