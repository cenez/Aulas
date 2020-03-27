DROP TABLE IF EXISTS cnz.contrato;
DROP TABLE IF EXISTS cnz.login;
DROP TABLE IF EXISTS cnz.funcao;
DROP TABLE IF EXISTS cnz.empresa;
DROP TABLE IF EXISTS cnz.pessoa;

CREATE TABLE cnz.pessoa (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  endereco VARCHAR(100) NOT NULL,
  cpf VARCHAR(45) NOT NULL,
  email VARCHAR(45) NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC));

CREATE TABLE cnz.empresa (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  cnpj VARCHAR(45) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC)
);

CREATE TABLE cnz.funcao (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC)
);

CREATE TABLE cnz.login (
  id INT NOT NULL AUTO_INCREMENT,
  usuario VARCHAR(45) NOT NULL,
  senha VARCHAR(45) NOT NULL,
  pessoa_id INT NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC),
  FOREIGN KEY (pessoa_id) REFERENCES cnz.pessoa (id)
);

CREATE TABLE cnz.contrato (
  id INT NOT NULL AUTO_INCREMENT,
  empresa_id INT NOT NULL,
  pessoa_id INT NOT NULL,
  funcao_id INT NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC),
  FOREIGN KEY (empresa_id) REFERENCES cnz.empresa (id),
  FOREIGN KEY (pessoa_id) REFERENCES cnz.pessoa (id),
  FOREIGN KEY (funcao_id) REFERENCES cnz.funcao (id)
);
