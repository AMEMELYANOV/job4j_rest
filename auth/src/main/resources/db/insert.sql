insert into employee (name, surname, inn, hired) values ('Petr', 'Arsentev', 111, now());
insert into employee (name, surname, inn, hired) values ('Ivan', 'Ivanov', 111, now());


insert into person (login, password) values ('parsentev', '123');
insert into person (login, password) values ('ban', '123');
insert into person (login, password) values ('ivan', '123');

insert into employee_persons (employee_id, persons_id) values (1, 1);
insert into employee_persons (employee_id, persons_id) values (1, 2);
insert into employee_persons (employee_id, persons_id) values (2, 3);