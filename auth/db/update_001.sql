create table employee (
   id serial primary key not null,
   name varchar(2000),
   surname varchar(2000),
   inn int,
   hired timestamp
);

create table person (
   id serial primary key not null,
   login varchar(2000),
   password varchar(2000)
);

create table employee_persons (
   employee_id int,
   persons_id int,
   primary key (employee_id, persons_id),
   foreign key (employee_id) REFERENCES employee(id),
   foreign key (persons_id) REFERENCES person(id)
);

insert into employee (name, surname, inn, hired) values ('Petr', 'Arsentev', 111, now());
insert into employee (name, surname, inn, hired) values ('Ivan', 'Ivanov', 111, now());


insert into person (login, password) values ('parsentev', '123');
insert into person (login, password) values ('ban', '123');
insert into person (login, password) values ('ivan', '123');

insert into employee_persons (employee_id, persons_id) values (1, 1);
insert into employee_persons (employee_id, persons_id) values (1, 2);
insert into employee_persons (employee_id, persons_id) values (2, 3);
