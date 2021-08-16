create table user (id integer not null, name varchar(255), tech varchar(255), primary key (id));
create table post (id integer not null, description varchar(255),user_id integer, primary key (id));
alter table post add constraint FK72mt33dhhs48hf9gcqrq4fxte foreign key (user_id) references user;