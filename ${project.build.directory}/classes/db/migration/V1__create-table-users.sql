create table users(

uuid char(36) not null unique,
nome varchar(128) not null,
email varchar(128) not null unique,
password varchar(128) not null,
telefone varchar (20) not null,
role varchar(30) not null default('CANDIDATO'),

created_at DATETIME,
updated_at DATETIME,

primary key(uuid)
);
