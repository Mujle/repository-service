create table order_product (
number_of_ordered_products int,
product_id int not null,
warehouse_order_id int not null,
primary key (product_id, warehouse_order_id)
) engine=InnoDB;

create table product (
id int not null auto_increment,
alcohol double precision not null,
amount int not null,
mass double precision not null,
name varchar(255),
picture varchar(255),
price int not null,
user_id integer,
primary key (id)
) engine=InnoDB;

create table product_history (
id int not null auto_increment,
changed_on datetime(6),
number_of_ordered_products int,
product_id int,
type_of_change varchar(6),
user_id int,
primary key (id)
) engine=InnoDB;

create table warehouse_order (
id int not null auto_increment,
created_on datetime(6),
user_id integer,
primary key (id)
) engine=InnoDB;

alter table order_product
add constraint FKhnfgqyjx3i80qoymrssls3kno
foreign key (product_id)
references product (id);

alter table order_product
add constraint FKoxiuld7eip4859620xyt0j7k
foreign key (warehouse_order_id)
references warehouse_order (id);