
create table visitor(
 visitor_id int primary key,
 visitor_name varchar(255) not null,
 email varchar(255) unique
)

create table pass(
 pass_id int primary key,
 visitor_id int not null,
 start_date datetime2 not null,
 no_of_days int not null,
 end_date as dateadd(day,no_of_days,start_date) persisted,
 check(no_of_days in (3,5,7)),
 foreign key(visitor_id) references visitor(visitor_id)
)

create table place(
 place_id int primary key,
 place_name varchar(225) not null
)

create table time_slots(
 slot_id int primary key,
 place_id int not null,
 slot_start datetime2 not null,
 slot_end datetime2 not null,
 max_capacity int not null,
 check(slot_end > slot_start),
 check(max_capacity > 0),
 foreign key(place_id) references place(place_id)
)

create table reservations(
 reservation_id int primary key,
 visitor_id int not null,
 pass_id int not null,
 slot_id int not null,
 reservation_time datetime2 default sysdatetime(),
 status varchar(20) default 'confirmed',
 foreign key(visitor_id) references visitor(visitor_id),
 foreign key(pass_id) references pass(pass_id),
 foreign key(slot_id) references time_slots(slot_id)
)

create table entry(
 entry_id int primary key,
 visitor_id int not null,
 pass_id int not null,
 slot_id int not null,
 entry_time datetime2 default sysdatetime(),
 validated bit not null,
 foreign key(visitor_id) references visitor(visitor_id),
 foreign key(pass_id) references pass(pass_id),
 foreign key(slot_id) references time_slots(slot_id)
)

alter table reservations
add unique(visitor_id,slot_id)

alter table pass
add unique(pass_id,visitor_id)

alter table reservations
add foreign key(pass_id,visitor_id)
references pass(pass_id,visitor_id)
