CREATE TABLE associado (
  id bigint NOT NULL AUTO_INCREMENT,
  cpf varchar(11) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UK_associado_cpf (cpf)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;