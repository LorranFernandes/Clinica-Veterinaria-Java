drop DATABASE if EXISTS dbclinicaveterinaria2024;

create database dbclinicaveterinaria2024 character set utf8mb4 collate utf8mb4_bin;
use dbclinicaveterinaria2024;

CREATE TABLE administrador (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    login VARCHAR(255) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL
);

create table veterinario(
id int AUTO_INCREMENT PRIMARY KEY, 
nome varchar(55),
especialidade varchar(55),
telefone varchar(55));

create table cliente(
id int AUTO_INCREMENT PRIMARY KEY, 
nome varchar(55),  
telefone varchar(55)); 

create table animal(
id int AUTO_INCREMENT PRIMARY KEY, 
nome varchar(55),  
especie varchar(55), 
raca varchar(55), 
idade int,
idcliente int,
foreign key(idcliente) references cliente(id)); 

create table consulta(
id int AUTO_INCREMENT PRIMARY KEY, 
data date,
hora time,
valor float,
idanimal int,
idveterinario int,
foreign key(idanimal) references animal(id),
foreign key(idveterinario) references veterinario(id));


INSERT INTO veterinario (nome, especialidade) VALUES
('Dr. Alexandre', 'Cirurgião'),
('Dra. Rina', 'Dermatologista'),
('Dr. Ronaldo', 'Ortopedista'),
('Dra. Vitoria', 'Cardiologista'),
('Dr. Joao', 'Oftalmologista'),
('Dra. Flavia', 'Endocrinologista');

INSERT INTO cliente (nome, telefone) VALUES
('Joao Silva', '111-222-3333'),
('Maria Santos', '444-555-6666'),
('Carlos Pereira', '777-888-9999'),
('Ana Costa', '000-111-2222'),
('Pedro Alves', '333-444-5555'),
('Julia Teixeira', '666-777-8888');

INSERT INTO animal (nome, especie, raca, idade, idcliente) VALUES
('Rex', 'Cao', 'Labrador', 7, 1),
('Mia', 'Gato', 'Siamese', 3, 2),
('Tico', 'Pássaro', 'Canario', 2, 3),
('Teco', 'Pássaro', 'Papagaio', 4, 4),
('Bolinha', 'Cao', 'Poodle', 5, 5),
('Frajola', 'Gato', 'Persa', 6, 6);

INSERT INTO consulta (data, hora, valor, idanimal, idveterinario) VALUES
('2024-04-25', '10:00:00', 100.0, 1, 1),
('2024-04-26', '14:00:00', 120.0, 2, 2),
('2024-04-27', '09:00:00', 130.0, 3, 3),
('2024-04-28', '15:00:00', 140.0, 4, 4),
('2024-04-29', '11:00:00', 150.0, 5, 5),
('2024-04-30', '16:00:00', 160.0, 6, 6);

