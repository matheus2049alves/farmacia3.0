import javax.swing.*;
import java.awt.*;
public class ServiceInterface extends JFrame {
    Estoque estoque = new Estoque();
    JTextArea textArea = new JTextArea();

    public  ServiceInterface () {
       setTitle("Farmácia Art3mis");
        Icon icon = new ImageIcon("pngwing.com.png");
        JLabel image = new JLabel(icon);
        image.setBounds(2,4,300,200);

        // Criando botão de diálogo para usuário adicionar um produto
        JButton addProductButton = new JButton("Adicionar Produto");
        addProductButton.addActionListener(e -> {
            JTextField nomeField = new JTextField();
            JTextField precoField = new JTextField();
            JTextField categoriaField = new JTextField();

            Object[] message = {
                    "Nome:", nomeField,
                    "Preço:", precoField,
                    "Categoria:", categoriaField
            };

            int option = JOptionPane.showConfirmDialog(null, message, "Adicionar Produto", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    String nome = nomeField.getText();
                    Double preco = Double.parseDouble(precoField.getText());
                    String categoria = categoriaField.getText();
                estoque.adicionarProduto(nome, preco, categoria);
            }

        });

        // Criando botão de diálogo para imprimir todos os produtos
        JButton showProductsButton = new JButton("Mostrar Produtos");
        showProductsButton.addActionListener(e -> mostrarProdutos());

        setLayout(new FlowLayout());
        setSize(400,500);
        add(addProductButton);
        add(showProductsButton);
        add(image);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // Método para mostrar os produtos em uma nova janela
    private void mostrarProdutos() {
        JFrame frame = new JFrame("Produtos");
        String[] columnNames = {"Nome do Produto", "Preço", "Categoria"};
        String[][] data = new String[estoque.getProdutos().size()][3];
        for (int i = 0; i < estoque.getProdutos().size(); i++) {
            Product produto = estoque.getProdutos().get(i);
            data[i][0] = produto.getNome();
            data[i][1] = String.valueOf(produto.getPreco());
            data[i][2] = produto.getCategoria();
        }
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
        frame.pack();
        frame.setVisible(true);
    }
}
