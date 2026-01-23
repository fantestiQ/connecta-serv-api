create table enderecos(

id bigint auto_increment not null,
user_id char(36) not null,
cep varchar (10) not null,
logradouro varchar(150)not null,
cidade varchar (100) not null,
bairro varchar (100) not null,
numero varchar (20) not null,
uf char (2) not null,
principal boolean default true,
created_at DATETIME,
updated_at DATETIME,

primary key (id),


constraint fk_enderecos foreign key (user_id) references users(uuid)
);
CREATE INDEX idx_enderecos_cidade_uf ON enderecos(cidade, uf);