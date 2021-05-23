CREATE TABLE sessao (
  id bigint NOT NULL AUTO_INCREMENT,
  data_abertura datetime NOT NULL,
  tempo_votacao int NOT NULL,
  pauta_id bigint NOT NULL,
  PRIMARY KEY (id),
  KEY FK_sessao_pauta (pauta_id),
  CONSTRAINT FK_sessao_pauta FOREIGN KEY (pauta_id) REFERENCES pauta (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;