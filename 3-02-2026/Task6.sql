select * from students 
where age >21
ORDER BY age DESC;

select count(name) as namecount from students
where name LIKE '%a%'

select course_name , fees from courses
where fees BETWEEN 10000 AND 1000000
ORDER BY fees DESC;

select name , age from students
where active_flag =0 and age is NOT NULL;

select course_id from ENROLLMENTS
group by course_id
having count(enroll_id)>1;
