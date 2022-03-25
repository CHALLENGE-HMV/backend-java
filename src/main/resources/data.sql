INSERT INTO Usuario (nome, email, senha, pontos, registro, data_nascimento) VALUES ('Teste', 'teste@teste.com', 'teste', 100, '5688-NS', to_date('2020-01-01', 'yyyy-mm-dd'));

INSERT INTO Atividade (descricao, usuario_id) VALUES ('Teste', 1);
INSERT INTO Atividade (descricao, usuario_id) VALUES ('Teste 2', 1);

INSERT INTO Consulta (medico, especialidade, data_hora, usuario_id) VALUES ('Dr. Teste', 'Oftalmologista', to_date('2020-01-01 00:00:00', 'yyyy-mm-dd hh24:mi:ss'), 1);
INSERT INTO Consulta (medico, especialidade, data_hora, usuario_id) VALUES ('Dr. Teste 2', 'Oftalmologista', to_date('2022-06-01 00:00:00', 'yyyy-mm-dd hh24:mi:ss'), 1);

INSERT INTO Remedio (nome, data_hora_inicio, data_hora_fim, intervalo, qtd_dose, usuario_id) VALUES ('Teste', to_date('2020-01-01 00:00:00', 'yyyy-mm-dd hh24:mi:ss'), to_date('2020-01-01 00:00:00', 'yyyy-mm-dd hh24:mi:ss'), 8, 1, 1);
INSERT INTO Remedio (nome, data_hora_inicio, data_hora_fim, intervalo, qtd_dose, usuario_id) VALUES ('Teste 2', to_date('2020-01-01 00:00:00', 'yyyy-mm-dd hh24:mi:ss'), to_date('2020-01-01 00:00:00', 'yyyy-mm-dd hh24:mi:ss'), 8, 1, 1);