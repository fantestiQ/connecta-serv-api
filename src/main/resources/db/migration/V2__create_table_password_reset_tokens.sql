create table password_reset_tokens(
email varchar(128) not null,
token varchar(255),
created_at timestamp,
updated_at timestamp,

primary key(email)
);