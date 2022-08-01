create table if not exists employee (
   id serial primary key not null,
   name varchar(2000),
   surname varchar(2000),
   inn int,
   hired timestamp
);

create table if not exists person (
   id serial primary key not null,
   login varchar(2000),
   password varchar(2000)
);

create table if not exists  employee_persons (
   employee_id int,
   persons_id int,
   primary key (employee_id, persons_id),
   foreign key (employee_id) REFERENCES employee(id),
   foreign key (persons_id) REFERENCES person(id)
);