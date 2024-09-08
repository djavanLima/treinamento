-- Inserir algumas listas
INSERT INTO "List" (name) VALUES
('Lista 1'),
('Lista 2'),
('Lista 3');

-- Inserir 20 itens associados a uma lista específica (por exemplo, Lista 1)
INSERT INTO Item (name, description, completed, priority, list_id) VALUES
('Item 1', 'Completar a tarefa', FALSE, TRUE, 1),
('Item 2', 'Comprar mantimentos', TRUE, FALSE, 1),
('Item 3', 'Agendar uma reunião', FALSE, FALSE, 1),
('Item 4', 'Ler um livro', TRUE, TRUE, 1),
('Item 5', 'Fazer exercícios', FALSE, FALSE, 1),
('Item 6', 'Limpar a casa', TRUE, TRUE, 1),
('Item 7', 'Finalizar o projeto', FALSE, TRUE, 1),
('Item 8', 'Ligar para o cliente', TRUE, FALSE, 1),
('Item 9', 'Preparar apresentação', FALSE, TRUE, 1),
('Item 10', 'Escrever relatório', TRUE, TRUE, 1),
('Item 11', 'Enviar e-mail', FALSE, FALSE, 1),
('Item 12', 'Atualizar o site', TRUE, FALSE, 1),
('Item 13', 'Organizar arquivos', FALSE, TRUE, 1),
('Item 14', 'Participar da conferência', TRUE, TRUE, 1),
('Item 15', 'Comprar material de escritório', FALSE, FALSE, 1),
('Item 16', 'Revisar documentos', TRUE, TRUE, 1),
('Item 17', 'Planejar as férias', FALSE, FALSE, 1),
('Item 18', 'Reunir-se com a equipe', TRUE, FALSE, 1),
('Item 19', 'Preparar o orçamento', FALSE, TRUE, 1),
('Item 20', 'Pesquisar nova ferramenta', TRUE, TRUE, 1);
