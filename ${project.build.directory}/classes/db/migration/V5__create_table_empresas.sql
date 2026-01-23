create table empresas(

user_id char (36) not null unique,
uuid char (36) not null unique ,

nome_fantasia varchar(128) not null,
cnpj varchar(11) unique not null,
inscricao_estadual varchar(20) unique null,
descricao text,
created_at DATETIME,
updated_at DATETIME,

primary key(uuid),

constraint fk_user_id foreign key(user_id) references users(uuid)


)