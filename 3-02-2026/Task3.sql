insert into  students values(1000011,'sahoo','sahoo@gmail.com',23,'2026-02-06',0);
insert into  students values(1000012,'sidharth','sidharath@gmail.com',21,'2026-01-06',1);
insert into  students values(1000013,'charan','charan@gmail.com',31,'2026-01-06',1);

insert into courses values(18,'Gen AI',3000000);

INSERT INTO ENROLLMENTS (enroll_id, student_id, course_id, enroll_timestamp)
VALUES (1000016, 1000005, 9, SYSDATETIME());

select * from students

select name, email from students;

select * from students
ORDER BY age DESC;

select TOP 5 * from students
ORDER BY join_date ;

select DISTINCT age from students

select DISTINCT course_name from courses

UPDATE students
set age=67
where student_id =1000001;

UPDATE students
set active_flag=0
where student_id in (1000001,1000002);

UPDATE courses
set fees= fees*1.10;

DELETE students
where student_id = 1000004;

DELETE courses
where fees <10000

DELETE ENROLLMENTS
where enroll_timestamp <'2026-02-01'

ALTER table  students ALTER column name varchar(200)

EXEC sp_rename 'dbo.STUDENTS.join_date','registration_date','COLUMN'

ALTER table students  add  phone_number VARCHAR(15)




