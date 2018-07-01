CREATE TABLE users
(
    id int(11) NOT NULL AUTO_INCREMENT,
    name varchar(100) NOT NULL,
    salary float(10) DEFAULT NULL,
    PRIMARY KEY (id)
);

insert into dev.users(id,name,salary) values(105,'Joe',1500);
insert into dev.users(id,name,salary) values(104,'James',3000);
insert into dev.users(id,name,salary) values(103,'John',2000);