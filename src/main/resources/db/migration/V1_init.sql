-- Criação da tabela de produtos
CREATE TABLE product (
                          id SERIAL PRIMARY KEY,
                          nome VARCHAR(100) NOT NULL,
                          categoria VARCHAR(50),
                          preco_unitario DECIMAL(10, 2) NOT NULL
);

-- Criação da tabela de vendas
CREATE TABLE sales (
                        id SERIAL PRIMARY KEY,
                        product_id INTEGER REFERENCES product(id),
                        quantity INTEGER NOT NULL,
                        salesDate DATE NOT NULL
);


-- Inserir produtos
INSERT INTO product (name, category, unitPrice) VALUES
                                                           ('Camiseta Básica', 'Roupas', 39.90),
                                                           ('Calça Jeans', 'Roupas', 89.90),
                                                           ('Tênis Esportivo', 'Calçados', 199.90),
                                                           ('Boné Estiloso', 'Acessórios', 29.90),
                                                           ('Meia Esportiva', 'Acessórios', 9.90);

-- Inserir vendas (simulando um mês)
INSERT INTO sales (id, quantity, salesDate) VALUES
                                                            (1, 10, '2025-06-01'),
                                                            (2, 5, '2025-06-02'),
                                                            (3, 3, '2025-06-03'),
                                                            (1, 7, '2025-06-04'),
                                                            (4, 15, '2025-06-04'),
                                                            (5, 20, '2025-06-05'),
                                                            (1, 12, '2025-06-06'),
                                                            (3, 2, '2025-06-06'),
                                                            (2, 4, '2025-06-07'),
                                                            (5, 30, '2025-06-08'),
                                                            (4, 8, '2025-06-09'),
                                                            (1, 9, '2025-06-10'),
                                                            (2, 6, '2025-06-10'),
                                                            (3, 4, '2025-06-11');