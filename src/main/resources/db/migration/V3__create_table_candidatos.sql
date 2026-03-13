create table candidatos (

user_id BINARY(16) not null unique,
uuid BINARY(16) unique not null,
cpf varchar(11) unique not null,
data_nascimento date not null,
descricao text,
created_at DATETIME,
updated_at DATETIME,

primary key(uuid),

constraint fk_user_id foreign key(user_id) references users(uuid)
) ;