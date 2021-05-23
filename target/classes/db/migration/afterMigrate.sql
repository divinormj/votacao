insert ignore into associado (cpf) values ('10546150047');
insert ignore into associado (cpf) values ('17863879051');
insert ignore into associado (cpf) values ('01704945003');
insert ignore into associado (cpf) values ('22943622095');
insert ignore into associado (cpf) values ('69749448022');
insert ignore into associado (cpf) values ('32418168000');
insert ignore into associado (cpf) values ('86140226031');
insert ignore into associado (cpf) values ('34823813057');
insert ignore into associado (cpf) values ('21281760005');
insert ignore into associado (cpf) values ('87537706093');

insert ignore into pauta (id, descricao) values (1, 'Contratação South System');

insert ignore into sessao (id, pauta_id, tempo_votacao, data_abertura) values (1, 1, 5, current_date);

insert ignore into voto (id, voto, associado_id, pauta_id) values (1, 1, 1, 1);
insert ignore into voto (id, voto, associado_id, pauta_id) values (2, 1, 2, 1);
insert ignore into voto (id, voto, associado_id, pauta_id) values (3, 1, 3, 1);
insert ignore into voto (id, voto, associado_id, pauta_id) values (4, 1, 4, 1);
insert ignore into voto (id, voto, associado_id, pauta_id) values (5, 2, 5, 1);
insert ignore into voto (id, voto, associado_id, pauta_id) values (6, 1, 6, 1);