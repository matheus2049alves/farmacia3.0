
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServiceInterface extends JFrame implements ActionListener {
    Estoque estoque = new Estoque();
    JTextArea textArea = new JTextArea();

    public  ServiceInterface () {
        setTitle("Farmácia Art3mis");
        //ImageIcon logoIcon = new ImageIcon("logo3.png");
        //JLabel ImageLabel = new JLabel(logoIcon);
        getContentPane().setBackground(Color.LIGHT_GRAY);
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
            JLabel tipoLabel = new JLabel("Tipo");
            JLabel marcaLabel = new JLabel(("Marca"));


            if (tipoBox.getSelectedItem().equals("Medicamento")) {
                tipoField.setVisible(true);
                marcaField.setVisible(false);
                marcaLabel.setVisible(false);
                tipoLabel.setVisible(true);
            } else {
                tipoField.setVisible(false);
                marcaField.setVisible(true);
                marcaLabel.setVisible(true);
                tipoLabel.setVisible(false);
            }

            Object[] message = {
                    "Nome:", nomeField,
                    "Preço:", precoField,
                    "Categoria:", categoriaField,
                    tipoLabel, tipoField,
                    marcaLabel, marcaField,
                    "Nome fornecedor:", nomeForneField,
                    "Cnpj Fornecedor:", cnpjForneField,
            };

            int option = JOptionPane.showConfirmDialog(null, message, "Adicionar Produto", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                boolean certo = true;
                try {
                    Double p = Double.parseDouble(precoField.getText());
                    Long i = Long.parseLong(cnpjForneField.getText());
                }
                catch(NumberFormatException n){
                    JOptionPane.showMessageDialog(null, "CNPJ ou PREÇO com valores não numericos!");
                    certo = false;
                }
                String tam = cnpjForneField.getText();
                if (tam.length() != 14 && certo){
                    JOptionPane.showMessageDialog(null, "CNPJ deve ter 14 dígitos!");
                    certo = false;
                }
                if (certo) {
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
            }
        });

        // Criando botão de diálogo para imprimir todos os produtos
        JButton showProductsButton = new JButton("Mostrar Produtos");
        showProductsButton.addActionListener(e -> mostrarProdutos());

        JButton alterarButton = new JButton("Alterar Produto");
        alterarButton.addActionListener(e -> {
            JTextField nomeAntigoField = new JTextField();
            JTextField nomeField = new JTextField();
            JTextField precoField = new JTextField();
            JTextField categoriaField = new JTextField();
            JTextField tipoField = new JTextField();
            JTextField marcaField = new JTextField();
            JTextField nomeForneField = new JTextField();
            JTextField cnpjForneField = new JTextField();
            JLabel tipoLabel = new JLabel("Novo Tipo");
            JLabel marcaLabel = new JLabel(("Nova Marca"));


            if (tipoBox.getSelectedItem().equals("Medicamento")) {
                tipoField.setVisible(true);
                marcaField.setVisible(false);
                marcaLabel.setVisible(false);
                tipoLabel.setVisible(true);
            } else {
                tipoField.setVisible(false);
                marcaField.setVisible(true);
                marcaLabel.setVisible(true);
                tipoLabel.setVisible(false);
            }

            Object[] message = {
                    "Nome Antigo", nomeAntigoField,
                    "Novo Nome:", nomeField,
                    "Novo Preço:", precoField,
                    "Nova Categoria:", categoriaField,
                    tipoLabel, tipoField,
                    marcaLabel, marcaField,
                    "Novo fornecedor:", nomeForneField,
                    "Novo Cnpj Fornecedor:", cnpjForneField,
            };
            int option = JOptionPane.showConfirmDialog(null, message, "Alterar Produto", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                boolean certo = true;
                try {
                    Double p = Double.parseDouble(precoField.getText());
                    Long i = Long.parseLong(cnpjForneField.getText());
                }
                catch(NumberFormatException n){
                    JOptionPane.showMessageDialog(null, "CNPJ ou PREÇO com valores não numericos!");
                    certo = false;
                }
                String tam = cnpjForneField.getText();
                if (tam.length() != 14 && certo){
                    JOptionPane.showMessageDialog(null, "CNPJ deve ter 14 dígitos!");
                    certo = false;
                }
                if (certo) {
                    String nomeAntigo = nomeAntigoField.getText();
                    String nome = nomeField.getText();
                    Double preco = Double.parseDouble(precoField.getText());
                    String categoria = categoriaField.getText();
                    String nomeFornecedor = nomeForneField.getText();
                    String cnpj = cnpjForneField.getText();
                    if (tipoBox.getSelectedItem().equals("Medicamento")) {
                        String tipo = tipoField.getText();
                        if (estoque.alterarProduto(nomeAntigo,new Medicamento(nome, preco, categoria, tipo, new Fornecedor(nomeFornecedor, cnpj)))){
                            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
                        }else{
                            JOptionPane.showMessageDialog(null, "Produto não encontrado");
                        }
                    } else {
                        String marca = marcaField.getText();
                        if (estoque.alterarProduto(nomeAntigo,new ProdutoGeral(nome, preco, categoria, marca, new Fornecedor(nomeFornecedor, cnpj)))){
                            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
                        }else {
                            JOptionPane.showMessageDialog(null, "Produto não encontrado");
                        }
                    }
                }
            }


        });

        JButton apagarButton = new JButton("Apagar Produto");
        apagarButton.addActionListener(e -> {
            JTextField nomeField = new JTextField();

            Object[] message = {"Nome", nomeField,};
            int option = JOptionPane.showConfirmDialog(null, message, "Apagar Produto", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                String nomeAntigo = nomeField.getText();
                if (estoque.excluirProduto(nomeAntigo) == 1)
                    JOptionPane.showMessageDialog(null, "Apagado com sucessor!");
                else{
                    JOptionPane.showMessageDialog(null, "Produto não Encontrado!");
                }
            }
        });



        setLayout(new FlowLayout());
        setSize(400, 500);
        setLocationRelativeTo(null);
        add(addProductButton);
        add(showProductsButton);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //add(ImageLabel,BorderLayout.NORTH);
        add(alterarButton);
        add(tipoBox);
        add(apagarButton);


         //Método para mostrar os produtos em uma nova janela

        }
    public void mostrarProdutos () {
        JFrame frame = new JFrame();
        String [] columnNames = {"Nome Produto","Preço Produto","Categoria Produto","Tipo/Marca","Nome Fornecedor","Cnpj"};
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
