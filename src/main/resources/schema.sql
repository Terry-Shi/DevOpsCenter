create table contacts (
	id identity,
	firstName varchar(30) not null,
	lastName varchar(50) not null,
	phoneNumber varchar(13),
	emailAddress varchar(30)
);

create table user (
    id varchar(50) not null,
    password varchar(50) not null
);