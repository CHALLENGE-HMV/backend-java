DELETE FROM Remedio;
DELETE FROM Consulta;
DELETE FROM Atividade;
DELETE FROM Usuario;

INSERT INTO Usuario (nome, email, senha, pontos, registro, data_nascimento) VALUES ('Teste', 'teste@teste.com', '$2a$16$M4DWD08AyoyX.0z3EDO9UeUFb2.wTPfCctfDh2KPnenIdDZ6PF0BC', 100, '5688-NS', to_date('2020-01-01', 'yyyy-mm-dd'));

INSERT INTO Atividade (descricao, usuario_id) VALUES ('Teste', (SELECT u.id FROM Usuario u where nome='Teste'));
INSERT INTO Atividade (descricao, usuario_id) VALUES ('Teste 2', (SELECT u.id FROM Usuario u where nome='Teste'));

INSERT INTO Consulta (medico, especialidade, data_hora, usuario_id) VALUES ('Dr. Teste', 'Oftalmologista', to_date('2020-01-01 00:00:00', 'yyyy-mm-dd hh24:mi:ss'), (SELECT u.id FROM Usuario u where nome='Teste'));
INSERT INTO Consulta (medico, especialidade, data_hora, usuario_id) VALUES ('Dr. Teste 2', 'Oftalmologista', to_date('2022-06-01 00:00:00', 'yyyy-mm-dd hh24:mi:ss'), (SELECT u.id FROM Usuario u where nome='Teste'));

INSERT INTO Remedio (nome, data_hora_inicio, data_hora_fim, intervalo, qtd_dose, usuario_id) VALUES ('Teste', to_date('2020-01-01 00:00:00', 'yyyy-mm-dd hh24:mi:ss'), to_date('2020-01-01 00:00:00', 'yyyy-mm-dd hh24:mi:ss'), 8, 1, (SELECT u.id FROM Usuario u where nome='Teste'));
INSERT INTO Remedio (nome, data_hora_inicio, data_hora_fim, intervalo, qtd_dose, usuario_id) VALUES ('Teste 2', to_date('2020-01-01 00:00:00', 'yyyy-mm-dd hh24:mi:ss'), to_date('2020-01-01 00:00:00', 'yyyy-mm-dd hh24:mi:ss'), 8, 1, (SELECT u.id FROM Usuario u where nome='Teste'));