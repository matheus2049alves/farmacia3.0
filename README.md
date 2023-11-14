# farmacia3.0
Bem-vindo ao Farmácia Art3mis, um sistema de gerenciamento de estoque e produtos desenvolvido em Java como projeto para a 
terceira nota na disciplina de Paradigmas da Programação da UFMA! Este projeto oferece uma interface gráfica simples para
adicionar, alterar, apagar e visualizar produtos em uma farmácia.
autores: matheus costa alves (matheus2049alves) e Diogo Brasil da Silva (diogobrasil)

Funcionalidades Principais:
Adicionar Produto:
Escolha entre adicionar medicamentos ou produtos gerais.
Preencha as informações necessárias, como nome, preço, categoria e detalhes específicos, como tipo ou marca, dependendo do tipo de produto.

Alterar Produto:
Atualize as informações de um produto existente, fornecendo o nome antigo e as novas informações.

Apagar Produto:
Remova um produto do estoque fornecendo seu nome.

Mostrar Produtos:
Visualize todos os produtos em uma tabela detalhada.

Estrutura do Código:
ServiceInterface.java: Contém a implementação da interface gráfica e a lógica para interação com o estoque.

Estoque.java: Classe que representa o estoque e suas operações, como adicionar, alterar e excluir produtos.

Medicamento.java e ProdutoGeral.java: Classes que representam os tipos específicos de produtos, cada uma com seus atributos exclusivos.
