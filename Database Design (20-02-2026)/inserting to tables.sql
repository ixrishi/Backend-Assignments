insert into visitor values (1,'Ravi Kumar','ravi@gmail.com');
insert into visitor values (2,'Anita Sharma','anita@gmail.com');
insert into visitor values (3,'John Peter','john@gmail.com');
insert into visitor values (4,'Meena Rao','meena@gmail.com');
insert into visitor values (5,'David Roy','david@gmail.com');

insert into pass(pass_id,visitor_id,start_date,no_of_days)
values (101,1,'2026-02-01',3);
insert into pass values (102,2,'2026-02-02',5);
insert into pass values (103,3,'2026-02-03',7);
insert into pass values (104,4,'2026-02-05',3);
insert into pass values (105,5,'2026-02-06',6); 

insert into place values (1,'Museum');
insert into place values (2,'Zoo');
insert into place values (3,'Aquarium');


insert into time_slots values
(201,1,'2026-02-10 09:00','2026-02-10 11:00',2)
--(202,1,'2026-02-10 11:00','2026-02-10 13:00',50),
--(203,2,'2026-02-10 10:00','2026-02-10 12:00',40),
--(204,3,'2026-02-10 14:00','2026-02-10 16:00',30),
(205,1,'2026-02-10 09:00','2026-02-10 11:00',3)

delete time_slots where slot_id =205;

insert into time_slots values
(206,1,'2026-02-10 11:00','2026-02-10 10:00',30);


insert into reservations values
(301,1,101,201,default,'confirmed'),
(302,2,102,201,default,'confirmed'),
(303,3,103,202,default,'confirmed')

insert into reservations values
(305,4,104,202,default,'confirmed')

insert into entry values
(401,1,101,201,default,1),
(402,2,102,201,default,1),
(403,3,103,202,default,1)




