insert into tb_user (name, email, password) values ('Joao', 'joao@gmail.com', '$#123456')
insert into tb_user (name, email, password) values ('Pedro', 'pedro@gmail.com', '$#12345')

insert into tb_role (role_name) values ('ROLE_OPERATOR')
insert into tb_role (role_name) values ('ROLE_ADMIN')

insert into tb_user_role (user_id, role_id) values (1, 1)
insert into tb_user_role (user_id, role_id) values (2, 1)
insert into tb_user_role (user_id, role_id) values (2, 2)