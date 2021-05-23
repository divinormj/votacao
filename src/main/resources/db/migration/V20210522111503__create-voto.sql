CREATE TABLE voto (
  id bigint NOT NULL AUTO_INCREMENT,
  voto int NOT NULL,
  associado_id bigint NOT NULL,
  pauta_id bigint NOT NULL,
  PRIMARY KEY (id),
  KEY FK_voto_associado (associado_id),
  KEY FK_voto_pauta (pauta_id),
  CONSTRAINT FK_voto_associado FOREIGN KEY (associado_id) REFERENCES associado (id),
  CONSTRAINT FK_voto_pauta FOREIGN KEY (pauta_id) REFERENCES pauta (id),
  UNIQUE KEY UK_voto (associado_id, pauta_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



