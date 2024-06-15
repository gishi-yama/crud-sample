drop table if exists mail;
drop table if exists account;

create table account
(
    id bigserial primary key
);

create table mail
(
    account_id bigint primary key REFERENCES account (id) ON UPDATE CASCADE ON DELETE CASCADE ,
    mail_address    text      not null unique,
    append_at  timestamp not null
)