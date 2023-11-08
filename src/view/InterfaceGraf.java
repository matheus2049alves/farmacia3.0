package view;
import entities.Medicamento;
import entities.Produto;
import entities.ProdutoGeral;
import domain.Estoque;
import entities.Fornecedor;
import javax.swing.*;
import java.awt.*;

public class InterfaceGraf extends JFrame  {
    Estoque estoque = new Estoque();
    JTextArea textArea = new JTextArea();

    public InterfaceGraf() {
        setTitle("Farmácia Art3mis");

        getContentPane().setBackground(Color.LIGHT_GRAY);
        String[] opcoesProdutos = {"Medicamento", "Produtos Gerais"};
        JComboBox<String> tipoBox = new JComboBox<>(opcoesProdutos);
        // Criando botão de diálogo para usuário adicionar um produto
        JButton addProductButton = new JButton("Adicionar Produto");
        addProductButton.addActionListener(e -> {
            // Cria campos de entrada de dados e rótulos para os atributos do produto.
            JTextField nomeField = new JTextField();
            JTextField precoField = new JTextField();
            JTextField categoriaField = new JTextField();
            JTextField tipoField = new JTextField();
            JTextField marcaField = new JTextField();
            JTextField nomeForneField = new JTextField();
            JTextField cnpjForneField = new JTextField();
            JLabel tipoLabel = new JLabel("Tipo");
            JLabel marcaLabel = new JLabel(("Marca"));

            // Verifica o tipo selecionado no combobox e ajusta a visibilidade dos campos de acordo com o tipo de produto.
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
            // Cria um array de objetos para exibir no diálogo de entrada de dados.
            Object[] message = {
                    "Nome:", nomeField,
                    "Preço:", precoField,
                    "Categoria:", categoriaField,
                    tipoLabel, tipoField,
                    marcaLabel, marcaField,
                    "Nome fornecedor:", nomeForneField,
                    "Cnpj Fornecedor:", cnpjForneField,
            };
            // Exibe um diálogo de confirmação com os campos de entrada de dados.
            int option = JOptionPane.showConfirmDialog(null, message, "Adicionar Produto", JOptionPane.OK_CANCEL_OPTION);
            // Se o usuário confirmar a adição do produto:
            if (option == JOptionPane.OK_OPTION) {
                boolean certo = true;
                try {
                    // Tenta converter o conteúdo dos campos 'precoField' e 'cnpjForneField' em números.
                    Double p = Double.parseDouble(precoField.getText());
                    Long i = Long.parseLong(cnpjForneField.getText());
                }
                catch(NumberFormatException n){
                    // Se ocorrer uma exceção de conversão, exibe uma mensagem de erro.
                    JOptionPane.showMessageDialog(null, "CNPJ ou PREÇO com valores não numericos!");
                    certo = false;
                }
                String tam = cnpjForneField.getText();
                // Verifica se o CNPJ tem 14 dígitos e se nenhum erro ocorreu até este ponto.
                if (tam.length() != 14 && certo){
                    JOptionPane.showMessageDialog(null, "CNPJ deve ter 14 dígitos!");
                    certo = false;
                }
                if (certo) {
                    // Coleta informações inseridas nos campos.
                    String nome = nomeField.getText();
                    Double preco = Double.parseDouble(precoField.getText());
                    String categoria = categoriaField.getText();
                    String nomeFornecedor = nomeForneField.getText();
                    String cnpj = cnpjForneField.getText();
                    // Com base no tipo de produto selecionado, cria e adiciona o produto ao estoque.
                    if (tipoBox.getSelectedItem().equals("Medicamento")) {
                        String tipo = tipoField.getText();
                        estoque.adicionarProduto(new Medicamento(nome, preco, categoria, tipo, new Fornecedor(nomeFornecedor, cnpj)));
                    } else {
                        String marca = marcaField.getText();
                        estoque.adicionarProduto(new ProdutoGeral(nome, preco, categoria, marca, new Fornecedor(nomeFornecedor, cnpj)));
                    }
                    JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!");
                }
            }
        });

        // Criando botão de diálogo para imprimir todos os produtos
        JButton mostraProdutosButton = new JButton("Mostrar Produtos");
        mostraProdutosButton.addActionListener(e -> estoque.mostrarProdutos());

        //criando botão e evento para alterar produtos----

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

            //configuração da visibilidade dos atributos Marca e tipo
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
            //
            int option = JOptionPane.showConfirmDialog(null, message, "Alterar Produto", JOptionPane.OK_CANCEL_OPTION);
            /* Exibe um diálogo de confirmação e aguarda a resposta do usuário.
            A variável 'option' irá conter o valor da escolha (OK ou CANCEL)*/
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
                // Verifica se o tamanho do CNPJ é diferente de 14 e se nenhum erro ocorreu anteriormente.
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
                    /* Verifica o tipo do produto (Medicamento ou Produto Geral) selecionado no combobox.
                    e altera o produto com base nessa seleção, chamando os métódos de cada tipo de produto
                    para alteração*/
                    if (tipoBox.getSelectedItem().equals("Medicamento")) {
                        String tipo = tipoField.getText();
                        if (estoque.alteraMedicamento(nomeAntigo,new Medicamento(nome, preco, categoria, tipo, new Fornecedor(nomeFornecedor, cnpj)))){
                            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
                        }else{
                            JOptionPane.showMessageDialog(null, "Produto não encontrado");
                        }
                    } else {
                        String marca = marcaField.getText();
                        if (estoque.alteraProdutoG(nomeAntigo,new ProdutoGeral(nome, preco, categoria, marca, new Fornecedor(nomeFornecedor, cnpj)))){
                            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
                        }else {
                            JOptionPane.showMessageDialog(null, "Produto não encontrado");
                        }
                    }
                }
            }


        });

        /*---criando botão e evento para apagar produto------
        * O precosso leva em conta a seleção da Jcombo box, se estiver selecionado medicamento, irá apagar medicaemnto,
        * caso contrario, irá apagar produto geral*/
        JButton apagarButton = new JButton("Apagar Produto");
        apagarButton.addActionListener(e -> {
            JTextField nomeField = new JTextField();

            Object[] message = {"Nome", nomeField,};
            int option = JOptionPane.showConfirmDialog(null, message, "Apagar Produto", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                String nomeAntigo = nomeField.getText();
                if (tipoBox.getSelectedItem().equals("Medicamento")) {
                    if (estoque.apagarMedicamento(nomeAntigo))
                        JOptionPane.showMessageDialog(null, "Apagado com sucessor!");
                    else {
                        JOptionPane.showMessageDialog(null, "Produto não Encontrado!");
                    }
                }
                else{
                    if (estoque.apagarProdutoG(nomeAntigo))
                        JOptionPane.showMessageDialog(null, "Apagado com sucessor!");
                    else {
                        JOptionPane.showMessageDialog(null, "Produto não Encontrado!");
                    }
                }
            }
        });

        //configurações de janela
        setLayout(new FlowLayout());
        setSize(400, 500);
        setLocationRelativeTo(null);
        add(addProductButton);
        add(mostraProdutosButton);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(alterarButton);
        add(tipoBox);
        add(apagarButton);

        }

}
