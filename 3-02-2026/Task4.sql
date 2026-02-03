SELECT * from students
where age >21;

SELECT * from students
where active_flag =1;

SELECT * from courses
where fees BETWEEN 10000 AND 100000

SELECT * from students
where age IN (21,33,22);

SELECT * from students
where age > 21 AND active_flag=1;

SELECT * from students
where age < 21 OR active_flag=0;

SELECT * from courses
where fees >200000 AND course_name like '%AI%';

SELECT * from students
where email LIKE '%gmail.com';

SELECT * from courses
where course_name LIKE 'AI%';

SELECT * from courses
where course_name LIKE '%AI%';

insert into  students values(1000014,'Raj','Raj@gmail.com',null,'2026-01-06',1,9849776655);

SELECT * from students
where age is NULL ;

SELECT * from students
where age is NOT NULL ;
